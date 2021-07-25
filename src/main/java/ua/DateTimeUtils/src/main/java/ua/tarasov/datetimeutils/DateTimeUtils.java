package ua.tarasov.datetimeutils;

import lombok.ToString;

import java.util.*;

import static ua.tarasov.datetimeutils.Months.*;
import static ua.tarasov.datetimeutils.Months.DECEMBER;

@ToString
class DateTimeUtils {

    DateConverter converter = new DateConverter();
    DateTime resultDateTime = new DateTime();

    DateTime difDateTime(DateTime dateTime, DateTime otherDateTime) {

        converter.convertDateTimeToSeconds(dateTime);
        long dateInSec = converter.getDateToSeconds();
        long timeInSec = converter.getTimeToSeconds();

        converter.convertDateTimeToSeconds(otherDateTime);
        long otherDateInSec = converter.getDateToSeconds();
        long otherTimeInSec = converter.getTimeToSeconds();

        long difDate = Math.abs(dateInSec - otherDateInSec);
        long difTime = timeInSec - otherTimeInSec;

        converter.convertToDate(difDate, difTime);

        resultDateTime.setSeconds(converter.getSeconds());
        resultDateTime.setMinutes(converter.getMinutes());
        resultDateTime.setHours(converter.getHours());
        resultDateTime.setDay(converter.getDays());
        resultDateTime.setMonth(converter.getMonths());
        resultDateTime.setYear(converter.getYears());

        return resultDateTime;
    }

    DateTime subTimeFromDateTime(DateTime dateTime, DateTime otherDateTime) {

        converter.convertDateTimeToSeconds(dateTime);
        long dateInSec = converter.getDateToSeconds();
        long timeInSec = converter.getTimeToSeconds();

        converter.convertDateTimeToSeconds(otherDateTime);
        long otherDateInSec = converter.getDateToSeconds();
        long otherTimeInSec = converter.getTimeToSeconds();

        long difDate = dateInSec - otherDateInSec;
        long difTime = timeInSec - otherTimeInSec;

        converter.convertToDate(difDate, difTime);

        resultDateTime.setSeconds(converter.getSeconds());
        resultDateTime.setMinutes(converter.getMinutes());
        resultDateTime.setHours(converter.getHours());
        resultDateTime.setDay(converter.getDays());
        resultDateTime.setMonth(converter.getMonths());
        resultDateTime.setYear(converter.getYears());

        return resultDateTime;
    }

    DateTime addTimeToDateTime(DateTime dateTime, DateTime otherDateTime) {

        converter.convertTimeToSeconds(dateTime);
        long dateInSec = converter.getDateToSeconds();
        long timeInSec = converter.getTimeToSeconds();

        converter.convertTimeToSeconds(otherDateTime);
        long otherDateInSec = converter.getDateToSeconds();
        long otherTimeInSec = converter.getTimeToSeconds();
        long difDate = dateInSec + otherDateInSec;
        long difTime = timeInSec + otherTimeInSec;

        converter.convertToDate(difDate, difTime);

        resultDateTime.setSeconds(converter.getSeconds());
        resultDateTime.setMinutes(converter.getMinutes());
        resultDateTime.setHours(converter.getHours());
        resultDateTime.setDay(converter.getDays());
        resultDateTime.setMonth(converter.getMonths());
        resultDateTime.setYear(converter.getYears());

        return resultDateTime;
    }

    void sortDatesInAscending(DateTime dateTime, DateTime otherDateTime, String patternOfDateTime) {

        Map<Long, DateTime> dateTimeMap = new TreeMap<>();
        dateTimeMap.put(converter.convertDateTimeToSeconds(dateTime), dateTime);
        dateTimeMap.put(converter.convertDateTimeToSeconds(otherDateTime), otherDateTime);

        System.out.println("Dates are sorted in ascending order:");
        dateTimeMap.forEach((key, name) -> {

            if (patternOfDateTime.equals("%2$s-%1$d-%3$02d %4$02d:%5$02d:%6$02d%n") ||
                    patternOfDateTime.equals("%02d/%s/%04d %02d:%02d%n")) {
                String month = "";
                long monthNumber = dateTimeMap.get(key).getMonth();
                switch ((int) monthNumber) {
                    case 1 -> month = JANUARY.getMonth();
                    case 2 -> month = FEBRUARY.getMonth();
                    case 3 -> month = MARCH.getMonth();
                    case 4 -> month = APRIL.getMonth();
                    case 5 -> month = MAY.getMonth();
                    case 6 -> month = JUNE.getMonth();
                    case 7 -> month = JULY.getMonth();
                    case 8 -> month = AUGUST.getMonth();
                    case 9 -> month = SEPTEMBER.getMonth();
                    case 10 -> month = OCTOBER.getMonth();
                    case 11 -> month = NOVEMBER.getMonth();
                    case 12 -> month = DECEMBER.getMonth();
                    default -> System.out.println("Sorry, something wrong, please try again");
                }
                System.out.printf(patternOfDateTime,
                        dateTimeMap.get(key).getDay(), month, dateTimeMap.get(key).getYear(),
                        dateTimeMap.get(key).getHours(), dateTimeMap.get(key).getMinutes(), dateTimeMap.get(key).getSeconds());
            } else {
                System.out.printf(patternOfDateTime,
                        dateTimeMap.get(key).getDay(), dateTimeMap.get(key).getMonth(), dateTimeMap.get(key).getYear(),
                        dateTimeMap.get(key).getHours(), dateTimeMap.get(key).getMinutes(), dateTimeMap.get(key).getSeconds());
            }
        });
    }

    void sortDatesDescending(DateTime dateTime, DateTime otherDateTime, String patternOfDateTime) {

        Map<Long, DateTime> dateTimeMap = new TreeMap<>();
        dateTimeMap.put(converter.convertDateTimeToSeconds(dateTime), dateTime);
        dateTimeMap.put(converter.convertDateTimeToSeconds(otherDateTime), otherDateTime);

        List<Long> listOfKeys = new ArrayList<>();
        listOfKeys.add(converter.convertDateTimeToSeconds(dateTime));
        listOfKeys.add(converter.convertDateTimeToSeconds(otherDateTime));
        listOfKeys.sort(Comparator.reverseOrder());

        System.out.println("Dates are descending:");
        listOfKeys.forEach(key -> {

            if (patternOfDateTime.equals("%2$s-%1$d-%3$02d %4$02d:%5$02d:%6$02d%n") ||
                    patternOfDateTime.equals("%02d/%s/%04d %02d:%02d%n")) {
                String month = "";
                long monthNumber = dateTimeMap.get(key).getMonth();
                switch ((int) monthNumber) {
                    case 1 -> month = JANUARY.getMonth();
                    case 2 -> month = FEBRUARY.getMonth();
                    case 3 -> month = MARCH.getMonth();
                    case 4 -> month = APRIL.getMonth();
                    case 5 -> month = MAY.getMonth();
                    case 6 -> month = JUNE.getMonth();
                    case 7 -> month = JULY.getMonth();
                    case 8 -> month = AUGUST.getMonth();
                    case 9 -> month = SEPTEMBER.getMonth();
                    case 10 -> month = OCTOBER.getMonth();
                    case 11 -> month = NOVEMBER.getMonth();
                    case 12 -> month = DECEMBER.getMonth();
                    default -> System.out.println("Sorry, something wrong, please try again");
                }
                System.out.printf(patternOfDateTime, dateTimeMap.get(key).getDay(), month,
                        dateTimeMap.get(key).getYear(), dateTimeMap.get(key).getHours(),
                        dateTimeMap.get(key).getMinutes(), dateTimeMap.get(key).getSeconds());
            } else {
                System.out.printf(patternOfDateTime, dateTimeMap.get(key).getDay(), dateTimeMap.get(key).getMonth(),
                        dateTimeMap.get(key).getYear(), dateTimeMap.get(key).getHours(),
                        dateTimeMap.get(key).getMinutes(), dateTimeMap.get(key).getSeconds());
            }
        });
    }
}
