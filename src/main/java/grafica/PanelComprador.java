package grafica;

import javax.swing.JPanel;
import logica.*;
import java.util.HashMap;

public class PanelComprador extends JPanel {
    private HashMap<String, Zona> zonas;
    private Moneda monedaSeleccionada;
    private ProductoEnum productoSeleccionado;
    private PanelExpendedor expendedor;
}
