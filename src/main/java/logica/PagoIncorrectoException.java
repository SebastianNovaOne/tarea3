package logica;

/**
 * Excepcion que se lanza cuando el pago realizado es incorrecto.
 * Por ejemplo, si se intenta usar una moneda de 200 pesos.
 */
public class PagoIncorrectoException extends Exception {

    /**
     * Constructor de la excepcion.
     *
     * @param mensaje Mensaje que describe el error.
     */
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}
