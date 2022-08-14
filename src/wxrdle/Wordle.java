package wxrdle;

public class Wordle {

    private String guess;
    private int guessCount;
    private String status;
    private char[] wrongLetters;
    
    public Wordle() {
        this.guess = "     ";
        this.guessCount = 0;
    }
    
    public void play() {
        
        System.out.print("\nNEW GAME -- good luck!");
        
        while (guessCount < 6) {
            guess();
            print();
        }
    }
    
    private void guess() {
        
        String checkGuess = "";
        
        System.out.print("\n\n -- guess : ");
        
        checkGuess = Driver.sc.next();
        
        while(checkGuess.length() != 5) {
            
            System.out.print("\n\n -- guess (must be 5 letter word) : ");
        
            checkGuess = Driver.sc.next();
        }
        
        this.guess = checkGuess;
        this.guess = this.guess.toUpperCase();
        this.guessCount++;
    }
    
    private void check() {
        
    }
    
    private void print() {
        
        System.out.print("\n ---    ---    ---    ---    ---");
        System.out.print("\n| " + guess.charAt(0) + " |  | " + guess.charAt(1) + " |  | " + guess.charAt(2) + " |  | " + guess.charAt(3) + " |  | " + guess.charAt(4) + " |");
        System.out.print("\n ---    ---    ---    ---    ---");
    }
}
