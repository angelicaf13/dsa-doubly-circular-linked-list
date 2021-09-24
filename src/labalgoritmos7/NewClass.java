/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labalgoritmos7;

/**
 *
 * @author Angelica Figueroa Muñiz
 */
public class NewClass {
    public static void main(String[] args) {
        ListaCircularDoble ls = new ListaCircularDoble();
        Poblacion p = new Poblacion("Baja California", "Masculino", "123");
        Poblacion p2 = new Poblacion("Sonora", "Femenino", "123");
        Poblacion p3 = new Poblacion("Cancun", "Femenino", "123");
        Poblacion p4 = new Poblacion("Monterrey", "Femenino", "123");
        
        ls.insertaFin(p);
        ls.insertaFin(p2);
        ls.insertaFin(p3);
        ls.insertaFin(p4);
        
//        System.out.println(ls.mostrarRecursivo(ls.getInicio()) + "\n");
//        
//        Poblacion p5 = new Poblacion("Cabo", "Masculino", "123");
//        
//        //System.out.println(ls.buscarEstado("Sonora"));
        NodoDoble buscar = ls.buscarEstado("Monterrey");
//        ls.eliminarIzquierda(buscar);
//        
//        System.out.println(ls.mostrarRecursivo(ls.getInicio()));
        
          System.out.println(ls.mostrarIzquierda(buscar, buscar));
          
          System.out.println("\n"+ls.mostrarDerecha(buscar, buscar));
        

    }
}
