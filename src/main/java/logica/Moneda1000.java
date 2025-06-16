package logica;

/**
 * Clase que representa una moneda de 1000 unidades.
 * Hereda de la clase Moneda.
 */
public class Moneda1000 extends Moneda {

    /**
     * Retorna el valor de la moneda, que es 1000.
     *
     * @return Valor de la moneda (1000).
     */
    @Override
    public int getValor() {
        return 1000;
    }
}
