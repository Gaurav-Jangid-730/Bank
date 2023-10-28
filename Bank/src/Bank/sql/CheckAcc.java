package Bank.sql;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckAcc {

    static Connection conn = connection.connect();
    static String data;
    public static String main(String str,int sel)
    {
        String Sql;
        if(sel==1) {
            Sql = "select * from registions where Rnum=?";
        }
        else
        {
            Sql= "select * from registions where Rusername=?";
        }
        try(PreparedStatement stmt =  conn.prepareStatement(Sql);)
        {
            stmt.setString(1, str);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                data = rs.getString("Rusername");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Not Found");
                data = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }


}
