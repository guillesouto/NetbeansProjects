/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Luis Valenzuela
 */
public class Casa {

    private int numHabitaciones;
    private Cocina cocina;
    private Banio banio;
    private Alberca alberca;
    private int numPisos;
    private boolean tieneGaraje;
    private int tamanioJardin;
    private String tipoDePintura;
    private String tipoDeTecho;
    private boolean sistemaDeSeguridad;

    public Casa() {
    }

    // Constructor completo
    public Casa(int numHabitaciones, Cocina cocina, Banio banio, Alberca alberca, int numPisos,
            boolean tieneGaraje, int tamanioJardin, String tipoDePintura, String tipoDeTecho,
            boolean sistemaDeSeguridad) {
        this.numHabitaciones = numHabitaciones;
        this.cocina = cocina;
        this.banio = banio;
        this.alberca = alberca;
        this.numPisos = numPisos;
        this.tieneGaraje = tieneGaraje;
        this.tamanioJardin = tamanioJardin;
        this.tipoDePintura = tipoDePintura;
        this.tipoDeTecho = tipoDeTecho;
        this.sistemaDeSeguridad = sistemaDeSeguridad;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public Cocina getCocina() {
        return cocina;
    }

    public void setCocina(Cocina cocina) {
        this.cocina = cocina;
    }

    public Banio getBanio() {
        return banio;
    }

    public void setBanio(Banio banio) {
        this.banio = banio;
    }

    public Alberca getAlberca() {
        return alberca;
    }

    public void setAlberca(Alberca alberca) {
        this.alberca = alberca;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public boolean isTieneGaraje() {
        return tieneGaraje;
    }

    public void setTieneGaraje(boolean tieneGaraje) {
        this.tieneGaraje = tieneGaraje;
    }

    public int getTamanioJardin() {
        return tamanioJardin;
    }

    public void setTamanioJardin(int tamanioJardin) {
        this.tamanioJardin = tamanioJardin;
    }

    public String getTipoDePintura() {
        return tipoDePintura;
    }

    public void setTipoDePintura(String tipoDePintura) {
        this.tipoDePintura = tipoDePintura;
    }

    public String getTipoDeTecho() {
        return tipoDeTecho;
    }

    public void setTipoDeTecho(String tipoDeTecho) {
        this.tipoDeTecho = tipoDeTecho;
    }

    public boolean isSistemaDeSeguridad() {
        return sistemaDeSeguridad;
    }

    public void setSistemaDeSeguridad(boolean sistemaDeSeguridad) {
        this.sistemaDeSeguridad = sistemaDeSeguridad;
    }

    @Override
    public String toString() {
        return "Casa{" + "numHabitaciones=" + numHabitaciones + ", cocina=" + cocina + ", banio=" + banio + ", alberca=" + alberca + ", numPisos=" + numPisos + ", tieneGaraje=" + tieneGaraje + ", tamanioJardin=" + tamanioJardin + ", tipoDePintura=" + tipoDePintura + ", tipoDeTecho=" + tipoDeTecho + ", sistemaDeSeguridad=" + sistemaDeSeguridad + '}';
    }

}
