package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add.html";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String verify) {
        if(user.getPassword().equals(verify)){
            return "user/index.html";
        }
        model.addAttribute("error", "Passwords do not match");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "user/add.html";
    }

}

/*
If we send a user back to re-populate the form, it would be nice to not clear their previous submission.
In the form submission handler, add the username and email fields of the submitted user as model attributes.
Back in the form, add a value attribute to these form fields and make them equal to the model attributes.
 */
