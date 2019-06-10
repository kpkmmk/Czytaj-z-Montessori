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

/**Klasa odpowiadająca za wyświetlanie odpowiednych napisów w poziomie zielonym oraz sprawdzanie,
*czy przeciągnięty został włąściwy obrazek we właściwe miejsce zgodnie z wylosowanym w metodzie 
*losowosc w klasie K parametrem przypisanym do parametru tej klasy numer_level 
*wyświetlany będzie odpowiedni napis
*następnie gracz będzie musiał przeciągnąć odpowiedni obrazek w pole z wyświetlonym napisem
*@see K #losowosc
*@author Kamila Pietrusińska
*/


public class Gra_3 extends Canvas
{
    private Image img_9 = new ImageIcon ("napis/napis9.png").getImage();
    private Image img9 = img_9.getScaledInstance (325,125, java.awt.Image.SCALE_SMOOTH);
    private Image img_10 = new ImageIcon ("napis/napis10.png").getImage();
    private Image img10 = img_10.getScaledInstance (325,125, java.awt.Image.SCALE_SMOOTH);
    private Image img_11 = new ImageIcon ("napis/napis11.png").getImage();
    private Image img11 = img_11.getScaledInstance (325,125, java.awt.Image.SCALE_SMOOTH);
    private Image img_12 = new ImageIcon ("napis/napis12.png").getImage();
    private Image img12 = img_12.getScaledInstance (325,125, java.awt.Image.SCALE_SMOOTH);
    private Image obr_9 = new ImageIcon ("obrazki/9.png").getImage();
    private Image obr9 = obr_9.getScaledInstance (175,125, java.awt.Image.SCALE_SMOOTH);
    private Image obr_10 = new ImageIcon ("obrazki/10.png").getImage();
    private Image obr10 = obr_10.getScaledInstance (125,175, java.awt.Image.SCALE_SMOOTH);
    private Image obr_11 = new ImageIcon ("obrazki/11.png").getImage();
    private Image obr11 = obr_11.getScaledInstance (125,175, java.awt.Image.SCALE_SMOOTH);
    private Image obr_12 = new ImageIcon ("obrazki/12.png").getImage();
    private Image obr12 = obr_12.getScaledInstance (125,175, java.awt.Image.SCALE_SMOOTH);

    /**
     *Parametr numer_level istotny jest dla metody paint Przypisywane są mu wartości w funkcji 
     * losowosc() z klasie K Zgodnie z wartością tego parametru wyświetlane są odpowiednie napisy.
     * @see K#losowosc()
     */
    public static int numer_level;
    private int obr9_x=30, obr9_y=30;
    private int obr10_x=340, obr10_y=30;
    private int obr11_x=30, obr11_y=450;
    private int obr12_x=340, obr12_y=450;
    private int obrazek_1=0;
    
    Gra_3()
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
                        obrazek_1 = 1;
                    }
                    if( (x>=(340) & x<=(340+125)) & (y>=(30) & y<=(30+175)) ) //jeżeli myszka została wciśnięta w tym obszarze oznacza to, że został wybrany obrazek 2
                    {
                        obrazek_1 = 2;
                    }
                    if( (x>=(30) & x<=(30+125)) & (y>=(450) & y<=(450+175)) ) //jeżeli myszka została wciśnięta w tym obszarze oznacza to, że został wybrany obrazek 3
                    {
                        obrazek_1 = 3;
                    }
                    if( (x>=(340) & x<=(340+125)) & (y>=(450) & y<=(450+175)) ) //jeżeli myszka została wciśnięta w tym obszarze oznacza to, że został wybrany obrazek 4
                    {
                        obrazek_1 = 4;
                    }
                    
                }
                
                public void mouseReleased(MouseEvent n) 
                {
                    int a=0, b=0;
                    a=n.getX();
                    b=n.getY();
                    
                    if ( (a>=80&a<=(80+325)) & (b>=250)&(b<=250+125)) //sprawdzenie, czy puszczono obrazek w dobre miejsce
                        {
                            sprawdzanie(obrazek_1);
                        }
                    else
                        {
                            JOptionPane.showMessageDialog(null, "Przeciągnąłeś w złe pole. Spróbuj jeszcze raz","UWAGA!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    
                //nadanie obrazkowi w pierwotnych parametrów obszaru, w którym ma być narysowany    
                    obr9_x=30;
                    obr9_y=30;
                    obr10_x=340;
                    obr10_y=30;
                    obr11_x=30;
                    obr11_y=450;
                    obr12_x=340;
                    obr12_y=450;
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
                    switch(obrazek_1)
                    {
                        case 1:
                        {
                            obr9_x=p;
                            obr9_y=z;
                            
                            break;
                        }
                        
                        case 2:
                        {
                            obr10_x=p;
                            obr10_y=z;
                            
                            break; 
                        }
                        
                        case 3:
                        {
                            obr11_x=p;
                            obr11_y=z;
                            
                            break; 
                        }
                        
                        case 4:
                        {
                            obr12_x=p;
                            obr12_y=z;
                            
                            break; 
                        }
                    }
                    
                    repaint();
                    System.out.println("drageed"+p+" "+z);
                    
                }

                @Override
                public void mouseMoved(MouseEvent me) 
                {
                    
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
        g2.drawImage(obr9,obr9_x,obr9_y,this);
        g2.drawImage(obr10,obr10_x,obr10_y,this);
        g2.drawImage(obr11,obr11_x,obr11_y,this);
        g2.drawImage(obr12,obr12_x,obr12_y,this);
        switch (numer_level)
        {
            case 1:
            {
                g2.drawImage(img9,80,250,this);
               
                break;
            }
                                
            case 2:
            {
                g2.drawImage(img10,80,250,this);
                
                break;
            }
            
            case 3:
            {
                g2.drawImage(img11,80,250,this);
                break;
            }
            
            case 4:
            {
                g2.drawImage(img12,80,250,this);
                
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
                            K.window.gra_f_3.setVisible(false);
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
                            K.window.gra_f_3.setVisible(false);
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
                            K.window.gra_f_3.setVisible(false);
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
                            K.window.gra_f_3.setVisible(false);
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
