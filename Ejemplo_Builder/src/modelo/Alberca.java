/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Luis Valenzuela
 */
public class Alberca {

    private int longitud;
    private int profundidad;

    public Alberca(int longitud, int profundidad) {
        this.longitud = longitud;
        this.profundidad = profundidad;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    @Override
    public String toString() {
        return "Alberca{" + "longitud=" + longitud + ", profundidad=" + profundidad + '}';
    }
    
    
}
