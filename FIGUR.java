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

    FIGUR()
    {   
        //Weels
        wel1 = new KREIS(200, 300, 30, 9);
        wel2 = new KREIS(500, 300, 30, 9);
        wel3 = new KREIS(625, 300, 30, 9);
        
        //Body
        body = new KASTEN(125, 75, 450, 200, 7);
        bodyFront = new KASTEN(575, 125, 100, 150, 7);
        
        //Window
        window = new KASTEN(450, 110, 80, 75, 1);
        
        //Stripes
        Stripe1 = new KASTEN(125, 150, 550, 10, 4);
        Stripe2 = new KASTEN(125, 175, 550, 10, 4);
        Stripe3 = new KASTEN(125, 200, 550, 10, 4);
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