public class KASTEN
{
    private int links,oben,breite,hoehe;
    private int farbe;                          // Farben von 1 bis 8
    
    public KASTEN()
    {   links = 50;
        oben = 100;
        breite = 200;
        hoehe = 40;    
        farbe = 5;}

    public KASTEN(int linksNeu, int obenNeu, int breiteNeu, int hoeheNeu, int farbeNeu)
    {   links = linksNeu;
        oben = obenNeu;
        breite = breiteNeu;
        hoehe = hoeheNeu;    
        farbe = farbeNeu;}

    public void zeichne()
    {   WINDOW.gibFenster().zeichneRechteck(links,oben,breite,hoehe);    }
    
    public void fuelle()
    {   WINDOW.gibFenster().fuelleRechteck(links,oben,breite,hoehe,farbe);    }
    
    public void setzeLinks(int linksNeu)
    {   links = linksNeu;    }
    
    public void setzeRechts(int rechtsNeu)
    {   links = rechtsNeu-breite;    }
    
    public void setzeGroesse(int breiteNeu, int hoeheNeu)
    {   breite = breiteNeu;
        hoehe = hoeheNeu;    }
    
    public void verschiebe(int nachRechts, int nachUnten)
    {   links = links + nachRechts;
        oben = oben + nachUnten;    } 
            
    public void setzeFarbe(int farbeNeu)
    {   farbe = farbeNeu;    }
    
    public int gibUmfang()
    {   return 2*(breite+hoehe);    }
    
    public int gibFlaeche()
    {   return breite*hoehe;    }
    
    public int gibFarbnr()
    {   return farbe;}
    
    public void warte(int ms)
    {   WINDOW.gibFenster().wait(ms);}
}
