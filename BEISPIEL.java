import java.util.Random;    //für Zufall
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BEISPIEL
{
    public JButton knopf;
    public Timer uhr;    
    Random z;               //für Zufall    
    
    //eigene Definitionen, z.B.
    FIGUR a;
    
    BEISPIEL()
    {   z = new Random();   //für Zufall: z.nextInt(10)
       
        //Uhr                    
        uhr = new Timer(25, new ActionListener(){
        public void actionPerformed(ActionEvent e){ticke();}});

        //Start-Knopf
        knopf = new JButton("Start");
        knopf.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e){starte();}});
        WINDOW.gibFenster().komponenteHinzufuegen(knopf,"unten");
        
        //Stopp-Knopf
        knopf = new JButton("Stopp");
        knopf.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e){stoppe();}});
        WINDOW.gibFenster().komponenteHinzufuegen(knopf,"unten");

        //eigene Initialisierungen
        a = new FIGUR(); 
    }

    public void leeren(){WINDOW.gibFenster().loescheAlles();}

    public void starte(){uhr.start();WINDOW.gibFenster().frame.requestFocusInWindow();}
    
    public void stoppe(){uhr.stop();}    
    
    public void ticke()
    {   if(WINDOW.gibFenster().Kl==1){leeren();}
        if(WINDOW.gibFenster().Kn==1){zeichneAlles();}
        if(WINDOW.gibFenster().Ka==1){methode1();}
        if(WINDOW.gibFenster().Kb==1){methode1();}
    }          
        
    public void zeichneAlles()
    {   a.zeichne();a.text();}
            
    public void methode1()
    {   a.zeichne();   }   
    
    public void methode2()
    {   a.text();   }
}