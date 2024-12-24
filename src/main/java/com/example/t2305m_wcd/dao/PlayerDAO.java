package com.example.t2305m_wcd.dao;

import com.example.t2305m_wcd.database.Database;
import com.example.t2305m_wcd.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO implements DAOInterface<Player,Long>{
    @Override
    public List<Player> all(){
        List<Player> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM player";
            Database db = Database.createInstance();
            Statement st = db.getStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                list.add(new Player(
                        rs.getInt("player_id"),
                        rs.getString("name"),
                        rs.getString("full_name"),
                        rs.getString("age"),
                        rs.getInt("index_id")
                ));
            }
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public void create(Player player) {
        try {
            String sql = "INSERT INTO player (name, full_name, age, index_id) VALUES (?, ?, ?, ?)";
            Database db = Database.createInstance();
            PreparedStatement pr = db.getPreparedStatement(sql);
            pr.setString(1, player.getName());
            pr.setString(2, player.getFullName());
            pr.setString(3, player.getAge());
            pr.setInt(4, player.getIndexId());
            pr.execute();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Player player) {
        try {
            String sql = "UPDATE player SET name = ?, full_name = ?, age = ?, index_id = ? WHERE player_id = ?";
            Database db = Database.createInstance();
            PreparedStatement pr = db.getPreparedStatement(sql);
            pr.setString(1, player.getName());
            pr.setString(2, player.getFullName());
            pr.setString(3, player.getAge());
            pr.setInt(4, player.getIndexId());
            pr.setInt(5, player.getPlayerId());
            pr.execute();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM player WHERE player_id = ?";
            Database db = Database.createInstance();
            PreparedStatement pr = db.getPreparedStatement(sql);
            pr.setLong(1, id);
            pr.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Player find(Long id) {
        Player player = null;
        try {
            String sql = "SELECT * FROM player WHERE player_id = ?";
            Database db = Database.createInstance();
            PreparedStatement pr = db.getPreparedStatement(sql);
            pr.setLong(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                player = new Player(
                        rs.getInt("player_id"),
                        rs.getString("name"),
                        rs.getString("full_name"),
                        rs.getString("age"),
                        rs.getInt("index_id")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return player;
    }
}