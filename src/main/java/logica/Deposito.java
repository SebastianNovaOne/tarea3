package logica;

import java.util.ArrayList;

/**
 * Clase generica que representa un deposito de items.
 * Permite almacenar items de cualquier tipo, agregarlos y retirarlos en orden.
 *
 * @param <T> Tipo de los items que se guardan en el deposito.
 */
public class Deposito<T> {
    private final ArrayList<T> items;

    /**
     * Crea un nuevo deposito vacio para guardar items.
     */
    public Deposito() {
        items = new ArrayList<>();
    }

    /**
     * Agrega un item al final del deposito.
     *
     * @param item Elemento que se desea agregar.
     */
    public void agregar(T item) {
        items.add(item);
    }

    /**
     * Retira el primer item del deposito.
     *
     * @return El primer item si existe, o null si el deposito esta vacio.
     */
    public T retirar() {
        if (items.isEmpty()) return null;
        return items.remove(0);
    }

    /**
     * Indica si el deposito esta vacio.
     *
     * @return true si no hay items en el deposito, false en caso contrario.
     */
    public boolean estaVacio() {
        return items.isEmpty();
    }

    /**
     * Devuelve la cantidad de items almacenados en el deposito.
     *
     * @return el numero de items en el deposito.
     */
    public int getCantidad() {
        return items.size();
    }

    /**
     * Devuelve el item ubicado en el indice especificado.
     *
     * @param index posicion del item a obtener.
     * @return el item en la posicion indicada, o null si el indice no es valido.
     */
    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }
}