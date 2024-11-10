/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder;

import builders.ConstructorCasasDirector;
import modelo.Casa;

/**
 *
 * @author Luis Valenzuela
 */
public class Main {

    public static void main(String[] ags) {
        ConstructorCasasDirector constructor = new ConstructorCasasDirector();

        Casa casaInteresSocial = constructor.construirCasaInteresSocial();
        Casa residencia = constructor.construirResidencia();
        Casa mansion = constructor.construirMansion();

        // Aquí puedes imprimir los detalles de las casas o realizar operaciones adicionales
        System.out.println("Casa de Interés Social: " + casaInteresSocial);
        System.out.println("Residencia: " + residencia);
        System.out.println("Mansión: " + mansion);
    }
}
