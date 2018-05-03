package ru.otus.jasperreports;

import ru.otus.ejb.session.client.JNDIClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReportRunner {
    public static void main(String[] args) {
        ReportFiller simpleReportFiller = new ReportFiller();
        DataSource dataSource = null;

        Properties props = new Properties();
        try {
            props.load(ReportRunner.class.getResourceAsStream("/jndi.properties"));
            InitialContext ctx = new InitialContext(props);
            dataSource = (DataSource) ctx.lookup("jdbc/OracleDS");
        } catch (IOException | NamingException ex) {
            ex.printStackTrace();
        }

        simpleReportFiller.setDataSource(dataSource);
        simpleReportFiller.setReportFileName("employeeEmailReport.jrxml");
        simpleReportFiller.compileReport();

        simpleReportFiller.setReportFileName("employeeReport.jrxml");
        simpleReportFiller.compileReport();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "Employee Report");
        parameters.put("minSalary", new BigDecimal(10.0));
        parameters.put("condition", " ENAME ='SMITH'");

        simpleReportFiller.setParameters(parameters);
        simpleReportFiller.fillReport();

        ReportExporter simpleExporter = new ReportExporter();
        simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());

        simpleExporter.exportToPdf("employeeReport.pdf", "Vitalii");
        simpleExporter.exportToXlsx("employeeReport.xlsx", "Employee Data");
        simpleExporter.exportToCsv("employeeReport.csv");
        simpleExporter.exportToHtml("employeeReport.html");

        System.out.println("Reports have been successfuly generated!");
    }
}
