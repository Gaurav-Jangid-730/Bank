package Bank.Registion;

import Bank.Login.Bank;
import Bank.SelfGenRes.RoundedPanel;
import Bank.SelfGenRes.RoundedPasswordField;
import Bank.SelfGenRes.RoundedTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

public class FillAccountDetails {

    private JFrame frame;
   RoundedTextField textField = new RoundedTextField(10);
   JPasswordField passwordField = new JPasswordField();
    JPasswordField passwordField_1 = new JPasswordField();
    private final JLabel messageLabel = new JLabel();
    private final JLabel messageLabel2 = new JLabel();
    private String str = "";
    private final Suggestion sr = new Suggestion();
    private int count =0;

    public static void Account(String FirstName, String LastName, String Email, String Phonenumber, String Occupation, String Income) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FillAccountDetails window = new FillAccountDetails(FirstName,LastName,Email,Phonenumber,Occupation,Income);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FillAccountDetails(String FirstName,String LastName,String Email,String Phonenumber,String Occupation,String Income) {
        initialize( FirstName,LastName,Email,Phonenumber,Occupation,Income);
    }

    private void initialize(String FirstName,String LastName,String Email,String Phonenumber,String Occupation,String Income) {
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/bank.png")));
        Border border1 = BorderFactory.createLineBorder(Color.GREEN, 4);
        frame = new JFrame();
        frame.setIconImage(image.getImage());
        frame.setTitle("Bank Management System");
        frame.setBounds(400, 150, 500, 525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        messageLabel.setText("");
        messageLabel.setBounds(115, 270, 150, 23);
        frame.add(messageLabel);

        messageLabel2.setBounds(115, 125, 250, 23);
        frame.add(messageLabel2);
        frame.setResizable(false);

        try{
            Font myfont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Bank.class.getResourceAsStream("/Bank/Font/AlexBrush-Regular.ttf")));
            myfont = myfont.deriveFont(Font.PLAIN, 25);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myfont);
            JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Welcome  "+FirstName+" "+LastName);
            lblNewJgoodiesLabel_3.setFont(myfont);
            lblNewJgoodiesLabel_3.setForeground(new Color(0, 0, 0));
            lblNewJgoodiesLabel_3.setBounds(115, 40, 300, 40);
            frame.getContentPane().add(lblNewJgoodiesLabel_3);
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.setBackground(new Color(0, 0, 0, 40));
        roundedPanel.setBounds(80, 35, 320, 390);
        frame.add(roundedPanel);

        try{
            Font myfont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Bank.class.getResourceAsStream("/Bank/Font/AlexBrush-Regular.ttf")));
            myfont = myfont.deriveFont(Font.PLAIN, 20);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myfont);
            JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Creator : Gaurav Jangid");
            lblNewJgoodiesLabel_3.setFont(myfont);
            lblNewJgoodiesLabel_3.setForeground(new Color(0, 0, 0));
            lblNewJgoodiesLabel_3.setBounds(280, 450, 300, 40);
            frame.getContentPane().add(lblNewJgoodiesLabel_3);
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel();
        label1.setBounds(0, 0, 487, 488);
        label1.setBorder(border1);
        frame.getContentPane().add(label1);

        textField.setBounds(115, 105, 246, 25);
        Border border = new BevelBorder(BevelBorder.LOWERED);
        textField.setBorder(border);
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                str = sr.Suggest(textField.getText());
                messageLabel2.setText(str);
                if(str!=null){
                    count =1 ;
                }
                if(str==null){
                    count =0 ;
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                str = sr.Suggest(textField.getText());
                messageLabel2.setText(str);
                if(str!=null){
                    count =1 ;
                }
                if(str==null){
                    count =0 ;
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                str = sr.Suggest(textField.getText());
                messageLabel2.setText(str);
                if(str!=null){
                    count =1 ;
                }
                if(str==null){
                    count =0 ;
                }
            }
        });
        frame.getContentPane().add(textField);


        RoundedPasswordField.RoundPasswordField(passwordField);
        passwordField.setBounds(115, 168, 246, 25);
        Border border2 = new BevelBorder(BevelBorder.LOWERED);
        passwordField.setBorder(border2);
        frame.getContentPane().add(passwordField);

        RoundedPasswordField.RoundPasswordField(passwordField_1);
        passwordField_1.setBounds(115, 233, 246, 25);
        Border border3 = new BevelBorder(BevelBorder.LOWERED);
        passwordField_1.setBorder(border3);
        passwordField_1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkPasswords();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkPasswords();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                checkPasswords();
            }
        });
        frame.getContentPane().add(passwordField_1);

        JButton btnNewButton_1 = new JButton("NEXT");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
               if(count!=1) {
                   String Username = textField.getText();
                   @SuppressWarnings("deprecation")
                   String Password = passwordField.getText();
                   frame.setVisible(false);
                   Details.main(FirstName, LastName, Email, Phonenumber, Occupation, Income, Username, Password);
               }
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton_1.setBounds(190, 300, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Type Username :");
        lblNewJgoodiesLabel.setForeground(Color.black);
        lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel.setBounds(115, 83, 129, 25);
        frame.getContentPane().add(lblNewJgoodiesLabel);

        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Type Password :");
        lblNewJgoodiesLabel_1.setForeground(Color.BLACK);
        lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_1.setBounds(115, 146, 129, 25);
        frame.getContentPane().add(lblNewJgoodiesLabel_1);

        JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Retype Password :");
        lblNewJgoodiesLabel_2.setForeground(Color.BLACK);
        lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_2.setBounds(115, 210, 129, 25);
        frame.getContentPane().add(lblNewJgoodiesLabel_2);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/viktor-forgacs-q8XSCZYh6D8-unsplash.jpg"))));
        lblNewLabel.setBounds(0, 0, 525, 500);
        frame.getContentPane().add(lblNewLabel);
    }
    private void checkPasswords() {
        char[] pass1 = passwordField.getPassword();
        char[] pass2 = passwordField_1.getPassword();

        if (pass1.length == 0 && pass2.length == 0) {
            messageLabel.setText("");
        } else if (pass1.length == pass2.length) {
            boolean match = true;
            for (int i = 0; i < pass1.length; i++) {
                if (pass1[i] != pass2[i]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                messageLabel.setText("Passwords match!");
            } else {
                messageLabel.setText("Passwords do not match!");
            }
        } else {
            messageLabel.setText("Passwords do not match!");
        }
    }
}
