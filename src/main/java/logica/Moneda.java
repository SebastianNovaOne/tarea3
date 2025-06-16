package logica;

/**
 * Clase abstracta que representa una moneda.
 * Implementa la interfaz Comparable para permitir la comparacion entre monedas.
 */
public abstract class Moneda implements Comparable<Moneda> {

    /**
     * Retorna el valor de la moneda.
     *
     * @return Valor de la moneda en unidades.
     */
    public abstract int getValor();

    /**
     * Compara esta moneda con otra.
     *
     * @param otra La otra moneda con la que se compara.
     * @return Un numero negativo si esta moneda es menor, 0 si son iguales, o un numero positivo si es mayor.
     */
    @Override
    public int compareTo(Moneda otra) {
        return Integer.compare(this.getValor(), otra.getValor());
    }

    /**
     * Retorna una representacion en cadena de texto de la moneda.
     *
     * @return Una cadena con el nombre de la clase, el valor y la serie (de hashCode).
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (serie: " + this.hashCode() + ", valor: $" + getValor() + ")";
    }
}