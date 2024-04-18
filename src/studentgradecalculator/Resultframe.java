
package studentgradecalculator;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;




public class Resultframe extends JFrame implements ActionListener {
    
    JLabel emT , avgT , gradeT;
    
    JButton print , exit;
    
    int total;
            
    double average; 
            
    String grade , emTF , dsaTF , seTF , mpTF , pplTF;
    
    Resultframe(int total , double average , String grade ,String emTF ,String dsaTF ,String  seTF ,String  mpTF ,String  pplTF){
        
        this.total = total;
        this.average = average;
        this.grade = grade;
        this.emTF = emTF;
        this.dsaTF = dsaTF;
        this.seTF = seTF;
        this.mpTF = mpTF;
        this.pplTF = pplTF;
        
        
        setLayout(null);        
        
        JLabel text = new JLabel("Results");
        text.setBounds(110 , 20 , 300 , 40);
        text.setFont(new Font("Raleway" , Font.BOLD , 40));
        add(text);
        
        JLabel em = new JLabel("<html>Total Marks");
        em.setBounds(60 , 110 , 150 , 50);
        em.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(em);
        
        emT = new JLabel(String.valueOf(total) + " / 500");
        emT.setBounds(250 ,120 , 90 , 30);
        emT.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(emT); 
        
        JLabel avg = new JLabel("<html>Average Marks");
        avg.setBounds(60 , 180 , 150 , 50);
        avg.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(avg);
        
        avgT = new JLabel(String.valueOf(average));
        avgT.setBounds(250 , 190 , 90 , 30);
        avgT.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(avgT);         
        
        JLabel gradetext = new JLabel("<html>Grade");
        gradetext.setBounds(60 , 250 , 150 , 50);
        gradetext.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(gradetext);
        
        gradeT = new JLabel(grade);
        gradeT.setBounds(250 , 260 , 90 , 30);
        gradeT.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(gradeT);         
        
        print = new JButton("Print");
        print.addActionListener(this);
        print.setBounds(65 , 350 , 100 , 30);
        add(print);
        
        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(220 , 350 , 100 , 30);
        add(exit);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(400 , 500);
        setLocation(500 , 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== print){
            generatePDF();
        }else{
            System.exit(0);
        }
    }
    
    private void generatePDF(){

          try{
              
              String filename = "E:\\testing\\test.pdf";
              Document document = new Document();
              
              PdfWriter.getInstance(document , new FileOutputStream(filename));
              
              document.open();

              Paragraph para = new Paragraph();  
              para.add("\tMarksheet: ");
              para.add("\n");
              document.add(para);
              
              PdfPTable table = new PdfPTable(2);
              PdfPCell c1 = new PdfPCell(new Phrase("Subjects"));
              table.addCell(c1);
              
              c1 = new PdfPCell(new Phrase("Marks Obtained"));
              table.addCell(c1);
              
              table.setHeaderRows(1);
              
              table.addCell("Engineering Mathematics");
              table.addCell(emTF);
              table.addCell("Data Structures and Algorithm");
              table.addCell(dsaTF);
              table.addCell("Software Engineering");
              table.addCell(seTF);
              table.addCell("Microprocessor");
              table.addCell(mpTF);
              table.addCell("Principle of Programming Languages");
              table.addCell(pplTF);
              
              document.add(table);

              Paragraph para2 = new Paragraph();
              para2.add("Result: \n");
              document.add(para2);
              
              PdfPTable table2 = new PdfPTable(2);
              PdfPCell c2 = new PdfPCell(new Phrase(""));
              table2.addCell(c2);
              
              c2 = new PdfPCell(new Phrase(""));
              table2.addCell(c2);
              
              table2.setHeaderRows(1);              
              
              table2.addCell("Total Marks");
              table2.addCell(String.valueOf(total));
              table2.addCell("Average Percentage");
              table2.addCell(String.valueOf(average));
              table2.addCell("Grade");
              table2.addCell(grade);
              
              
              document.add(table2);
              
              document.close();
              
              System.out.println("Finished");
              
            
              
              
              
          }catch(Exception e){
              System.out.println(e);
          }
    
    
    
    }
    
    public static void main(String[] args){
        new Resultframe(0 , 0 , "" , "" , "" , "" , "" , "");
    }
    
}
