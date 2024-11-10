/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author Luis Valenzuela
 */
public class Main {

    public static void main(String[] args) {
        PersonajeFactory fabricaHeroes = new HeroeFactory();
        Personaje heroe = fabricaHeroes.crearPersonaje();
        Arma espada = fabricaHeroes.crearArma();
        System.out.println(heroe.obtenerTipo());
        System.out.println(espada.obtenerTipo());
        
        PersonajeFactory fabricaVillanos = new VillanoFactory();
        Personaje villano = fabricaVillanos.crearPersonaje();
        Arma armaFuego = fabricaVillanos.crearArma();
        System.out.println(villano.obtenerTipo());
        System.out.println(armaFuego.obtenerTipo());
    }
}
