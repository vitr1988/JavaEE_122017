package ru.otus.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class DateTimeRunner {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args){
        String datetime = "30.04.2018 20:47:36";
        System.out.println(formatter.parse(datetime).get(ChronoField.MINUTE_OF_HOUR));
        System.out.println(formatter.format(LocalDateTime.now()));
    }
}
