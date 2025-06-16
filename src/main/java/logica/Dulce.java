package logica;

/**
 * Clase que representa un dulce como producto.
 * Extiende la clase Producto y agrega el nombre del dulce.
 */
public class Dulce extends Producto {
    private String nombre;

    /**
     * Constructor del dulce.
     *
     * @param nombre Nombre del dulce.
     * @param precio Precio del dulce.
     */
    public Dulce(String nombre, int precio) {
        super(precio);
        this.nombre = nombre;
    }

    /**
     * Retorna el nombre del dulce.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }
}