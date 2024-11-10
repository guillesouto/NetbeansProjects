/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builders;

import modelo.Alberca;
import modelo.Banio;
import modelo.Casa;
import modelo.Cocina;

/**
 *
 * @author Luis Valenzuela
 */
public class MansionBuilder implements CasaBuilder {

    private Casa casa = new Casa();

    @Override
    public CasaBuilder conNumHabitaciones(int numHabitaciones) {
        casa.setNumHabitaciones(numHabitaciones);
        return this;
    }

    @Override
    public CasaBuilder conCocina(Cocina cocina) {
        casa.setCocina(cocina);
        return this;
    }

    @Override
    public CasaBuilder conBanio(Banio banio) {
        casa.setBanio(banio);
        return this;
    }

    @Override
    public CasaBuilder conAlberca(Alberca alberca) {
        casa.setAlberca(alberca);
        return this;
    }

    @Override
    public CasaBuilder conNumPisos(int numPisos) {
        casa.setNumPisos(numPisos);
        return this;
    }

    @Override
    public CasaBuilder conTieneGaraje(boolean tieneGaraje) {
        casa.setTieneGaraje(tieneGaraje);
        return this;
    }

    @Override
    public CasaBuilder conTamanioJardin(int tamanioJardin) {
        casa.setTamanioJardin(tamanioJardin);
        return this;
    }

    @Override
    public CasaBuilder conTipoDePintura(String tipoDePintura) {
        casa.setTipoDePintura(tipoDePintura);
        return this;
    }

    @Override
    public CasaBuilder conTipoDeTecho(String tipoDeTecho) {
        casa.setTipoDeTecho(tipoDeTecho);
        return this;
    }

    @Override
    public CasaBuilder conSistemaDeSeguridad(boolean sistemaDeSeguridad) {
        casa.setSistemaDeSeguridad(sistemaDeSeguridad);
        return this;
    }

    @Override
    public Casa construir() {
        return casa;
    }
}
