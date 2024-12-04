package com.example.t2305m_wcd.controller;

import com.example.t2305m_wcd.dao.SubjectDAO;
import com.example.t2305m_wcd.database.Database;
import com.example.t2305m_wcd.entity.Subject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@WebServlet(value = "/subject")
public class SubjectController extends HttpServlet {
    private SubjectDAO subjectDAO;
    @Override
    public void init() throws ServletException {
        super.init();
        subjectDAO = new SubjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") != null ? req.getParameter("action") : "";
        switch (action) {
            case "create":
                renderForm(req, resp);
                return;
            case "edit": {
                Long id = Long.parseLong(req.getParameter("id"));
                Subject subject = subjectDAO.find(id);
                req.setAttribute("subject", subject);
                renderForm(req, resp);
                return;
            }
            case "delete": {
                Long id = Long.parseLong(req.getParameter("id"));
                subjectDAO.delete(id);
                resp.sendRedirect("subject");
                return;
            }
        }
        List<Subject> list = subjectDAO.all();
        req.setAttribute("subjects", list);
        RequestDispatcher rd = req.getRequestDispatcher("subject/list.jsp");
        rd.forward(req, resp);
    }

    private void renderForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("subject/form.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            // Create new subject
            subjectDAO.create(new Subject(
                    null,
                    req.getParameter("name"),
                    req.getParameter("code"),
                    Integer.parseInt(req.getParameter("hour"))
            ));
        } else {
            // Update existing subject
            subjectDAO.update(new Subject(
                    Long.parseLong(idParam),
                    req.getParameter("name"),
                    req.getParameter("code"),
                    Integer.parseInt(req.getParameter("hour"))
            ));
        }
        resp.sendRedirect("subject");
    }
}