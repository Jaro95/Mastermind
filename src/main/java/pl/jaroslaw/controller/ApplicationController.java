package pl.jaroslaw.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/mastermind")
public class ApplicationController {

    @GetMapping("")
    public String home(Model model) {
        return "application/home";
    }
}
