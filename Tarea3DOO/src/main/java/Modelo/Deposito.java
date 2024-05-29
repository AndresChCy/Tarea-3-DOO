package Modelo;
import java.util.ArrayList;

/**
 * Un deposito para almacenar un tipo de objeto
 */
class Deposito<T> {
    /** Lista para guardar un tipo de objeto */
    private ArrayList<T>  al;

    /** Metodo constructor para inicializar la lista */
    public Deposito(){
        al = new ArrayList<T>();
    }

    /** Metodo para añadir mas elementos al deposito */
    public void addObject(T t){
        al.add(t);
    }

    /** Metodo para retirar el primer elemento del deposito y correr todos los demas
      * Si no quedan objetos para retirar entonces no devuelve nada */
    public T getObject(){
        if (al.size() != 0) {
            T t = al.remove(0);
            return t;
        }
        return null;
    }
}
