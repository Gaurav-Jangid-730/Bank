package Bank.Registion;

import Bank.sql.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Suggestion {
    public String Suggest(String inputUsername) {

        Connection conn = connection.connect();
        try {

            String sql = "SELECT COUNT(*) FROM registions WHERE Rusername = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, inputUsername);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int count = resultSet.getInt(1);

            if (count > 0) {
                return "UserName Is Already Taken";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}