package Modelo;

/**
 * Superclase abstracta que representa una moneda.
 */
abstract public class Moneda implements Comparable<Integer>{
    private int serie;

    /**
     * Constructor por defecto de la clase Moneda.
     * @param NumSerie  Int que representa la serie de la moneda.
     */
    public Moneda(int NumSerie) {
        this.serie = NumSerie;
    }

    /**
     * Método para obtener la serie de la moneda.
     * @return Int que representa la serie de la moneda.
     */
    public int getSerie(){
        return serie;
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
