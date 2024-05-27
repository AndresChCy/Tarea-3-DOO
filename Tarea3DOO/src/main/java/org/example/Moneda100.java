package org.example;

/**
 * Subclase que representa una moneda de valor 100.
 * Extiende la clase abstracta Moneda.
 */
class Moneda100 extends Moneda{
    /** Constructor por defecto de la clase Moneda100.
     * Llama al constructor de la superclase Moneda. */
    public Moneda100(){
        super();
    }

    /**
     * Obtiene el valor de la moneda.
     * @return El valor de la moneda, que en este caso es 100.
     */
    public int getValor(){
        return 100;
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
