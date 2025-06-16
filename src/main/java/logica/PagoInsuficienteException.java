package logica;

/**
 * Excepcion que se lanza cuando el pago realizado es insuficiente.
 * Si el valor de la moneda es menor al valor del producto ocurre este error.
 */
public class PagoInsuficienteException extends Exception {

    /**
     * Constructor de la excepcion.
     *
     * @param mensaje Mensaje que describe el error.
     */
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}