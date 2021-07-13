package ua.tarasov.datetimeutils;

import lombok.Getter;

@Getter
public enum Months {

    JANUARY("Jan", 1),
    FEBRUARY("Feb", 2),
    MARCH("Mar", 3),
    APRIL("Apr", 4),
    MAY("May", 5),
    JUNE("Jun", 6),
    JULY("Jul", 7),
    AUGUST("Aug", 8),
    SEPTEMBER("Sep", 9),
    OCTOBER("Oct", 10),
    NOVEMBER("Nov", 11),
    DECEMBER("Dec", 12);

    private final String month;
    private final long numberOfMonth;

    Months(String month, long numberOfMonth){
        this.month=month;
        this.numberOfMonth=numberOfMonth;
    }

}
