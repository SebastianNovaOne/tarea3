package logica;

/**
 * Clase abstracta que representa un producto generico.
 * Contiene el precio y define el metodo para obtener el nombre.
 */
public abstract class Producto {
    protected int precio;

    /**
     * Constructor del producto.
     *
     * @param precio Precio del producto.
     */
    public Producto(int precio) {
        this.precio = precio;
    }

    /**
     * Metodo abstracto que retorna el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public abstract String getNombre();

    public int getPrecio() {
        return precio;
    }
}