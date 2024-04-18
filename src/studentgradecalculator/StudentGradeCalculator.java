
package studentgradecalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StudentGradeCalculator extends JFrame implements ActionListener{
    
    JButton submit;
    
    JTextField  emTF , dsaTF , seTF , mpTF , pplTF;
    
    StudentGradeCalculator(){
        
        setLayout(null);
        
        JLabel text = new JLabel("Marks Obtained");
        text.setBounds(50 , 20 , 300 , 40);
        text.setFont(new Font("Raleway" , Font.BOLD , 40));
        add(text);
        
        JLabel em = new JLabel("<html>Engineering<br>Mathematics</html>");
        em.setBounds(40 , 80 , 150 , 50);
        em.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(em);
        
        emTF = new JTextField();
        emTF.setBounds(250 , 90 , 90 , 30);
        emTF.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(emTF);        
        
        JLabel dsa = new JLabel("<html>Data Structures<br>and Algorithm</html>");
        dsa.setBounds(40 , 140 , 150 , 50);
        dsa.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(dsa);
        
        dsaTF = new JTextField();
        dsaTF.setBounds(250 , 150 , 90 , 30);
        dsaTF.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(dsaTF); 

        JLabel se = new JLabel("<html>Software<br>Engineering</html>");
        se.setBounds(40 , 200 , 150 , 50);
        se.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(se);
        
        seTF = new JTextField();
        seTF.setBounds(250 , 210 , 90 , 30);
        seTF.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(seTF); 
        
        JLabel mp = new JLabel("<html>Microprocessor</html>");
        mp.setBounds(40 , 260 , 150 , 50);
        mp.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(mp);
        
        mpTF = new JTextField();
        mpTF.setBounds(250 , 270 , 90 , 30);
        mpTF.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(mpTF); 
        
        JLabel ppl = new JLabel("<html>Principle of Programming<br>Languages</html>");
        ppl.setBounds(40 , 320 , 150 , 60);
        ppl.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(ppl);
        
        pplTF = new JTextField();
        pplTF.setBounds(250 , 330 , 90 , 30);
        pplTF.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(pplTF);         

        submit = new JButton("SUBMIT");
        submit.addActionListener(this);
        submit.setBounds(150 , 400 , 100 , 30);
        add(submit);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(400 , 500);
        setLocation(500 , 150);
        setVisible(true);
        
    }
    
    public void actionPerformed (ActionEvent ae){
        


        
    
        
        if(ae.getSource() == submit){
            // Check if the value is within bounds
                try {
                    
                    int em  = Integer.parseInt(emTF.getText());
                    int dsa = Integer.parseInt(dsaTF.getText());
                    int se = Integer.parseInt(seTF.getText());
                    int mp = Integer.parseInt(mpTF.getText());
                    int ppl = Integer.parseInt(pplTF.getText());

                    
                    int arr[] = {em , dsa , se , mp , ppl};
                    for(int i = 0 ; i < 5 ; i++){
                        
                        int value = arr[i];

                        if (value < 0 || value > 100) {
                            JOptionPane.showMessageDialog(null, "Please enter a value between 0 and 100.");
                            return;
                        }
                    }
                    
                    int total = ( em + dsa + se + mp + ppl );
                    double average = (total/5);
                    String grade = calculateGrade(average);

                    setVisible(false);
                    new Resultframe(total , average , grade , emTF.getText() , dsaTF.getText() , seTF.getText() , mpTF.getText() , pplTF.getText()).setVisible(true);
            
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer value.");
                }
           
        }    
    }

    private String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }    
    
    public static void main(String[] args) {
        new StudentGradeCalculator();
    }

    
}
