package grafica;

import javax.swing.JFrame;

/**
 * Ventana principal de la aplicacion del expendedor.
 */
public class Ventana extends JFrame {

    /**
     * Crea la ventana principal con initial setup.
     */
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