package Modelo;

/**
 * Subclase que representa una moneda de valor 500.
 * Extiende la clase abstracta Moneda.
 */
public class Moneda500 extends Moneda{
    /**
     * Método constructor de Moneda500 que permite asignarle un número de serie.
     * @param NumSerie Número que representa la serie de la moneda.
     */
    public Moneda500(int NumSerie){
        super(NumSerie);
    }

    /**
     * Obtiene el valor de la moneda.
     * @return El valor de la moneda, que en este caso es 500.
     */
    public int getValor(){
        return 500;
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
