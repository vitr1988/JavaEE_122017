package ru.otus.log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "InternationalizationServlet", urlPatterns = "/i18n")
public class InternationalizationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Locale locale = request.getLocale();
        Locale localeANother = new Locale("ru", "RU");
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter pw = response.getWriter()) {
            pw.println("Default Locale Properties:\n");

            pw.println(locale.getDisplayCountry());
            pw.println(locale.getDisplayLanguage());
            pw.println(locale.getDisplayName());
            pw.println(locale.getISO3Country());
            pw.println(locale.getISO3Language());
            pw.println(locale.getLanguage());
            pw.println(locale.getCountry());

            Locale frenchLocale = new Locale("fr","fr");

            pw.println("\nfr Locale Properties:\n");
            pw.println(frenchLocale.getDisplayCountry());
            pw.println(frenchLocale.getDisplayLanguage());
            pw.println(frenchLocale.getDisplayName());
            pw.println(frenchLocale.getISO3Country());
            pw.println(frenchLocale.getISO3Language());
            pw.println(frenchLocale.getLanguage());
            pw.println(frenchLocale.getCountry());

            //-----
            Locale enLocale = new Locale("en", "US");
            Locale ruLocale = new Locale("ru", "RU");
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ruLocale);

            pw.println(numberFormat.format(100.76));

            numberFormat = NumberFormat.getCurrencyInstance(enLocale);

            pw.println(numberFormat.format(100.76));
            
            //---
            NumberFormat percentageFormat = NumberFormat.getPercentInstance(enLocale);

            pw.println(percentageFormat.format(0.76));
            
            //--
            numberFormat.setMinimumFractionDigits(0);
            numberFormat.setMaximumFractionDigits(0);

            pw.println(numberFormat.format(99.50));

            numberFormat.setRoundingMode(RoundingMode.HALF_DOWN);

            pw.println(numberFormat.format(99.50));

            //--
            NumberFormat decimalFormat = NumberFormat.getInstance(ruLocale);

            pw.println(decimalFormat.parse("100,76"));

            decimalFormat = NumberFormat.getInstance(enLocale);

            pw.println(decimalFormat.parse("100,76"));
            
            //--
            String pattern = "####,####.##";
            double number = 123456789.123;

            DecimalFormat decFormat = new DecimalFormat(pattern);
            pw.println(number);
            pw.println(decFormat.format(number));

            //--

            DateFormat dateFormat = DateFormat.getDateInstance();

            pw.println(dateFormat.format(new Date()));

            dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

            pw.println(dateFormat.format(new Date()));
            
            //---

            String datePattern = "dd-MM-yyyy";

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);

            Date date = new Date();

            pw.println(date);
            pw.println(simpleDateFormat.format(date));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
