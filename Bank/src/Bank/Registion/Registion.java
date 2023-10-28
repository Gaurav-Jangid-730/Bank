package Bank.Registion;

import Bank.Login.Bank;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

public class Registion {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registion window = new Registion();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public Registion() {
        initialize();
    }
    private void initialize() {
        Border border1 = BorderFactory.createLineBorder(Color.GREEN, 4);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/bank.png")));
        frame = new JFrame();
        frame.setTitle("Bank Management System");
        frame.setBounds(400, 150, 500, 525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setIconImage(image.getImage());
        frame.setResizable(false);

        try{
            Font myfont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Bank.class.getResourceAsStream("/Bank/Font/AlexBrush-Regular.ttf")));
            myfont = myfont.deriveFont(Font.PLAIN, 20);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myfont);
            JLabel lblNewJgoodiesLabel_6 = DefaultComponentFactory.getInstance().createLabel("Creator : Gaurav Jangid");
            lblNewJgoodiesLabel_6.setFont(myfont);
            lblNewJgoodiesLabel_6.setForeground(new Color(0, 0, 0));
            lblNewJgoodiesLabel_6.setBounds(280, 450, 300, 40);
            frame.getContentPane().add(lblNewJgoodiesLabel_6);
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        JLabel Label = DefaultComponentFactory.getInstance().createLabel(" REGISTION");
        Label.setFont(new Font("Tahoma", Font.BOLD, 20));
        Label.setIcon(new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/login.png"))).getImage().getScaledInstance(32,32,Image.SCALE_SMOOTH)));
        Label.setBounds(155, 40, 300, 50);
        frame.getContentPane().add(Label);

        JLabel label1 = new JLabel();
        label1.setBounds(0, 0, 487, 488);
        label1.setBorder(border1);
        frame.getContentPane().add(label1);

        textField = new JTextField();
        textField.setBounds(115, 122, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(272, 122, 86, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(115, 169, 243, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(115, 213, 243, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(115, 255, 86, 20);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(272, 255, 86, 20);
        frame.getContentPane().add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("First Name :\r\n");
        lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel.setBounds(115, 97, 92, 23);
        frame.getContentPane().add(lblNewJgoodiesLabel);

        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Last Name :");
        lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_1.setBounds(272, 97, 92, 23);
        frame.getContentPane().add(lblNewJgoodiesLabel_1);

        JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Emali :");
        lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_2.setBounds(115, 146, 92, 20);
        frame.getContentPane().add(lblNewJgoodiesLabel_2);

        JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Phone Number :\r\n");
        lblNewJgoodiesLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_3.setBounds(115, 190, 111, 20);
        frame.getContentPane().add(lblNewJgoodiesLabel_3);

        JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Occupation :");
        lblNewJgoodiesLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_4.setBounds(115, 230, 92, 28);
        frame.getContentPane().add(lblNewJgoodiesLabel_4);

        JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("Income :");
        lblNewJgoodiesLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_5.setBounds(272, 230, 92, 28);
        frame.getContentPane().add(lblNewJgoodiesLabel_5);

        JButton btnNewButton = new JButton("Register ->");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String FirstName = textField.getText();
                String LastName = textField_1.getText();
                String Email = textField_2.getText();
                String Phonenumber = textField_3.getText();
                String Occupation = textField_4.getText();
                String Income = textField_5.getText();
                frame.setVisible(false);
                FillAccountDetails.Account(FirstName, LastName, Email, Phonenumber, Occupation, Income);
            }
        });
        btnNewButton.setBounds(259, 300, 100, 23);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("<- Go Back");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                frame.dispose();
                Bank.main(null);

            }
        });
        btnNewButton_1.setBounds(115, 300, 100, 23);
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        frame.getContentPane().add(btnNewButton_1);


        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/viktor-forgacs-q8XSCZYh6D8-unsplash.jpg"))));
        lblNewLabel.setBounds(0, 0, 525, 500);
        frame.getContentPane().add(lblNewLabel);


    }
}
