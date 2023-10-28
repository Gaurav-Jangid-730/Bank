package Bank.sql;
import Bank.Login.Start;

import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Manage {

    static Connection conn = connection.connect();

    public String findFName( String Uname ) throws SQLException {

        String selectQuery = "SELECT * FROM registions WHERE Rusername=?";

        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {

            stmt.setString(1, Uname);

            ResultSet rs = stmt.executeQuery();


            if (rs.next())
            {
                return rs.getString("RFname");

            } else
            {

                System.out.println("Not found");
                return null;
            }

        }

    }

    public String findRuser( String Uname ) throws SQLException {

        String selectQuery = "SELECT * FROM registions WHERE Rusername=?";

        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {

            stmt.setString(1, Uname);

            ResultSet rs = stmt.executeQuery();


            if (rs.next())
            {
                return rs.getString("Rusername");

            } else
            {

                System.out.println("Not found");
                return null;
            }

        }

    }

    public String findRphone( String Uname ) throws SQLException {

        String selectQuery = "SELECT * FROM registions WHERE Rusername=?";

        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {

            stmt.setString(1, Uname);

            ResultSet rs = stmt.executeQuery();


            if (rs.next())
            {
                return rs.getString("Rphone");

            } else
            {

                System.out.println("Not found");
                return null;
            }

        }

    }

    public String findRemail(String Uname ) throws SQLException {

        String selectQuery = "SELECT * FROM registions WHERE Rusername=?";

        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {

            stmt.setString(1, Uname);

            ResultSet rs = stmt.executeQuery();


            if (rs.next())
            {
                return rs.getString("Remail");

            } else
            {

                System.out.println("Not found");
                return null;
            }

        }

    }

    public String findBal( String Uname ) throws SQLException {
        String selectQuery = "SELECT * FROM "+Uname+" order by id desc limit 1";

        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                return rs.getString("Balance");

            } else
            {

                System.out.println("Not Found");
                return null;
            }

        }

    }

    public void Deposit( String Uname ) throws SQLException {
        int Val=Integer.parseInt(JOptionPane.showInputDialog("Enter Money You Want To Deposit"));
        String selectQuery = "insert into "+Uname+"(Balance,Deposit,Withdrawal,TransferTo,TransferFrom,TransferMoney) values (?,?,?,?,?,?)";
        String balance = findBal(Uname);
        int Bal = Integer.parseInt(balance);
        Bal=Bal+Val;
        String bal = Integer.toString(Bal);
        String val = Integer.toString(Val);
        String Trans = "----";
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            stmt.setString(1,bal);
            stmt.setString(2,val);
            stmt.setString(3,Trans);
            stmt.setString(4,Trans);
            stmt.setString(5,Trans);
            stmt.setString(6,Trans);
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected>0) {
                JOptionPane.showMessageDialog(null, "Sucessfull");
            }
            else {
                JOptionPane.showMessageDialog(null, "UnSucessfull");
            }
            stmt.close();
        }

    }

    public void Withdrawal( String Uname ) throws SQLException {
        int Val= Integer.parseInt(JOptionPane.showInputDialog("Enter Money You Want To WithDrawal"));
        String balance = findBal(Uname);
        int Bal = Integer.parseInt(balance);
        Bal=Bal-Val;
        if(Bal>=0)
        {
            String selectQuery = "insert into "+Uname+"(Balance,Deposit,Withdrawal,TransferTo,TransferFrom,TransferMoney) values (?,?,?,?,?,?)";
            String bal = Integer.toString(Bal);
            String val = Integer.toString(Val);
            String Trans = "----";
            try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
                stmt.setString(1,bal);
                stmt.setString(2,Trans);
                stmt.setString(3,val);
                stmt.setString(4,Trans);
                stmt.setString(5,Trans);
                stmt.setString(6,Trans);
                int rowsAffected = stmt.executeUpdate();
                if(rowsAffected>0) {
                    JOptionPane.showMessageDialog(null, "Sucessfull");
                }
                else {
                    JOptionPane.showMessageDialog(null, "UnSucessfull");
                }
                stmt.close();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"UnSufficient Balance");
        }

    }

    public void Transfer( String Uname , String Uname_1) throws SQLException {
        int Val= Integer.parseInt(JOptionPane.showInputDialog("Enter Money You Want To Send"));
        String balance = findBal(Uname);
        int Bal = Integer.parseInt(balance);
        Bal=Bal-Val;
        if(Bal>=0)
        {
            String selectQuery = "insert into "+Uname+"(Balance,Deposit,Withdrawal,TransferTo,TransferFrom,TransferMoney) values (?,?,?,?,?,?)";
            String selectQuery_1 = "insert into "+Uname_1+"(Balance,Deposit,Withdrawal,TransferTo,TransferFrom,TransferMoney) values (?,?,?,?,?,?)";
            String bal = Integer.toString(Bal);
            String bal_1=findBal(Uname_1);
            int Bal_1= Integer.parseInt(bal_1);
            Bal_1=Bal_1+Val;
            bal_1 = Integer.toString(Bal_1);
            String val = Integer.toString(Val);
            String Trans = "----";
            try (PreparedStatement stmt = conn.prepareStatement(selectQuery_1)) {
                stmt.setString(1,bal_1);
                stmt.setString(2,Trans);
                stmt.setString(3,Trans);
                stmt.setString(4,Trans);
                stmt.setString(5,Uname);
                stmt.setString(6,val);
                int rowsAffected = stmt.executeUpdate();
                if(rowsAffected>0) {
                    JOptionPane.showMessageDialog(null, "Sucessfull");
                    try (PreparedStatement stmt_1 = conn.prepareStatement(selectQuery)) {
                        stmt_1.setString(1,bal);
                        stmt_1.setString(2,Trans);
                        stmt_1.setString(3,Trans);
                        stmt_1.setString(4,Uname_1);
                        stmt_1.setString(5,Trans);
                        stmt_1.setString(6,val);
                        stmt_1.executeUpdate();
                        stmt_1.close();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "UnSucessfull");
                }
                stmt.close();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"UnSufficient Balance");
        }
    }
    public void ChName(String user)
    {
        String sql;
        sql = "update registions set RFname = ? , RLname = ? where Rusername = ? ";
        String fname = JOptionPane.showInputDialog("Enter Your Fisrt Name : ");
        String lname = JOptionPane.showInputDialog("Enter Your Last Name : ");
        try(PreparedStatement stmt_2 = conn.prepareStatement(sql))
        {
            stmt_2.setString(1,fname);
            stmt_2.setString(2,lname);
            stmt_2.setString(3,user);
            stmt_2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucessfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ChEmail(String user) {

        String sql;
        sql = "update registions set Remail = ? where Rusername = ? ";
        String fname = JOptionPane.showInputDialog("Enter Your New Email : ");
        try(PreparedStatement stmt_2 = conn.prepareStatement(sql))
        {
            stmt_2.setString(1,fname);
            stmt_2.setString(2,user);
            stmt_2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucessfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void ChPhone(String user) {

        String sql;
        sql = "update registions set Rnum = ? where Rusername = ? ";
        String fname = JOptionPane.showInputDialog("Enter Your New Phone Number : ");
        try(PreparedStatement stmt_2 = conn.prepareStatement(sql))
        {
            stmt_2.setString(1,fname);
            stmt_2.setString(2,user);
            stmt_2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucessfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void CHPass(String user) {

        String sql;
        sql = "update registions set Rpassword = ? where Rusername = ? ";
        String fname = JOptionPane.showInputDialog("Enter Your New Password : ");
        try(PreparedStatement stmt_2 = conn.prepareStatement(sql))
        {
            String str = Start.hashPassword(fname);
            stmt_2.setString(1,str);
            stmt_2.setString(2,user);
            stmt_2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucessfull");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }



}
