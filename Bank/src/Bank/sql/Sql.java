package Bank.sql;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Sql {

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String FirstName,String LastName,String Email,String Phonenumber,String Occupation,String Income,String username,String password,String Nat,String gen , String account , String dob , String kyc) {
        try {
            int Account=0;
            Random rn = new Random();
            Account = 1000000000 + rn.nextInt(1000000000);
            String hashedPassword = hashPassword(password);
            Connection conn = connection.connect();
            String sql = "INSERT INTO registions(RFname,RLname,Remail,Rphone,Roccupation,RIncome,Rusername,Rpassword,RNationality,Rgender,RAccount,RDob,Rkyc,Rnum) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,"+Account+")";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,FirstName);
            stmt.setString(2,LastName);
            stmt.setString(3,Email);
            stmt.setString(4,Phonenumber);
            stmt.setString(5,Occupation);
            stmt.setString(6,Income);
            stmt.setString(7,username);
            stmt.setString(8,hashedPassword);
            stmt.setString(9,Nat);
            stmt.setString(10,gen);
            stmt.setString(11,account);
            stmt.setString(12,dob);
            stmt.setString(13,kyc);
            //   stmt.setString(14,Account);
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected>0) {
                JOptionPane.showMessageDialog(null, "Sucessfull");
                JOptionPane.showMessageDialog(null, "Your Account Number is : " +Account);
            }
            else {
                JOptionPane.showMessageDialog(null, "UnSucessfull");
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}

