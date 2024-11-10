/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @author roger
 */
// Implementación de la fábrica de informes concreta 4 para la categoría PEDIDO
class ConcreteReportFactory4 implements ReportFactory {

    @Override
    public AbstractReport createReport() {
        return new OrderReport();
    }

    @Override
    public AbstractReportType createReportType() {
        return new EntranceReportType(); // Asumiendo que el tipo de informe de PEDIDO es de ENTRADA
    }
}
