package Modelo;

/**
 * Subclase que representa una moneda de valor 1500.
 * Extiende la clase abstracta Moneda.
 */
class Moneda1500 extends Moneda{
    /** Constructor por defecto de la clase Moneda1500.
     * Llama al constructor de la superclase Moneda. */
    public Moneda1500(){
        super();
    }

    /**
     * Obtiene el valor de la moneda.
     * @return El valor de la moneda, que en este caso es 1500.
     */
    public int getValor(){
        return 1500;
    }

    /**
     * Método para comparar el valor de la moneda con un precio dado.
     * @param valor El precio a comparar.
     * @return La diferencia entre la moneda y el precio del prducto comprado, cuyo valor
     *         será uno negativo si el valor de la moneda es menor que el precio,
     *         cero si son iguales, o un valor positivo si el valor de la moneda es mayor.
     */
    @Override
    public int compareTo(Integer valor) {
        return this.getValor() - valor;
    }
}
