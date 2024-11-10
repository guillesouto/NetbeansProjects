/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder;

import modelo.Alberca;
import modelo.Banio;
import modelo.Casa;
import modelo.Cocina;

/**
 *
 * @author Luis Valenzuela
 */
public class Main2 {

    public static void main(String[] args) {
        Casa casaInteresSocial = new Casa(2, new Cocina("Estilo sencillo", 15), new Banio(false, 5), null, 1, false, 10, "Latex", "Teja", false);
        Casa residencia = new Casa(4, new Cocina("Estilo moderno", 30), new Banio(true, 10), new Alberca(5, 2), 2, true, 50, "Acrílica", "Asfáltica", true);
        Casa mansion = new Casa(10, new Cocina("Estilo gourmet", 50), new Banio(true, 15), new Alberca(10, 3), 3, true, 200, "Vinílica", "Cerámica", true);

        // Aquí puedes imprimir los detalles de las casas o realizar operaciones adicionales
        System.out.println("Casa de Interés Social: " + casaInteresSocial);
        System.out.println("Residencia: " + residencia);
        System.out.println("Mansión: " + mansion);
    }
}
