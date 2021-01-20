import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

import java.awt.event.*;
import java.awt.Component;

/**
 * Class WINDOW - Eine Klasse, die einfache grafische Zeichnungen 
 * in einem Programmfenster erm�glicht.
 * 
 * @author Michael Kolling (mik)
 * @author Bruce Quig
 * @author Christian Heidrich
 * @author Birgit Rattenhuber
 * @author Vincent Flecke
 * @author Christian Kluge
 * @author Paul Schindler
 *
 * @version 2007.05.07 Modified 2014.05.09/2020.12.12
 */

public class WINDOW extends JFrame implements KeyListener
{
    public JFrame frame;
    public CanvasPane canvas;
    private JPanel steuerungOst,steuerungSued;
    public Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    public Font stringFont;
    
    public static WINDOW singleton;
    
    public int Kup, Kdown, Kleft, Kright,Ka,Kw,Ks,Kd,Kb,Kq,Ke,Kr,Kt,Kz,Ku,Ki,Ko,Kp,Kf,Kg,Kh,Kj,Kk,Kl,Ky,Kx,Kc,Kv,Kn,Km;;
    public int Kenter, Kspace, Kescape, Kback_space;
    public int K1;
    
    public WINDOW(){
        this("WINDOW", 1000, 800, Color.white);}
    
    public WINDOW(String titel)
    {   this(titel, 1000, 800, Color.white);    }

    public WINDOW(String titel, int breite, int hoehe)
    {   this(titel, breite, hoehe, Color.white);}
    
    private WINDOW(String titel, int breite, int hoehe, Color hintergrundFarbe)
    {   frame = new JFrame();
        canvas = new CanvasPane();
        canvas.setPreferredSize(new Dimension(breite, hoehe));
        frame.getContentPane().add(canvas,BorderLayout.CENTER);
        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());
        steuerungOst = new JPanel();
        steuerungSued = new JPanel();
        steuerungOst.setLayout(new BoxLayout(steuerungOst,BoxLayout.Y_AXIS));
        steuerungSued.setLayout(new BoxLayout(steuerungSued,BoxLayout.X_AXIS));
        p1.add(steuerungOst,BorderLayout.NORTH);
        frame.getContentPane().add(p1,BorderLayout.EAST);
        frame.getContentPane().add(steuerungSued,BorderLayout.SOUTH);
        frame.setTitle(titel);
        backgroundColor = hintergrundFarbe;
        frame.pack();
        zeige();
        
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.addKeyListener(this);
    
        stringFont = new Font( "SansSerif", Font.BOLD, 16 );}

    public static WINDOW gibFenster()
    {   if (singleton==null){singleton=new WINDOW("Das WINDOW");}
        singleton.zeige();
        return singleton;}

    public void schriften_plain(int schriftgroesse)
    {   stringFont = new Font( "SansSerif", Font.PLAIN, schriftgroesse ); 
        graphic.setFont( stringFont );}
        
    public void schriften_bold(int schriftgroesse)
    {   stringFont = new Font( "SansSerif", Font.BOLD, schriftgroesse ); 
        graphic.setFont( stringFont );}
        
    public void schriften(int schriftgroesse, String schriftart)
    {   stringFont = new Font(schriftart, Font.PLAIN, schriftgroesse ); 
        graphic.setFont( stringFont );}
    //0 plain   1 bold   2 italic
        public void zeige()
    {   if(graphic == null) {
            // nur beim ersten Aufruf wird der Hintergrund mit der Hintergrundfarbe 
            // gefuellt
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(true);}

    public boolean istSichtbar()
    {   return frame.isVisible();}

    public void zeichneBogen(int x, int y, int halbachseX, int halbachseY, int startWinkel, int winkel)
    {   graphic.drawArc(x-halbachseX,y-halbachseY,2*halbachseX,2*halbachseY,startWinkel,winkel);
        canvas.repaint();}

    public void zeichneKreis(int x, int y, int radius)
    {   graphic.drawOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();}

    /**
     * "weiss" "schwarz" "rot"
     * "gruen" "blau" "gelb" "magenta" "cyan" "grau"
     */
    public void fuelleKreis(int x, int y, int radius, String farbe)
    {   Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
        graphic.setColor(original);}
    
    /**
     * F�llfarbnummer f�r den Kreis (0 bis 8)
     */
    public void fuelleKreis(int x, int y, int radius, int farbnr)
    {   Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillOval(x-radius,y-radius,2*radius,2*radius);
        canvas.repaint();
        graphic.setColor(original);}
    
    public void loescheKreis(int x, int y, int radius)
    {   Ellipse2D.Double circle = new Ellipse2D.Double(x-radius, y-radius, 2*radius, 2*radius);
        loesche(circle);}

    public void zeichne(Shape shape)
    {   graphic.draw(shape);
        canvas.repaint();}

    public void fuelle(Shape shape, String farbe)
    {   Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fill(shape);
        canvas.repaint();
        graphic.setColor(original);}

    public void fuelle(Shape shape, int farbnr)
    {   Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fill(shape);
        canvas.repaint();
        graphic.setColor(original);}

    public void loesche(Shape shape)
    {   Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);              // erase by filling background color
        graphic.setColor(original);
        canvas.repaint();}

    public void zeichneRechteck(int xPos, int yPos, int breite, int hoehe)
    {   graphic.drawRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
       // fill(new Rectangle(xPos, yPos, breite, hoehe));
    }

    public void fuelleRechteck(int xPos, int yPos, int breite, int hoehe, String farbe)
    {   Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
        graphic.setColor(original);}

    public void fuelleRechteck(int xPos, int yPos, int breite, int hoehe, int farbnr)
    {   Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillRect(xPos, yPos, breite, hoehe);
        canvas.repaint();
        graphic.setColor(original);}

    public void loescheRechteck(int xPos, int yPos, int breite, int hoehe)
    {   loesche(new Rectangle(xPos, yPos, breite, hoehe));}
    
    private Polygon gibDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {   Polygon p=new Polygon();
        p.addPoint(x1,y1);
        p.addPoint(x2,y2);
        p.addPoint(x3,y3);
        return p;}

    public void zeichneDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {   graphic.drawPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();}

    public void fuelleDreieck(int x1, int y1, int x2, int y2, int x3, int y3, String farbe)
    {   Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbe));
        graphic.fillPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
        graphic.setColor(original);}

    public void fuelleDreieck(int x1, int y1, int x2, int y2, int x3, int y3, int farbnr)
    {   Color original=graphic.getColor();
        graphic.setColor(farbeZuColor(farbnr));
        graphic.fillPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
        canvas.repaint();
        graphic.setColor(original);}

    public void loescheDreieck(int x1, int y1, int x2, int y2, int x3, int y3)
    {   loesche(gibDreieck(x1, y1, x2, y2, x3, y3));}

    public void loescheAlles()
    {   Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();}

    public void loescheRand(Shape shape)
    {   Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // Löschen durch übermalen mit Hintergrundfarbe
        graphic.setColor(original);
        canvas.repaint();}

    public boolean zeichneBild(Image bild, int x, int y)
    {   boolean result = graphic.drawImage(bild, x, y, null);
        canvas.repaint();
        return result;}

    public void zeichneText(String text, int x, int y)
    {   graphic.drawString(text, x, y);   
        canvas.repaint();}

    public void loescheText(String text, int x, int y)
    {   Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
        canvas.repaint();}

    public void zeichneStrecke(int x1, int y1, int x2, int y2)
    {   graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();}

    public void setzeVordergrundFarbe(String neueFarbe)
    {   graphic.setColor(farbeZuColor(neueFarbe));}
    
    private void setzeVordergrundFarbe(Color neueFarbe)
    {   graphic.setColor(neueFarbe);}
    
    public Color farbeZuColor(int farbnr)
    {   switch (farbnr)
        {   case 0: return Color.black;
            case 1: return Color.blue;
            case 2: return Color.green;
            case 3: return Color.cyan;
            case 4: return Color.red;
            case 5: return Color.magenta;
            case 6: return Color.yellow;
            case 7: return Color.gray;
            case 8: return Color.white;
            default: return graphic.getColor();}}
    
    private Color farbeZuColor(String farbe)
    {   if (farbe=="weiss") return Color.white;
        if (farbe=="schwarz") return Color.black;
        if (farbe=="rot") return Color.red;
        if (farbe=="gruen") return Color.green;
        if (farbe=="blau") return Color.blue;
        if (farbe=="gelb") return Color.yellow;
        if (farbe=="magenta") return Color.magenta;
        if (farbe=="cyan") return Color.cyan;
        if (farbe=="grau") return Color.gray;
        return graphic.getColor();}
    
    private String colorZuFarbe(Color color)
    {   if (color==Color.white) return "weiss";
        if (color==Color.black) return "schwarz";
        if (color==Color.red) return "rot";
        if (color==Color.green) return "gruen";
        if (color==Color.blue) return "blau";
        if (color==Color.yellow) return "gelb";
        if (color==Color.magenta) return "magenta";
        if (color==Color.cyan) return "cyan";
        if (color==Color.gray) return "gruen";
        return "";}

    public String gibVordergrundFarbe()
    {
        return colorZuFarbe(graphic.getColor());
    }
    //public Color gibVordergrundFarbe()
    //{
    //    return graphic.getColor();
    //}

    /**
     * Setzt die Hintergrundfarbe des WINDOWs.
     * @param  neueFarbe   neue Hintergrundfarbe 
     */
    public void setzeHintergrundFarbe(String neueFarbe)
    {
        backgroundColor = farbeZuColor(neueFarbe);   
        graphic.setBackground(backgroundColor);
    }
    private void setzeHintergrundFarbe(Color neueFarbe)
    {
        backgroundColor = neueFarbe;   
        graphic.setBackground(neueFarbe);
    }

    /**
     * Gibt die aktuelle Hintergrundfarbe des WINDOWs zurück.
     * @return   die aktuelle Hintergrundfarbe 
     */
    public String gibHintergrundFarbe()
    {
        return colorZuFarbe(backgroundColor);
    }
    //public Color gibHintergrundFarbe()
    //{
    //    return backgroundColor;
    //}

    /**
     * Ändert den aktuellen Zeichensatz des WINDOWs.
     * @param  neuerZeichensatz   Zeichensatz, der künftig für Zeichenkettenausgaben verwendet wird
     */
    public void setzeZeichensatz(Font neuerZeichensatz)
    {
        graphic.setFont(neuerZeichensatz);
    }

    /**
     * Gibt den aktuellen Zeichensatz des WINDOWs zurück.
     * @return     den aktuellen Zeichensatz
     **/
    public Font gibZeichensatz()
    {
        return graphic.getFont();
    }

    /**
     * Ändert die Abmessungen des WINDOWs.
     * @param  breite    neue Breite 
     * @param  hoehe     neue Höhe 
     */
    public void setzeMasse(int breite, int hoehe)
    {
        canvas.setPreferredSize(new Dimension(breite, hoehe));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(breite, hoehe);
        graphic = (Graphics2D)canvasImage.getGraphics();
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    /**
     * Gibt die Abmessungen des WINDOWs zurück.
     * @return     die aktuellen Abmessungen des WINDOWs
     */
    public Dimension gibMasse()
    {
        return canvas.getSize();
    }

    /**
     * Wartet eine bestimmte Zeit.
     * Eine kurze Verzögerung kann z. B. für Animationen verwendet werden.
     * @param  zeit  Wartezeit in Millisekunden 
     */
    public void warte(int zeit)
    {
        try
        {
            Thread.sleep(zeit);
        } 
        catch (InterruptedException e)
        {
            // ignoring exception at the moment
        }
    }

    public void wait(int ms)
    {   try  {Thread.sleep(ms);}
        catch(InterruptedException ex)
          {Thread.currentThread().interrupt();}}

    /**
     * Fügt ein weiteres Steuerungselement in die rechte Steuerungsleiste ein.
     * @param  element  Das einzufügende Steuerungselement muss aus JComponent abgeleitet
     * sein. z. B. JButton, JComboBox. 
     */
    public void komponenteHinzufuegen(JComponent element, String position)
    {
        if (position=="rechts") steuerungOst.add(element);
        else if (position=="unten") steuerungSued.add(element);
        frame.pack();
    }
    
    public void komponenteRemove(JComponent element, String position)
    {
        if (position=="rechts") steuerungOst.remove(element);
        else if (position=="unten") steuerungSued.remove(element);
        frame.pack();
    }
    public void komponenteRevalidate(JComponent element, String position)
    {
        if (position=="rechts") steuerungOst.revalidate();
        else if (position=="unten") steuerungSued.revalidate();
        frame.pack();
    }
    public void komponenteRepaint(JComponent element, String position)
    {
        if (position=="rechts") steuerungOst.repaint();
        else if (position=="unten") steuerungSued.repaint();
        frame.pack();
    }

    
    /**
     * Beschriftet den Titel des WINDOWs neu.
     * @param  titelNeu  Text der neuen Fensterüberschrift
     */
    public void setzeTitel(String titelNeu)
    {
        frame.setTitle(titelNeu);
    }

    /************************************************************************
     * Nested class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        private static final long serialVersionUID = 20060330L;
        
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
    
    public void keyTyped(KeyEvent e){    }
        
    public void keyPressed(KeyEvent e){
        int key= e.getKeyCode();
          if(key == KeyEvent.VK_1)  {K1=1;}
          if(key == KeyEvent.VK_Q)  {Kq=1;}
          if(key == KeyEvent.VK_W)  {Kw=1;}
          if(key == KeyEvent.VK_E)  {Ke=1;}
          if(key == KeyEvent.VK_R)  {Kr=1;}
          if(key == KeyEvent.VK_T)  {Kt=1;}
          if(key == KeyEvent.VK_Z)  {Kz=1;}
          if(key == KeyEvent.VK_U)  {Ku=1;}
          if(key == KeyEvent.VK_I)  {Ki=1;}
          if(key == KeyEvent.VK_O)  {Ko=1;}
          if(key == KeyEvent.VK_P)  {Kp=1;}
          if(key == KeyEvent.VK_A)  {Ka=1;}
          if(key == KeyEvent.VK_S)  {Ks=1;}
          if(key == KeyEvent.VK_D)  {Kd=1;}
          if(key == KeyEvent.VK_F)  {Kf=1;}
          if(key == KeyEvent.VK_G)  {Kg=1;}
          if(key == KeyEvent.VK_H)  {Kh=1;}
          if(key == KeyEvent.VK_J)  {Kj=1;}
          if(key == KeyEvent.VK_K)  {Kk=1;}
          if(key == KeyEvent.VK_L)  {Kl=1;}
          if(key == KeyEvent.VK_Y)  {Ky=1;}
          if(key == KeyEvent.VK_X)  {Kx=1;}
          if(key == KeyEvent.VK_C)  {Kc=1;}
          if(key == KeyEvent.VK_V)  {Kv=1;}
          if(key == KeyEvent.VK_B)  {Kb=1;}
          if(key == KeyEvent.VK_N)  {Kn=1;}
          if(key == KeyEvent.VK_M)  {Km=1;}
          if(key == KeyEvent.VK_UP) {Kup=1;}  
          if(key == KeyEvent.VK_DOWN) {Kdown=1;} 
          if(key == KeyEvent.VK_LEFT) {Kleft=1;} 
          if(key == KeyEvent.VK_RIGHT) {Kright=1;}    
          if(key == KeyEvent.VK_ENTER) {Kenter=1;}    
          if(key == KeyEvent.VK_SPACE) {Kspace=1;}    
          if(key == KeyEvent.VK_ESCAPE) {Kescape=1;}    
          if(key == KeyEvent.VK_BACK_SPACE) {Kback_space=1;}    
    }
    
    
    public void keyReleased(KeyEvent e){
        int key= e.getKeyCode();

          if(key == KeyEvent.VK_1)  {K1=0;}
          if(key == KeyEvent.VK_Q)  {Kq=0;}
          if(key == KeyEvent.VK_W)  {Kw=0;}
          if(key == KeyEvent.VK_E)  {Ke=0;}
          if(key == KeyEvent.VK_R)  {Kr=0;}
          if(key == KeyEvent.VK_T)  {Kt=0;}
          if(key == KeyEvent.VK_Z)  {Kz=0;}
          if(key == KeyEvent.VK_U)  {Ku=0;}
          if(key == KeyEvent.VK_I)  {Ki=0;}
          if(key == KeyEvent.VK_O)  {Ko=0;}
          if(key == KeyEvent.VK_P)  {Kp=0;}
          if(key == KeyEvent.VK_A)  {Ka=0;}
          if(key == KeyEvent.VK_S)  {Ks=0;}
          if(key == KeyEvent.VK_D)  {Kd=0;}
          if(key == KeyEvent.VK_F)  {Kf=0;}
          if(key == KeyEvent.VK_G)  {Kg=0;}
          if(key == KeyEvent.VK_H)  {Kh=0;}
          if(key == KeyEvent.VK_J)  {Kj=0;}
          if(key == KeyEvent.VK_K)  {Kk=0;}
          if(key == KeyEvent.VK_L)  {Kl=0;}
          if(key == KeyEvent.VK_Y)  {Ky=0;}
          if(key == KeyEvent.VK_X)  {Kx=0;}
          if(key == KeyEvent.VK_C)  {Kc=0;}
          if(key == KeyEvent.VK_V)  {Kv=0;}
          if(key == KeyEvent.VK_B)  {Kb=0;}
          if(key == KeyEvent.VK_N)  {Kn=0;}
          if(key == KeyEvent.VK_M)  {Km=0;}
          if(key == KeyEvent.VK_UP) {Kup=0;}
          if(key == KeyEvent.VK_DOWN) {Kdown=0;} 
          if(key == KeyEvent.VK_LEFT) {Kleft=0;} 
          if(key == KeyEvent.VK_RIGHT) {Kright=0;}         
          if(key == KeyEvent.VK_ENTER) {Kenter=0;}         
          if(key == KeyEvent.VK_SPACE) {Kspace=0;}         
          if(key == KeyEvent.VK_ESCAPE) {Kescape=0;}         
          if(key == KeyEvent.VK_BACK_SPACE) {Kback_space=0;}                   
    }

/* Vincent */

    public void addKeyListener(java.awt.event.KeyListener listener)
    {   frame.addKeyListener(listener);    }
    
    public void removeKeyListener(java.awt.event.KeyListener listener)
    {   frame.removeKeyListener(listener);    }
    
    public void addWindowListener(java.awt.event.WindowListener listener)
    {   frame.addWindowListener(listener);    }
    
    public void addWindowFocusListener(java.awt.event.WindowFocusListener listener)
    {   frame.addWindowFocusListener(listener);    }
    
    public void requestFocus()
    {   frame.requestFocus();    }
    
    
}
