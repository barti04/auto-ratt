public class BAUM
{
    private KREIS baum1;
    private KREIS baum2;
    private KREIS baum3;
    private KASTEN trunk;
    private KREIS apple;
    
    public BAUM()
    {
        baum1 = new KREIS(650, 300, 100, 2);
        baum2 = new KREIS(730, 300, 100, 2);
        baum3 = new KREIS(690, 250, 100, 2);
        
        trunk = new KASTEN(650, 300, 75, 300, 9);
        
        apple = new KREIS(740, 350, 20, 4);
    }
    
    public void zeichne()
    {
        //Paint tree trunk
        trunk.fuelle();
        
        //paint leaves
        baum1.fuelle();
        baum2.fuelle();
        baum3.fuelle();
    }
    
    public void paintApple()
    {      
        //paint apple
        apple.fuelle();
    }
    
    public void verschieben(int x, int y)
    {
        leeren();
        apple.verschiebe(x, y);
        zeichne();
        paintApple();
    }
    
    public void dropApple()
    {
        
    }
    
    public void leeren()
    {
        WINDOW.gibFenster().loescheAlles();
    }
}
