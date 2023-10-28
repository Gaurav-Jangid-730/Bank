package Bank.Login;

import Bank.sql.connection;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Start {


    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }


    public static void StartBank(String Username , String password) {

        try {
            String Hashpass = hashPassword(password);
            Connection conn = connection.connect();
            String Sql = "SELECT * FROM registions WHERE Rusername = ? AND Rpassword = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(Sql);
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Hashpass);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null,"Authentication successful");
                Startbank.Start(Username);
            } else {
                JOptionPane.showMessageDialog(null,"Authentication failed!!");
                Bank.main(null);
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null,"Can't Be Able To Connect With MySql");
        }

    }

}
