package grafica;

import javax.swing.*;
import logica.*;
import java.awt.*;
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

    public void comprar(Moneda moneda, ProductoEnum producto) {
        try {
            expendedor.comprarProducto(moneda, producto);
            Producto comprado = expendedor.getProducto();
            if (comprado != null) {
                if (comprado instanceof Bebida) {
                    System.out.println("glu glu glu");
                } else if (comprado instanceof Dulce) {
                    System.out.println("ñom ñom ñom");
                }
            }
            repaint();
        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e) {
            System.out.println("Error al comprar: " + e.getMessage());
        }
    }

    private void rellenarDepositosVacios() {
        for (int i = 0; i < panelesProductos.length; i++) {
            var deposito = expendedor.getDepositoProducto(i);
            if (deposito.estaVacio()) {
                ProductoEnum tipo = ProductoEnum.values()[i];
                for (int j = 0; j < 5; j++) {
                    deposito.agregar(expendedor.getProductoPorTipo(tipo));
                }
                panelesProductos[i].repaint();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect();

        g.setColor(Color.BLACK);
        g.drawString("Expendedor",);
        g.drawString("Vuelto",);
        g.drawString("Monedas Ingresadas",);

    }
}
