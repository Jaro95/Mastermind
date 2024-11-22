package pl.jaroslaw.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jaroslaw.dto.RegistrationRequest;
import pl.jaroslaw.model.Game;
import pl.jaroslaw.model.Role;
import pl.jaroslaw.model.Statistics;
import pl.jaroslaw.model.User;
import pl.jaroslaw.repository.GameRepository;
import pl.jaroslaw.repository.RoleRepository;
import pl.jaroslaw.repository.StatisticRepository;
import pl.jaroslaw.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class ApplicationService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final StatisticRepository statisticRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void saveUser(RegistrationRequest user) {
        Role userRole = roleRepository.findByName("ROLE_USER").orElseThrow();
        userRepository.save(User.builder()
                .email(user.getEmail())
                .roles(new HashSet<>(Collections.singletonList(userRole)))
                .password(passwordEncoder.encode(user.getPassword()))
                .createdAccount(LocalDateTime.now())
                .enabled(true)
                .token(UUID.randomUUID().toString())
                .build());
        initializeGame(user.getEmail());
        Statistics statistics = statisticRepository.findById(1L).orElseThrow();
        statistics.setRegistrationPlayers(statistics.getRegistrationPlayers() + 1);
        statisticRepository.save(statistics);
    }

    @Transactional
    public void initializeGame(String email) {
        Optional<User> userForGame = userRepository.findByEmail(email);
        Game game = new Game();
        game.setCountGames(0);
        game.setLoseGames(0);
        game.setUser(userForGame.orElseThrow());
        gameRepository.save(game);
    }

    @Transactional
    public void increaseCountGame() {
        Statistics statistics = statisticRepository.findById(1L).orElseThrow();
        statistics.setCountAllGames(statistics.getCountAllGames() + 1);
        statisticRepository.save(statistics);
    }

    @Transactional
    public void increaseResultGameForPlayer(String result, Long userId) {
        Game game = gameRepository.findByUserId(userId).orElseThrow();
        game.setCountGames(game.getCountGames() + 1);
        if (result.equals("winner")) {
            game.setWinGames(game.getWinGames() + 1);
        } else {
            game.setLoseGames(game.getLoseGames() + 1);
        }
    }
}
