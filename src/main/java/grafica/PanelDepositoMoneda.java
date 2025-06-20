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

    private Color getColorMoneda(int valor) {
        switch (valor) {
            case 500: return Color.ORANGE;
            case 100: return Color.GRAY;
            case 1000: return Color.GREEN;
            default: return null;
        }
    }
}
