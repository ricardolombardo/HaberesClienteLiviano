package componentesGraficos;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class BordeRedondeado extends AbstractBorder {

	private static final long serialVersionUID = 1L;
	private int radius;

    public BordeRedondeado(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2)); // Grosor del borde
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
