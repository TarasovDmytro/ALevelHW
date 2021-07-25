package ua.tarasov.datetimeutils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class DateTime {

    private long day;
    private long month;
    private long year;
    private long hours;
    private long minutes;
    private long seconds;

    public DateTime(Parser parser) {

        this.day = parser.getDay();
        this.month = parser.getMonth();
        this.year = parser.getYear();
        this.hours = parser.getHours();
        this.minutes = parser.getMinutes();
        this.seconds = parser.getSeconds();
    }

    public DateTime() {
    }
}
