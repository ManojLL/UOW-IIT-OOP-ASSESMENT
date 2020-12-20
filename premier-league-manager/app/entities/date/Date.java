package entities.date;

import java.io.Serializable;

public class Date implements Serializable, Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(Date date) {
        if (this.getDate() > date.getDate()) {
            return -1;
        } else {
            return 1;
        }
    }

    public int getDate() {
        return (this.day + this.month * 30 + this.year * 12 * 30);
    }

    @Override
    public boolean equals(Object date) {
        if (this == date) return true;
        if (!(date instanceof Date)) return false;
        Date dateTime = (Date) date;
        return year == dateTime.year && month == dateTime.month && day == dateTime.day;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
