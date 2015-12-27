package com.example.app.validation;

import java.time.DateTimeException;
import java.time.LocalDate;

public class DateItem {

    private Integer year;

    private Integer month;

    private Integer day;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public boolean isValid() {
        if (year == null && month == null && day == null) {
            return true;
        }
        if (year == null || month == null || day == null) {
            return false;
        }
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public LocalDate getValue() {
        if (year != null && month != null && day != null) {
            return LocalDate.of(year, month, day);
        } else {
            return null;
        }
    }

}
