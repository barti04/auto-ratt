import java.util.Random;    //für Zufall
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ÖFFNEN
{
    public JButton knopf;
    public Timer uhr;    
    Random z;               //für Zufall    
    String t;
    
    //eigene Definitionen, z.B.
    FIGUR a;
    
    ÖFFNEN()
    {   anfang();       
        
        z = new Random();   //für Zufall: z.nextInt(10)
       
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
        if(WINDOW.gibFenster().Kb==1){methode2();}
        if(WINDOW.gibFenster().Kc==1){methode3();}
        if(WINDOW.gibFenster().Kd==1){methode4();}
        if(WINDOW.gibFenster().Ke==1){leeren();anfang();}
    }          
        
    public void zeichneAlles()
    {   leeren(); a.zeichne();a.text();}
    
    public void anfang()
    {   WINDOW.gibFenster().schriften_bold(28);       
        t="Dies ist ein neues Zeichenfenster!";
        WINDOW.gibFenster().zeichneText(t,20,50);
        
        WINDOW.gibFenster().schriften_plain(20);
               
        t="Es hat einen Timer, der mit Start gestartet bzw. mit Stopp wieder ausschaltet werden kann.";
        WINDOW.gibFenster().zeichneText(t,20,100);
        t="Der Timer ist später für Aktivitäten gut. ";
        WINDOW.gibFenster().zeichneText(t,20,120);
        t="Es gibt zudem, wenn der Start-Knopf aktiviert wurde, einen Keylistener, der erlaubt, Methoden";
        WINDOW.gibFenster().zeichneText(t,20,170);   
        t="mit einzelnen Tasten zu verknüpfen!";
        WINDOW.gibFenster().zeichneText(t,20,190);   
        t="Aktiviere nun unten den Start-Button und drücke dann die Taste A";
        WINDOW.gibFenster().zeichneText(t,20,300); }
        
    public void methode1()
    {   leeren();
        t="Öffne nun die Klasse BEISPIEL so, dass du daneben dieses Zeichenfenster noch sehen kannst";
        WINDOW.gibFenster().zeichneText(t,20,50);
        
        t="";
        WINDOW.gibFenster().zeichneText(t,20,90);        
        t="Im Programmiercode werden oben zuerst die Bibliotheken importiert:";
        WINDOW.gibFenster().zeichneText(t,20,120);
        t="für Zufallszahlen:";
        WINDOW.gibFenster().zeichneText(t,20,150);
        t="   import java.util.Random;";
        WINDOW.gibFenster().zeichneText(t,20,170);
        t="für die Buttons, Timer und Keylistener: ";
        WINDOW.gibFenster().zeichneText(t,20,200);
        t="   import java.awt.*; import javax.swing.*; import java.awt.event.*;";
        WINDOW.gibFenster().zeichneText(t,20,220);
        t="Drücke nun: B";
        WINDOW.gibFenster().zeichneText(t,20,300);}
    
    public void methode2()
    {   leeren();
        t="Die beiden Knöpfe wurden als JButton definiert und im Konstruktor dann initialisiert:";
        WINDOW.gibFenster().zeichneText(t,20,50);
        t="//Start-Knopf";
        WINDOW.gibFenster().zeichneText(t,20,90);
                
        t="knopf = new JButton('Start');";
        WINDOW.gibFenster().zeichneText(t,20,110);
        t="knopf.addActionListener(new ActionListener()";
        WINDOW.gibFenster().zeichneText(t,20,130);
        t="{public void actionPerformed(ActionEvent e){starte();}});";
        WINDOW.gibFenster().zeichneText(t,20,150);
        t="WINDOW.gibFenster().komponenteHinzufuegen(knopf,'unten');";
        WINDOW.gibFenster().zeichneText(t,20,170);
        t="Du kannst also jederzeit noch Knöpfe hinzufügen, indem du einfach diese fünf Zeilen im Konstruktor kopierst, ";
        WINDOW.gibFenster().zeichneText(t,20,210);
        t="und mit einer neuen Methode (hier steht noch starte();) einfügst.";
        WINDOW.gibFenster().zeichneText(t,20,230);
        t="Drücke nun: C";
        WINDOW.gibFenster().zeichneText(t,20,300);
    }
     
    public void methode3()
    {   leeren();
        t="Damit Bewegung hier im Zeichenfenster funktioniert, gibt es nun einen Timer 'uhr':";
        WINDOW.gibFenster().zeichneText(t,20,50);
        
        t="//Uhr ";
        WINDOW.gibFenster().zeichneText(t,20,90);
        
        t="uhr = new Timer(25, new ActionListener(){";
        WINDOW.gibFenster().zeichneText(t,20,110);
        t="public void actionPerformed(ActionEvent e){ticke();}});";
        WINDOW.gibFenster().zeichneText(t,20,130);
        
        t="Sobald mit Start der Timer gestartet wird, wird quasi im Sekundentakt die Methode ticke() ausgeführt.";
        WINDOW.gibFenster().zeichneText(t,20,170);
        t="Damit kann man Bewegung einbauen!!";
        WINDOW.gibFenster().zeichneText(t,20,190);

        t="Drücke nun: D";
        WINDOW.gibFenster().zeichneText(t,20,300);
    }
    
    public void methode4()
    {   leeren();
        t="Noch ein Schmankerl: Keylistener";
        WINDOW.gibFenster().zeichneText(t,20,50);
        t="Nun kann man für viele Tasten Methoden festlegen.";
        WINDOW.gibFenster().zeichneText(t,20,90);
        t="In der Methode 'ticke()' muss sie mit:";
        WINDOW.gibFenster().zeichneText(t,20,120);
        t="   if(WINDOW.gibFenster().Kxxx==1){methode4();} ";
        WINDOW.gibFenster().zeichneText(t,20,150);
        t="beschrieben werden. Für xxx muss entsprechend die Taste gesetzt werden";
        WINDOW.gibFenster().zeichneText(t,20,180);
        t="z.B. Ka für die Taste A. Und natürlich muss die richtige Methode verknüpft werden!";
        WINDOW.gibFenster().zeichneText(t,20,200);
        
        t="Folgende Tasten sind möglich:";
        WINDOW.gibFenster().zeichneText(t,20,240);
        t="a bis z";
        WINDOW.gibFenster().zeichneText(t,20,260);
        t="up, down, left, right, enter, space, escape, back_space";
        WINDOW.gibFenster().zeichneText(t,20,280);
    }
    
    public void methode5()
    {   leeren();}

}