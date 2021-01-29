public class DREIECK
{
    private int oben1, oben2;
    private int links1, links2;
    private int rechts1, rechts2;
    private int farbe;   

    public DREIECK(int oben1Neu, int oben2Neu, int links1Neu, int links2Neu, int rechts1Neu, int rechts2Neu, int farbeNeu)
    {   oben1 = oben1Neu;
        oben2 = oben2Neu;
        links1 = links1Neu;
        links2 = links2Neu;
        rechts1 = rechts1Neu;
        rechts2 = rechts2Neu;
        farbe = farbeNeu;    }

    public void fuelle(int farbeNeu)
    {   WINDOW.gibFenster().fuelleDreieck(oben1,oben2,links1,links2, rechts1, rechts2, farbeNeu);    }
        
    public void fuelle()
    {   WINDOW.gibFenster().fuelleDreieck(oben1,oben2,links1,links2, rechts1, rechts2, farbe);    }
    
    public void zeichne()
    {   WINDOW.gibFenster().fuelleDreieck(oben1,oben2,links1,links2, rechts1, rechts2, farbe);    }
    
    public void verschiebe(int nachRechts, int nachUnten)
    {   oben1 = oben1 + nachRechts;
        oben2 = oben2 + nachUnten;
    
        links1 = links1 + nachRechts;
        links2 = links2 + nachUnten;
        
        rechts1 = rechts1 + nachRechts;
        rechts2 = rechts2 + nachUnten;
    }
   
    
}