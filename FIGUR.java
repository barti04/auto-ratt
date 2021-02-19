public class FIGUR
{

    // 0"schwarz"  1"blau"  2"gruen"  3"cyan"   4"rot"   
    // 5"magenta"  6"gelb"  7"grau"   8"weiss"  9"schwarz"

    private KREIS wel1;
    private KREIS wel2;
    private KREIS wel3;
    private KASTEN body;
    private KASTEN bodyFront;
    private KASTEN window;
    private KASTEN Stripe1;
    private KASTEN Stripe2;
    private KASTEN Stripe3;
    private BAUM tree;

    FIGUR()
    {   
        //Weels
        wel1 = new KREIS(200, 500, 30, 9);
        wel2 = new KREIS(500, 500, 30, 9);
        wel3 = new KREIS(625, 500, 30, 9);
        
        //Body
        body = new KASTEN(125, 275, 450, 200, 7);
        bodyFront = new KASTEN(575, 325, 100, 150, 7);
        
        //Window
        window = new KASTEN(450, 310, 80, 75, 1);
        
        //Stripes
        Stripe1 = new KASTEN(125, 350, 550, 10, 4);
        Stripe2 = new KASTEN(125, 375, 550, 10, 4);
        Stripe3 = new KASTEN(125, 400, 550, 10, 4);
        
        //tree
        tree = new BAUM();
    }

    public void zeichne()
    {   
        //Paint weels
        wel1.fuelle();
        wel2.fuelle();
        wel3.fuelle();
        
        //Paint body
        body.fuelle();
        bodyFront.fuelle();
        
        //Paint strips
        Stripe1.fuelle();
        Stripe2.fuelle();
        Stripe3.fuelle();
        
        //Paint window
        window.fuelle();
        
        //Paint tree
        tree.zeichne();
        tree.paintApple();
    }
    
    public void leeren()
    {
        WINDOW.gibFenster().loescheAlles();
    }
    
    public void verschieben(int x, int y)
    {
        
        
        //move weels
        wel1.verschiebe(x, y);
        wel2.verschiebe(x, y);
        wel3.verschiebe(x, y);
        
        //move body
        body.verschiebe(x, y);
        bodyFront.verschiebe(x, y);
        
        //move strips
        Stripe1.verschiebe(x, y);
        Stripe2.verschiebe(x, y);
        Stripe3.verschiebe(x, y);
        
        //move window
        window.verschiebe(x, y);
        leeren();
        zeichne();
    }
    
    public void verschieben()
    {   
        verschieben(-600, 0);
        for (int i=0; i<58; i++)
        {

           verschieben(10, 0);
        }
        for (int i=0; i<25; i++)
        {
           tree.verschieben(0, i);
           zeichne();
        }   
    }
    
    public void verschiebenBisRand()
    {
        int ext;
        
         for (int i=0; i<200; i++)
        {

           ext = bodyFront.gibExt();

           if (ext>1000){verschieben(-1000, 0);}

           verschieben(10, 0);
        }          
    }
    
    public void text()
    {String t="(400|100)";
        WINDOW.gibFenster().zeichneText(t,400,100);
        t="(300|150)";
        WINDOW.gibFenster().zeichneText(t,240,150); 
        t="(500|150)";
        WINDOW.gibFenster().zeichneText(t,500,150);
    }
}