package az.kanan.db;

import java.sql.*;

/**
 * Created by Kanan on 12/19/2016.
 */
public class ConnectorDB {

    public Connection getConnection() {
        Connection myConn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cities?useSSL=false", "root", "oracle");
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return myConn;
    }

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (!con.isClosed()) {
            con.close();
        }
        if (!ps.isClosed()) {
            ps.close();
        }
        if (rs != null) {
            rs.close();
        }
    }
}
