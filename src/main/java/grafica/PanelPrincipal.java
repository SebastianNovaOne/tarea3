package grafica;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import logica.Expendedor;

public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor expendedor;
    private Expendedor expendedorLogica;

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        expendedor.repaint();
        comprador.repaint();
    }
}
