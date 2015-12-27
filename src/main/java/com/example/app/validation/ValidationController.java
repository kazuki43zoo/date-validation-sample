package com.example.app.validation;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/validation")
@Controller
public class ValidationController {

    @ModelAttribute
    public SampleForm setUpForm() {
        return new SampleForm();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String form() {
        return "validation/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String validate(@Validated SampleForm form, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "validation/form";
        }
        model.addAttribute("dateOfBirth", form.getDateOfBirth().toLocalDate());
        model.addAttribute("dateOfJoin", form.getDateOfJoin().toLocalDate());
        return "validation/form";
    }

}
