package com.project.DAO;

import com.project.Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO{
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public UserDAO(Connection con) {
        this.con = con;
    }

    public User userLogin(String email, String password) {
        User user = null;

        try {
            this.query = "select * from users where email=? and password=?";
            this.pst = this.con.prepareStatement(this.query);
            this.pst.setString(1, email);
            this.pst.setString(2, password);
            this.rs = this.pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(this.rs.getInt("id"));
                user.setName(this.rs.getString("name"));
                user.setEmail(this.rs.getString("email"));
            }
        } catch (SQLException var5) {
            System.out.print(var5.getMessage());
        }

        return user;
    }
}
