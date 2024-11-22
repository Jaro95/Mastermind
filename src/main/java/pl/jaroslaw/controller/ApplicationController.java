package pl.jaroslaw.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.jaroslaw.configuration.CurrentUser;
import pl.jaroslaw.dto.RegistrationRequest;
import pl.jaroslaw.model.Game;
import pl.jaroslaw.model.Statistics;
import pl.jaroslaw.repository.GameRepository;
import pl.jaroslaw.repository.StatisticRepository;
import pl.jaroslaw.repository.UserRepository;
import pl.jaroslaw.service.MastermindGame;
import pl.jaroslaw.service.ApplicationService;

@Controller
@AllArgsConstructor
@Slf4j
@SessionAttributes("mastermindGame")
@RequestMapping("/mastermind")
public class ApplicationController {

    private final UserRepository userRepository;
    private final ApplicationService applicationService;
    private final StatisticRepository statisticRepository;
    private final GameRepository gameRepository;

    @GetMapping("")
    public String home() {
        return "application/home";
    }

    @GetMapping("/game")
    public String game(Model model) {
        MastermindGame mastermindGame = setupMastermindGame();
        model.addAttribute("mastermindGame", mastermindGame);
        model.addAttribute("information", mastermindGame.getInformation());
        model.addAttribute("attemptsCount", mastermindGame.getAttemptsCount());
        log.info("Secret code: {}", mastermindGame.getSecretCode());
        applicationService.increaseCountGame();
        return "application/game";
    }

    @PostMapping("/game")
    public String guess(@ModelAttribute("mastermindGame") MastermindGame mastermindGame, BindingResult bindingResult,
                        @RequestParam(value = "guess", required = false) String guess,
                        @AuthenticationPrincipal CurrentUser currentUser, Model model) {
        if(guess.isBlank() || guess.length() != 4) {
            model.addAttribute("error", "You don't insert correct digit!");
            model.addAttribute("mastermindGame", mastermindGame);
            model.addAttribute("information", mastermindGame.getInformation());
            model.addAttribute("attemptsCount", mastermindGame.getAttemptsCount());
            return "application/game";
        }
        boolean check = mastermindGame.checkGuess(guess);
        if(mastermindGame.getSecretCode().equals(guess)) {
            model.addAttribute("winner", "Congratulation you win!");
            model.addAttribute("secretCode", "Secret code: " + mastermindGame.getSecretCode());
            model.addAttribute("mastermindGame", mastermindGame);
            model.addAttribute("information", mastermindGame.getInformation());
            model.addAttribute("attemptsCount", mastermindGame.getAttemptsCount());
            if(currentUser != null) {
                applicationService.increaseResultGameForPlayer("winner",currentUser.getUser().getId());
            }
            return "application/game";
        }
        if(!check) {
            model.addAttribute("error", "you repeated digit!");
        }
        if(mastermindGame.getAttemptsCount() == 15) {
            model.addAttribute("lose", "Sorry you lose!");
            model.addAttribute("secretCode", "Secret code: " + mastermindGame.getSecretCode());
            model.addAttribute("mastermindGame", mastermindGame);
            model.addAttribute("information", mastermindGame.getInformation());
            model.addAttribute("attemptsCount", mastermindGame.getAttemptsCount());
            if(currentUser != null) {
                applicationService.increaseResultGameForPlayer("lose",currentUser.getUser().getId());
            }
            return "application/game";
        }
        model.addAttribute("mastermindGame", mastermindGame);
        model.addAttribute("information", mastermindGame.getInformation());
        model.addAttribute("attemptsCount", mastermindGame.getAttemptsCount());

        return "application/game";
    }

    @GetMapping("/game/reset")
    public String resetGame(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/mastermind/game";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("wrongPassword", error);
        return "application/login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("registrationRequest", new RegistrationRequest());
        return "application/registration";
    }

    @PostMapping("/registration")
    public String postRegistration(@Valid RegistrationRequest registrationRequest, BindingResult result,
                                   Model model, RedirectAttributes redirectAttributes) {
        System.out.println(registrationRequest.getPassword());
        System.out.println(registrationRequest.getRepeatPassword());
        if (result.hasErrors()) {
            model.addAttribute("registrationRequest", registrationRequest);
            model.addAttribute("errors", result.getAllErrors());
            return "application/registration";
        }
        if (!registrationRequest.getPassword().equals(registrationRequest.getRepeatPassword())) {
            model.addAttribute("registrationRequest", registrationRequest);
            model.addAttribute("messageError", "Hasła nie są takie same");
            return "application/registration";
        }
        if (userRepository.findByEmail(registrationRequest.getEmail()).isPresent()) {
            model.addAttribute("registrationRequest", registrationRequest);
            model.addAttribute("messageError", "Email jest już zajęty");
            return "application/registration";
        }

        applicationService.saveUser(registrationRequest);
        redirectAttributes.addFlashAttribute("message", "Rejestracja przebiegła pomyślnie");
        return "redirect:/mastermind/login";
    }

    @GetMapping("/validate")
    public String validateUser(@AuthenticationPrincipal CurrentUser currentUser, RedirectAttributes redirectAttributes) {
        if (!currentUser.getUser().isEnabled()) {
            redirectAttributes.addFlashAttribute("messageEnabled", "Konto nie zostało aktywowane");
            return "redirect:/mastermind/login";
        }
        return "redirect:/mastermind";
    }

    @GetMapping("/statistic")
    public String statistic(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        Statistics statistics = statisticRepository.findById(1L).orElseThrow();
        model.addAttribute("countPlayers", statistics.getRegistrationPlayers());
        model.addAttribute("countGame", statistics.getCountAllGames());
        if(currentUser != null) {
            Game game = gameRepository.findByUserId(currentUser.getUser().getId()).orElseThrow();
            model.addAttribute("gamePlayer", game.getCountGames());
            model.addAttribute("win", game.getWinGames());
            model.addAttribute("lose", game.getLoseGames());
        }
        return "application/statistics";
    }

    @ModelAttribute("mastermindGame")
    public MastermindGame setupMastermindGame() {
        return new MastermindGame();
    }

}
