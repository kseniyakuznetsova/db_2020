package homework.riddle_game;

import design_patterns.template_method.AbstractGame;
import design_patterns.template_method.Game;
import design_patterns.template_method.Pair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class RiddleGame implements Game{

    //todo

    private final int maxLimit;
    private int number;
    private int score = 99;
    private int numOfAttempts = 0;
    private List<Integer> scoresList = new ArrayList<>();

    public RiddleGame(int max) {
        this.maxLimit = max;
    }

    @Override
    public void play() {
        createGame();
        while(true){
            String answer = JOptionPane.showInputDialog("Input your number (Attempt: " + numOfAttempts + ")");
            if (answer != null) {
                if(Integer.parseInt(answer) == number){
                    score++;
                    numOfAttempts++;
                    scoresList.add(score);
                    System.out.println("Number: " + answer + " Your score: " + score + ", num of attempt: " + numOfAttempts);
                    System.out.println("Best score: " + calcBestScore());
                    createGame();
                }else {
                    score--;
                    numOfAttempts++;
                    System.out.println("Number: " + answer + " Your score: " + score + ", num of attempt: " + numOfAttempts);
                }
            }else{
                System.out.println("GAME END");
                System.exit(0);
            }
        }
    }

    private void createGame(){
        System.out.println("*************** START NEW GAME ****************");
        generateNumber();
        numOfAttempts = 0;
        score = 99;
    }

    private int calcBestScore(){
        return Collections.max(scoresList);
    }

    private void generateNumber() {
        number = new Random().nextInt(maxLimit);
    }
}
