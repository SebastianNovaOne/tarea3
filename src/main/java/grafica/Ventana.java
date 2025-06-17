package grafica;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    public Ventana() {
        setTitle("Aplicacion Expendedor");
        setSize(1200, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        PanelPrincipal panel = new PanelPrincipal();
        setContentPane(panel);

        setVisible(true);
    }
}