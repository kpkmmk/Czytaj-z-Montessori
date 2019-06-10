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
import javax.swing.ImageIcon;

/**Klasa odpowiadająca za wyświetlanie odpowiednych napisów w poziomie różowym
 *<br> Zgodnie z wylosowanym w funcji losowosc w klasie K parametrem tej klasy
 *nr_level wyświetlany będzie odpowiedni napis przez wywołanie matody paint
 *@see K #losowosc
* @author Kamila Pietrusińska
 */

public class Gra extends Canvas
{
    private Image img_1 = new ImageIcon ("napis/napis1.png").getImage();
    private Image img1 = img_1.getScaledInstance (300,100, java.awt.Image.SCALE_SMOOTH);
    private ImageIcon napis1 = new ImageIcon (img1);
    private Image img_2 = new ImageIcon ("napis/napis2.png").getImage();
    private Image img2 = img_2.getScaledInstance (300,100, java.awt.Image.SCALE_SMOOTH);
    private ImageIcon napis2 = new ImageIcon (img2);
    private Image img_3 = new ImageIcon ("napis/napis3.png").getImage();
    private Image img3 = img_3.getScaledInstance (300,100, java.awt.Image.SCALE_SMOOTH);
    private ImageIcon napis3 = new ImageIcon (img3);
    private Image img_4 = new ImageIcon ("napis/napis4.png").getImage();
    private Image img4 = img_4.getScaledInstance (300,100, java.awt.Image.SCALE_SMOOTH);
    private ImageIcon napis4 = new ImageIcon (img4);
    int nr_level;
    
    Gra()
    {
       
    }
    
    /**
     *Metoda paint() odpowiada za rysowanie odpowiednich napisów 
     * @param g paramert pozwalający na rysowanie w Canvas
     */
    @Override
    public void paint(Graphics g)
    {
        
        Graphics2D g2 = (Graphics2D) g; 
        
      
        switch (nr_level)
        {
            case 1:
            {
                g2.drawImage(img1,100,250,this);
               
                break;
            }
                                
            case 2:
            {
                g2.drawImage(img2,100,250,this);
                
                break;
            }
            
            case 3:
            {
                g2.drawImage(img3,100,250,this);
                break;
            }
            
            case 4:
            {
                g2.drawImage(img4,100,250,this);
                
                break;
            }
        }
        
        
    }

      
}
