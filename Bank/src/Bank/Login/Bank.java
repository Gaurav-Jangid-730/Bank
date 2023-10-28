package Bank.Login;

import Bank.Registion.Registion;
import Bank.SelfGenRes.Roundbutton;
import Bank.SelfGenRes.RoundedPanel;
import Bank.SelfGenRes.RoundedPasswordField;
import Bank.SelfGenRes.RoundedTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;


public class Bank {

    private JFrame frame;
    private JCheckBox CB;
    private int Count = 1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Bank window = new Bank();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Window Not Created");
                }
            }
        });
    }
    public Bank() {
        try {
            initialize();
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private void initialize() throws IOException, FontFormatException {
        Border border1 = BorderFactory.createLineBorder(Color.GREEN, 4);
        frame = new JFrame();
        frame.setTitle("Bank Management System");
        frame.setForeground(Color.CYAN);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/bank.png")));
        frame.setBounds(400, 150, 500, 525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setIconImage(image.getImage());
        frame.setResizable(false);

        JLabel label1 = new JLabel();
        label1.setBounds(0, 0, 487, 488);
        label1.setBorder(border1);
        frame.getContentPane().add(label1);

        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.setBackground(new Color(0, 0, 0, 40));
        roundedPanel.setBounds(80, 35, 320, 390);
        frame.add(roundedPanel);

        RoundedTextField TF = new RoundedTextField(10);
        TF.setBounds(118, 114, 245, 20);
        Border border = new BevelBorder(BevelBorder.LOWERED);
        TF.setBorder(border);
        frame.getContentPane().add(TF);

        JPasswordField PF = new JPasswordField();
        RoundedPasswordField.RoundPasswordField(PF);
        PF.setBounds(118, 169, 245, 20);
        Border border2 = new BevelBorder(BevelBorder.LOWERED);
        PF.setBorder(border2);
        frame.getContentPane().add(PF);

        CB = new JCheckBox();
        CB.setSelected(false);
        CB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (Count == 1) {
                    Count = Count * -1;
                    CB.setSelected(true);
                } else {
                    Count = Count * -1;
                    CB.setSelected(false);
                }
            }
        });
        CB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        CB.setVisible(true);
        CB.setBounds(100, 202, 40, 40);
        CB.setOpaque(false);
        CB.setBackground(new Color(0, 0, 0, 0));
        frame.getContentPane().add(CB);

        JLabel label4 = new JLabel("Access to this system is subject to compliance");
        JLabel label5 = new JLabel("with our bank's terms and conditions");
        label5.setBounds(125, 220, 300, 15);
        label4.setBounds(125, 208, 300, 15);
        frame.getContentPane().add(label4);
        frame.getContentPane().add(label5);

        Roundbutton rb = new Roundbutton("Login");
        rb.setBorderPainted(false);
        rb.setFocusable(false);
        rb.setContentAreaFilled(false);
        rb.setBounds(175, 255, 120, 30);
        rb.setBackground(new Color(102, 255, 255, 200));
        rb.setForegroundColor(new Color(0, 0, 0, 170));
        frame.getContentPane().add(rb);
        rb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (Count == -1) {
                    String user = TF.getText();
                    String pass = PF.getText();
                    frame.setVisible(false);
                    Start.StartBank(user, pass);
                } else {
                    JOptionPane.showMessageDialog(null, "Please Accept Terms And Conditions");
                }
            }
        });
        rb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });

        JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Username :");
        lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewJgoodiesLabel.setBounds(118, 98, 92, 15);
        frame.getContentPane().add(lblNewJgoodiesLabel);

        JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Password :");
        lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewJgoodiesLabel_1.setBounds(118, 152, 92, 15);
        frame.getContentPane().add(lblNewJgoodiesLabel_1);

        JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Don't Have Any Account ? Create A New Account.");
        lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewJgoodiesLabel_2.setBounds(118, 315, 250, 14);
        frame.getContentPane().add(lblNewJgoodiesLabel_2);

        JLabel label = DefaultComponentFactory.getInstance().createLabel("Sign Up");
        label.setFont(new Font("Tahoma", Font.BOLD, 11));
        label.setBounds(215, 330, 50, 15);
        label.setForeground(new Color(0, 128, 255));
        frame.getContentPane().add(label);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                frame.setVisible(false);
                Registion.main(null);
            }
        });
        rb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
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
            JOptionPane.showMessageDialog(null,"File Not Found");
        }
        JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel(" LOGIN");
        lblNewJgoodiesLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewJgoodiesLabel_4.setIcon(new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/login.png"))).getImage().getScaledInstance(32,32,Image.SCALE_SMOOTH)));
        lblNewJgoodiesLabel_4.setBounds(180, 40, 300, 50);
        frame.getContentPane().add(lblNewJgoodiesLabel_4);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Bank/Icon/viktor-forgacs-q8XSCZYh6D8-unsplash.jpg"))));
        lblNewLabel.setBounds(0, 0, 525, 500);
        frame.getContentPane().add(lblNewLabel);
    }
}
