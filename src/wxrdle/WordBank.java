package wxrdle;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;

public class WordBank {

    private List<String> bank = new LinkedList<>();
    
    public void initWordBank() {
        
        try {
            Scanner w = new Scanner(new File("wordbank"));
            
            while(w.hasNextLine()) {
                bank.add(w.nextLine());
            }
            
        } catch (IOException ioe) {
            
            System.out.print("file not found");
            ioe.printStackTrace();
        }   
    } 
    
    public String pickWord() {
        
        int index = (int) (Math.random() * bank.size());
        
        return bank.get(index);
    }
}
