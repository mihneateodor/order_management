package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Aceasta este clasa care realizeaza interfata pentru prima pagina a aplicatiei.
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 17th 2021
 */

public class StartView extends JFrame {

    /**
     * Continutul din fereastra.
     */
    private JPanel continut=new JPanel();
    /**
     * Eticheta pentru utilizator in prezentarea butoanelor interfetei grafice.
     */
    private JLabel eticheta = new JLabel("Alege fereastra");
    /**
     * Buton pentru selectia operatiilor pe tabelul "Persoana".
     */
    private JButton persoane = new JButton("Persoane");
    /**
     * Buton pentru selectia operatiilor pe tabelul "Produs".
     */
    private JButton produse = new JButton("Produse");
    /**
     * Buton pentru selectia operatiilor pe tabelul "Comanda".
     */
    private JButton comenzi = new JButton("Comenzi");

    /**
     * Constructorul clasei, asaza fiecare componenta si o configureaza pentru a fi folosita in interfata.
     */
    public StartView(){
        this.setBounds(100, 100, 569, 216);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        continut.setLayout(null);
        this.setTitle("Start");

        eticheta.setFont(new Font("Tahoma", Font.PLAIN, 18));
        eticheta.setBounds(209, 10, 213, 39);
        continut.add(eticheta);

        persoane.setFont(new Font("Tahoma", Font.PLAIN, 18));
        persoane.setBounds(38, 48, 119, 61);
        continut.add(persoane);
        produse.setFont(new Font("Tahoma", Font.PLAIN, 18));
        produse.setBounds(209, 48, 119, 61);
        continut.add(produse);
        comenzi.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comenzi.setBounds(390, 48, 119, 61);
        continut.add(comenzi);

        this.setContentPane(continut);
    }

    /**
     * Metoda care asigura conexiunea intre buton si operatiile pe tabel.
     * @param a Obiect care genereaza o actiune la apasarea butonului.
     */
    public void persoaneActionListener(ActionListener a){
        persoane.addActionListener(a);
    }
    /**
     * Metoda care asigura conexiunea intre buton si operatiile pe tabel.
     * @param a Obiect care genereaza o actiune la apasarea butonului.
     */
    public void produseActionListener(ActionListener a){
        produse.addActionListener(a);
    }
    /**
     * Metoda care asigura conexiunea intre buton si operatiile pe tabel.
     * @param a Obiect care genereaza o actiune la apasarea butonului.
     */
    public void comenziActionListener(ActionListener a){
        comenzi.addActionListener(a);
    }
}
