package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Aceasta este clasa care realizeaza interfata pentru operatiile pe tabelul "Produs".
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 17th 2021
 */

public class ProdusView extends JFrame {
    /**
     * Continutul din fereastra.
     */
    private JPanel continut=new JPanel();
    /**
     * Eticheta pentru informatiile din partea stanga a tabelului in contextul operatiilor.
     */
    private JLabel labelStanga= new JLabel("<html>\r\nID:<br><br>\r\nNume:<br><br>\r\nCantitate:<br><br>\r\n</html>");
    /**
     * Eticheta pentru informatiile din partea dreapta a tabelului in contextul operatiilor.
     */
    private JLabel labelDreapta = new JLabel("<html>\r\nID:<br><br>\r\nNume:<br><br>\r\nCantitate:<br><br>\r\n</html>");
    /**
     * Eticheta pentru afisarea alegerii operatiei pe tabelul "Produs".
     */
    private JLabel alegeOperatia = new JLabel("Alege operatia");
    /**
     * Caseta text pentru introducerea ID-ului.
     */
    private JTextField idStanga = new JTextField();
    /**
     * Caseta text pentru introducerea numelui.
     */
    private JTextField numeStanga = new JTextField();
    /**
     * Caseta text pentru introducerea cantitatii.
     */
    private JTextField cantitateStanga = new JTextField();
    /**
     * Caseta text pentru introducerea ID-ului in contextul unei operatii.
     */
    private JTextField idDreapta = new JTextField();
    /**
     * Caseta text pentru introducerea numelui in contextul unei operatii.
     */
    private JTextField numeDreapta = new JTextField();
    /**
     * Caseta text pentru introducerea cantitatii in contextul unei operatii.
     */
    private JTextField cantitateDreapta = new JTextField();
    /**
     * Butonul pentru rularea operatiei selectate.
     */
    private JButton butonRun = new JButton("RUN");
    /**
     * Lista de selectie pentru operatii.
     */
    private JComboBox comboBoxOperatii = new JComboBox();
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
    public ProdusView(){
        this.setBounds(100, 100, 919, 683);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        continut.setLayout(null);
        this.setTitle("Produs - Operatii");

        labelStanga.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelStanga.setBounds(40, 160, 47, 127);
        continut.add(labelStanga);
        labelDreapta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelDreapta.setBounds(518, 160, 47, 127);
        continut.add(labelDreapta);
        alegeOperatia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        alegeOperatia.setBounds(120, 23, 264, 25);
        continut.add(alegeOperatia);

        idStanga.setBounds(120, 177, 264, 19);
        continut.add(idStanga);
        numeStanga.setBounds(120, 206, 264, 19);
        continut.add(numeStanga);
        cantitateStanga.setBounds(120, 235, 264, 19);
        continut.add(cantitateStanga);
        idDreapta.setBounds(587, 177, 264, 19);
        continut.add(idDreapta);
        numeDreapta.setBounds(587, 206, 264, 19);
        continut.add(numeDreapta);
        cantitateDreapta.setBounds(587, 235, 264, 19);
        continut.add(cantitateDreapta);

        butonRun.setFont(new Font("Tahoma", Font.BOLD, 20));
        butonRun.setBounds(587, 82, 135, 57);
        continut.add(butonRun);

        comboBoxOperatii.setBounds(120, 58, 173, 25);
        comboBoxOperatii.addItem("ADD");
        comboBoxOperatii.addItem("FIND");
        comboBoxOperatii.addItem("DELETE");
        comboBoxOperatii.addItem("SET");
        comboBoxOperatii.addItem("VIEW ALL");
        continut.add(comboBoxOperatii);

        scrPane.setBounds(40, 276, 812, 219);
        tabel.setVisible(true);
        tabel.setModel(new DefaultTableModel());
        continut.add(scrPane);

        this.setContentPane(continut);
    }

    /**
     * Metoda care returneaza tabelul cu informatii ale clasei "Produs".
     * @return Tabelul cu informatii.
     */
    public JTable getTabel(){ return this.tabel;}

    /**
     * Metoda care asigura conexiunea intre buton si operatiile pe tabel.
     * @param a Obiect care genereaza o actiune la apasarea butonului.
     */
    public void runProdusButonActionListener(ActionListener a){
        butonRun.addActionListener(a);
    }

    /**
     * Metoda care obtine selectia curenta din caseta ComboBox pentru alegerea operatiei.
     * @return String-ul curent, selectat de utilizator in ComboBox.
     */
    public String getComboBoxText(){
        return this.comboBoxOperatii.getSelectedItem().toString();
    }

    /**
     * Metoda de resetare a casetelor text din partea stanga.
     */
    public void resetStanga(){
        this.idStanga.setText("");
        this.numeStanga.setText("");
        this.cantitateStanga.setText("");
    }

    /**
     * Metoda de resetare a casetelor text din partea dreapta.
     */
    public void resetDreapta(){
        this.idDreapta.setText("");
        this.numeDreapta.setText("");
        this.cantitateDreapta.setText("");
    }

    /**
     * Metoda de resetare a tuturor casetelor text din fereastra.
     */
    public void resetStangaDreapta(){
        this.resetStanga();
        this.resetDreapta();
    }

    /**
     * Metoda care obtine informatia din caseta text a ID-ului din stanga.
     * @return String-ul din caseta text.
     */
    public String getIdStanga(){
        return this.idStanga.getText();
    }
    /**
     * Metoda care obtine informatia din caseta text a ID-ului din dreapta.
     * @return String-ul din caseta text.
     */
    public String getIdDreapta(){
        return this.idDreapta.getText();
    }
    /**
     * Metoda care obtine informatia din caseta text a numelui din stanga.
     * @return String-ul din caseta text.
     */
    public String getNumeStanga(){
        return this.numeStanga.getText();
    }
    /**
     * Metoda care obtine informatia din caseta text a numelui din dreapta.
     * @return String-ul din caseta text.
     */
    public String getNumeDreapta(){
        return this.numeDreapta.getText();
    }
    /**
     * Metoda care obtine informatia din caseta text a cantitatii din stanga.
     * @return String-ul din caseta text.
     */
    public String getCantitateStanga(){
        return this.cantitateStanga.getText();
    }
    /**
     * Metoda care obtine informatia din caseta text a cantitatii din dreapta.
     * @return String-ul din caseta text.
     */
    public String getCantitateDreapta(){
        return this.cantitateDreapta.getText();
    }
}
