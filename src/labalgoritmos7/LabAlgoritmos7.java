/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labalgoritmos7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Angelica Figueroa Muñiz
 * Abril 17, 2018
 * Clase main para el programa en el cual se utilizan
 * listas dobles circulares para almacenar informacion 
 * respecto a la población en México en el año 2015. 
 * En este programa se presentan diferentes opciones
 * al usuario en un menú y se realizan diferentes acciones
 * utilizando métodos de la clase ListaCircularDoble
 */
public class LabAlgoritmos7 {
    
    public static void main(String[] args) throws FileNotFoundException {
        ListaCircularDoble<Poblacion> entidades = new ListaCircularDoble();
        Scanner lector = new Scanner(System.in);
        Scanner input = new Scanner(new File("poblacion.txt"));//archivo con info
        input.useDelimiter("-|\n");//delimitador para el scanner
        String estado;
        String sexo;
        String poblacion;
        String opcion;        
        Poblacion p;
        int cantidad, contador;
        
        do {//menú principal
            System.out.println("✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦ Población de México 2015 ✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦");
            System.out.println("1.Registrar desde teclado               2.Registrar desde teclado despues");
            System.out.println("3.Registrar desde teclado antes         4.Registrar desde archivo derecha");
            System.out.println("5.Registrar desde archivo izquierda     6.Eliminar izquierda");
            System.out.println("7.Mostrar toda la información           8.Mostrar hacia la derecha");
            System.out.println("9.Mostrar hacia la izquierda            10.Salir");
            System.out.println("--------------------------------------------------------------------------");
            System.out.print("Ingrese una opcion: ");//se pide al usuario que ingrese una opcion
            opcion = lector.nextLine();
            System.out.println("--------------------------------------------------------------------------");
            
            switch (opcion) {//switch para cada una de las opciones del menú
                case "1"://registrar desde teclado
                    System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧ Registro desde teclado ✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
                    System.out.println("Ingrese la siguiente información...");
                    System.out.print("Estado: ");//se pide la informacion necesaria para realizar el registro
                    estado = lector.nextLine();
                    System.out.print("Sexo: ");
                    sexo = lector.nextLine();
                    System.out.print("Poblacion: ");
                    poblacion = lector.nextLine();
                    p = new Poblacion(estado, sexo, poblacion);//se crea un objeto Poblacion con la info obtenida
                    entidades.insertaFin(p);//se inserta el objeto dentro de la lista
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("Se ha registrado la información exitosamente");
                    System.out.println("--------------------------------------------------------------------------");
                    break;
                case "2"://registrar desde teclado despues de un estado ya registrado
                    if(entidades.estaVacia()){//se revisa si la lista se encuentra vacia
                        System.out.println("No hay información en el registro");
                    }else{//en caso de no estar vacia
                    System.out.println("✧✧✧✧✧✧✧✧ Registro desde teclado despues de uno existente ✧✧✧✧✧✧✧✧");
                    System.out.println("Ingrese la siguiente información...");//se pide la informacion necesaria
                    System.out.print("Estado: ");
                    estado = lector.nextLine();
                    System.out.print("Sexo: ");
                    sexo = lector.nextLine();
                    System.out.print("Poblacion: ");
                    poblacion = lector.nextLine();
                    p = new Poblacion(estado, sexo, poblacion);//se crea un nuevo objeto con la info obtenida
                    System.out.println("Ingrese el estado despues del cual se agregara el registro: ");
                    String estadoD = lector.nextLine();//se pide el estado despues del que se agregara la info
                    NodoDoble nodoDespues = entidades.buscarEstado(estadoD);//se revisa que el estado se encuentre dentro de la lista
                    if (nodoDespues == null) {//si el estado no se encuentra en la lista
                        System.out.println("El estado no se encontro en el registro");
                    } else {//si el estado si se encuentra en la lista
                        entidades.insertarDespues(p, nodoDespues);//se inserta el nuevo estado despues del estado indicado
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("Se ha registrado la información exitosamente");
                        System.out.println("--------------------------------------------------------------------------");
                    }
                    }
                    break;
                case "3"://registrar desde teclado antes de un estado ya registrado
                    if(entidades.estaVacia()){//se revisa si la lista se encuentra vacia
                        System.out.println("No hay información en el registro");
                    }else{//en caso de no estar vacia
                    System.out.println("✧✧✧✧✧✧✧✧ Registro desde teclado antes de uno existente ✧✧✧✧✧✧✧✧✧");
                    System.out.println("Ingrese la siguiente información...");//se pide la informacion necesaria
                    System.out.print("Estado: ");
                    estado = lector.nextLine();
                    System.out.print("Sexo: ");
                    sexo = lector.nextLine();
                    System.out.print("Poblacion: ");
                    poblacion = lector.nextLine();
                    p = new Poblacion(estado, sexo, poblacion);//se crea un objeto Poblacion con la info obtenida
                    System.out.println("Ingrese el estado antes del cual se agregara el registro: ");
                    String estadoA = lector.nextLine();//se pide el estado antes del cual se agregara la informacion
                    NodoDoble nodoAntes = entidades.buscarEstado(estadoA);//se revis que el estado se encuentre dentro de la lista
                    if (nodoAntes == null) {//si el estado no se encuentra
                        System.out.println("El estado no se encontro en el registro");
                    } else {//si el estado si se encuentra
                        entidades.insertarAntes(p, nodoAntes);//se inserta el estado antes del estado indicado
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("Se ha registrado la información exitosamente");
                        System.out.println("--------------------------------------------------------------------------");
                    }
                    }
                    break;
                case "4"://registrar desde archivo hacia la derecha
                    if(entidades.estaVacia()){//se revisa si la lista se encuentra vacia
                        System.out.println("No hay información en el registro");
                    }else{//si la lista no esta vacia
                    System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧ Registro desde archivo a la derecha ✧✧✧✧✧✧✧✧✧✧✧✧");
                    System.out.print("Ingrese la cantidad de registros que desea realizar: ");//se pide la cantidad de registros que se desean realizar
                    cantidad = lector.nextInt();
                    lector.nextLine();
                    System.out.print("Ingrese el estado a partir del cual se insertara la información: ");//se pide el estado a partir del cual se registrara la información
                    String eDerecha = lector.nextLine();//se asigna el estado a una variable de tipo String
                    NodoDoble nodoD = entidades.buscarEstado(eDerecha);//se verifica que el estado ingresado se encuentre dentro de la lista
                    contador = 0;//contador para la cantidad de registros
                    while (input.hasNextLine() && contador < cantidad) {//se realizan los registros leyendo la info del archivo
                        estado = input.next();
                        sexo = input.next();
                        poblacion = input.next();
                        p = new Poblacion(estado, sexo, poblacion);//se crea un objeto Poblacion con al info obtenida
                        entidades.insertarDespues(p, nodoD);//se inserta la el objeto en la lista despues del estado ingresado
                        contador++;
                    }
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("Se ha registrado la información exitosamente");
                    System.out.println("--------------------------------------------------------------------------");
                    }
                    break;
                case "5":
                    if(entidades.estaVacia()){//se revisa si la lista se encuentra vacia
                        System.out.println("No hay información en el registro");
                    }else{
                    System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧ Registro desde archivo a la izquierda ✧✧✧✧✧✧✧✧✧✧✧");
                    System.out.print("Ingrese la cantidad de registros que desea realizar: ");//se pide la cantidad de registros que se desean realizar
                    cantidad = lector.nextInt();
                    lector.nextLine();
                    System.out.print("Ingrese el estado a partir del cual se insertara la información: ");//se pide el estado desde el que se realizaran los registros
                    String eIzquierda = lector.nextLine();//se asigna el estado a una variable de tipo String
                    NodoDoble nodoI = entidades.buscarEstado(eIzquierda);//se busca el estado dentro de la lista
                    contador = 0;//contador para la cantidad de registros
                    while (input.hasNextLine() && contador < cantidad) {//se realizan los registris leyendo la info del archivo
                        estado = input.next();
                        sexo = input.next();
                        poblacion = input.next();
                        p = new Poblacion(estado, sexo, poblacion);//se crea un objeto Poblacion con al info obtenida
                        entidades.insertarAntes(p, nodoI);//se inserta la el objeto en la lista despues del estado ingresado
                        contador++;
                    }
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("Se ha registrado la información exitosamente");
                    System.out.println("--------------------------------------------------------------------------");
                    }
                    break;
                case "6"://eliminar informacion a la izquierda
                    if(entidades.estaVacia()){//se revisa si la lista esta vacia
                        System.out.println("No hay información en el registro");
                    }else{//si la lista no esta vacia
                    System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧ Eliminar lado izquierdo ✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
                    System.out.println("Ingrese el estado del cual se eliminara la información a la izquierda: ");
                    String estadoIzq = lector.nextLine();//se pide el estado del cual se eliminara la info a la izquierda
                    NodoDoble eliminarI = entidades.buscarEstado(estadoIzq);//se revisa que el estado se encuentre dentro de la lista
                    if (eliminarI == null) {//si el estado no se encuentra en la lista
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("El estado no se encontro en el registro");
                        System.out.println("--------------------------------------------------------------------------");
                    } else {//si el estado se encuentra en la lista
                        entidades.eliminarIzquierda(eliminarI);//se elimina la informacion a la izquierda
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("Se ha eliminado la información exitosamente");
                        System.out.println("--------------------------------------------------------------------------");
                    }
                    }
                    break;
                case "7"://mostrar toda la informacion
                    if(entidades.estaVacia()){//si la lista esta vacia
                        System.out.println("No hay información en el registro");
                    }else{//si no esta vacia, se muestra el contenido
                    System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧ Mostrar toda la información ✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
                    System.out.println(entidades.mostrarRecursivo(entidades.getInicio()));
                    }
                    break;
                case "8"://mostrar hacia la derecha
                    if(entidades.estaVacia()){//se revisa si la lista esta vacia
                        System.out.println("No hay información en el registro");
                    }else{//si la lista no esta vacia
                    System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧ Mostrar hacia la derecha ✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
                    System.out.println("Ingrese el estado desde el que se mostrara la información: ");
                    String mostrarD = lector.nextLine();//se pide el estado desde el cual se iniciara el recorrido
                    NodoDoble mDerecha = entidades.buscarEstado(mostrarD);//se busca el estado dentro de la lista
                    if (mDerecha == null) {//si el estado no se encuentra en la lista
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("El estado no se encontro en el registro");
                        System.out.println("--------------------------------------------------------------------------");
                    } else {//si el estado si se encuentra dentro de la lista
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println(entidades.mostrarDerecha(mDerecha, mDerecha));//se muestra la informacion
                        System.out.println("--------------------------------------------------------------------------");
                    }
                    }
                    break;
                case "9"://mostrar hacia la izquierda
                    if(entidades.estaVacia()){//se revisa si la lista esta vacia
                        System.out.println("No hay información en el registro");
                    }else{//si la lista no esta vacia
                    System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧ Mostrar hacia la izquierda ✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
                    System.out.println("Ingrese el estado desde el que se mostrara la información: ");
                    String mostrarI = lector.nextLine();//se pide el estado desde el cual se iniciara el recorrido
                    NodoDoble mIzquierda = entidades.buscarEstado(mostrarI);
                    if (mIzquierda == null) {//si el estado no se encuentra en la lista
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println("El estado no se encontro en el registro");
                        System.out.println("--------------------------------------------------------------------------");
                    } else {//si el estado si se encuentra dentro de la lista
                        System.out.println("--------------------------------------------------------------------------");
                        System.out.println(entidades.mostrarIzquierda(mIzquierda, mIzquierda));//se muestra la informacion
                        System.out.println("--------------------------------------------------------------------------");
                    }
                    }
                    break;
                case "10"://salir
                    System.out.println("¡Adios!");//mensaje de despedida
                    System.out.println("--------------------------------------------------------------------------");
                    System.exit(0);//se termina la ejecución
                    break;
                default://en caso de ingresar una opcion que no esta dentro del menú
                    System.out.println("Opción invalida");
            }//fin del switch
        } while (!opcion.matches("10"));//se repite el ciclo mientras que no se ingrese "10"
        
    }
}//fin de la clase
