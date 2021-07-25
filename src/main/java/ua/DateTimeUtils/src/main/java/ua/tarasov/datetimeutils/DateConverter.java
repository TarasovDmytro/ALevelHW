package ua.tarasov.datetimeutils;

import lombok.Getter;

@Getter
class DateConverter {

    private long days;
    private long months;
    private long years;
    private long hours;
    private long minutes;
    private long seconds;
    private long dateToSeconds;
    private long timeToSeconds;

    long convertDateTimeToSeconds(DateTime dateTime) {

        long seconds = dateTime.getSeconds();
        long minToSec = dateTime.getMinutes() * 60L;
        long hourToSec = dateTime.getHours() * 3600L;
        long dayToSec = dateTime.getDay() * 86400;
        long monthToSec = (dateTime.getMonth() - 1) * 2629800;
        long yearToSec = (dateTime.getYear() - 1) * 31557600;

        dateToSeconds = dayToSec + monthToSec + yearToSec;
        timeToSeconds = hourToSec + minToSec + seconds;

        return (dateToSeconds + timeToSeconds);
    }

    void convertTimeToSeconds(DateTime dateTime) {

        long seconds = dateTime.getSeconds();
        long minToSec = dateTime.getMinutes() * 60L;
        long hourToSec = dateTime.getHours() * 3600L;
        long dayToSec = dateTime.getDay() * 86400;
        long monthToSec = (dateTime.getMonth()) * 2629800;
        long yearToSec = (dateTime.getYear()) * 31557600;

        dateToSeconds = dayToSec + monthToSec + yearToSec;
        timeToSeconds = hourToSec + minToSec + seconds;
    }

    void convertToDate(long dateInSeconds, long timeInSeconds) {

        if (timeInSeconds > 86399) {
            dateInSeconds += (timeInSeconds - timeInSeconds % 86400);
            timeInSeconds = timeInSeconds % 86400;
        }
        if (timeInSeconds < 0) {
            dateInSeconds -= 86400;
            timeInSeconds += 86400;
        }
        hours = timeInSeconds / 3600;
        minutes = (timeInSeconds % 3600) / 60;
        seconds = timeInSeconds % 60;

        days = (dateInSeconds % 2629800) / 86400;
        if ((dateInSeconds % 2629800) % 86400 != 0) {
            days += 1;
        }
        years = dateInSeconds / 31557600;
        months = (dateInSeconds % 31557600) / 2629800;
    }
}
