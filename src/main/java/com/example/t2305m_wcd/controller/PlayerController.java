package com.example.t2305m_wcd.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.example.t2305m_wcd.dao.PlayerDAO;
import com.example.t2305m_wcd.entity.Player;
@WebServlet(value = "/player")
public class PlayerController extends HttpServlet {
    private PlayerDAO playerDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        playerDAO = new PlayerDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") != null ? req.getParameter("action") : "";
        try {
            switch (action) {
                case "create":
                    renderForm(req, resp);
                    break;
                case "edit":
                    String editIdStr = req.getParameter("id");
                    if (editIdStr != null && editIdStr.matches("\\d+")) {
                        long editId = Integer.parseInt(editIdStr);
                        Player editPlayer = playerDAO.find(editId);
                        if (editPlayer != null) {
                            req.setAttribute("player", editPlayer);
                            renderForm(req, resp);
                        } else {
                            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Player not found");
                        }
                    } else {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
                    }
                    break;
                case "delete":
                    String deleteIdStr = req.getParameter("id");
                    if (deleteIdStr != null && deleteIdStr.matches("\\d+")) {
                        long deleteId = Integer.parseInt(deleteIdStr);
                        playerDAO.delete(deleteId);
                        resp.sendRedirect("player");
                    } else {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
                    }
                    break;
                default:
                    List<Player> players = playerDAO.all();
                    req.setAttribute("players", players);
                    RequestDispatcher listDispatcher = req.getRequestDispatcher("player/list.jsp");
                    listDispatcher.forward(req, resp);
                    break;
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format");
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred");
        }
    }

    private void renderForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher formDispatcher = req.getRequestDispatcher("player/form.jsp");
        formDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") != null ? req.getParameter("action") : "";
        if ("update".equals(action)) {
            playerDAO.update(new Player(
                    Integer.parseInt(req.getParameter("id")),
                    req.getParameter("name"),
                    req.getParameter("fullName"),
                    req.getParameter("age"),
                    Integer.parseInt(req.getParameter("indexId"))
            ));
        } else {
            playerDAO.create(new Player(
                    0,
                    req.getParameter("name"),
                    req.getParameter("fullName"),
                    req.getParameter("age"),
                    Integer.parseInt(req.getParameter("indexId"))
            ));
        }
        resp.sendRedirect("player");
    }
}
