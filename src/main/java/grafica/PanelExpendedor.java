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
            panelesProductos[i].setBounds(20 + i * 100,50,80,150);
            this.add(panelesProductos[i]);
        }

        panelMonedasVuelto = new PanelDepositoMoneda(expendedor.getDepositoVuelto());
        panelMonedasVuelto.setBounds(0,0,0,0);
        this.add(panelMonedasVuelto);

        panelMonedasIngresadas = new PanelDepositoMoneda(expendedor.getDepositoMonedasIngresadas());
        panelMonedasIngresadas.setBounds(0,0,0,0);
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
        g.fillRect(10, 10, this.getWidth() - 20, this.getHeight() - 20);

        g.setColor(Color.BLACK);
        g.drawString("Expendedor",10,25);
        g.drawString("Vuelto",20,315);
        g.drawString("Monedas Ingresadas",20,215);

        g.setFont(g.getFont().deriveFont(Font.BOLD, 14));
        for (int i = 0; i < panelesProductos.length; i++) {
            int x = 20 + i * 100;
            int y = 40;
            int precio = ProductoEnum.values()[i].getPrecio();
            g.drawString("$" + precio, x + 20, y);
        }
    }
}
