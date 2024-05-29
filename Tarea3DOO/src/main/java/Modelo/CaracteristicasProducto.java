package Modelo;

/**
 * Enumeración que representa diferentes productos con sus características y métodos asociados.
 */
public enum CaracteristicasProducto {
    SPRITE(400) {
        @Override
        public Bebida createProducto(int serie) {
            return new Sprite(serie);
        }
    },
    COCACOLA(450) {
        @Override
        public Bebida createProducto(int serie) {
            return new CocaCola(serie);
        }
    },
    FANTA(500) {
        @Override
        public Bebida createProducto(int serie) {
            return new Fanta(serie);
        }
    },
    SUPER8(800) {
        @Override
        public Dulce createProducto(int serie) {
            return new Super8(serie);
        }
    },
    SNICKERS(1000) {
        @Override
        public Dulce createProducto(int serie) {
            return new Snicker(serie);
        }
    };

    /**
     * Precio asociado al producto.
     */
    private final int precio;

    /**
     * Constructor privado para inicializar el precio y el índice del producto.
     * @param precio El precio del producto en centavos.
     */
    CaracteristicasProducto(int precio) {
        this.precio = precio;
    }
    /**
     * Obtiene el precio del producto.
     * @return El precio del producto.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Método que crea un producto con un número de serie y lo retorna.
     * @param serie El número de serie del producto al momento de crearse.
     * @return      Un objeto producto creado con un número de serie especifico.
     */
    public abstract Producto createProducto(int serie);
}
