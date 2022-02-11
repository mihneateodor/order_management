package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * Aceasta este clasa care realizeaza interfata pentru operatiile pe tabelul "Comanda".
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 17th 2021
 */
public class ComandaView extends JFrame {
    /**
     * Continutul din fereastra.
     */
    private JPanel continut=new JPanel();
    /**
     * Eticheta pentru informatiile din partea stanga a tabelului in contextul operatiilor.
     */
    private JLabel alegeOperatie=new JLabel("Alege operatia");
    /**
     * Eticheta corespunzatoare casetei text pentru ID-ul comenzii.
     */
    private JLabel idComanda=new JLabel("ID Comanda");
    /**
     * Eticheta corespunzatoare casetei text pentru ID-ul persoanei.
     */
    private JLabel idPersoana=new JLabel("ID Persoana");
    /**
     * Eticheta corespunzatoare casetei text pentru ID-ul produsului.
     */
    private JLabel idProdus=new JLabel("ID Produs");
    /**
     * Eticheta corespunzatoare casetei text pentru cantitatea de produse din comanda.
     */
    private JLabel cantitate= new JLabel("Cantitate");
    /**
     * Lista de selectie pentru operatii.
     */
    private JComboBox comboBoxOperatii = new JComboBox();
    /**
     * Caseta text pentru ID-ul comenzii.
     */
    private JTextField idComandaTF=new JTextField();
    /**
     * Caseta text pentru ID-ul persoanei.
     */
    private JTextField idPersoanaTF = new JTextField();
    /**
     * Caseta text pentru ID-ul produsului.
     */
    private JTextField idProdusTF = new JTextField();
    /**
     * Caseta text pentru cantitatea de produse din comanda.
     */
    private JTextField cantitateTF = new JTextField();
    /**
     * Butonul pentru rularea operatiei selectate.
     */
    private JButton butonRun = new JButton("RUN");
    /**
     * Tabelul in care se vor afisa informatiile operatiilor.
     */
    private JTable tabel = new JTable();
    /**
     * Fereastra in care se va afisa tabelul.
     */
    private JScrollPane scrPane=new JScrollPane(tabel);

    /**
     * Constructorul clasei, asaza fiecare componenta si o configureaza pentru a fi folosita in interfata.
     */
    public ComandaView(){
        this.setBounds(100, 100, 919, 683);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        continut.setLayout(null);
        this.setTitle("Comanda - Operatii");

        alegeOperatie.setFont(new Font("Tahoma", Font.PLAIN, 14));
        alegeOperatie.setBounds(114, 28, 264, 25);
        continut.add(alegeOperatie);
        idComanda.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idComanda.setBounds(382, 60, 145, 31);
        continut.add(idComanda);
        idPersoana.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idPersoana.setBounds(382, 101, 145, 31);
        continut.add(idPersoana);
        idProdus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idProdus.setBounds(382, 142, 145, 31);
        continut.add(idProdus);
        cantitate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cantitate.setBounds(382, 181, 145, 31);
        continut.add(cantitate);

        comboBoxOperatii.setBounds(114, 63, 173, 25);
        comboBoxOperatii.addItem("ADD");
        comboBoxOperatii.addItem("FIND");
        comboBoxOperatii.addItem("DELETE");
        comboBoxOperatii.addItem("VIEW ALL");
        continut.add(comboBoxOperatii);

        idComandaTF.setBounds(492, 66, 96, 19);
        continut.add(idComandaTF);
        idPersoanaTF.setBounds(492, 109, 96, 19);
        continut.add(idPersoanaTF);
        idProdusTF.setBounds(492, 150, 96, 19);
        continut.add(idProdusTF);
        cantitateTF.setBounds(492, 189, 96, 19);
        continut.add(cantitateTF);

        butonRun.setFont(new Font("Tahoma", Font.BOLD, 20));
        butonRun.setBounds(685, 121, 96, 52);
        continut.add(butonRun);

        scrPane.setBounds(62, 229, 774, 258);
        tabel.setVisible(true);
        tabel.setModel(new DefaultTableModel());
        continut.add(scrPane);

        this.setContentPane(continut);
    }

    /**
     * Metoda care returneaza tabelul cu informatii ale clasei "Comanda".
     * @return Tabelul cu informatii.
     */
    public JTable getTabel(){ return this.tabel;}

    /**
     * Metoda care obtine selectia curenta din caseta ComboBox pentru alegerea operatiei.
     * @return String-ul curent, selectat de utilizator in ComboBox.
     */
    public String getComboBox(){
        return this.comboBoxOperatii.getSelectedItem().toString();
    }

    /**
     * Metoda de resetare a casetelor text din fereastra.
     */
    public void resetStrings(){
        this.idProdusTF.setText("");
        this.idPersoanaTF.setText("");
        this.idComandaTF.setText("");
        this.cantitateTF.setText("");
    }
    /**
     *Metoda care obtine informatia din caseta text a ID-ului comenzii.
     *@return String-ul din caseta text.
     */
    public String getIdComanda(){
        return this.idComandaTF.getText();
    }

    /**
     * Metoda care obtine informatia din caseta text a ID-ului persoanei.
     * @return String-ul din caseta text.
     */
    public String getIdPersoana(){
        return this.idPersoanaTF.getText();
    }

    /**
     * Metoda care obtine informatia din caseta text a ID-ului produsului.
     * @return String-ul din caseta text.
     */
    public String getIdProdus(){
        return this.idProdusTF.getText();
    }

    /**
     * Metoda care obtine informatia din caseta text a cantitatii produsului comenzii.
     * @return String-ul din caseta text.
     */
    public String getCantitate(){
        return this.cantitateTF.getText();
    }
    /**
     * Metoda care asigura conexiunea intre buton si operatiile pe tabel.
     * @param a Obiect care genereaza o actiune la apasarea butonului.
     */
    public void runComandaButonActionListener(ActionListener a){
        butonRun.addActionListener(a);
    }
}
