package Bank.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connection {
    static Connection conn;
    public static Connection connect() {
        String ur1= "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String password = "Gaurav@123";
        try {
            conn  = DriverManager.getConnection(ur1, user, password);
        } catch (SQLException q)
        {
            System.out.print("Error Bank Database : "+q.getMessage());
        }
        return conn;
    }
}