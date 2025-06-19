package grafica;

import javax.swing.JPanel;
import logica.*;
import java.util.HashMap;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelComprador extends JPanel {
    private HashMap<String, Zona> zonas;
    private Moneda monedaSeleccionada;
    private ProductoEnum productoSeleccionado;
    private PanelExpendedor expendedor;

    public PanelComprador(PanelExpendedor exp) {
        this.expendedor = exp;
        this.zonas = new HashMap<>();
        setBackground(Color.WHITE);
    }

    private static class Zona {
        int x, y, ancho, alto;
        Color color;
        String texto;

        public Zona(int x, int y, int ancho, int alto, Color color, String texto) {
            this.x = x;
            this.y = y;
            this.ancho = ancho;
            this.alto = alto;
            this.color = color;
            this.texto = texto;
        }

        public void dibujar(Graphics g) {
            g.setColor(color);
            g.fillRect(x, y, ancho, alto);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, ancho, alto);
        }

        public boolean contiene(int px, int py) {
            return px >= x && px <= x + ancho && py >= y && py <= y + alto;
        }
    }
}
