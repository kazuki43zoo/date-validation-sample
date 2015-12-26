package com.example.app.validation;

import javax.validation.GroupSequence;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.DateTimeException;
import java.time.LocalDate;

@GroupSequence({DateItem.class, ValidationGroups.Correlation.class})
@ValidDateItem(groups = ValidationGroups.Correlation.class)
public class DateItem {

    @Min(1900)
    @Max(9999)
    private Integer year;

    @Min(1)
    @Max(12)
    private Integer month;

    @Min(1)
    @Max(31)
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

    public boolean isValidDate() {
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

    public LocalDate toLocalDate() {
        if (year != null && month != null && day != null) {
            return LocalDate.of(year, month, day);
        } else {
            return null;
        }
    }

}
