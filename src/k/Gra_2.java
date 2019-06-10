/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**Klasa odpowiadająca za wyświetlanie odpowiednych napisów w poziomie niebieskim oraz sprawdzanie,
*czy przeciągnięty został włąściwy obrazek we właściwe miejsce zgodnie z wylosowanym w metodzie 
*losowosc w klasie K parametrem przypisanym do parametru tej klasy numer_level 
*wyświetlany będzie odpowiedni napis następnie gracz będzie musiał 
* przeciągnąć odpowiedni obrazek w pole z wyświetlonym napisem
*@see K #losowosc
*@author Kamila Pietrusińska
*/

public class Gra_2 extends Canvas
{
    private Image img_5 = new ImageIcon ("napis/napis5.png").getImage();
    private Image img5 = img_5.getScaledInstance (325,125, java.awt.Image.SCALE_SMOOTH);
    private Image img_6 = new ImageIcon ("napis/napis6.png").getImage();
    private Image img6 = img_6.getScaledInstance (325,125, java.awt.Image.SCALE_SMOOTH);
    private Image img_7 = new ImageIcon ("napis/napis7.png").getImage();
    private Image img7 = img_7.getScaledInstance (325,125, java.awt.Image.SCALE_SMOOTH);
    private Image img_8 = new ImageIcon ("napis/napis8.png").getImage();
    private Image img8 = img_8.getScaledInstance (325,125, java.awt.Image.SCALE_SMOOTH);
    private Image obr_5 = new ImageIcon ("obrazki/5.png").getImage();
    private Image obr5 = obr_5.getScaledInstance (175,125, java.awt.Image.SCALE_SMOOTH);
    private Image obr_6 = new ImageIcon ("obrazki/6.png").getImage();
    private Image obr6 = obr_6.getScaledInstance (125,175, java.awt.Image.SCALE_SMOOTH);
    private Image obr_7 = new ImageIcon ("obrazki/7.png").getImage();
    private Image obr7 = obr_7.getScaledInstance (125,175, java.awt.Image.SCALE_SMOOTH);
    private Image obr_8 = new ImageIcon ("obrazki/8.png").getImage();
    private Image obr8 = obr_8.getScaledInstance (125,175, java.awt.Image.SCALE_SMOOTH);
    /**
     *Parametr numer_level istotny jest dla metody paint Przypisywane są mu wartości w funkcji 
     * losowosc() z klasie K Zgodnie z wartością tego parametru wyświetlane są odpowiednie napisy
     * @see K losowosc()
     */
    public static int numer_level;
    private int obr5_x=30, obr5_y=30;
    private int obr6_x=340, obr6_y=30;
    private int obr7_x=30, obr7_y=450;
    private int obr8_x=340, obr8_y=450;
    private int obrazek=0;
    
    Gra_2()
    {
        addMouseListener
        (
            new MouseAdapter()
            {
                @Override
                public void mousePressed(MouseEvent m) 
                {
                    int x=0, y=0;
                    x=m.getX();
                    y=m.getY();
                    
                    if( (x>=(30) & x<=(30+175)) & (y>=(30) & y<=(30+125)) ) //jeżeli myszka została wciśnięta w tym obszarze oznacza to, że został wybrany obrazek 1
                    {
                        obrazek = 1;
                    }
                    if( (x>=(340) & x<=(340+125)) & (y>=(30) & y<=(30+175)) ) //jeżeli myszka została wciśnięta w tym obszarze oznacza to, że został wybrany obrazek 2
                    {
                        obrazek = 2;
                    }
                    if( (x>=(30) & x<=(30+125)) & (y>=(450) & y<=(450+175)) ) //jeżeli myszka została wciśnięta w tym obszarze oznacza to, że został wybrany obrazek 3
                    {
                        obrazek = 3;
                    }
                    if( (x>=(340) & x<=(340+125)) & (y>=(450) & y<=(450+175)) ) //jeżeli myszka została wciśnięta w tym obszarze oznacza to, że został wybrany obrazek 4
                    {
                        obrazek = 4;
                    }
                    
                }
                
                @Override
                public void mouseReleased (MouseEvent n) 
                {
                    int a=0, b=0;
                    a=n.getX();
                    b=n.getY();
                    
                    if ( (a>=80&a<=(80+325)) & (b>=250)&(b<=250+125)) //sprawdzenie, czy puszczono obrazek w dobre miejsce
                        {
                            sprawdzanie(obrazek);
                        }
                    else
                        {
                            JOptionPane.showMessageDialog(null, "Przeciągnąłeś w złe pole. Spróbuj jeszcze raz", "UWAGA!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    
                //nadanie obrazkowi w pierwotnych parametrów obszaru, w którym ma być narysowany    
                    obr5_x=30;
                    obr5_y=30;
                    obr6_x=340;
                    obr6_y=30;
                    obr7_x=30;
                    obr7_y=450;
                    obr8_x=340;
                    obr8_y=450;
                    repaint();
                    
                }
                
            }
                
        );
        
        addMouseMotionListener
        (
            new MouseMotionListener()
            {
                @Override
                public void mouseDragged(MouseEvent f) 
                {
                    
                    int p=f.getX();
                    int z=f.getY();
                    
                //pobierając parametry przesuwającego się kursora odpowiedni obrazek, który indentyfikowany jest
                //w mousePressed odpowiedni obrazek jest rysowany na nowo z każdą zmianą tych parametrów
                    switch(obrazek)
                    {
                        case 1:
                        {
                            obr5_x=p;
                            obr5_y=z;
                            
                            break;
                        }
                        
                        case 2:
                        {
                            obr6_x=p;
                            obr6_y=z;
                            
                            break; 
                        }
                        
                        case 3:
                        {
                            obr7_x=p;
                            obr7_y=z;
                            
                            break; 
                        }
                        
                        case 4:
                        {
                            obr8_x=p;
                            obr8_y=z;
                            
                            break; 
                        }
                    }
                    
                    repaint();                    
                }

            @Override
            public void mouseMoved(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            }
        );        
                
    }
    
    /**
     Metoda paint() odpowiada za rysowanie odpowiednich napisów 
     * @param g paramert pozwalający na rysowanie w Canvas
     */
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g; 
        g2.drawImage(obr5,obr5_x,obr5_y,this);
        g2.drawImage(obr6,obr6_x,obr6_y,this);
        g2.drawImage(obr7,obr7_x,obr7_y,this);
        g2.drawImage(obr8,obr8_x,obr8_y,this);
        switch (numer_level)
        {
            case 1:
            {
                g2.drawImage(img5,80,250,this);
               
                break;
            }
                                
            case 2:
            {
                g2.drawImage(img6,80,250,this);
                
                break;
            }
            
            case 3:
            {
                g2.drawImage(img7,80,250,this);
                break;
            }
            
            case 4:
            {
                g2.drawImage(img8,80,250,this);
                
                break;
            }
        } 
        
    }

    /**
     * Funkcja sprawdzająca poprawność przeciągniętych obrazków
     * względem wyświetlonego napisu
     * @param w_obr ustawiany jest zgodnie ze wciśnietym przyciskiem 
     * i zgodnie zjego wartością wykonywane są kolejne czynności takie jak
     * wyświetlenie odpowiedniego okna z informacja o dobrym lub złym ruchu,
     * zmiana wartości odpowiedniego parametru, w celu umożliwienia wyświetlenia 
     * kolejnego napisu lub wyświetlenie okna z informacją o ukończeniu poziomu
     * po czym nastąpi przekierowanie do Menu 
     */
    public static void sprawdzanie(int w_obr) 
    {
        
        switch(w_obr)
        {
            case 1:
            {
                if (w_obr == numer_level)
                {
                    K.licznik++;
                    if(K.licznik >= 4)
                        {
                            K.licznik = 0;
                            JOptionPane.showMessageDialog(null, "Brawo wygrałeś!","BRAWO!", JOptionPane.INFORMATION_MESSAGE);
                            K.window.menu_f.setVisible(true);
                            K.window.gra_f_2.setVisible(false);
                        }
                   
                    numer_level = K.tab.get(K.licznik);
                    
                }
                
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz","UWAGA!", JOptionPane.INFORMATION_MESSAGE);
                }
                
                break;   
            }
            
             case 2:
            {
                if (w_obr == numer_level)
                {
                    K.licznik++;
                    if(K.licznik >= 4)
                        {
                            K.licznik = 0;
                            JOptionPane.showMessageDialog(null, "Brawo wygrałeś!","BRAWO!", JOptionPane.INFORMATION_MESSAGE);
                            K.window.menu_f.setVisible(true);
                            K.window.gra_f_2.setVisible(false);
                        }
                    numer_level = K.tab.get(K.licznik);
                    
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz","UWAGA!", JOptionPane.INFORMATION_MESSAGE);
                }
                
                break;   
            }
            
             case 3:
            {
                if (w_obr == numer_level)
                {
                    K.licznik++;
                    if(K.licznik >= 4)
                        {
                            K.licznik = 0;
                            JOptionPane.showMessageDialog(null, "Brawo wygrałeś!","BRAWO!", JOptionPane.INFORMATION_MESSAGE);
                            K.window.menu_f.setVisible(true);
                            K.window.gra_f_2.setVisible(false);
                        }
                    numer_level = K.tab.get(K.licznik);
                    
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz","UWAGA!", JOptionPane.INFORMATION_MESSAGE);
                }
                
                break;   
            }
            
            case 4:
            {
                if (w_obr == numer_level)
                {
                    K.licznik++;
                    if(K.licznik >= 4)
                        {
                            K.licznik = 0;
                            JOptionPane.showMessageDialog(null, "Brawo wygrałeś!","BRAWO!", JOptionPane.INFORMATION_MESSAGE);
                            K.window.menu_f.setVisible(true);
                            K.window.gra_f_2.setVisible(false);
                        }
                    numer_level = K.tab.get(K.licznik);
                    
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz","UWAGA!", JOptionPane.INFORMATION_MESSAGE);
                }
                
                break;   
            }
        }
    }       
}