package main.view;

import main.controller.GameControl;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame {

    public GameControl g = new GameControl();

    private static int HEIGHT = 500;
    private static int WIDTH = 500;

    private JPanel content = new JPanel(new BorderLayout());

    private JPanel upperDescription = new JPanel();
    private JPanel guessAndSubmit = new JPanel();

    private JLabel gameTitle = new JLabel("<html><h1>LEARN THE PHONETIC ALPHABET</h1></html>");
    private JLabel gameDescription = new JLabel("This game will help you learn about the NATO phonetic alphabet.");
    private JLabel currentLetter = new JLabel();
    private JTextField userGuess = new JTextField("Enter your guess here");
    private JButton submitButton = new JButton("Submit");


    public GamePanel() {
        super("GamePanel");
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        content.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        upperDescription.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        upperDescription.setLayout(new BoxLayout(upperDescription, BoxLayout.Y_AXIS));

        guessAndSubmit.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        guessAndSubmit.setLayout(new BoxLayout(guessAndSubmit, BoxLayout.X_AXIS));

        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
        gameTitle.setOpaque(true);
        gameTitle.setBackground(new Color(0xFFC0CB));

        gameDescription.setHorizontalAlignment(SwingConstants.CENTER);

        currentLetter.setHorizontalAlignment(SwingConstants.CENTER);

        upperDescription.add(gameTitle);
        upperDescription.add(gameDescription);

        submitButton.addActionListener(g);
        g.panel = this;

        guessAndSubmit.add(userGuess, BorderLayout.SOUTH);
        guessAndSubmit.add(submitButton);

        content.add(upperDescription, BorderLayout.NORTH);
        content.add(currentLetter, BorderLayout.CENTER);
        content.add(guessAndSubmit, BorderLayout.SOUTH);

        setContentPane(content);

        content.setVisible(true);
        setVisible(true);

        g.startGame();
    }

    public void updateCurrentLetter(String myLetter) {
        currentLetter.setText("<html><h2 style='font-size:40px'>"+myLetter+"</h2></html>");
        userGuess.setText("Enter your guess here");
    }

    public void updateDescriptionField(String s) {
        gameDescription.setText(s);
    }

    public String getTextFromUserInputAsUpperCase() {
        return userGuess.getText().toUpperCase();
    }


    public static void main(String[] args) {
	    new GamePanel();
    }
}
