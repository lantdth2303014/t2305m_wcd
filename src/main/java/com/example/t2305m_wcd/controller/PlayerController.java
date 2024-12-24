package com.example.t2305m_wcd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.t2305m_wcd.entity.Player;
import com.example.t2305m_wcd.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/player")
public class PlayerController extends HttpServlet {
    private PlayerService playerService;

    @Override
    public void init() throws ServletException {
        playerService = new PlayerService();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String fullName = request.getParameter("fullName");
        String age = request.getParameter("age");

        Player newPlayer = new Player(null, name, fullName, age, null);

        if (playerService.isValidPlayer(newPlayer)) {
            playerService.addPlayer(newPlayer);
            response.sendRedirect("/player"); // Chuyển hướng đến trang danh sách người chơi
        } else {
            request.setAttribute("error", "data error");
            request.getRequestDispatcher("/addPlayer.jsp").forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();

        if ("/addPlayer".equals(action)) {
            request.getRequestDispatcher("/addPlayer.jsp").forward(request, response);
        } else {

            List<Player> players = playerService.getAllPlayers();
            request.setAttribute("players", players);
            request.getRequestDispatcher("/playerList.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String playerId = request.getParameter("playerId");
        String name = request.getParameter("name");
        String fullName = request.getParameter("fullName");
        String age = request.getParameter("age");

        Player updatedPlayer = new Player(Long.parseLong(playerId), name, fullName, age, null);

        if (playerService.isValidPlayer(updatedPlayer)) {
            playerService.updatePlayer(Long.parseLong(playerId), updatedPlayer);
            response.sendRedirect("/player");
        } else {
            request.setAttribute("error", "data error");
            request.getRequestDispatcher("/editPlayer.jsp").forward(request, response);
        }
    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playerId = request.getParameter("playerId");
        if (playerService.deletePlayer(Long.parseLong(playerId))) {
            response.sendRedirect("/player");
        } else {
            request.setAttribute("error", "not found player");
            request.getRequestDispatcher("/playerList.jsp").forward(request, response);
        }
    }


}