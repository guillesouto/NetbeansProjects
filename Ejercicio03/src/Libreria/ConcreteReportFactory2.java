/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

/**
 *
 * @author roger
 */
class ConcreteReportFactory2 implements ReportFactory {

    @Override
    public AbstractReport createReport() {
        return new PurchaseReport();
    }

    @Override
    public AbstractReportType createReportType() {
        return new ExitReportType();
    }
}
