package wxrdle;

import java.lang.Character;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

public class Wordle {

    private String word;
    private String guess;
    private boolean correct = false;
    private int guessCount;
    private String status = "";
    private List<Character> wrongLetters = new LinkedList<>();
    
    public Wordle() {
        this.guess = "     ";
        this.guessCount = 0;
    }
    
    public void play() {
        
        System.out.print("\nNEW GAME -- good luck!");
        System.out.print("\n\nright letter, right spot = *\nright letter, wrong spot = !\nwrong letter = x");
        
        Gui.initGui();
        
        WordBank wb = new WordBank();
        wb.initWordBank();
        word = wb.pickWord();
        
        while (guessCount < 6 && correct != true) {
            guess();
            check();
            print();
        }
    }
    
    private void guess() {
        
        String checkGuess = "";
        
        System.out.print("\n\n -- guess " + (guessCount + 1) + " : ");
        
        checkGuess = Driver.sc.next();
        
        while(checkGuess.length() != 5) {
            
            System.out.print("\n\n -- guess (must be 5 letter word) : ");
        
            checkGuess = Driver.sc.next();
        }
        
        this.guess = checkGuess.toUpperCase();
        this.guessCount++;
    }
    
    private void check() {
        
        status = "  ";
        
        for (int i = 0; i < 5; i++) {
            
            String currentChar = Character.toString(guess.charAt(i));
            
            if(guess.charAt(i) == word.charAt(i)) {
                status += "*"; 
            } else if (word.contains(currentChar)) {
                status += "!";
            } else {
                status += "x";
                wrongLetters.add(guess.charAt(i));
            }
            
            status += "      ";
        }
        
        if (word.equals(guess)) correct = true;
    }
    
    private void print() {
        
        System.out.print("\n ---    ---    ---    ---    ---");
        System.out.print("\n| " + guess.charAt(0) + " |  | " + guess.charAt(1) + " |  | " + guess.charAt(2) + " |  | " + guess.charAt(3) + " |  | " + guess.charAt(4) + " |");
        System.out.print("\n ---    ---    ---    ---    ---");
        System.out.print("\n" + status);
        System.out.print("\n\nwrong letters : " + wrongLetters.toString());
        
        if (correct == true) System.out.print("\n\ncorrect in " + guessCount + " tries !");
        if (guessCount == 6) System.out.print("\n\ngame over");
    }
}
