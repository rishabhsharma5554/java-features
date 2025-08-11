package com.rishahtech.java8.placement.company.Newgen.code;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

// LocalDateTime
// LocalDate
// LocalTime
// DateTimeFormatter
// ZoneDateTime

public class DataProblem {
    public static void main(String[] args) {
        // the current date
        LocalDate date = LocalDate.now();
        System.out.println("the current date is " + date);

        // the current time
        LocalTime time = LocalTime.now();
        System.out.println("the current time is " + time);

        // will give us the current time and date
        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : " + current);

        // to print in a particular format
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatedDateTime = LocalDateTime.now().format(format);
        System.out.println("in formatted manner " + formatedDateTime);

        // printing months days and seconds
        //old API
        Month month = current.getMonth();
        int day = current.getDayOfMonth();
        int seconds = current.getSecond();
        System.out.println("Month : " + month + " day : " + day + " seconds : " + seconds);

        // printing some specified date
        LocalDate date2 = LocalDate.of(1997, 5, 9);
        System.out.println("Bday  :" + date2);

        // printing date with current time.
        LocalDateTime specificDate = current.withDayOfMonth(24).withYear(2016);
        System.out.println("specific date with current time : " + specificDate);

        //Interview Question
        //Given a data 2023-10-27 print the day of the date
        String givenDate = "2023-10-27";
        DateTimeFormatter dtfGivenDate = DateTimeFormatter.ofPattern(givenDate);
        LocalDate ldGivenDate = LocalDate.parse(givenDate);
        System.out.println(ldGivenDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));

        System.out.println();
        String dateStr = "14-02-2024 20:15:22";
        DateTimeFormatter dtfDateStr = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime ldtDateStr = LocalDateTime.parse(dateStr, dtfDateStr);
        System.out.println(ldtDateStr.getMinute());
        System.out.println(ldtDateStr.getMonth());


    }
}
