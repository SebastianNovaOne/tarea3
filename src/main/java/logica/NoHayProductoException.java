package logica;

/**
 * Excepcion que ocurre cuando no queda del producto en el expendedor.
 */
public class NoHayProductoException extends Exception {

    /**
     * Constructor de la excepcion.
     *
     * @param mensaje Mensaje que describe el error.
     */
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }
}