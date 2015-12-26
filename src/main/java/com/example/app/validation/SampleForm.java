package com.example.app.validation;

import javax.validation.Valid;

public class SampleForm {

    @Valid
    private DateItem dateOfBirth;

    public DateItem getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateItem dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
