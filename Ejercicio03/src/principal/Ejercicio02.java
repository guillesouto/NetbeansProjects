/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

/**
 *
 * @author roger
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// Nombres de archivos de informes
        String[] reports = {"ENT_FAC_001.txt", "SAL_COM_001.txt", "ENT_COM_002.txt", "SAL_FAC_002.txt", "MIX_FAC_001.txt", "MIX_COM_001.txt"};
// Procesar los informes 
        processReports(reports);
    }

    public static void processReports(String[] reports) {
// Simulación del procesado de informes
        for (String report : reports) {
            if (report.contains("MIX")) {
                System.out.println("Procesando informe MIXTO");
            } else if (report.contains("SAL")) {
                System.out.println("Procesando informe de SALIDA de tipo "
                        + getType(report));
            } else {
                System.out.println("Procesando informe de ENTRADA de tipo "
                        + getType(report));
            }
        }
    }

    public static String getType(String report) {
        if (report.contains("FAC")) {
            return "FACTURA";
        } else {
            return "COMPRA";
        }
    }
    
}
