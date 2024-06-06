package Modelo;

/**
 * Enumeración que representa diferentes productos con sus características y métodos asociados.
 */
public enum CaracteristicasProducto {
    FANTA(400) {
        @Override
        public Bebida createProducto(int serie) {
            return new Fanta(serie);
        }
    },
    SPRITE(700) {
        @Override
        public Bebida createProducto(int serie) {
            return new Sprite(serie);
        }
    },
    COCACOLA(500) {
        @Override
        public Bebida createProducto(int serie) {
            return new CocaCola(serie);
        }
    },
    SNICKERS(800) {
        @Override
        public Dulce createProducto(int serie) {
            return new Snicker(serie);
        }
    },
    SUPER8(1000) {
        @Override
        public Dulce createProducto(int serie) {
            return new Super8(serie);
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
