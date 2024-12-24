package com.example.t2305m_wcd.service;

import com.example.t2305m_wcd.database.Database;
import com.example.t2305m_wcd.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private Connection conn;

    public PlayerService() {
        conn = Database.createInstance().getConnection();
    }

    public Player addPlayer(Player player) {
        String sql = "INSERT INTO player (name, full_name, age, index_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.createInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, player.getName());
            stmt.setString(2, player.getFullName());
            stmt.setString(3, player.getAge());
            stmt.setInt(4, player.getIndexId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return player;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT player_id, name, full_name, age, index_id FROM player";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Player player = new Player(
                        rs.getLong("player_id"),
                        rs.getString("name"),
                        rs.getString("full_name"),
                        rs.getString("age"),
                        rs.getInt("index_id")
                );
                players.add(player);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return players;
    }


    public boolean isValidPlayer(Player player) {
        if (player.getName() == null || player.getName().isEmpty()) {
            return false;  // Name is required
        }
        if (player.getAge() == null || player.getAge().isEmpty()) {
            return false;  // Age is required
        }
        try {
            Integer.parseInt(player.getAge()); // Validate if age is an integer
        } catch (NumberFormatException e) {
            return false;  // Age must be a valid number
        }
        return true;
    }

    public void updatePlayer(Long playerId, Player player) {
        String sql = "UPDATE player SET name = ?, full_name = ?, age = ?, index_id = ? WHERE player_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, player.getName());
            pstmt.setString(2, player.getFullName());
            pstmt.setString(3, player.getAge());
            pstmt.setInt(4, player.getIndexId());
            pstmt.setLong(5, playerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean deletePlayer(Long playerId) {
        String sql = "DELETE FROM player WHERE player_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, playerId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
