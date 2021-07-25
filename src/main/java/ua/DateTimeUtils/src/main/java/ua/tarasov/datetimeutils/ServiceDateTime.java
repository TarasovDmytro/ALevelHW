package ua.tarasov.datetimeutils;

class ServiceDateTime {

    DateTimeUtils dateTimeUtils = new DateTimeUtils();
    DateTime resultDateTime;

    void difDateTime(DateTime dateTime, DateTime otherDateTime) {

        resultDateTime = dateTimeUtils.difDateTime(dateTime, otherDateTime);

        System.out.println("The difference in dates:");
        System.out.printf("%2$d months %1$d days %3$d years %4$02d hrs %5$02d min %6$02d sec",
                resultDateTime.getDay(), resultDateTime.getMonth(), resultDateTime.getYear(),
                resultDateTime.getHours(), resultDateTime.getMinutes(), resultDateTime.getSeconds());
    }

    public void subTimeFromDateTime(DateTime dateTime, DateTime otherDateTime, String patternOfDateTime) {

        resultDateTime = dateTimeUtils.subTimeFromDateTime(dateTime, otherDateTime);
        System.out.println("New date after subtracting time:");
        System.out.printf(patternOfDateTime, resultDateTime.getDay(), resultDateTime.getMonth(),
                resultDateTime.getYear(), resultDateTime.getHours(), resultDateTime.getMinutes(),
                resultDateTime.getSeconds());
    }

    public void addTimeToDateTime(DateTime dateTime, DateTime otherDateTime, String patternOfDateTime) {

        resultDateTime = dateTimeUtils.addTimeToDateTime(dateTime, otherDateTime);
        System.out.println("New date after adding time:");
        System.out.printf(patternOfDateTime, resultDateTime.getDay(), resultDateTime.getMonth(),
                resultDateTime.getYear(), resultDateTime.getHours(), resultDateTime.getMinutes(),
                resultDateTime.getSeconds());
    }

    public void sortDatesInAscending(DateTime dateTime, DateTime otherDateTime, String patternOfDateTime) {

        dateTimeUtils.sortDatesInAscending(dateTime, otherDateTime, patternOfDateTime);
    }

    public void sortDatesDescending(DateTime dateTime, DateTime otherDateTime, String patternOfDateTime) {

        dateTimeUtils.sortDatesDescending(dateTime, otherDateTime, patternOfDateTime);
    }
}
