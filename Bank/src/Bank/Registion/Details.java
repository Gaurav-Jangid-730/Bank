package Bank.Registion;

import Bank.Login.Bank;
import Bank.SelfGenRes.RoundedPanel;
import Bank.sql.Sql;
import Bank.sql.SqlD;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

public class Details {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private String str;
    private String st;
    private final JLabel label_1 = new JLabel();
    private final JLabel label_2 = new JLabel();
    private final JLabel label_3 = new JLabel();
    private final JLabel label_4 = new JLabel();
    private final JLabel label_5 = new JLabel();

    public static void main(String FirstName,String LastName,String Email,String Phonenumber,String Occupation,String Income,String Username,String Password) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Details window = new Details(FirstName,LastName,Email,Phonenumber,Occupation,Income,Username,Password);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Details(String FirstName,String LastName,String Email,String Phonenumber,String Occupation,String Income,String Username,String Password) {
        initialize(FirstName,LastName,Email,Phonenumber,Occupation,Income,Username,Password);
    }

    private void initialize (String FirstName,String LastName,String Email,String Phonenumber,String Occupation,String Income,String Username,String Password) {
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/bank.png")));
        Border border1 = BorderFactory.createLineBorder(Color.GREEN, 4);
        frame = new JFrame();
        frame.setIconImage(image.getImage());
        frame.setTitle("Bank Management System");
        frame.setBounds(400, 150, 500, 525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

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


        str = "";
        st = "";

        label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_1.setText("MALE");
        label_1.setForeground(Color.BLACK);
        label_1.setBounds(122, 181, 40, 40);

        label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_2.setText("FEMALE");
        label_2.setForeground(Color.BLACK);
        label_2.setBounds(197, 181, 60, 40);

        label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_3.setText("OTHERS");
        label_3.setForeground(Color.BLACK);
        label_3.setBounds(278, 181, 60, 40);


        label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_4.setText("SAVINGS");
        label_4.setForeground(Color.BLACK);
        label_4.setBounds(122, 215, 60, 40);


        label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_5.setText("CURRENT");
        label_5.setForeground(Color.BLACK);
        label_5.setBounds(273, 215, 60, 40);


        frame.add(label_1);
        frame.add(label_2);
        frame.add(label_3);
        frame.add(label_4);
        frame.add(label_5);

        JCheckBox CB = new JCheckBox();
        JCheckBox CB1 = new JCheckBox();
        JCheckBox CB2 = new JCheckBox();
        JCheckBox CB3 = new JCheckBox();
        JCheckBox CB4 = new JCheckBox();

        CB.setSelected(false);
        CB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CB.setSelected(true);
                CB1.setSelected(false);
                CB4.setSelected(false);
                str="MALE";

            }
        });
        CB.setVisible(true);
        CB.setBounds(160, 181, 40, 40);
        CB.setOpaque(false);
        CB.setBackground(new Color(0, 0, 0, 0));
        frame.getContentPane().add(CB);


        CB1.setSelected(false);
        CB1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CB.setSelected(false);
                CB1.setSelected(true);
                CB4.setSelected(false);
                str="FEMALE";
            }
        });
        CB1.setVisible(true);
        CB1.setBounds(245, 181, 40, 40);
        CB1.setOpaque(false);
        CB1.setBackground(new Color(0, 0, 0, 0));
        frame.getContentPane().add(CB1);


        CB2.setSelected(false);

        CB2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CB3.setSelected(false);
                CB2.setSelected(true);
                st="SAVINGS";
            }
        });
        CB2.setVisible(true);
        CB2.setBounds(180, 215, 40, 40);
        CB2.setOpaque(false);
        CB2.setBackground(new Color(0, 0, 0, 0));
        frame.getContentPane().add(CB2);


        CB3.setSelected(false);
        CB3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CB2.setSelected(false);
                CB3.setSelected(true);
                st="CURRENT";
            }
        });
        CB3.setVisible(true);
        CB3.setBounds(331, 215, 40, 40);
        CB3.setOpaque(false);
        CB3.setBackground(new Color(0, 0, 0, 0));
        frame.getContentPane().add(CB3);


        CB4.setSelected(false);
        CB4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CB1.setSelected(false);
                CB.setSelected(false);
                CB4.setSelected(true);
                str="OTHER";

            }
        });
        CB4.setVisible(true);
        CB4.setBounds(331, 181, 40, 40);
        CB4.setOpaque(false);
        CB4.setBackground(new Color(0, 0, 0, 0));
        frame.getContentPane().add(CB4);

        textField = new JTextField();
        textField.setBounds(120, 111, 228, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(120, 261, 228, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Gender :");
        lblNewJgoodiesLabel.setForeground(Color.BLACK);
        lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel.setBounds(120, 172, 92, 23);
        frame.getContentPane().add(lblNewJgoodiesLabel);
        
        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Account Type :");
        lblNewJgoodiesLabel_1.setForeground(Color.BLACK);
        lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_1.setBounds(120, 205, 109, 23);
        frame.getContentPane().add(lblNewJgoodiesLabel_1);

        textField_2 = new JTextField();
        textField_2.setBounds(120, 304, 228, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(120, 155, 228, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Nationality :");
        lblNewJgoodiesLabel_2.setForeground(Color.BLACK);
        lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_2.setBounds(120, 91, 92, 23);
        frame.getContentPane().add(lblNewJgoodiesLabel_2);

        JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Initial balance :");
        lblNewJgoodiesLabel_3.setForeground(Color.BLACK);
        lblNewJgoodiesLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_3.setBounds(120, 135, 109, 23);
        frame.getContentPane().add(lblNewJgoodiesLabel_3);

        JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Birth Date (DD/MM/YYYY) :");
        lblNewJgoodiesLabel_4.setForeground(Color.BLACK);
        lblNewJgoodiesLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_4.setBounds(120, 241, 194, 23);
        frame.getContentPane().add(lblNewJgoodiesLabel_4);

        JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("KYC Document Name :");
        lblNewJgoodiesLabel_5.setForeground(Color.BLACK);
        lblNewJgoodiesLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewJgoodiesLabel_5.setBounds(120, 284, 157, 23);
        frame.getContentPane().add(lblNewJgoodiesLabel_5);

        JButton btnNewButton = new JButton("NEXT");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sql.main(FirstName,LastName,Email,Phonenumber,Occupation,Income,Username,Password,textField.getText(),str,st,textField_1.getText(),textField_2.getText());
                SqlD.main(Username,textField_3.getText());
                frame.setVisible(false);
                Bank.main(null);
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton.setBounds(188, 335, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/viktor-forgacs-q8XSCZYh6D8-unsplash.jpg"))));
        lblNewLabel.setBounds(0, 0, 525, 500);
        frame.getContentPane().add(lblNewLabel);
    }
}

