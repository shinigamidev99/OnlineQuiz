/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;

/**
 *
 * @author Administrator
 */
public class AccountDB {
    public Account selectByUsername(String username) throws Exception {
        DBContext context = new DBContext();
        String sql = "SELECT  [username]\n"
                + "      ,[password]\n"
                + "      ,[user_type]\n"
                + "      ,[email]\n"
                + "  FROM [OnlineQuiz].[dbo].[Account]\n"
                + "  where username like ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setEmail(rs.getString("email"));
                acc.setUserType(rs.getBoolean("user_type"));
                return acc;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(rs, ps, conn);
        }

        return null;
    }

    public int insert(Account ac) throws Exception {
        DBContext context = new DBContext();
        int update = 0;
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[user_type]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = context.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ac.getUsername());
            ps.setString(2, ac.getPassword());
            ps.setBoolean(3, ac.isUserType());
            ps.setString(4, ac.getEmail());
            update = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            context.closeConnection(null, ps, conn);
        }

        return update;
    }
}
