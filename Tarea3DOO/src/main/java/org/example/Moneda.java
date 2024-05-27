package org.example;

/**
 * Superclase abstracta que representa una moneda.
 */
abstract class Moneda implements Comparable<Integer>{
    /** Constructor por defecto de la clase Moneda. */
    public Moneda(){}

    /**
     * Método para obtener la serie de la moneda.
     * @return La instancia actual de la moneda.
     */
    public Moneda getSerie(){
        return this ;
    }

    /**
     * Método abstracto para obtener el valor de la moneda.
     * @return El valor de la moneda.
     */
    public abstract int getValor();

    /**
     * Compara esta moneda con un valor.
     * @param valor El valor a comparar con la moneda.
     * @return La diferencia entre el valor de la moneda y el valor dado como parámetro.
     *         Un valor negativo si el valor de la moneda es menor que el parámetro,
     *         cero si son iguales, o un valor positivo si el valor de la moneda es mayor.
     */
    public abstract int compareTo(Integer valor);
}
