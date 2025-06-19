package grafica;

import javax.swing.*;
import java.awt.*;
import logica.*;

public class PanelDepositoProducto extends JPanel {

    private Deposito<Producto> deposito;

    public PanelDepositoProducto(Deposito<Producto> deposito) {
        this.deposito = deposito;
        this.setPreferredSize(new Dimension(0,0));
    }
}
