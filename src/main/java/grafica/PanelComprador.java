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
        setBackground(Color.CYAN);

        zonas.put("Moneda100", new Zona(30, 20, 100, 40, Color.ORANGE, "$100"));
        zonas.put("Moneda500", new Zona(150, 20, 100, 40, Color.YELLOW, "$500"));
        zonas.put("Moneda1000", new Zona(270, 20, 100, 40, new Color(0,100,0), "$1000"));

        zonas.put("Producto1", new Zona(30, 100, 100, 40, Color.RED, "CocaCola"));
        zonas.put("Producto2", new Zona(150, 100, 100, 40, Color.GREEN, "Sprite"));
        zonas.put("Producto3", new Zona(270, 100, 100, 40, new Color(250, 112, 0), "Fanta"));
        zonas.put("Producto4", new Zona(30, 160, 100, 40, new Color(150,75,0), "Snickers"));
        zonas.put("Producto5", new Zona(150, 160, 100, 40, Color.LIGHT_GRAY, "Super8"));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (String identificadorZona : zonas.keySet()) {
                    Zona z = zonas.get(identificadorZona);
                    if (z.contiene(e.getX(), e.getY())) {
                        if (identificadorZona.startsWith("Moneda")) {
                            switch (identificadorZona) {
                                case "Moneda100" -> monedaSeleccionada = new Moneda100();
                                case "Moneda500" -> monedaSeleccionada = new Moneda500();
                                case "Moneda1000" -> monedaSeleccionada = new Moneda1000();
                            }
                            System.out.println("Moneda seleccionada: " + identificadorZona);
                            repaint();
                        } else if (identificadorZona.startsWith("Producto")) {
                            if (monedaSeleccionada != null) {
                                switch (identificadorZona) {
                                    case "Producto1" -> productoSeleccionado = ProductoEnum.COCACOLA;
                                    case "Producto2" -> productoSeleccionado = ProductoEnum.SPRITE;
                                    case "Producto3" -> productoSeleccionado = ProductoEnum.FANTA;
                                    case "Producto4" -> productoSeleccionado = ProductoEnum.SNICKERS;
                                    case "Producto5" -> productoSeleccionado = ProductoEnum.SUPER8;
                                }

                                System.out.println("Producto seleccionado: " + productoSeleccionado.name());

                                expendedor.comprar(monedaSeleccionada, productoSeleccionado);
                                monedaSeleccionada = null;
                                productoSeleccionado = null;
                                repaint();
                            } else {
                                System.out.println("Selecciona una moneda antes de elegir un producto.");
                            }
                        }
                        break;
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 14));

        g.drawString("1) Elección de moneda", 30, 15);

        g.drawString("2) Elección de producto", 30, 85);

        for (Zona z : zonas.values()) {
            z.dibujar(g);
        }
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
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString(texto, x + 10, y + 25);
        }

        public boolean contiene(int px, int py) {
            return px >= x && px <= x + ancho && py >= y && py <= y + alto;
        }
    }
}
