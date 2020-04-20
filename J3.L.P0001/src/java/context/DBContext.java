/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DBContext {

    public Connection getConnection() throws Exception {
        Config config = new Config();
        String url = "jdbc:sqlserver://" + config.getConfigValue("host") + ":" + config.getConfigValue("port")
                + ";databaseName=" + config.getConfigValue("databaseName");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(url, "sa", "1");
        return conn;
    }

    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
