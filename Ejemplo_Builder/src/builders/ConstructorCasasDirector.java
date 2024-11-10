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
public class ConstructorCasasDirector {

    public Casa construirCasaInteresSocial() {
        return new CasaInteresSocialBuilder()
                .conNumHabitaciones(2)
                .conCocina(new Cocina("Estilo sencillo", 15))
                .conBanio(new Banio(false, 5))
                .conNumPisos(1)
                .conTieneGaraje(false)
                .conTamanioJardin(10)
                .conTipoDePintura("Latex")
                .conTipoDeTecho("Teja")
                .conSistemaDeSeguridad(false)
                .construir();
    }

    public Casa construirResidencia() {
        return new ResidenciaBuilder()
                .conNumHabitaciones(4)
                .conCocina(new Cocina("Estilo moderno", 30))
                .conBanio(new Banio(true, 10))
                .conAlberca(new Alberca(5, 2))
                .conNumPisos(2)
                .conTieneGaraje(true)
                .conTamanioJardin(50)
                .conTipoDePintura("Acrílica")
                .conTipoDeTecho("Asfáltica")
                .conSistemaDeSeguridad(true)
                .construir();
    }

    public Casa construirMansion() {
        return new MansionBuilder()
                .conNumHabitaciones(10)
                .conCocina(new Cocina("Estilo gourmet", 50))
                .conBanio(new Banio(true, 15))
                .conAlberca(new Alberca(10, 3))
                .conNumPisos(3)
                .conTieneGaraje(true)
                .conTamanioJardin(200)
                .conTipoDePintura("Vinílica")
                .conTipoDeTecho("Cerámica")
                .conSistemaDeSeguridad(true)
                .construir();
    }
}
