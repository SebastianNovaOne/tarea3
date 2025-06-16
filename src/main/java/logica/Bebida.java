package logica;

/**
 * Clase que representa una bebida como producto.
 * Hereda de la clase Producto.
 */
public class Bebida extends Producto {
    private String nombre;

    /**
     * Constructor de la clase Bebida.
     *
     * @param nombre el nombre de la bebida.
     * @param precio el precio de la bebida.
     */
    public Bebida(String nombre, int precio) {
        super(precio);
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el nombre de la bebida.
     *
     * @return el nombre de la bebida.
     */
    public String getNombre() {
        return nombre;
    }
}