package ru.otus.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import ru.otus.json.model.Car;
import ru.otus.jsp.model.Employee;

import java.io.StringWriter;
import java.util.*;

public class FreeMarkerRunner {
    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration(new Version("2.3.23"));

        cfg.setClassForTemplateLoading(FreeMarkerRunner.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("/ftl/index.ftl");
        Map<String, Object> templateData = new HashMap<>();

        templateData.put("foo", true);
        templateData.put("user", "Ivanov Vitalii");
        templateData.put("x", 2);
        templateData.put("bar", "Test");


        Employee emp = new Employee();
        emp.setName("Vitalii Ivanov");

        Employee emp2 = new Employee();
        emp2.setName("Petr Sidorov");

        templateData.put("persons", Arrays.asList(emp, emp2));

        try (StringWriter out = new StringWriter()) {

            template.process(templateData, out);
            System.out.println(out.getBuffer().toString());

            out.flush();
        }
    }
}
