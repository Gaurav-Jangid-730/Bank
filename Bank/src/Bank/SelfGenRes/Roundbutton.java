package Bank.SelfGenRes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Roundbutton extends JButton {
    private int cornerRadius = 20;
    private Color backgroundColor;
    private Color foregroundColor;
    private boolean isPressed = false;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        RoundRectangle2D roundedRect = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);
        g2.setColor(getBackground());
        g2.fill(roundedRect);

        g2.setColor(foregroundColor);
        FontMetrics fontMetrics = g2.getFontMetrics();
        int textX = (width - fontMetrics.stringWidth(getText())) / 2;
        int textY = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        g2.drawString(getText(), textX, textY);

        if (isPressed) {
            float[] hsbValues = Color.RGBtoHSB(backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue(), null);
            Color darkerColor = Color.getHSBColor(hsbValues[0], hsbValues[1], hsbValues[2] * 0.8f);
            g2.setColor(darkerColor);
            g2.fill(roundedRect);
        }

        g2.dispose();
    }

    // Constructor
    public Roundbutton() {
        setOpaque(true);
    }
    public Roundbutton(String sr)
    {
        super(sr);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setFont(getFont().deriveFont(Font.BOLD, 14));
        backgroundColor = new Color(59, 89, 152);
        foregroundColor = Color.WHITE;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                repaint();
            }
        });
    }
    protected void paintBorder(Graphics g) {

    }

    public void setBackgroundColor(Color color) {
        backgroundColor = color;
        repaint();
    }

    public void setForegroundColor(Color color) {
        foregroundColor = color;
        repaint();
    }
    }
