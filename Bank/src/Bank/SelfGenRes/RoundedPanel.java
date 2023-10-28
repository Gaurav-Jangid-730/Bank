package Bank.SelfGenRes;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {
    private int cornerRadius = 20;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        RoundRectangle2D roundedRect = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);
        g2.setColor(getBackground());
        g2.fill(roundedRect);

        g2.dispose();
    }

    public RoundedPanel() {
        setOpaque(true);
    }
}
