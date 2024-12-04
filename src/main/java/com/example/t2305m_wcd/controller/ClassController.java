package com.example.t2305m_wcd.controller;

import com.example.t2305m_wcd.dao.ClassDAO;
import com.example.t2305m_wcd.database.Database;
import com.example.t2305m_wcd.entity.Class;
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

@WebServlet(value = "/class")
public class ClassController extends HttpServlet {
    private ClassDAO classDAO;
    @Override
    public void init() throws ServletException {
        super.init();
        classDAO = new ClassDAO();
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
                Class clazz = classDAO.find(id);
                req.setAttribute("class", clazz);
                renderForm(req, resp);
                return;
            }
            case "delete": {
                Long id = Long.parseLong(req.getParameter("id"));
                classDAO.delete(id);
                resp.sendRedirect("class");
                return;
            }
        }
        List<Class> list = classDAO.all();
        req.setAttribute("classes", list);
        RequestDispatcher rd = req.getRequestDispatcher("class/list.jsp");
        rd.forward(req, resp);
    }

    private void renderForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("class/form.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            // Create new class
            classDAO.create(new Class(
                    null,
                    req.getParameter("name")
            ));
        } else {
            // Update existing class
            classDAO.update(new Class(
                    Long.parseLong(idParam),
                    req.getParameter("name")
            ));
        }
        resp.sendRedirect("class");
    }
}