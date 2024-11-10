/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Luis Valenzuela
 */
public class Cocina {

    private String estilo;
    private int area;

    public Cocina(String estilo, int area) {
        this.estilo = estilo;
        this.area = area;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Cocina{" + "estilo=" + estilo + ", area=" + area + '}';
    }

}
