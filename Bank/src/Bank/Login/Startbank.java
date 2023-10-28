package Bank.Login;

import Bank.SelfGenRes.RoundedPanel;
import Bank.sql.Manage;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static javax.swing.JOptionPane.*;

public class Startbank {
    private static String bal;

    static void Bank(String str, String username) throws SQLException {
        ImageIcon image = new ImageIcon(Objects.requireNonNull(Startbank.class.getResource("/Bank/Icon/bank.png")));
        Border border1 = BorderFactory.createLineBorder(Color.GREEN, 4);
        JFrame frame = new JFrame();
        frame.setIconImage(image.getImage());
        frame.setTitle("Bank Management System");
        frame.setBounds(400, 150, 700, 625);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setLayout(null);;

        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.setBackground(new Color(0, 0, 0, 40));
        roundedPanel.setBounds(-10, -10, 320, 690);
        frame.add(roundedPanel);

        JButton btnNewButton_7 = new JButton("<---       Back");
        btnNewButton_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                Bank.main(null);
            }
        });
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_7.setBounds(75, 540, 150, 23);
        btnNewButton_7.setVisible(true);
        btnNewButton_7.setFocusable(false);
        frame.getContentPane().add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("Account");
        btnNewButton_8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Manage mn = new Manage();
                String str;
                str = JOptionPane.showInputDialog(null,"What do you want to change 1)Name 2)Email 3)Phone 4)Password");
                if(Objects.equals(str, "Name") || Objects.equals(str, "name") || Objects.equals(str, "1")) {
                    mn.ChName(username);
                }
                if(Objects.equals(str, "Email") || Objects.equals(str, "email") || Objects.equals(str, "2")) {
                    mn.ChEmail(username);
                }
                if(Objects.equals(str, "phone") || Objects.equals(str, "Phone") || Objects.equals(str, "3")){
                    mn.ChPhone(username);
                }
                if(Objects.equals(str, "Password") || Objects.equals(str, "password") || Objects.equals(str, "4")) {
                    mn.CHPass(username);
                }
            }
        });
        btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_8.setBounds(330, 100, 150, 150);
        btnNewButton_8.setVisible(true);
        btnNewButton_8.setFocusable(false);
        frame.getContentPane().add(btnNewButton_8);

        JButton btnNewButton_9 = new JButton("Deposit");
        btnNewButton_9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Manage mn = new Manage();
                try {
                    mn.Deposit(username);
                } catch (SQLException e) {
                    showMessageDialog(null,"Error");
                }
            }
        });
        btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_9.setBounds(505, 100, 150, 150);
        btnNewButton_9.setVisible(true);
        btnNewButton_9.setFocusable(false);
        frame.getContentPane().add(btnNewButton_9);

        JButton btnNewButton_1 = new JButton("Withdrawal");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Manage mn_2 = new Manage();
                try {
                    mn_2.Withdrawal(username);
                } catch (SQLException e) {
                    showMessageDialog(null,"Error");
                }
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1.setBounds(330, 275, 150, 150);
        btnNewButton_1.setVisible(true);
        btnNewButton_1.setFocusable(false);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Transfer");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelectOpt.main(username);
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_2.setBounds(505, 275, 150, 150);
        btnNewButton_2.setVisible(true);
        btnNewButton_2.setFocusable(false);
        frame.getContentPane().add(btnNewButton_2);

        try {
            Font myfont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Bank.class.getResourceAsStream("/Bank/Font/AlexBrush-Regular.ttf")));
            myfont = myfont.deriveFont(Font.PLAIN, 23);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myfont);
            JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Welcome  " + str);
            lblNewJgoodiesLabel_3.setFont(myfont);
            lblNewJgoodiesLabel_3.setForeground(new Color(0, 0, 0));
            lblNewJgoodiesLabel_3.setBounds(25, 25, 300, 40);
            frame.getContentPane().add(lblNewJgoodiesLabel_3);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        try{
            Font myfont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Bank.class.getResourceAsStream("/Bank/Font/AlexBrush-Regular.ttf")));
            myfont = myfont.deriveFont(Font.PLAIN, 15);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myfont);
            JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Balance : "+bal);
            lblNewJgoodiesLabel_3.setFont(myfont);
            lblNewJgoodiesLabel_3.setForeground(new Color(0, 0, 0));
            lblNewJgoodiesLabel_3.setBounds(25, 65, 300, 40);
            frame.getContentPane().add(lblNewJgoodiesLabel_3);
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        String str2 = "";
        Manage mn = new Manage();
        str2 = mn.findRuser(username);
        try{
            Font myfont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Bank.class.getResourceAsStream("/Bank/Font/AlexBrush-Regular.ttf")));
            myfont = myfont.deriveFont(Font.PLAIN, 15);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myfont);
            JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Username : "+str2);
            lblNewJgoodiesLabel_3.setFont(myfont);
            lblNewJgoodiesLabel_3.setForeground(new Color(0, 0, 0));
            lblNewJgoodiesLabel_3.setBounds(25, 50, 300, 40);
            frame.getContentPane().add(lblNewJgoodiesLabel_3);
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        String str3 = "";
        str3 = mn.findRemail(username);
        try{
            Font myfont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Bank.class.getResourceAsStream("/Bank/Font/AlexBrush-Regular.ttf")));
            myfont = myfont.deriveFont(Font.PLAIN, 15);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myfont);
            JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Email : "+str3);
            lblNewJgoodiesLabel_3.setFont(myfont);
            lblNewJgoodiesLabel_3.setForeground(new Color(0, 0, 0));
            lblNewJgoodiesLabel_3.setBounds(25, 80, 300, 40);
            frame.getContentPane().add(lblNewJgoodiesLabel_3);
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        String str4 = "";
        str4 = mn.findRphone(username);
        try{
            Font myfont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Bank.class.getResourceAsStream("/Bank/Font/AlexBrush-Regular.ttf")));
            myfont = myfont.deriveFont(Font.PLAIN, 15);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myfont);
            JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Phone : "+str4);
            lblNewJgoodiesLabel_3.setFont(myfont);
            lblNewJgoodiesLabel_3.setForeground(new Color(0, 0, 0));
            lblNewJgoodiesLabel_3.setBounds(25, 95, 300, 40);
            frame.getContentPane().add(lblNewJgoodiesLabel_3);
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        try{
            Font myfont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Bank.class.getResourceAsStream("/Bank/Font/AlexBrush-Regular.ttf")));
            myfont = myfont.deriveFont(Font.PLAIN, 20);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myfont);
            JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Creator : Gaurav Jangid");
            lblNewJgoodiesLabel_3.setFont(myfont);
            lblNewJgoodiesLabel_3.setForeground(new Color(0, 0, 0));
            lblNewJgoodiesLabel_3.setBounds(480, 550, 300, 40);
            frame.getContentPane().add(lblNewJgoodiesLabel_3);
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel();
        label1.setBounds(0, 0, 687, 588);
        label1.setBorder(border1);
        frame.getContentPane().add(label1);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(Objects.requireNonNull(Startbank.class.getResource("/Bank/Icon/viktor-forgacs-q8XSCZYh6D8-unsplash.jpg"))));
        lblNewLabel_1.setBounds(-34, -127, 840, 733);
        frame.getContentPane().add(lblNewLabel_1);

    }
    public static void Start(String user)
    {
        try {
            Manage mg = new Manage();
            String str = mg.findFName(user);
            bal=mg.findBal(user);
            Bank(str , user);
        } catch (Exception e) {
            showMessageDialog(null,"Mysql error");
        }


    }
    public static void main(String[] argu){
        Start("gauravjangid");
    }
}
