import javax.swing.*;  
import java.awt.event.*; 

public class week3 {  
    JFrame f;  
    week3(){  
        f=new JFrame();  
        String name=JOptionPane.showInputDialog(f,"Enter Name"); 
    }  
    public static void main(String[] args) {  
        new week3();  
    }  
}  

