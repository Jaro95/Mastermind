package pl.jaroslaw.service;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class MastermindGame {
    private String secretCode;
    private int attemptsCount;
    private Map<String, String> information;

    public MastermindGame() {
        this.secretCode = generateSecretCode();
        this.attemptsCount = 0;
        this.information = new LinkedHashMap<>();
    }

    private String generateSecretCode() {
        Random random = new Random();
        int number = random.nextInt(10000);
        return String.format("%04d", number);
    }

    public boolean checkGuess(String guess) {
        if(information.containsKey(guess)) {
            return false;
        } else {
            List<Character> code = new ArrayList<>(secretCode.chars().mapToObj(a -> (char) a).toList());
            List<Character> guessList = new ArrayList<>(guess.chars().mapToObj(a -> (char) a).toList());
            int correctPositions = 0;
            int correctDigits = 0;

            for (int i = 0; i < 4; i++) {
                if (guessList.get(i) == code.get(i)) {
                    correctPositions++;
                    code.set(i, null);
                    guessList.set(i, null);
                }
            }

            for (int i = 0; i < 4; i++) {
                if (guessList.get(i) != null) {
                    for (int j = 0; j < 4; j++) {
                        if (guessList.get(i) == code.get(j)) {
                            correctDigits++;
                            code.set(j, null);
                        }
                    }
                }
            }
            this.attemptsCount++;
            information.put(guess,String.format("Correct positions: %d, Correct digits: %d", correctPositions, correctDigits));
            return true;
        }
    }
}
