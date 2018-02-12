package tests;

import model.GroupData;
import org.testng.annotations.Test;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbConnectionTest {
    @Test
    public void testDbConnect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?"
                    + "user=root&password=&serverTimezone=UTC");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");
            List<GroupData> groups = new ArrayList<>();

            while (rs.next()) {
                groups.add(new GroupData().withName(rs.getString("group_name")));
            }

            rs.close();
            st.close();
            conn.close();
            while (rs.next()) {
                groups.add(new GroupData().withName(rs.getString("group_name")).withHeader(rs.getString("droup_header")).withFooter(rs.getString("droup_footer")));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
