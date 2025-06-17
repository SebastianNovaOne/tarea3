package grafica;

import javax.swing.JPanel;
import logica.Expendedor;

import java.awt.*;

public class PanelPrincipal extends JPanel{
    private PanelComprador comprador;
    private PanelExpendedor expendedor;
    private Expendedor expendedorLogica;

    public PanelPrincipal() {
        setBackground(Color.WHITE);
        setLayout(null);

        expendedorLogica = new Expendedor(5);
        expendedor = new PanelExpendedor(expendedorLogica);
        comprador = new PanelComprador(expendedor);

        expendedor.setBounds(0, 0, 0, 0);
        comprador.setBounds(0, 0, 0, 0);

        add(expendedor);
        add(comprador);
        comprador.setVisible(true);
    }
}
