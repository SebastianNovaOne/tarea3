package logica;

/**
 * Enumeracion de los dulces y bebidas disponibles.
 * Cada producto tiene un precio asociado.
 */
public enum ProductoEnum {
    COCACOLA(900),
    SPRITE(900),
    FANTA(900),
    SNICKERS(400),
    SUPER8(100);

    private final int precio;

    /**
     * Constructor de la enumeracion.
     *
     * @param precio Precio asociado al producto.
     */
    ProductoEnum(int precio) {
        this.precio = precio;
    }

    /**
     * Retorna el precio del producto.
     *
     * @return Precio.
     */
    public int getPrecio() {
        return precio;
    }
}
