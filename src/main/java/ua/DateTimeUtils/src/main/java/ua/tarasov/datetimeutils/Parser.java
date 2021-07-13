package ua.tarasov.datetimeutils;

import lombok.*;

import static ua.tarasov.datetimeutils.Months.*;

@Getter
@ToString
class Parser {

    private long day;
    private long month;
    private long year;
    private long hours;
    private long minutes;
    private long seconds;

    public Parser(String stringDateTime, String formatOfDateTime) {
        setDateTime(stringDateTime, formatOfDateTime);
    }

    void setDateTime(String stringDateTime, String formatOfDateTime) {

        String parsMarkerOfDate = "/";
        if (stringDateTime.contains("-")) {
            parsMarkerOfDate = "-";
        }

        String[] parts = stringDateTime.split(" ");
        if (parts.length > 2) {
            throw new IllegalArgumentException("Wrong format");
        }

        String[] date = parts[0].split(parsMarkerOfDate);

        if (date[0].equals("")) {
            throw new IllegalArgumentException("Date not found");
        }

        if (formatOfDateTime.equals("mmm-d-yy 00:00:00")) {
            String s = "";
            if (date.length > 1) {
                switch (date[0]) {
                    case "Jan" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(JANUARY.getNumberOfMonth());
                    }
                    case "Feb" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(FEBRUARY.getNumberOfMonth());
                    }
                    case "Mar" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(MARCH.getNumberOfMonth());
                    }
                    case "Apr" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(APRIL.getNumberOfMonth());
                    }
                    case "May" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(MAY.getNumberOfMonth());
                    }
                    case "Jun" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(JUNE.getNumberOfMonth());
                    }
                    case "Jul" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(JULY.getNumberOfMonth());
                    }
                    case "Aug" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(AUGUST.getNumberOfMonth());
                    }
                    case "Sep" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(SEPTEMBER.getNumberOfMonth());
                    }
                    case "Oct" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(OCTOBER.getNumberOfMonth());
                    }
                    case "Nov" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(NOVEMBER.getNumberOfMonth());
                    }
                    case "Dec" -> {
                        date[0] = date[1];
                        date[1] = String.valueOf(DECEMBER.getNumberOfMonth());
                    }
                    default -> throw new IllegalStateException("Unexpected value of month: " + date[0]);
                }
                if (date.length == 2) {
                    this.day = Long.parseLong(date[0]);
                    this.month = Long.parseLong(date[1]);
                    this.year = 2021;
                } else {
                    this.day = Long.parseLong(date[0]);
                    this.month = Long.parseLong(date[1]);
                    this.year = Long.parseLong(date[2]);
                }
            } else {
                this.day = 1;
                this.month = 1;
                this.year = Long.parseLong(date[0]);
            }
        }

        if (formatOfDateTime.equals("dd-mmm-yyyy 00:00:00")) {
            if (date.length > 1) {
                switch (date[1]) {
                    case "Jan" -> date[1] = String.valueOf(JANUARY.getNumberOfMonth());
                    case "Feb" -> date[1] = String.valueOf(FEBRUARY.getNumberOfMonth());
                    case "Mar" -> date[1] = String.valueOf(MARCH.getNumberOfMonth());
                    case "Apr" -> date[1] = String.valueOf(APRIL.getNumberOfMonth());
                    case "May" -> date[1] = String.valueOf(MAY.getNumberOfMonth());
                    case "Jun" -> date[1] = String.valueOf(JUNE.getNumberOfMonth());
                    case "Jul" -> date[1] = String.valueOf(JULY.getNumberOfMonth());
                    case "Aug" -> date[1] = String.valueOf(AUGUST.getNumberOfMonth());
                    case "Sep" -> date[1] = String.valueOf(SEPTEMBER.getNumberOfMonth());
                    case "Oct" -> date[1] = String.valueOf(OCTOBER.getNumberOfMonth());
                    case "Nov" -> date[1] = String.valueOf(NOVEMBER.getNumberOfMonth());
                    case "Dec" -> date[1] = String.valueOf(DECEMBER.getNumberOfMonth());
                    default -> throw new IllegalStateException("Unexpected value of month: " + date[0]);
                }
                if (date.length == 2) {
                    this.day = Long.parseLong(date[0]);
                    this.month = Long.parseLong(date[1]);
                    this.year = 2021;
                } else {
                    this.day = Long.parseLong(date[0]);
                    this.month = Long.parseLong(date[1]);
                    this.year = Long.parseLong(date[2]);
                }
            } else {
                this.day = 1;
                this.month = 1;
                this.year = Long.parseLong(date[0]);
            }
        } else {

            switch (date.length) {
                case 1 -> {
                    this.day = 1;
                    this.month = 1;
                    this.year = Long.parseLong(date[0]);
                }
                case 2 -> {
                    this.day = Long.parseLong(date[0]);
                    this.month = Long.parseLong(date[1]);
                    this.year = 2021;

                }
                case 3 -> {
                    this.day = Long.parseLong(date[0]);
                    this.month = Long.parseLong(date[1]);
                    this.year = Long.parseLong(date[2]);
                }
                default -> {
                    this.day = 1;
                    this.month = 1;
                    this.year = 2021;
                }
            }
        }

        String[] time;
        if (parts.length == 2) {
            time = parts[1].split(":");
        } else time = new String[]{"00", "00", "00"};

        for (int i = 0; i < time.length; i++) {

            if (time[i].equals("")) {
                time[i] = "00";
            }
        }

        switch (time.length) {
            case 1 -> {
                this.hours = Long.parseLong(time[0]);
                this.minutes = 0;
                this.seconds = 0;
            }
            case 2 -> {
                this.hours = Long.parseLong(time[0]);
                this.minutes = Long.parseLong(time[1]);
                this.seconds = 0;
            }
            case 3 -> {
                this.hours = Integer.parseInt(time[0]);
                this.minutes = Integer.parseInt(time[1]);
                this.seconds = Integer.parseInt(time[2]);
            }
            default -> throw new IllegalArgumentException("Wrong format of time");
        }

        if (this.day > 31 || this.month > 12 || this.year < 0 || this.day < 0 || this.month < 0) {
            throw new IllegalArgumentException("Wrong date");
        }
        for (int i = 0; i < 5; i = i + 2) {
            if ((this.month == i + 2 || this.month == i + 9) && this.day > 30) {
                throw new IllegalArgumentException("Wrong date");
            }
        }
        if (this.month == 2 && this.day > 29) {
            throw new IllegalArgumentException("Wrong date");
        }
    }
}
