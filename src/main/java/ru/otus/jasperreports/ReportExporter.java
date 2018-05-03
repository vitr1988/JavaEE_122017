package ru.otus.jasperreports;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.apache.log4j.Logger;

public class ReportExporter {
    private static final Logger logger = Logger.getLogger(ReportExporter.class);

    private JasperPrint jasperPrint;

    public ReportExporter() {
    }

    public ReportExporter(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }

    public void setJasperPrint(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    public void exportToPdf(String fileName, String author) {

        // print report to file
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileName);
        try {
            exporter.exportReport();
//            JasperExportManager.exportReportToPdfFile(jasperPrint, fileName); - same result
        } catch (JRException ex) {
            logger.error(null, ex);
        }
    }

    public void exportToXlsx(String fileName, String sheetName) {
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileName);

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            logger.error(null, ex);
        }
    }

    public void exportToCsv(String fileName) {
        JRCsvExporter exporter = new JRCsvExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileName);

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            logger.error(null, ex);
        }
    }

    public void exportToHtml(String fileName) {
        JRHtmlExporter exporter = new JRHtmlExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileName);

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            logger.error( null, ex);
        }
    }
}
