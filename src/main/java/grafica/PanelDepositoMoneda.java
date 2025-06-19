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
        this.setPreferredSize(new Dimension(0, 0));
    }
}
