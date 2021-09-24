/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labalgoritmos7;

import java.util.Objects;

/**
 *
 * @author Angelica Figueroa Muñiz
 * Abril 10, 2018
 * La clase Poblacion se creo con la finalidad
 * de ser utilizada para representar la información
 * poblacional en México, un objeto de la clase
 * Poblacion cuenta con los atributos: estado, sexo y 
 * poblacion, de tipo String cada uno.
 */
public class Poblacion {
    
    private String estado;
    private String sexo;
    private String poblacion;

    /**
     * Constructor sin parametros
     */
    public Poblacion() {
    }

    /**
     * Constructor parametrizados
     * @param estado el estado de la poblacion
     * @param sexo el sexo de la poblacion
     * @param poblacion la cantidad poblacional
     */
    public Poblacion(String estado, String sexo, String poblacion) {
        this.estado = estado;
        this.sexo = sexo;
        this.poblacion = poblacion;
    }

    /**
     * Método para obtener el estado de la poblacion
     * @return una cadena con el estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método para asignar el estado de la poblacion
     * @param estado el estado que se asignara
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método para obtener el sexo de la poblacion
     * @return una cadena con el sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Método para asignar el sexo de la poblacion
     * @param sexo el sexo que se asignara a la poblacion
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Método para obtener la cantidad poblacional
     * @return un string con la cantidad de la poblacional
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * Método para asignar la cantidad poblacional
     * @param poblacion la cantidad poblacional que se asignara
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Método para obtener la información de la población
     * @return una cadena con la informacion de la poblacion
     */
    @Override
    public String toString() {
        return "Estado: " + estado + "\nSexo: " + sexo + "\nPoblación: " + poblacion;
    }

 
    @Override
    public int hashCode() {
        return Integer.valueOf(estado);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Poblacion other = (Poblacion) obj;
        return true;
    }
    
    public int getSexoHashCode(){
        return sexo.hashCode();
    }
    
    public int getEstadoHashCode(){
        return estado.hashCode();
    }
        
    public int getPoblacionHashCode(){
        return poblacion.hashCode();
    }
    
}
