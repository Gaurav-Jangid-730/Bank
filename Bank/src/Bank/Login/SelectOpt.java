package Bank.Login;
import Bank.sql.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Objects;

public class SelectOpt {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    public static String str;
    public static int count=2;
    public static int count_1=0;
    public static String data;
    public static void main(String User) {
        try {
            SelectOpt window = new SelectOpt(User);
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public SelectOpt(String User) {
        initialize(User);
    }
    private void initialize(String User) {
        Border border1 = BorderFactory.createLineBorder(Color.GREEN, 4);
        frame = new JFrame();
        frame.setTitle("Bank Management System");
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/bank.png")));
       //frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(image.getImage());
        frame.getContentPane().setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(0, 0, 436, 263);
        label1.setBorder(border1);
        frame.getContentPane().add(label1);

        textField = new JTextField();
        textField.setBounds(41, 80, 347, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(41, 188, 347, 20);
        textField_1.setVisible(false);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Enter Account Username :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setBounds(41, 163, 194, 20);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel mylabel = new JLabel("Enter Account Username :");
        mylabel.setFont(new Font("Tahoma",Font.BOLD,13));
        mylabel.setBounds(41,54,192,20);
        frame.getContentPane().add(mylabel);

        JLabel lblOr = new JLabel("    or");
        lblOr.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblOr.setBounds(189, 131, 46, 14);
        frame.getContentPane().add(lblOr);

        JLabel lblPleaseEnterRight = new JLabel("Please enter Right Account Number.");
        lblPleaseEnterRight.setVisible(false);
        lblPleaseEnterRight.setForeground(Color.RED);
        lblPleaseEnterRight.setBounds(41, 101, 256, 14);
        frame.add(lblPleaseEnterRight);

        JLabel lblPleaseEnterRight_1 = new JLabel("Please enter Right Username.");
        lblPleaseEnterRight_1.setVisible(false);
        lblPleaseEnterRight_1.setForeground(Color.RED);
        lblPleaseEnterRight_1.setBounds(41, 210, 256, 14);
        frame.getContentPane().add(lblPleaseEnterRight_1);

        JRadioButton radioButton = new JRadioButton("");
        JRadioButton radioButton_1 = new JRadioButton("");
        radioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                radioButton_1.setSelected(false);
                radioButton.setSelected(true);
                textField_1.setVisible(false);
                textField.setVisible(true);
                count=1;
                lblPleaseEnterRight_1.setVisible(false);
            }
        });
        radioButton.setBounds(6, 55, 21, 23);
        radioButton.setSelected(true);
        frame.getContentPane().add(radioButton);

        radioButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                radioButton.setSelected(false);
                radioButton_1.setSelected(true);
                textField_1.setVisible(true);
                textField.setVisible(false);
                count=2;
                lblPleaseEnterRight.setVisible(false);
            }
        });
        radioButton_1.setBounds(6, 163, 21, 23);
        radioButton_1.setSelected(false);
        frame.getContentPane().add(radioButton_1);

        JButton btnNext = new JButton("Next");
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                frame.setVisible(false);

                if (count==1)
                {
                    str= textField.getText();
                    lblPleaseEnterRight.setVisible(true);
                    lblPleaseEnterRight_1.setVisible(false);
                }
                if (count==2)
                {
                    str= textField_1.getText();
                    lblPleaseEnterRight.setVisible(false);
                    lblPleaseEnterRight_1.setVisible(true);
                }
                data = CheckAcc.main(str, count);
                if (data==null)
                {
                    frame.setVisible(true);
                }
                else
                {
                    frame.dispose();
                    Manage mn = new Manage();
                    try {
                        mn.Transfer(User,data);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        btnNext.setBounds(335, 228, 89, 23);
        frame.getContentPane().add(btnNext);

        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/viktor-forgacs-q8XSCZYh6D8-unsplash.jpg"))));
        lblNewLabel_2.setBounds(0, 0, 525, 500);
        frame.getContentPane().add(lblNewLabel_2);

    }
}
