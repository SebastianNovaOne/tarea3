package grafica;

import javax.swing.*;
import logica.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelExpendedor extends JPanel {

    private Expendedor expendedor;
    private PanelDepositoProducto[] panelesProductos;
    private PanelDepositoMoneda panelMonedasVuelto;
    private PanelDepositoMoneda panelMonedasIngresadas;

    public PanelExpendedor(Expendedor expendedor) {
        this.expendedor = expendedor;
        this.setLayout(null);

        int numProductos = 5;
        panelesProductos = new PanelDepositoProducto[numProductos];

        for (int i = 0; i < numProductos; i++) {
            panelesProductos[i] = new PanelDepositoProducto(expendedor.getDepositoProducto(i));
            panelesProductos[i].setBounds();
            this.add(panelesProductos[i]);
        }

        panelMonedasVuelto = new PanelDepositoMoneda(expendedor.getDepositoVuelto());
        panelMonedasVuelto.setBounds();
        this.add(panelMonedasVuelto);

        panelMonedasIngresadas = new PanelDepositoMoneda(expendedor.getDepositoMonedasIngresadas());
        panelMonedasIngresadas.setBounds();
        this.add(panelMonedasIngresadas);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rellenarDepositosVacios();
                repaint();
            }
        });
    }
}
