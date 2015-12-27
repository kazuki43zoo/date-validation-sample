package com.example.app.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SampleForm {

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @ValidDateItem(required = true)
    private DateItem dateOfBirth;

    @ValidDateItem(minYear = 2000, maxYear = 2999)
    private DateItem dateOfJoin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateItem getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateItem dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public DateItem getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(DateItem dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }
}
