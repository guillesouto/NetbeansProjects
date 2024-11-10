/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Luis Valenzuela
 */
public class Banio {

    private boolean tieneBaniera;
    private int area;

    public Banio(boolean tieneBaniera, int area) {
        this.tieneBaniera = tieneBaniera;
        this.area = area;
    }

    public boolean isTieneBaniera() {
        return tieneBaniera;
    }

    public void setTieneBaniera(boolean tieneBaniera) {
        this.tieneBaniera = tieneBaniera;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Banio{" + "tieneBaniera=" + tieneBaniera + ", area=" + area + '}';
    }
    
    
}
