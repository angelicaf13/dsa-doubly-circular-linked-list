/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labalgoritmos7;

/**
 *
 * @author Angelica Figueroa Muñiz
 * Abril 17, 2018
 * La clase representa una lista circular doblemente ligada, por lo
 * cual cuenta con dos Nodos Dobles; inicio y fin. Se tienen los métodos
 * basicos para insertar y eliminar información al inicio y final
 * de la lista, ademas de métodos adicionales para cumplir con 
 * el funcionamiento del programa en la clase main. La clase esta parametrizada
 * a objetos de tipo T por lo que puede almacenar cualquier tipo
 * de dato
 */
public class ListaCircularDoble <T> {
    
    private NodoDoble inicio;
    private NodoDoble fin;
    
    /**
     * Constructor sin parametros
     */
    public ListaCircularDoble() {
    }

    /**
     * Constructor parametrizado
     * @param inicio el nodo inicial de la lista
     * @param fin el nodo final de la lista
     */
    public ListaCircularDoble(NodoDoble inicio, NodoDoble fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    /**
     * Método para obtener el inicio de la lista
     * @return el nodo inicial de la lista
     */
    public NodoDoble getInicio() {
        return inicio;
    }

    /**
     * Método para asignar el inicio de la lista
     * @param inicio el nodo que se asignara como inicio
     */
    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    /**
     * Método para obtener el fin de la lista
     * @return el nodo final de la lista
     */
    public NodoDoble getFin() {
        return fin;
    }

    /**
     * Método para asignar el fin de la lista
     * @param fin el nodo que se asignara como fin
     */
    public void setFin(NodoDoble fin) {
        this.fin = fin;
    }
    
    /**
     * Método para insertar al inicio de la lista
     * @param dato el dato que se agregara a la lista
     */
    public void insertaInicio(T dato){
        NodoDoble n = new NodoDoble();//se crea un nuevo NodoDoble
        n.setInfo(dato);//se le asigna la info
        
        if(inicio == null){//si la lista esta vacia
            inicio = fin = n;//inicio y fin apuntan a n porque sera el unico nodo en la lista
            n.setSig(inicio);//el siguiente de n es inicio(el mismo)
            n.setAnt(fin);//el anterior de n es fin(el mismo)
        }else{//si hay mas nodos en la lista
            n.setSig(inicio);//el siguiente de n es el inicio actual
            n.setAnt(fin);//el anterior de n es fin
            inicio.setAnt(n);//el anterior del inicio viejo ahora sera n
            inicio = n;//se actualiza el inicio, ahora apunta a n
            fin.setSig(inicio);//el siguiente de fin es el nuevo inicio
            
        }
    }
    
    /**
     * Método para insertar al final de la lista
     * @param dato el dato que se agregara a la lista
     */
    public void insertaFin(T dato){
        NodoDoble n = new NodoDoble();//se crea un nuevo NodoDoble
        n.setInfo(dato);//se asigna la info
        if(inicio == null){//si la lista esta vacia
            inicio = fin = n;//inicio y fin apuntan a n(el unico nodo de la lista)
            n.setSig(inicio);//el siguiente de n es inicio(el mismo)
            n.setAnt(fin);//el anterior de n es fin(el mismo)
        }else{//si hay mas nodos en la lista
            n.setAnt(fin);//el anterior de n es fin
            n.setSig(inicio);//el siguiente de n es el inicio viejo
            fin.setSig(n);//el siguiente de fin es n (que sera el nuevo fin)
            fin = n;//se actualiza fin, ahora fin sera n
            inicio.setAnt(fin);//el anterior de inicio es el nuevo fin
        }
    }
    
    /**
     * Método para eliminar la información al inicio de la lista
     * @return la información que se elimino
     */
    public T eliminaInicio(){
        T dato = null;
        if(inicio == null){
            System.out.println("Lista vacia");
        }else{
            if(inicio == fin){
                dato = (T) inicio.getInfo();
                inicio = fin = null;
            }else{
                dato = (T) inicio.getInfo();
                inicio = inicio.getSig();
                inicio.setAnt(fin);
            }
        }
        return dato;
    }
    
    /**
     * Método para eliminar la informacion al final de la lista
     * @return la informacion que se elimino
     */
    public T eliminaFin(){
        T dato = null;
        if(inicio == null){
            System.out.println("Lista vacia");
        }else{
            if(inicio == fin){
                dato = (T) fin.getInfo();
                inicio = fin = null;}
            else{
                dato = (T) fin.getInfo();
                fin = fin.getAnt();
                fin.setSig(inicio);
                inicio.setAnt(fin);
            }
        }
        return dato;
    }
    
    /**
     * Método para mostrar toda la informacion dentro de la lista
     * @param x el nodo inicial de la lista
     * @return una cadena con toda la información
     */
    public String mostrarRecursivo(NodoDoble x){
        if(x == fin){
            return x.getInfo() + "";
        }else{
            return x.getInfo() + "\n" + mostrarRecursivo(x.getSig());
        }
    }
    
    public T eliminaX(T x){
        T dato = null;
        if(inicio == null){//si esta vacia
            System.out.println("Lista vacia");
        }else if(x.hashCode() == inicio.getInfo().hashCode()){//si es el primero
            dato = eliminaInicio();
        }else if(x.hashCode() == fin.getInfo().hashCode()){//si es el ultimo
            dato = eliminaFin();
        }else{//si esta en medio
            NodoDoble r = inicio;
            while(r.getSig() != inicio && x.hashCode() != r.getInfo().hashCode()){
                r = r.getSig();
            }
            if(x.hashCode() == r.getInfo().hashCode()){//si si lo encontro
                if(r.getSig() == inicio){
                    dato = eliminaFin();
                }else{//si esta en medio
                    dato = (T) r.getInfo();
                    r.getAnt().setSig(r.getSig());
                    r.getAnt().setAnt(r.getAnt());
                }
            }
        }
        return dato;
        
    }
    
    public int buscar(T x){
        int index = 0;
        if(inicio == null){
            System.out.println("Lista vacia");
            return -1;
        }else if(x.hashCode() == inicio.getInfo().hashCode()){
            return 0;
        }else{
            NodoDoble r = inicio;
            while(r.getSig() != inicio && x.hashCode() != r.getInfo().hashCode()){
                r = r.getSig();
                index++;
            }
            if(x.hashCode() == r.getInfo().hashCode()){
                return index;
            }else{
                return -1;
            }
        }        
    }
    
    public T eliminaPosicion(int posicion){
        T dato = null;
        if(inicio == null){
            System.out.println("Lista vacia");
        }else if(posicion < 0){
            //posicion invalida
        }else if(posicion == 0){
            dato = eliminaInicio();
        }else{
            int contador = 0;
            NodoDoble r = inicio;
            while(r.getSig() != inicio && contador != posicion){
                r = r.getSig();
                contador++;
            }if(posicion == contador){
                if(r == fin){
                    dato = eliminaFin();
                }else{
                    dato = (T)r.getInfo();
                    r.getAnt().setSig(r.getSig());
                    r.getSig().setAnt(r.getAnt());
                }
                
            }
        }
        return dato;
    }
    
    public void ordenarLista(){
        if(inicio == null){
            System.out.println("Lista vacia");
        }else if(inicio == fin){
            //solo hay un dato
        }else{
            NodoDoble r = inicio;
            NodoDoble a = inicio.getSig();
            T aux;
            while(r.getSig() != inicio){
                while(a != inicio){
                    if(r.getInfo().hashCode() > a.getInfo().hashCode()){
                        aux =  (T) r.getInfo();
                        r.setInfo(a.getInfo());
                        a.setInfo(aux);
                    }
                    a= a.getSig();
                }
                r = r.getSig();
                a = r.getSig();
            }
        }
    }
    
    public void insertaEnPosicion(T dato, int posicion){
        if(posicion < 0){
            //posicion invalida
        }else if(posicion == 0){
            insertaInicio(dato);
        }else{
            int contador = 0;
            NodoDoble r = inicio;
            while(r.getSig() != inicio && contador != posicion){
                r = r.getSig();
                contador++;
            }
            if(contador == posicion){
                NodoDoble n = new NodoDoble();
                NodoDoble a = r.getAnt();
                n.setInfo(dato);
                r.setAnt(n);
                n.setSig(r);
                n.setAnt(a);
                a.setSig(n);
            }
        }
        
    }
    
    /**
     * Método para buscar un nodo en la lista, mediante el estado
     * @param estado el estado que se buscara
     * @return el nodo donde se encontro el estado
     */
    public NodoDoble buscarEstado(String estado) {
        Poblacion i = (Poblacion) inicio.getInfo();
        Poblacion f = (Poblacion) fin.getInfo();
        if (inicio == null) {
            System.out.println("Lista vacia");
        } else if (i.getEstado().matches(estado)) {
            return inicio;
        } else if (f.getEstado().matches(estado)) {
            return fin;
        } else {
            NodoDoble r = inicio;
            Poblacion p = (Poblacion) r.getInfo();
            while (r.getSig() != inicio && !p.getEstado().matches(estado)) {
                r = r.getSig();
                p = (Poblacion) r.getInfo();
            }
            if (p.getEstado().matches(estado)) {
                return r;
            }
        }
        return null;
    }
    
    /**
     * Método para insertar informacion en la lista despues del nodo indicado
     * @param dato la informacion que se agregara
     * @param n el nodo despues del cual se insertara la información
     */
    public void insertarDespues(T dato, NodoDoble n){
        if(n == fin){
        insertaFin(dato);
        }else{
            NodoDoble d = new NodoDoble();
            d.setInfo(dato);
            d.setSig(n.getSig());
            n.getSig().setAnt(d);
            n.setSig(d);
            d.setAnt(n);
        }
    }
    
    /**
     * Método para insertar informacion en la lista antes del nodo indicado
     * @param dato la informacion que se agregara
     * @param n el nodo despues del cual se insertara la información
     */
    public void insertarAntes(T dato, NodoDoble n){
        if(n == inicio){
            insertaInicio(dato);
        }else{
            NodoDoble a = new NodoDoble();
            a.setInfo(dato);
            a.setSig(n);
            a.setAnt(n.getAnt());
            n.getAnt().setSig(a);
            n.setAnt(a);
        }
    }
    
    /**
     * Método para eliminar la información a la izquierda del nodo indicado
     * @param n
     * @return 
     */
    public T eliminarIzquierda(NodoDoble n){
        T dato = null;
        if(n == inicio){
            dato = eliminaFin();
        }else if(n.getAnt() == inicio){
            dato = eliminaInicio();
        }else{
            NodoDoble a = n.getAnt();
            dato = (T) a.getInfo();
            n.setAnt(a.getAnt());
            a.getAnt().setSig(a.getSig());
        }
        return dato;
    }
    
    /**
     * Método para mostrar la informacion en la lista iniciando en el nodo indicado
     * hacia la derecha
     * @param n el nodo donde se iniciara el recorrido
     * @param a el nodo del cual se obtiene la informacion
     * @return una cadena con la informacion de la lista
     */
    public String mostrarDerecha(NodoDoble n, NodoDoble a){
        if(a.getSig() == n){
            return a.getInfo() + "";
        }else{
            return a.getInfo() + "\n" + mostrarDerecha(n, a.getSig());
        }
    }
    
    /**
     * Método para mostrar la informacion en la lista iniciando en el nodo indicado
     * hacia la izquierda
     * @param n el nodo donde se iniciara el recorrido
     * @param a el nodo del cual se obtiene la informacion
     * @return una cadena con la informacion de la lista
     */
    public String mostrarIzquierda(NodoDoble n, NodoDoble a){
        if(a.getAnt() == n){
            return a.getInfo() + "";
        }else{
            return a.getInfo() + "\n" + mostrarIzquierda(n, a.getAnt());
        }
    }
    
    /**
     * Método para saber si la lista esta vacia
     * @return true si no contiene ningun elemento
     * o false en caso de contener elementos
     */
    public boolean estaVacia(){
        return inicio == null;
    }
}
