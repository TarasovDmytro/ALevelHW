package ua.tarasov.datetimeutils;

import lombok.ToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@ToString
class Controller {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    DateTimeUtils dateTimeUtils = new DateTimeUtils();
    ServiceDateTime serviceDateTime = new ServiceDateTime();
    String patternOfDateTime;
    String formatOfDateTime;
    Parser parser;

    public void run() {

        String action = "";
        while (!action.equals("0")) {

            System.out.println("""
                     
                     Select an action, please:
                     -----------------------------------------------------------------------------
                     enter 1  Find the difference between dates
                     enter 2  Add years, months, days, hours, minutes, seconds to the date
                     enter 3  Subtract years, months, days, hours, minutes, seconds from the date
                     enter 4  Sort dates in ascending order
                     enter 5  Sort dates descending
                     enter 0  if you want to exit
                     -----------------------------------------------------------------------------
                    """);

            try {
                action = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (action) {
                case "1" -> difDateTime(reader);
                case "2" -> addTimeToDateTime(reader);
                case "3" -> subTimeFromDateTime(reader);
                case "4" -> sortDatesInAscending(reader);
                case "5" -> sortDatesDescending(reader);
                case "0" -> System.out.println("Bye-bye)))");
                default -> System.out.println("WRONG ACTION! Try again, please");
            }
        }
    }

    private void sortDatesDescending(BufferedReader reader) {

        selectFormatOfDateTime();
        try {
            System.out.println("Enter the date in the format: " + formatOfDateTime);
            String firstDateTime = reader.readLine();
            parser = new Parser(firstDateTime, formatOfDateTime);
            DateTime dateTime = new DateTime(parser);
            System.out.println("Enter the next date in the format: " + formatOfDateTime);
            String secondDateTime = reader.readLine();
            parser = new Parser(secondDateTime, formatOfDateTime);
            DateTime otherDateTime = new DateTime(parser);
            serviceDateTime.sortDatesDescending(dateTime, otherDateTime, patternOfDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sortDatesInAscending(BufferedReader reader) {

        selectFormatOfDateTime();
        try {
            System.out.println("Enter the date in the format: " + formatOfDateTime);
            String firstDateTime = reader.readLine();
            parser = new Parser(firstDateTime, formatOfDateTime);
            DateTime dateTime = new DateTime(parser);
            System.out.println("Enter the next date in the format: " + formatOfDateTime);
            String secondDateTime = reader.readLine();
            parser = new Parser(secondDateTime, formatOfDateTime);
            DateTime otherDateTime = new DateTime(parser);
            serviceDateTime.sortDatesInAscending(dateTime, otherDateTime, patternOfDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void subTimeFromDateTime(BufferedReader reader) {

        selectFormatOfDateTime();
        while (formatOfDateTime.equals("mmm-d-yy 00:00:00") || formatOfDateTime.equals("dd-mmm-yyyy 00:00:00")) {
            System.out.println("""
                            
                    The format cannot be used to perform this action correctly.
                    Select the data input / output format for this action from numbers 1 or 2
                    """);
            selectFormatOfDateTime();
        }
        try {
            System.out.println("Enter the date in the format: " + formatOfDateTime);
            String firstDateTime = reader.readLine();
            parser = new Parser(firstDateTime, formatOfDateTime);
            DateTime dateTime = new DateTime(parser);
            System.out.println("Enter the time to subtract from the date in the format: " + formatOfDateTime);
            String secondDateTime = reader.readLine();
            parser = new Parser(secondDateTime, formatOfDateTime);
            DateTime otherDateTime = new DateTime(parser);
            serviceDateTime.subTimeFromDateTime(dateTime, otherDateTime, patternOfDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addTimeToDateTime(BufferedReader reader) {

        System.out.println("Select the data input / output format for this action from numbers 1 or 2");
        selectFormatOfDateTime();
        while (formatOfDateTime.equals("mmm-d-yy 00:00:00") || formatOfDateTime.equals("dd-mmm-yyyy 00:00:00")) {
            System.out.println("""
                            
                    The format cannot be used to perform this action correctly.
                    Select the data input / output format for this action from numbers 1 or 2
                    """);
            selectFormatOfDateTime();
        }
        try {
            System.out.println("Enter the date in the format: " + formatOfDateTime);
            String firstDateTime = reader.readLine();
            parser = new Parser(firstDateTime, formatOfDateTime);
            DateTime dateTime = new DateTime(parser);
            System.out.println("Enter the time to add to the date in the format: " + formatOfDateTime);
            String secondDateTime = reader.readLine();
            parser = new Parser(secondDateTime, formatOfDateTime);
            DateTime otherDateTime = new DateTime(parser);
            serviceDateTime.addTimeToDateTime(dateTime, otherDateTime, patternOfDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void difDateTime(BufferedReader reader) {

        selectFormatOfDateTime();
        try {
            System.out.println("Enter the date in the format: " + formatOfDateTime);
            String firstDateTime = reader.readLine();
            parser = new Parser(firstDateTime, formatOfDateTime);
            DateTime dateTime = new DateTime(parser);
            System.out.println("Enter the next date in the format: " + formatOfDateTime);
            String secondDateTime = reader.readLine();
            parser = new Parser(secondDateTime, formatOfDateTime);
            DateTime otherDateTime = new DateTime(parser);
            serviceDateTime.difDateTime(dateTime, otherDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectFormatOfDateTime() {
        System.out.println("""
                 
                 Select the data input / output format:
                 -----------------------------------------------------------------------------
                 enter 1  for  dd/mm/yy 00:00:00
                 enter 2  for  d/m/yyyy 0:0:0
                 enter 3  for  mmm-d-yy
                 enter 4  for  dd-mmm-yyyy 00:00
                 -----------------------------------------------------------------------------
                """);
        String format = "";
        try {
            format = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (format) {
            case "1" -> {
                formatOfDateTime = "dd/mm/yy 00:00:00";
                patternOfDateTime = "%02d/%02d/%02d %02d:%02d:%02d%n";
            }
            case "2" -> {
                formatOfDateTime = "d/m/yyyy 0:0:0";
                patternOfDateTime = "%d/%d/%04d %d:%d:%d%n";
            }
            case "3" -> {
                formatOfDateTime = "mmm-d-yy 00:00:00";
                patternOfDateTime = "%2$s-%1$d-%3$02d %4$02d:%5$02d:%6$02d%n";
            }
            case "4" -> {
                formatOfDateTime = "dd-mmm-yyyy 00:00:00";
                patternOfDateTime = "%02d-%s-%04d %02d:%02d%n";
            }
            default -> throw new IllegalArgumentException("format not found");
        }
    }
}
