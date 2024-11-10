/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author Luis Valenzuela
 */
public class HeroeFactory implements PersonajeFactory {

    @Override
    public Personaje crearPersonaje() {
        return new Heroe();
    }

    @Override
    public Arma crearArma() {
        return new Espada();
    }
}
