package wxrdle;

import javax.swing.JFrame;

public class Gui {
    
    public static void initGui(){
        
        JFrame window = new JFrame();
        
        int width = 400;
        int height = 800;
        
        window.setSize(width, height);
        
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        window.setVisible(true);
    }
    
}
