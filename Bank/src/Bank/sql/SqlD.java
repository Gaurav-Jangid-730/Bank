package Bank.sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class SqlD {

    public static void main(String tableName,String in) {
        try {
            Connection conn = connection.connect();
            Statement stmt = conn.createStatement();
            String str = new String();
            str = "----";
            // create table using user input as table name
            String createTableSQL = "CREATE TABLE " + tableName
                    + "(id INT PRIMARY KEY AUTO_INCREMENT, "
                    + " Balance VARCHAR(50), "
                    + " Deposit varchar(10),"
                    +" Withdrawal varchar(11),"
                    + " TransferTo varchar(30),"
                    +" TransferFrom varchar(30),"
                    +" TransferMoney varchar(30))";
            String sql = "INSERT INTO "+tableName+"(Balance , Deposit , Withdrawal , TransferTo , TransferFrom,TransferMoney) VALUES (?,?,?,?,?,?);";
            stmt.executeUpdate(createTableSQL);
            PreparedStatement stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1,in);
            stmt1.setString(2,str);
            stmt1.setString(3,str);
            stmt1.setString(4,str);
            stmt1.setString(5,str);
            stmt1.setString(6,str);
            stmt1.executeUpdate();
            stmt.close();
            stmt1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


