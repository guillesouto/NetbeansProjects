/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @author roger
 */
// Implementación de la fábrica de informes concreta 3 para la categoría MIXTA 
class ConcreteReportFactory3 implements ReportFactory {

    @Override
    public AbstractReport createReport() {
        return new MixedReport();
    }

    @Override
    public AbstractReportType createReportType() {
        return new MixedReportType();
    }
}
