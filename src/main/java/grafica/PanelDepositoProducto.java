package grafica;

import javax.swing.*;
import java.awt.*;
import logica.*;

public class PanelDepositoProducto extends JPanel {

    private Deposito<Producto> deposito;

    public PanelDepositoProducto(Deposito<Producto> deposito) {
        this.deposito = deposito;
        this.setPreferredSize(new Dimension(80,150));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);

        int y = 10;
        for (int i = 0; i < deposito.getCantidad(); i++) {
            Producto p = deposito.getItem(i);

            String nombre = p.getNombre();
            switch (nombre) {
                case "CocaCola" -> g.setColor(Color.RED);
                case "Sprite"   -> g.setColor(Color.GREEN);
                case "Fanta"    -> g.setColor(new Color(250,112,0));
                case "Snickers" -> g.setColor(new Color(150,75,0));
                case "Super8"   -> g.setColor(Color.BLACK);
            }

            g.fillRect(10, y, 60, 20);

            g.setColor(Color.WHITE);
            g.drawString(nombre, 12, y + 15);
            y += 25;
        }
    }
}
