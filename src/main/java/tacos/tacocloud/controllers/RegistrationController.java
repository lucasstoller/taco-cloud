package tacos.tacocloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.tacocloud.dtos.UserDto;
import tacos.tacocloud.entities.User;
import tacos.tacocloud.repositories.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registrationForm(Model model, @ModelAttribute UserDto userDto) {
        model.addAttribute(userDto);
        return "registration";
    }

    @PostMapping
    public String processRegistration(@Valid UserDto userDto, Errors errors) {
        if (errors.hasErrors()) {
            return "registration";
        }

        userRepository.save(userDto.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
