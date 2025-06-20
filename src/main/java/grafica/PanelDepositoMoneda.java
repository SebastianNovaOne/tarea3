package grafica;

import javax.swing.*;
import java.awt.*;
import logica.Deposito;
import logica.Moneda;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDepositoMoneda extends JPanel {

    private Deposito<Moneda> deposito;

    public PanelDepositoMoneda(Deposito<Moneda> deposito) {
        this.deposito = deposito;
        this.setPreferredSize(new Dimension(100, 80));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        int x = 10;
        for (int i = 0; i < deposito.getCantidad(); i++) {
            Moneda m = deposito.getItem(i);

            if (m.getValor() == 1000) {
                g.setColor(Color.GREEN);
                g.fillRect(x, 20, 60, 35);
                g.setColor(Color.BLACK);
                g.drawString("$" + m.getValor(), x + 15, 40);
                x += 70;
            } else {
                g.setColor(getColorMoneda(m.getValor()));
                g.fillOval(x, 20, 35, 35);
                g.setColor(Color.BLACK);
                g.drawString("$" + m.getValor(), x + 5, 40);
                x += 35;
            }
        }
    }

    private Color getColorMoneda(int valor) {
        switch (valor) {
            case 500: return Color.ORANGE;
            case 100: return Color.GRAY;
            case 1000: return Color.GREEN;
            default: return null;
        }
    }
}
