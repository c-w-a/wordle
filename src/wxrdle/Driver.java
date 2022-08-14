package wxrdle;

import java.util.Scanner;

public class Driver {

    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {

        Wordle w = new Wordle();
        
        w.play();
    }
}
