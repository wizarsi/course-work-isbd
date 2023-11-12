package com.example.courseworkisbd.controller;


import com.example.courseworkisbd.dto.SportDirectorDto;
import com.example.courseworkisbd.entity.SportDirector;
import com.example.courseworkisbd.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

import static com.example.courseworkisbd.controller.util.Paths.*;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(HOME)
    public String home(){
        return "index";
    }

    @GetMapping(LOGIN)
    public String loginForm() {
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping(REGISTER)
    public String showRegistrationForm(Model model){
        SportDirectorDto user = new SportDirectorDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping(REGISTER_SAVE)
    public String registration(@Valid @ModelAttribute("sportDirector") SportDirectorDto user,
                               BindingResult result,
                               Model model){
        SportDirector existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping(USERS)
    public String listRegisteredUsers(Model model){
        List<SportDirectorDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
