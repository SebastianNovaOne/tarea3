package logica;

import java.util.ArrayList;

/**
 * Clase generica que representa un deposito de elementos.
 * Permite almacenar elementos de cualquier tipo, agregarlos y retirarlos en orden.
 *
 * @param <T> Tipo de los elementos que se guardan en el deposito.
 */
public class Deposito<T> {
    private final ArrayList<T> items;

    /**
     * Crea un nuevo deposito vacio para guardar elementos.
     */
    public Deposito() {
        items = new ArrayList<>();
    }

    /**
     * Agrega un elemento al final del deposito.
     *
     * @param item Elemento que se desea agregar.
     */
    public void agregar(T item) {
        items.add(item);
    }

    /**
     * Retira el primer elemento del deposito.
     *
     * @return El primer elemento si existe, o null si el deposito esta vacio.
     */
    public T retirar() {
        if (items.isEmpty()) return null;
        return items.remove(0);
    }
}