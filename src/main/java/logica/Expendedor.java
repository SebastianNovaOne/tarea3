package logica;

/**
 * Clase expendedor de productos.
 * Gestiona los productos y el vuelto que se entrega al comprador.
 */
public class Expendedor {

    /**
     * Arreglo que almacena los depositos de productos, donde cada indice corresponde a un producto.
     */
    private final Deposito<Producto>[] depositos;

    /**
     * Deposito que maneja el vuelto que se entrega al comprador.
     */
    private final Deposito<Moneda> depositoVuelto = new Deposito<>();

    /**
     * Deposito que almacena las monedas ingresadas por el usuario.
     */
    private final Deposito<Moneda> depositoMonedasIngresadas = new Deposito<>();

    /**
     * Producto comprado, guardado para ser entregado mediante getProducto().
     */
    private Producto productoComprado;

    /**
     * Constructor que inicia los depositos de productos en el expendedor.
     * Crea un deposito para cada tipo de producto y lo llena con la cantidad inicial de productos.
     *
     * @param cantidadInicial la cantidad de cada producto que se agrega al expendedor.
     */
    public Expendedor(int cantidadInicial) {
        depositos = new Deposito[ProductoEnum.values().length];
        for (int i = 0; i < ProductoEnum.values().length; i++) {
            depositos[i] = new Deposito<>();
            for (int j = 0; j < cantidadInicial; j++) {
                depositos[i].agregar(crearProducto(ProductoEnum.values()[i]));
            }
        }
    }

    /**
     * Realiza la compra de un producto en el expendedor.
     * Verifica el pago y deja el producto comprado listo para obtener mediante getProducto().
     * También calcula y almacena el vuelto.
     *
     * @param moneda   el tipo de moneda utilizada para el pago.
     * @param producto el producto que se desea comprar.
     * @throws PagoIncorrectoException   si la moneda es nula.
     * @throws PagoInsuficienteException si el pago no es suficiente para cubrir el precio.
     * @throws NoHayProductoException    si el producto solicitado no está disponible.
     */
    public void comprarProducto(Moneda moneda, ProductoEnum producto)
            throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        if (moneda == null) {
            throw new PagoIncorrectoException("Moneda nula.");
        }

        int indice = producto.ordinal();
        if (depositos[indice] == null) {
            depositoVuelto.agregar(moneda);
            throw new NoHayProductoException("No disponible.");
        }

        int precio = producto.getPrecio();
        int pago = moneda.getValor();

        depositoMonedasIngresadas.agregar(moneda);

        if (pago < precio) {
            depositoVuelto.agregar(moneda);
            throw new PagoInsuficienteException("Pago insuficiente.");
        }

        Producto prod = depositos[indice].retirar();
        if (prod == null) {
            depositoVuelto.agregar(moneda);
            throw new NoHayProductoException("Sin stock.");
        }

        int vuelto = pago - precio;

        if (vuelto >= 500) {
            depositoVuelto.agregar(new Moneda500());
            vuelto -= 500;
        }

        while (vuelto >= 100) {
            depositoVuelto.agregar(new Moneda100());
            vuelto -= 100;
        }

        productoComprado = prod;
    }

    /**
     * Devuelve el producto comprado y deja vacío el lugar para el próximo producto.
     *
     * @return el producto comprado.
     */
    public Producto getProducto() {
        Producto temp = productoComprado;
        productoComprado = null;
        return temp;
    }

    /**
     * Devuelve el vuelto del expendedor.
     *
     * @return la moneda de vuelto.
     */
    public Moneda getVuelto() {
        return depositoVuelto.retirar();
    }

    /**
     * Devuelve el depósito de monedas ingresadas por el usuario.
     *
     * @return el depósito de monedas ingresadas.
     */
    public Deposito<Moneda> getDepositoMonedasIngresadas() {
        return depositoMonedasIngresadas;
    }

    /**
     * Crea un producto según el tipo indicado.
     *
     * @param producto el tipo de producto a crear.
     * @return el producto creado.
     */
    private Producto crearProducto(ProductoEnum producto) {
        switch (producto) {
            case COCACOLA:
                return new Bebida("CocaCola", producto.getPrecio());
            case SPRITE:
                return new Bebida("Sprite", producto.getPrecio());
            case FANTA:
                return new Bebida("Fanta", producto.getPrecio());
            case SNICKERS:
                return new Dulce("Snickers", producto.getPrecio());
            case SUPER8:
                return new Dulce("Super8", producto.getPrecio());
            default:
                return null;
        }
    }
}