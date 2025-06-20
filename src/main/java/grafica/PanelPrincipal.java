package grafica;

import javax.swing.JPanel;
import java.awt.Color;
import logica.Expendedor;

/**
 * Panel principal que contiene los subpaneles del expendedor y comprador.
 */
public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor expendedor;
    private Expendedor expendedorLogica;

    /**
     * Constructor que inicializa el panel principal con los subpaneles.
     */
    public PanelPrincipal() {
        setBackground(Color.WHITE);
        setLayout(null);

        expendedorLogica = new Expendedor(5);
        expendedor = new PanelExpendedor(expendedorLogica);
        comprador = new PanelComprador(expendedor);

        expendedor.setBounds(50, 50, 550, 420);
        comprador.setBounds(650, 50, 400, 220);

        add(expendedor);
        add(comprador);
        comprador.setVisible(true);
    }
}