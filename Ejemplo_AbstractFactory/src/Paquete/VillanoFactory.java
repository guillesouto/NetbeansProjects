/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author Luis Valenzuela
 */
public class VillanoFactory implements PersonajeFactory {

    @Override
    public Personaje crearPersonaje() {
        return new Villano();
    }

    @Override
    public Arma crearArma() {
        return new ArmaDeFuego();
    }
}
