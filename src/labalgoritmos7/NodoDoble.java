/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labalgoritmos7;

/**
 *
 * @author Angelica Figueroa Muñiz
 * Abril 10, 2018
 * La clase NodoDoble contiene tres atributos, los cuales
 * son: info, que es la informacion que se almacenara, sig
 * y ant que son Nodos Dobles que representan las referencias
 * a los nodos siguiente y anterior en la lista. Esta clase
 * se utiliza dentro de la clase ListaDoble y ListaCircularDoble.
 */
public class NodoDoble <T> {
    
    private T info;
    private NodoDoble sig;
    private NodoDoble ant;

    /**
     * Constructor sin parametros
     */
    public NodoDoble() {
    }
    
    /**
     * Constructor parametrizado
     * @param info la informacion del nodo
     * @param sig la referencia al nodo siguiente
     * @param ant la referencia al nodo anterior
     */
    public NodoDoble(T info, NodoDoble sig, NodoDoble ant) {
        this.info = info;
        this.sig = sig;
        this.ant = ant;
    }

    /**
     * Método para obtener la información del nodo
     * @return la información del nodo
     */
    public T getInfo() {
        return info;
    }

    /**
     * Método para asignar la informacion que contendra el nodo
     * @param info la informacion que se guardara en el nodo
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Método para obtener el nodo siguiente
     * @return el nodo siguiente en la lista
     */
    public NodoDoble getSig() {
        return sig;
    }

    /**
     * Método para asignar el nodo siguiente
     * @param sig el nodo que se asignara como siguiente
     */
    public void setSig(NodoDoble sig) {
        this.sig = sig;
    }

    /**
     * Método para obtener el nodo anterior
     * @return el nodo anterior en la lista
     */
    public NodoDoble getAnt() {
        return ant;
    }

    /**
     * Método para asignar el nodo anterior
     * @param ant el nodo que se asignara como anterior
     */
    public void setAnt(NodoDoble ant) {
        this.ant = ant;
    }

    /**
     * Método para obtener una cadena con la informacion del nodo
     * @return una cadena con la informacion
     */
    @Override
    public String toString() {
        return info.toString();
    }
    
}
