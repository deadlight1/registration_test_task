package com.volodymyr.register_usertest_task.controller;

import com.volodymyr.register_usertest_task.model.dto.UserDto;
import com.volodymyr.register_usertest_task.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.volodymyr.register_usertest_task.utils.DefaultUtils.bindingResultToList;
import static java.util.Collections.singletonList;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public String getRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUser(@Valid UserDto user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("username_errors", bindingResultToList(bindingResult, "username"));
            model.addAttribute("password_errors", bindingResultToList(bindingResult, "password"));
            model.addAttribute("username", user.getUsername());
            return "registration";
        } else if (registrationService.registerUser(user)) {
            return "redirect:/main/greeting";
        } else {
            model.addAttribute("username_errors", singletonList("User already exists!"));
            return "registration";
        }
    }
}
