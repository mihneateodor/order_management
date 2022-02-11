package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
/**
 * Aceasta este clasa care realizeaza interfata pentru operatiile pe tabelul "Persoana".
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 17th 2021
 */

public class PersoanaView extends JFrame {
    /**
     * Continutul din fereastra.
     */
    private JPanel continut=new JPanel();
    /**
     * Eticheta pentru informatiile din partea stanga a tabelului in contextul operatiilor.
     */
    private JLabel labelStanga= new JLabel("<html>\r\nID:<br><br>\r\nNume:<br><br>\r\nEmail:<br><br>\r\n</html>");
    /**
     * Eticheta pentru informatiile din partea dreapta a tabelului in contextul operatiilor.
     */
    private JLabel labelDreapta = new JLabel("<html>\r\nID:<br><br>\r\nNume:<br><br>\r\nEmail:<br><br>\r\n</html>");
    /**
     * Eticheta pentru afisarea alegerii operatiei pe tabelul "Persoana".
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
     * Caseta text pentru introducerea adresei de email.
     */
    private JTextField emailStanga = new JTextField();
    /**
     * Caseta text pentru introducerea ID-ului in contextul unei operatii.
     */
    private JTextField idDreapta = new JTextField();
    /**
     * Caseta text pentru introducerea numelui in contextul unei operatii.
     */
    private JTextField numeDreapta = new JTextField();
    /**
     * Caseta text pentru introducerea adresei de email in contextul unei operatii.
     */
    private JTextField emailDreapta = new JTextField();
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
    public PersoanaView(){
        this.setBounds(100, 100, 919, 683);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        continut.setLayout(null);
        this.setTitle("Persoana - Operatii");

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
        emailStanga.setBounds(120, 235, 264, 19);
        continut.add(emailStanga);
        idDreapta.setBounds(587, 177, 264, 19);
        continut.add(idDreapta);
        numeDreapta.setBounds(587, 206, 264, 19);
        continut.add(numeDreapta);
        emailDreapta.setBounds(587, 235, 264, 19);
        continut.add(emailDreapta);

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
     * Metoda care returneaza tabelul cu informatii ale clasei "Persoana".
     * @return Tabelul cu informatii.
     */
    public JTable getTabel(){ return this.tabel;}

    /**
     * Metoda care asigura conexiunea intre buton si operatiile pe tabel.
     * @param a Obiect care genereaza o actiune la apasarea butonului.
     */
    public void runPersoanaButonActionListener (ActionListener a){
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
     *Metoda care obtine informatia din caseta text a ID-ului din stanga.
     *@return String-ul din caseta text.
     */
    public String getIdStanga(){
        return this.idStanga.getText();
    }

    /**
     * Metoda care obtine informatia din caseta text a numelui din stanga.
     * @return String-ul din caseta text.
     */
    public String getNumeStanga(){
        return this.numeStanga.getText();
    }

    /**
     * Metoda care obtine informatia din caseta text a adresei de email din stanga.
     * @return String-ul din caseta text.
     */
    public String getEmailStanga(){
        return this.emailStanga.getText();
    }

    /**
     * Metoda care obtine informatia din caseta text a ID-ului din dreapta.
     * @return String-ul din caseta text.
     */
    public String getIdDreapta(){
        return this.idDreapta.getText();
    }

    /**
     * Metoda care obtine informatia din caseta text a numelui din dreapta.
     * @return String-ul din caseta text.
     */
    public String getNumeDreapta(){
        return this.numeDreapta.getText();
    }

    /**
     * Metoda care obtine informatia din caseta text a adresei de email din dreapta.
     * @return String-ul din caseta text.
     */
    public String getEmailDreapta(){
        return this.emailDreapta.getText();
    }

    /**
     * Metoda de resetare a continutului casetelor text din partea dreapta.
     */
    public void resetDreapta(){
        this.numeDreapta.setText("");
        this.idDreapta.setText("");
        this.emailDreapta.setText("");
    }

    /**
     * Metoda de resetare a continutlui casetelor text din partea stanga.
     */
    public void resetStanga(){
        this.numeStanga.setText("");
        this.idStanga.setText("");
        this.emailStanga.setText("");
    }

    /**
     * Metoda de resetare a continuturilor casetelor text.
     */
    public void resetStangaDreapta(){
        this.resetStanga();
        this.resetDreapta();
    }
}
