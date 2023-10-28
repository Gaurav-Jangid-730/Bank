package Bank.SelfGenRes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoundedPasswordField {
    public static void RoundPasswordField(JPasswordField passwordField) {
        passwordField.setOpaque(false);
        passwordField.setBorder(new RoundedBorder(20)); // You can adjust the corner radius here
        passwordField.setFont(new Font("Plain", Font.PLAIN, 14));
    }

    // Custom Border class for rounded edges
    private static class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}
