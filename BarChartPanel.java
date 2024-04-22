import java.awt.*;
import javax.swing.*;


public class BarChartPanel extends JPanel{
    private long[] data;
    private static final int BORDER_GAP = 30;
    private static final Color GRAPH_COLOR = Color.GRAY;
    private static final Color AXIS_COLOR = Color.black;

    public BarChartPanel(long[] data) {
        this.data = data;
    }
    private String[] labels = {"TimSort", "CombSort", "TreeSort", "PigeonHoleSort", "HeapSort", "BitonicSort", "GnomeSort"};
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        // Dibujar ejes x e y
        g2d.setColor(AXIS_COLOR);
        g2d.drawLine(BORDER_GAP, height - BORDER_GAP, BORDER_GAP, BORDER_GAP);
        g2d.drawLine(BORDER_GAP, height - BORDER_GAP, width - BORDER_GAP, height - BORDER_GAP);



        // Calcular los tamaños y posiciones de las barras
        int barWidth = (width - 2 * BORDER_GAP) / data.length;
        long max = Long.MIN_VALUE;
        for (long value : data) {
            max = Math.max(max, value);
        }

        double scaleFactor = (double) (height - 2 * BORDER_GAP) / max;

        // Dibujar las barras y etiquetas
        g2d.setColor(GRAPH_COLOR);
        for (int i = 0; i < data.length; i++) {
            int barHeight = (int) (data[i] * scaleFactor);
            int x = BORDER_GAP + i * barWidth;
            int y = height - BORDER_GAP - barHeight;
            g2d.fillRect(x, y, barWidth, barHeight);
            // Etiquetas para el eje y
            String yAxisLabel = "Tiempo de Ejecucion (ms)";
            g2d.drawString(yAxisLabel, BORDER_GAP / 2, BORDER_GAP / 2);

            for (int k = 0; k < labels.length; k++) {
                int z = BORDER_GAP + (k * (width - 2 * BORDER_GAP) / labels.length);
                int j = height - BORDER_GAP / 2;
                g2d.drawString(labels[k], z, j);
            }
            // Dibujar el valor numérico sobre la barra
            String valueLabel = String.valueOf(data[i]);
            FontMetrics fm = g2d.getFontMetrics();
            int labelWidth = fm.stringWidth(valueLabel);
            g2d.drawString(valueLabel, x + (barWidth - labelWidth) / 2, y - 5);
        }
    }
}