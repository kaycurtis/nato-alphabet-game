package main.controller;

import main.model.PhoneticAlphabet;
import main.view.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by kayla on 2017-08-12.
 */
public class GameControl implements ActionListener {

    public GamePanel panel;

    private List<PhoneticAlphabet> unusedLetters = new ArrayList<>(Arrays.asList(PhoneticAlphabet.values()));

    private PhoneticAlphabet letter;
    private String phoneticValue;

    private boolean tryAgain = true;
    private boolean giveHint = true;
    int hintLength = 2;

    private void processGuess() {
        String guess = panel.getTextFromUserInputAsUpperCase();
        if (guess.equals(phoneticValue)) {
            panel.updateDescriptionField("Well done! Let's do another one.");
            getNewLetter();
        }
        else if (tryAgain && giveHint) {
            panel.updateDescriptionField("That's not quite it! Here's a hint: the first two letters are " + phoneticValue.substring(0,hintLength));
            tryAgain = false;
        }
        else if (tryAgain) {
            panel.updateDescriptionField("That's not quite it! Give it another try.");
            tryAgain = false;
        }
        else {
            String toShow = letter.toString() + " stands for " + phoneticValue.toLowerCase() + ". ";
            panel.updateDescriptionField("Good try. " + toShow + "Let's do another one.");
            getNewLetter();
        }
    }

    private void getNewLetter() {

        // End the game when all the letters have been guessed
        if (unusedLetters.isEmpty()) gameOver();

        else {
            // Grab a random letter from the remaining letters
            Random randomGenerator = new Random();
            int num = randomGenerator.nextInt(unusedLetters.size());
            letter = unusedLetters.get(num);

            unusedLetters.remove(letter);

            // Show the new letter to the user
            phoneticValue = letter.getPhonetic();
            panel.updateCurrentLetter(letter.toString());
            tryAgain = true;
        }
    }

    //TODO: temporary implementation (add restart button)
    private void gameOver() {
        panel.updateDescriptionField("That's the end of the game!");
    }

    public void startGame() {
        getNewLetter();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        processGuess();
    }
}
