/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**W klasie tworzone są okna programu i dodawane do nich najważniejsze elemety
* elementy są też odpowiednio porządkowane zgodnie z zadeklarowanym Layoutem
* <br> W tej klasie znajduje się równięż główna metoda progarmu- losowosc() odpowiadająca 
* za losowe wyświetlanie napisów
* najduje się również metoda sprawdzająca poprawność wciśniętego przycisku
* w poziomie różowym Sprawdzanie poprawności przeciągnięcia obrazka w kolejnych poziomach 
* znajduję się w klasach odpowiadającym za kolejne poziomy
* @see Gra
* @see Gra_2
* @see Gra_3
* @see K#losowosc() 
* @see K#sprawdzanie(int) 
 * @author Kamila Pietrusińska
 */

public class K {

    static Gra game = new Gra();               //obiekt canvas
    static Gra_2 game_2 = new Gra_2();
    static Gra_3 game_3 = new Gra_3();
    private JPanel obrazki_g = new JPanel ();   //panel z przyciskami do gry
    
    /**
     * okno z głónym menu gry
     */
    public JFrame menu_f = new JFrame();   
    /**
     *okno z poziomem różowym
     */    
    public JFrame gra_f = new JFrame();        //okienko z grą poziomu różowego

    /**
     *okno z poziomem niebieskiem
     */
    public JFrame gra_f_2 = new JFrame();  //okienko z grą poziomu niebieskiego

    /**
     *okno z poziomem zielonym 
     */
    public JFrame gra_f_3 = new JFrame();  //okienko z grą poziomu zielonego
    private JPanel menu_p = new JPanel();       //panel z menu
    private JFrame poziom_f = new JFrame ();    //panel z wyborem poziomu
    private JFrame jak_grac_f = new JFrame ();    //panel jak grac
    
    private JPanel powrot_do_menu_p = new JPanel ();    //panel dla powrotu do menu z poziomu różwego
    private JPanel powrot_do_menu_p_2 = new JPanel ();  //panel dla powrotu do menu z poziomu niebieskiego
    private JPanel powrot_do_menu_p_3 = new JPanel ();  //panel dla powrotu do menu z poziomu zielonego
    private JPanel srodek_2 = new JPanel ();            //środkowa część panelu okna poziomu niebieskiego
    private JPanel srodek_3 = new JPanel ();            //środkowa część panelu okna poziomu zielonego
    /**
     * deklaracja przycisków wykorzystywanych w grze
     */
    
    private JButton menu_f_1 = new JButton("Nowa Gra");     //przyciski dodawane do panelu menu_p
    private JButton menu_f_2 = new JButton("Jak Grać");     //przyciski dodawane do panelu menu_p
    private JButton menu_f_3 = new JButton("Wyjście");      //przyciski dodawane do panelu menu_p
    private JButton obrazek_1 = new JButton();          //przyciski do poziomu różowego deklaracja
    private JButton obrazek_2 = new JButton();          //przyciski do poziomu różowego deklaracja
    private JButton obrazek_3 = new JButton();          //przyciski do poziomu różowego deklaracja 
    private JButton obrazek_4 = new JButton();          //przyciski do poziomu różowego deklaracja
    private JButton powrot_do_menu = new JButton("Menu");     //przycisk powrotu do menu z poziomu
    private JButton powrot_do_menu_2 = new JButton("Menu");     //przycisk powrotu do menu z poziomu
    private JButton powrot_do_menu_3 = new JButton("Menu");     //przycisk powrotu do menu z poziomu
    private JButton poziom_1 = new JButton("Poziom Różowy");        //przyciski do wyboru poziomu
    private JButton poziom_2 = new JButton("Poziom Niebieski");     //przyciski do wyboru poziomu
    private JButton poziom_3 = new JButton("Poziom Zielony");       //przyciski do wyboru poziomu 
    /**
     * główne okno do gry
     */
    public static K window = new K();     
    private static int wcisniety_przycisk = 0;
    /**
     * do tej ArrayListy zapisane zostaną wylosowane w metodzie losowosc() wartosci, 
     * które odpowiadać będą za zapewnienie randomizacji gry
     */
    public static ArrayList<Integer> tab = new ArrayList<Integer>();       
    /**
     * parametr ważny dla metody spradzanie () Gdy jego wartość jest mniejsza od 4 
     *  metoda będzie kontynuować sprawdzanie poprawności wybranych lub przeciąganych obrazków 
     * zgodnie w wyświetlonym napisem Gdy jego wartość jest większa wyświetlany jest komunikat o 
     * ukończeniu poziomu
     */
    public static int licznik = 0;
    
    K(){                            // konstruktor
               
    //ustawienie parametrów głównego menu
        menu_f.setTitle("MENU");
        menu_f.setSize(400,700);
        menu_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu_f.setLayout(new BorderLayout());
        menu_f.setLocation(625,250);
        
    //ustawieni parametrów panelu menu głównego
        menu_p.setLayout(new GridLayout(5,3,0,50));
        menu_p.setBackground(new Color(35,200,240));       

    //odawanie przycisków w menu_f - START      
        for(int i=0; i<3; i++) { menu_p.add( new JLabel("")); } 
        for(int i=0; i<1; i++) { menu_p.add( new JLabel("")); } 
        menu_p.add(menu_f_1); for(int i=0; i<2; i++) { menu_p.add( new JLabel("")); } 
        menu_p.add(menu_f_2); for(int i=0; i<2; i++) { menu_p.add( new JLabel("")); } 
        menu_p.add(menu_f_3); for(int i=0; i<1; i++) { menu_p.add( new JLabel("")); }
        for(int i=0; i<3; i++) { menu_p.add( new JLabel("")); } 
        
        Image nowa_gra = new ImageIcon ("guziki/g1.png").getImage();    //dodanie obrazka do przyciku
        Image n_gra = nowa_gra.getScaledInstance (140,200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon menuf1 = new ImageIcon (n_gra); 
        Image jak_grac = new ImageIcon ("guziki/g2.png").getImage();    //dodanie obrazka do przyciku
        Image j_grac = jak_grac.getScaledInstance (140,200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon menuf2 = new ImageIcon (j_grac);
        Image wyjscie = new ImageIcon ("guziki/g3.png").getImage();    //dodanie obrazka do przyciku
        Image w_scie = wyjscie.getScaledInstance (140,200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon menuf3 = new ImageIcon (w_scie);
               
        menu_f_1.setIcon(menuf1);
        menu_f_1.setContentAreaFilled(true);
        menu_f_1.setPreferredSize(new Dimension(100, 100));
        menu_f_2.setIcon(menuf2);
        menu_f_2.setContentAreaFilled(true);
        menu_f_2.setPreferredSize(new Dimension(100, 100));
        menu_f_3.setIcon(menuf3);
        menu_f_3.setContentAreaFilled(true);
        menu_f_3.setPreferredSize(new Dimension(100, 100));
    //dodawanie przycisków w menu_f - KONIEC
    
    //dodanie ActionListenera do przycisków menu głownego
        menu_f_1.addActionListener(new Nowa_Gra());
        menu_f_2.addActionListener(new Jak_Grac());        
        menu_f_3.addActionListener(new Wyjscie());

        menu_f.add(menu_p, BorderLayout.CENTER);
        
    //ustawienie okna Jak Grać
    
        jak_grac_f.setTitle("Jak grać?");
        jak_grac_f.setSize(800,800);
        jak_grac_f.setLayout(null);
        jak_grac_f.setLocation(625,200);
        JTextArea area=new JTextArea("Gra ma na celu pomóc w nauce\n"+
                                    "czytania dzieciom pracującym \nmetodą Montessori\n"+
                                    "Pierwszy poziom- Poziom Różowy \n"+
                                    "wymaga od użytkownika \nodpowiedniego przycisku\n"+
                                    "z ilustracją napisu.\n"+ 
                                    "Kolejne poziomy- Niebieski i \nZielony wybór odpowiedzi"+
                                    "\nrazlizują wybór odpowiedzi przez\n"+
                                    "przeciągnięcie obrazka w pole \nz napisem."+
                                    "\n\nGrę wykonała Kamila Pietrusińska");  
        area.setBounds(10,30, 410,410);
        area.setOpaque(false);  
        Font font = new Font("Arial", Font.BOLD, 25);
        area.setFont(font);
        area.setEditable(false);
        area.setForeground(Color.getHSBColor(35, 175, 220));
        jak_grac_f.add(area);        
        area.setLocation(150,150);
        
        jak_grac_f.getContentPane().setBackground(new Color(35,200,240));        

    //dodawanie obrazków do poziomu różowego

        obrazki_g.setSize(new Dimension (500,500));
        obrazki_g.setLayout(new GridLayout(6,2,0,20));
        obrazki_g.setBackground(new Color(221,160,221));
        
        Image obr_1 = new ImageIcon ("obrazki/1.png").getImage();    //dodanie obrazka do przyciku
        Image obr1 = obr_1.getScaledInstance (100,100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon obrazek1 = new ImageIcon (obr1);                                                  //koniec dodawania obrazku do przycisku
        Image obr_2 = new ImageIcon ("obrazki/2.png").getImage();    //dodanie obrazka do przyciku
        Image obr2 = obr_2.getScaledInstance (100,100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon obrazek2 = new ImageIcon (obr2);                    //koniec dodawania obrazku do przycisku
        Image obr_3 = new ImageIcon ("obrazki/3.png").getImage();    //dodanie obrazka do przyciku
        Image obr3 = obr_3.getScaledInstance (100,100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon obrazek3 = new ImageIcon (obr3);                                                  //koniec dodawania obrazku do przycisku
        Image obr_4 = new ImageIcon ("obrazki/4.png").getImage();    //dodanie obrazka do przyciku
        Image obr4 = obr_4.getScaledInstance (100,100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon obrazek4 = new ImageIcon (obr4);
        
    //dodawanie przycisków do poziomu różowego
        for(int i=0; i<3; i++) { obrazki_g.add( new JLabel("")); } 
        obrazki_g.add( new JLabel("")); 
        obrazki_g.add(obrazek_1); for(int i=0; i<2; i++) { obrazki_g.add( new JLabel("")); } 
        obrazki_g.add(obrazek_2); for(int i=0; i<2; i++) { obrazki_g.add( new JLabel("")); } 
        obrazki_g.add(obrazek_3); for(int i=0; i<2; i++) { obrazki_g.add( new JLabel("")); } 
        obrazki_g.add(obrazek_4); for(int i=0; i<1; i++) { obrazki_g.add( new JLabel("")); }
        for(int i=0; i<1; i++) { obrazki_g.add( new JLabel("")); } 
               
        obrazek_1.setIcon(obrazek1);
        obrazek_1.setContentAreaFilled(true);
        obrazek_2.setIcon(obrazek2);
        obrazek_2.setContentAreaFilled(true);
        obrazek_3.setIcon(obrazek3);
        obrazek_3.setContentAreaFilled(true);
        obrazek_4.setIcon(obrazek4);
        obrazek_4.setContentAreaFilled(true);
        
        obrazek_1.setPreferredSize(new Dimension(300,100));
        obrazek_2.setPreferredSize(new Dimension(300,100));
        obrazek_3.setPreferredSize(new Dimension(300,100));
        obrazek_4.setPreferredSize(new Dimension(300,100));
        
    //dodawanie reakcji do wciśnięcia przycisku w poziomie różowym
        obrazek_1.addActionListener(new Spr_1());
        obrazek_2.addActionListener(new Spr_2());
        obrazek_3.addActionListener(new Spr_3());
        obrazek_4.addActionListener(new Spr_4());
        
    //możliwość powrotu do menu z poziomu różowego
        powrot_do_menu_p.setSize(new Dimension (200,200));
        powrot_do_menu_p.setLayout(new GridLayout(3,3,10,50));
        powrot_do_menu_p.setBackground(new Color(221,160,221));
                
        for(int i=0; i<3; i++) { powrot_do_menu_p.add( new JLabel("")); } 
        powrot_do_menu_p.add( new JLabel("")); 
        powrot_do_menu_p.add(powrot_do_menu);
        for(int i=0; i<2; i++) { powrot_do_menu_p.add( new JLabel("")); } 
        
        Image powrot_1 = new ImageIcon ("guziki/g7.png").getImage();    //dodanie obrazka do przyciku
        Image powr_1 = powrot_1.getScaledInstance (210,200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon powr1 = new ImageIcon (powr_1);
        
        powrot_do_menu.setIcon(powr1);
        powrot_do_menu.setContentAreaFilled(true);
        
        powrot_do_menu.setPreferredSize(new Dimension(70,50));
        powrot_do_menu.addActionListener(new Powrot_do_menu());
        powrot_do_menu.setBorder(null);
    //koniec powrotu do menu z poziomu różowego
        
    
    //możliwość powrotu do menu z poziomu niebieskiego
        powrot_do_menu_p_2.setSize(new Dimension (200,200));
        powrot_do_menu_p_2.setLayout(new GridLayout(3,3,10,50));
        powrot_do_menu_p_2.setBackground(new Color(126,176,255));
                
        for(int i=0; i<3; i++) { powrot_do_menu_p_2.add( new JLabel("")); } 
        powrot_do_menu_p_2.add( new JLabel("")); 
        powrot_do_menu_p_2.add(powrot_do_menu_2);
        for(int i=0; i<2; i++) { powrot_do_menu_p_2.add( new JLabel("")); } 
        
        Image powrot_2 = new ImageIcon ("guziki/g8.png").getImage();    //dodanie obrazka do przyciku
        Image powr_2 = powrot_2.getScaledInstance (210,200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon powr2 = new ImageIcon (powr_2);
        
        powrot_do_menu_2.setIcon(powr2);
        powrot_do_menu_2.setContentAreaFilled(true);
                
        powrot_do_menu_2.setPreferredSize(new Dimension(70,50));
        powrot_do_menu_2.addActionListener(new Powrot_do_menu_2());
        powrot_do_menu_2.setBorder(null);
    //koniec powrotu do menu
    
    //możliwość powrotu do menu z poziomu zielonego
        powrot_do_menu_p_3.setSize(new Dimension (210,200));
        powrot_do_menu_p_3.setLayout(new GridLayout(3,3,10,50));
        powrot_do_menu_p_3.setBackground(new Color(185,231,165));
                
        for(int i=0; i<3; i++) { powrot_do_menu_p_3.add( new JLabel("")); } 
        powrot_do_menu_p_3.add( new JLabel("")); 
        powrot_do_menu_p_3.add(powrot_do_menu_3);
        for(int i=0; i<2; i++) { powrot_do_menu_p_3.add( new JLabel("")); } 
        
        Image powrot_3 = new ImageIcon ("guziki/g9.png").getImage();    //dodanie obrazka do przyciku
        Image powr_3 = powrot_3.getScaledInstance (200,200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon powr3 = new ImageIcon (powr_3);
        
        powrot_do_menu_3.setIcon(powr3);
        powrot_do_menu_3.setContentAreaFilled(true);
        
        
        powrot_do_menu_3.setPreferredSize(new Dimension(70,50));
        powrot_do_menu_3.addActionListener(new Powrot_do_menu_3());
        powrot_do_menu_3.setBorder(null);
    //koniec powrotu do menu
        
    //wybór poziomu 
        poziom_f.setTitle("Wybierz poziom");
        poziom_f.setSize(600,300);
        poziom_f.setLayout(new GridLayout(5,4,70,0));
        poziom_f.setLocation(625,250);
    
        JTextArea area2=new JTextArea("\nWybierz poziom");  
        area2.setBounds(10,40,30,30);
        area2.setOpaque(false);  
        Font font2 = new Font("Arial", Font.BOLD, 18);
        area2.setFont(font2);
        area2.setEditable(false);
        area2.setForeground(Color.getHSBColor(35, 175, 220));
        
        for(int i=0; i<1; i++) { poziom_f.add( new JLabel("")); } 
        poziom_f.add(area2);
        for(int i=0; i<1; i++) { poziom_f.add( new JLabel("")); }
        for(int i=0; i<3; i++) { poziom_f.add( new JLabel("")); } 
        poziom_f.add(poziom_1); 
        poziom_f.add(poziom_2); 
        poziom_f.add(poziom_3);  
        for(int i=0; i<6; i++) { poziom_f.add( new JLabel("")); } 
        
        poziom_f.getContentPane().setBackground(new Color(35,200,240));
        
        Image poziom1 = new ImageIcon ("guziki/g4.png").getImage();    //dodanie obrazka do przyciku
        Image poz_1 = poziom1.getScaledInstance (160,140, java.awt.Image.SCALE_SMOOTH);
        ImageIcon poz1 = new ImageIcon (poz_1); 
        Image poziom2 = new ImageIcon ("guziki/g5.png").getImage();    //dodanie obrazka do przyciku
        Image poz_2 = poziom2.getScaledInstance (160,140, java.awt.Image.SCALE_SMOOTH);
        ImageIcon poz2 = new ImageIcon (poz_2);
        Image poziom3 = new ImageIcon ("guziki/g6.png").getImage();    //dodanie obrazka do przyciku
        Image poz_3 = poziom3.getScaledInstance (160,135, java.awt.Image.SCALE_SMOOTH);
        ImageIcon poz3 = new ImageIcon (poz_3);
               
        poziom_1.setIcon(poz1);
        poziom_1.setContentAreaFilled(true);
        poziom_1.setPreferredSize(new Dimension(200, 200));
        poziom_2.setIcon(poz2);
        poziom_2.setContentAreaFilled(true);
        poziom_2.setPreferredSize(new Dimension(200, 200));
        poziom_3.setIcon(poz3);
        poziom_3.setContentAreaFilled(true);
        poziom_3.setPreferredSize(new Dimension(200, 200));
                       
        poziom_1.addActionListener(new Poziom_1());
        poziom_2.addActionListener(new Poziom_2());
        poziom_3.addActionListener(new Poziom_3());
    //koniec wyboru poziomu
        
    //ustawienie okna gry poziomu różowego
    
        gra_f.setTitle("Poziom Różowy");
        gra_f.setSize(1024,768);
        gra_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gra_f.setLayout(new BorderLayout());
        gra_f.setLocation(500,200);
        
        gra_f.add(powrot_do_menu_p,BorderLayout.EAST);
        gra_f.add(obrazki_g,BorderLayout.CENTER);
        gra_f.add(game,BorderLayout.WEST);
        game.setSize(new Dimension(500,500));
        game.setBackground(new Color(221,160,221));
        
    //ustawienie parametrów okna poziomu niebieskiego
        gra_f_2.setTitle("Poziom Niebieski");
        gra_f_2.setSize(1024,768);
        gra_f_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gra_f_2.setLayout(new BorderLayout());
        gra_f_2.setLocation(500,200);
        
        srodek_2.setSize( new Dimension(100,100)); 
        srodek_2.setBackground(new Color(126,176,255));
        
    //ustawienie porządku okna gry poziomu niebieskiego
        gra_f_2.add(powrot_do_menu_p_2,BorderLayout.EAST);
        gra_f_2.add(srodek_2, BorderLayout.CENTER);
        gra_f_2.add(game_2,BorderLayout.WEST);
        game_2.setSize(new Dimension(500,768));
        game_2.setBackground(new Color(126,176,255));
        
    //ustawienie parametrów i porządku okna gry poziomu zielonego
        gra_f_3.setTitle("Poziom Zielony");
        gra_f_3.setSize(1024,768);
        gra_f_3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gra_f_3.setLayout(new BorderLayout());
        gra_f_3.setLocation(500,200);
        
        srodek_3.setSize( new Dimension(100,100)); 
        srodek_3.setBackground(new Color(185,231,165));
        
        gra_f_3.add(powrot_do_menu_p_3,BorderLayout.EAST);
        gra_f_3.add(srodek_3, BorderLayout.CENTER);
        gra_f_3.add(game_3,BorderLayout.WEST);
        game_3.setSize(new Dimension(500,500));
        game_3.setBackground(new Color(185,231,165));   
    
    }

    /**
     *Główna metoda programu, która wywołuje odpowiednie okna po uruchmieniu gry 
     * @param args domyślny parametr uruchamiający główną metodę
     */
    public static void main(String[] args) { 
        
        window.menu_p.setVisible(true);
        window.menu_f.setVisible(true); 
        
    }
    
    /**
     *Klasa obsługująca działenie przycisku powrot_do_menu, który odpowiada za powrót do menu
     * z poziomu różowego
     */
    public static class Powrot_do_menu implements ActionListener    //reakcja na przycisk powrót do menu
    {

        /**
         *W momencie wciśnięcia przycisku odpowiednie okna są wyświetlane lub ukrywane
         * oraz wywyoływana jest funkcji losowości
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        { 
           window.menu_f.setVisible(true);
           window.poziom_f.setVisible(false);
           window.gra_f.setVisible(false); 
           losowosc();
                   
        }
    }

    /**
     *Klasa obsługująca działenie przycisku powrot_do_menu_2, który odpowiada za powrót do menu
     * z poziomu niebieskiego
     */
    public static class Powrot_do_menu_2 implements ActionListener
    {

        /**
         *W momencie wciśnięcia przycisku odpowiednie okna są wyświetlane lub ukrywane
         * oraz wywyoływana jest funkcji losowości
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        { 
           window.menu_f.setVisible(true);
           window.poziom_f.setVisible(false);
           window.gra_f_2.setVisible(false); 
           losowosc();
                   
        }
    }

    /**
     *Klasa obsługująca działenie przycisku powrot_do_menu_3, który odpowiada za powrót do menu
     * z poziomu zielonego
     */
    public static class Powrot_do_menu_3 implements ActionListener
    {

        /**
         *W momencie wciśnięcia przycisku odpowiednie okna są wyświetlane lub ukrywane
         * oraz wywyoływana jest funkcji losowości
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        { 
           window.menu_f.setVisible(true);
           window.poziom_f.setVisible(false);
           window.gra_f_3.setVisible(false); 
           losowosc();
        }
    }
    
    /**
     *Klasa obsługująca działenie przycisku menu_f_1, który odpowiada za 
     *umożliwienie rozpoczęcia rozgrywki
     *<br>Wyświetlane jest okno z wyborem poziomu 
     */
    private static class Nowa_Gra implements ActionListener
    {

        /**
         *W momencie wciśnięcia przycisku odpowiednie okna są wyświetlane lub ukrywane
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        { 
           window.menu_f.setVisible(true);
           window.poziom_f.setVisible(true);
           window.gra_f.setVisible(false); 
        }
    }

    /**
     *Klasa obsługująca działenie przycisku menu_f_2, który odpowiada za 
     *wyświetlenie informacji o tym jak grać w grę oraz o autorze gry
     */
    public static class Jak_Grac implements ActionListener 
    {

        /**
         *W momencie wciśnięcia przycisku odpowiednie okna są wyświetlane lub ukrywane
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            window.jak_grac_f.setVisible(true);
        }
    }

    /**
     *Klasa obsługująca działenie przycisku menu_f_3, który odpowiada za 
     * zamknięcie programu
     */
    public static class Wyjscie implements ActionListener 
    {

        /**
         *W momencie wciśnięcia przycisku program jest zamykany
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
          System.exit(0);
        }
    }
    
    /**
     *Klasa obsługująca działenie przycisku poziom_1, który odpowiada za 
     * wyświetlenie okna z Poziomem Róźowym
     * @see gra_f
     */
    public static class Poziom_1 implements ActionListener 
    {

        /**
         *W momencie wciśnięcia przycisku odpowiednie okna są wyświetlane lub ukrywane
         * oraz wywyoływana jest funkcji losowości
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
           window.menu_f.setVisible(false);
           window.poziom_f.setVisible(false);
           window.gra_f.setVisible(true);   
           losowosc();
        }       
    }
    
    /**
     *Klasa obsługująca działenie przycisku poziom_2, który odpowiada za 
     * oraz wywyoływana jest funkcji losowości
     * wyświetlenie okna z Poziomem Niebieskim
     * @see gra_f_2
     */
    public static class Poziom_2 implements ActionListener 
    {

        /**
         *W momencie wciśnięcia przycisku odpowiednie okna są wyświetlane lub ukrywane
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
           window.menu_f.setVisible(false);
           window.poziom_f.setVisible(false);
           window.gra_f_2.setVisible(true);   
           losowosc();
        }       
    }
    
    /**
     *Klasa obsługująca działenie przycisku poziom_2, który odpowiada za 
     * wyświetlenie okna z Poziomem Niebieskim
     * oraz wywyoływana jest funkcji losowości
     * @see gra_f_2
     */
    public static class Poziom_3 implements ActionListener 
    {

        /**
         *W momencie wciśnięcia przycisku odpowiednie okna są wyświetlane lub ukrywane
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            window.menu_f.setVisible(false);
            window.poziom_f.setVisible(false);
            window.gra_f_3.setVisible(true);   
            losowosc();
        }       
    }

//początek dot. poziomu różowego- przyciski do wyboru obrazków i metoda sprawdzająca

    /**Klasa obsługująca działenie przycisku obrazek_1, któremu przypisany jest 
     * dany obrazek
     * <br>W metodzie sprawdzanie zależnie od wciśniętego przucisku sprawdzana 
     * będzie zgodność z wyświetlonym napisem
     * @see K#sprawdzanie(int) 
     */
    
    public static class Spr_1 implements ActionListener
    {

        /**
         *W momencie wciśnięcia przycisku ustawiana jest wartość parametru 
         * wcisniety_przycisk oraz wywoływana jest metoda 
         * sprawdzanie(wcisniety_przycisk), w której sprawdzana jest zgodność z
         * wyświetlolnym napisem
         * <br>Wywoływana jest również metoda klasy Gra game.repaint(), 
         * która odpowiada za narysowanie odpowiedniego napisu Canvasie  
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            wcisniety_przycisk = 1;
            sprawdzanie (wcisniety_przycisk);
            game.repaint();
        }
    }
    
     /**Klasa obsługująca działenie przycisku obrazek_2, któremu przypisany jest 
     * dany obrazek
     * <br>W metodzie sprawdzanie zależnie od wciśniętego przucisku sprawdzana 
     * będzie zgodność z wyświetlonym napisem
     * @see K#sprawdzanie(int) 
     */
    public static class Spr_2 implements ActionListener
    {

        /**
         *W momencie wciśnięcia przycisku ustawiana jest wartość parametru 
         * wcisniety_przycisk oraz wywoływana jest metoda 
         * sprawdzanie(wcisniety_przycisk), w której sprawdzana jest zgodność z
         * wyświetlolnym napisem
         * <br>Wywoływana jest również metoda klasy Gra game.repaint(), 
         * która odpowiada za narysowanie odpowiedniego napisu Canvasie  
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            wcisniety_przycisk = 2;
            sprawdzanie (wcisniety_przycisk);
            game.repaint();

        }
    }
    
     /**Klasa obsługująca działenie przycisku obrazek_3, któremu przypisany jest 
     * dany obrazek
     * <br>W metodzie sprawdzanie zależnie od wciśniętego przucisku sprawdzana 
     * będzie zgodność z wyświetlonym napisem
     * @see K#sprawdzanie(int) 
     */
    public static class Spr_3 implements ActionListener
    {

         /**
         *W momencie wciśnięcia przycisku ustawiana jest wartość parametru 
         * wcisniety_przycisk oraz wywoływana jest metoda 
         * sprawdzanie(wcisniety_przycisk), w której sprawdzana jest zgodność z
         * wyświetlolnym napisem
         * <br>Wywoływana jest również metoda klasy Gra game.repaint(), 
         * która odpowiada za narysowanie odpowiedniego napisu Canvasie  
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
           wcisniety_przycisk = 3; 
           sprawdzanie (wcisniety_przycisk);
           game.repaint();
        }
    }
    
    /**Klasa obsługująca działenie przycisku obrazek_4, któremu przypisany jest 
    * dany obrazek
    * <br>W metodzie sprawdzanie zależnie od wciśniętego przucisku sprawdzana 
    * będzie zgodność z wyświetlonym napisem
    * @see K#sprawdzanie(int) 
    */
    public static class Spr_4 implements ActionListener
    {

         /**
         *W momencie wciśnięcia przycisku ustawiana jest wartość parametru 
         * wcisniety_przycisk oraz wywoływana jest metoda 
         * sprawdzanie(wcisniety_przycisk), w której sprawdzana jest zgodność z
         * wyświetlolnym napisem
         * <br>Wywoływana jest również metoda klasy Gra game.repaint(), 
         * która odpowiada za narysowanie odpowiedniego napisu Canvasie  
         * @param ae domyślny parametr umożliwiający wykonanie reakcji na kliknięcie przycisku
         */
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            wcisniety_przycisk = 4;
            sprawdzanie (wcisniety_przycisk);
            game.repaint();
        }
    }
    
    
    /**
     * Funkcja sprawdzająca poprawność wciśniętych przycisków w poziomie różowym
     * względem wyświetlonego napisu
     * @param w_przycisk ustawiany jest zgodnie ze wciśnietym przyciskiem 
     * i zgodnie zjego wartością wykonywane są kolejne czynności takie jak
     * wyświetlenie odpowiedniego okna z informacja o dobrym lub złym ruchu,
     * zmiana wartości odpowiedniego parametru, w celu umożliwienia wyświetlenia 
     * kolejnego napisu lub wyświetlenie okna z informacją o ukończeniu poziomu
     * po czym nastąpi przekierowanie do Menu 
     */
    public static void sprawdzanie(int w_przycisk) 
    
    {
        

        switch(w_przycisk)
        {
            case 1:
            {
                if (w_przycisk == game.nr_level)
                {
                    licznik++;
                    if(licznik >= 4)
                        {
                            licznik = 0; 
                            JOptionPane.showMessageDialog(null, "Brawo wygrałeś!","BRAWO!", JOptionPane.INFORMATION_MESSAGE);
                            window.menu_f.setVisible(true);
                            window.poziom_f.setVisible(false);
                            window.gra_f.setVisible(false);
                        }
                   
                    game.nr_level = tab.get(licznik);
                    
                }
                
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz","UWAGA!", JOptionPane.INFORMATION_MESSAGE);
                }
                
                break;   
            }
            
             case 2:
            {
                if (w_przycisk == game.nr_level)
                {
                    licznik++;
                    if(licznik >= 4)
                        {
                            licznik = 0;  
                            JOptionPane.showMessageDialog(null, "Brawo wygrałeś!","BRAWO!", JOptionPane.INFORMATION_MESSAGE);
                            window.menu_f.setVisible(true);
                            window.poziom_f.setVisible(false);
                            window.gra_f.setVisible(false);
                        }
                    game.nr_level = tab.get(licznik);
                    
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz","UWAGA!", JOptionPane.INFORMATION_MESSAGE);
                }
                
                break;   
            }
            
             case 3:
            {
                if (w_przycisk == game.nr_level)
                {
                    licznik++;
                    if(licznik >= 4)
                        {
                            licznik = 0;  
                            JOptionPane.showMessageDialog(null, "Brawo wygrałeś!","BRAWO!", JOptionPane.INFORMATION_MESSAGE);
                            window.menu_f.setVisible(true);
                            window.poziom_f.setVisible(false);
                            window.gra_f.setVisible(false);;
                        }
                    game.nr_level = tab.get(licznik);
                    
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz","UWAGA!", JOptionPane.INFORMATION_MESSAGE);
                }
                
                break;   
            }
            
            case 4:
            {
                if (w_przycisk == game.nr_level)
                {
                    licznik++;
                    if(licznik >= 4)
                        {
                            licznik = 0; 
                            JOptionPane.showMessageDialog(null, "Brawo wygrałeś!","BRAWO!", JOptionPane.INFORMATION_MESSAGE);
                            window.menu_f.setVisible(true);
                            window.poziom_f.setVisible(false);
                            window.gra_f.setVisible(false);
                        }
                    game.nr_level = tab.get(licznik);
                    
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz","UWAGA!", JOptionPane.INFORMATION_MESSAGE);
                }
                
                break;   
            }
        }
        
         
    }
    
    /**Metoda ta odpowiada za randomizacje gry.
    *<br> Losowane są liczby z przedziału 1-4 i wpisujemu je do ArrayListy tab
    *<br> Kolejne pozycje z listy tab są przypisywane do zmiennych odpowiadających za zmianę 
    *wyświtlanych napisó w kolejnych poziomach
    */
    public static void losowosc ()
    {
        tab.clear();
        while(true)
        {
            Integer kolejnosc;
            Random generator = new Random ();
            kolejnosc = generator.nextInt(4)+1;     //losujemu liczbę z przedziału 1-4
            if(!tab.contains(kolejnosc))            //dodajemu wylosowane liczby do tablicy
            {
                tab.add(kolejnosc);
            }
            if(tab.size()==4)
            {
                break;
            }
        }
        
        game.nr_level = tab.get(licznik);
        game_2.numer_level = tab.get(licznik);
        game_3.numer_level = tab.get(licznik);
        
        
    }
}

    

