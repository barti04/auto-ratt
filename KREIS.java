public class KREIS
{
    // 0"schwarz"  1"blau"  2"gruen"  3"cyan"   4"rot"   
    // 5"magenta"  6"gelb"  7"grau"   8"weiss"  9"schwarz"

    private int xMitte, yMitte, radius, farbe;

    public KREIS()
    {   xMitte = 100;
        yMitte = 100;
        radius = 10;
        farbe = 5;    }
    
    public KREIS(int xNeu, int yNeu, int radiusNeu, int farbeNeu)
    {   xMitte = xNeu;
        yMitte = yNeu;
        radius = radiusNeu;
        farbe = farbeNeu;    }

    public void setzeMitte(int xNeu, int yNeu)
    {   xMitte = xNeu;
        yMitte = yNeu;    }
        
    public void fuelle()
    {   WINDOW.gibFenster().fuelleKreis(xMitte,yMitte,radius,farbe);    }   

    public void fuelle(int farbeNeu)
    {   WINDOW.gibFenster().fuelleKreis(xMitte,yMitte,radius,farbeNeu);    }   

    public void setzeFarbe(int farbeNeu)
    {   farbe = farbeNeu;    }
    
    public void verschiebe(int nachRechts, int nachUnten)
    {   xMitte = xMitte + nachRechts;
        yMitte = yMitte + nachUnten;    }
        
    public double gibUmfang()
    {   return 2*Math.PI*radius;}
    
    public double gibFlaeche()
    {   return Math.PI*radius*radius;}
    
    public void warte(int ms)
    {   WINDOW.gibFenster().wait(ms);}

}
