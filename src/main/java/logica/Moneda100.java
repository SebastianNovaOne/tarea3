package logica;

/**
 * Clase que representa una moneda de 100 unidades.
 * Hereda de la clase Moneda.
 */
public class Moneda100 extends Moneda {

    /**
     * Retorna el valor de la moneda, que es 100.
     *
     * @return Valor de la moneda (100).
     */
    @Override
    public int getValor() {
        return 100;
    }
}
