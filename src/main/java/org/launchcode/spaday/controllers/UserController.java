package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, String verify, @ModelAttribute @Valid User user, Errors errors) {
        if(errors.hasErrors() || !user.getPassword().equals(verify)){
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("error", errors.getFieldError().getDefaultMessage());
            return "user/add";
        } else {
           return "user/index";
        }
    }

    /*
    Within the processAddUserForm handler, check for errors configured by the validation annotation
    using errors.hasErrors(). If this returns true, return the user to the form.
     */

}