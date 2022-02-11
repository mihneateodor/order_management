package controller;

import dao.*;
import model.Comanda;
import model.Persoana;
import model.Produs;
import view.ComandaView;
import view.PersoanaView;
import view.ProdusView;
import view.StartView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Clasa "Controller" reprezinta legatura dintre interfetele grafice {@literal <"StartView","PersoanaView","ProdusView","ComandaView">} si
 * operatiile pe tabelele din baza de date.
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 19th 2021
 */
public class Controller {
    /**
     * Variabila instanta de tipul "PersoanaView" pentru a putea afisa si folosi elementele din interfata grafica pentru tabelul "Persoana".
     */
    private PersoanaView persoanaView;
    /**
     * Variabila instanta de tipul "ProdusView" pentru a putea afisa si folosi elementele din interfata grafica pentru tabelul "Produs".
     */
    private ProdusView produsView;
    /**
     * Variabila instanta de tipul "ComandaView" pentru a putea afisa si folosi elementele din interfata grafica pentru tabelul "Comanda".
     */
    private ComandaView comandaView;

    /**
     * Constructorul clasei "Controller" care initializeaza variabile instanta cu valorile corespunzatoare din parametrii.
     * @param startView Parametru de tip "StartView" pentru a putea initializa metodele care actioneaza pe butoanele interfetei grafice.
     * @param persoanaView Parametru de tip "PersoanaView" pentru a putea initializa metodele si butonul ce actioneaza pe elemetele interfetei grafice.
     * @param produsView Parametru de tip "ProdusView" pentru a putea initializa metodele si butonul ce actioneaza pe elementele interfetei grafice.
     * @param comandaView Parametru de tip "ComandaView" pentru a putea initializa metodele si butonul ce actioneaza pe elementele interfetei grafice.
     */
    public Controller(StartView startView, PersoanaView persoanaView, ProdusView produsView, ComandaView comandaView) {
        this.persoanaView = persoanaView;
        this.produsView = produsView;
        this.comandaView = comandaView;
        startView.persoaneActionListener(new PersoaneActionListener());
        startView.produseActionListener(new ProduseActionListener());
        startView.comenziActionListener(new ComenziActionListener());
        persoanaView.runPersoanaButonActionListener(new RunPersoanaButonActionListener());
        produsView.runProdusButonActionListener(new RunProdusButonActionListener());
        comandaView.runComandaButonActionListener(new RunComandaActionListener());
    }

    /**
     * Clasa interna care implementeaza interfata "ActionListener" pentru a putea executa actiunea butonului pentru "Persoana"
     * din "StartView".
     */
    class PersoaneActionListener implements ActionListener {
        /**
         * Suprascrierea metodei "actionPerformed" pentru butonul "Persoane" din "StartView".
         * @param e Generare de eveniment la apasarea butonului.
         */
        public void actionPerformed(ActionEvent e) {
            persoanaView.setVisible(true);
        }
    }
    /**
     * Clasa interna care implementeaza interfata "ActionListener" pentru a putea executa actiunea butonului pentru "Produs"
     * din "StartView".
     */
    class ProduseActionListener implements ActionListener {
        /**
         * Suprascrierea metodei "actionPerformed" pentru butonul "Produse" din "StartView".
         * @param e Generare de eveniment la apasarea butonului.
         */
        public void actionPerformed(ActionEvent e) {
            produsView.setVisible(true);
        }
    }
    /**
     * Clasa interna care implementeaza interfata "ActionListener" pentru a putea executa actiunea butonului pentru "Comanda"
     * din "StartView".
     */
    class ComenziActionListener implements ActionListener {
        /**
         * Suprascrierea metodei "actionPerformed" pentru butonul "Comenzi" din "StartView".
         * @param e Generare de eveniment la apasarea butonului.
         */
        public void actionPerformed(ActionEvent e) {
            comandaView.setVisible(true);
        }
    }

    /**
     * Clasa interna care implementeaza interfata "ActionListener" pentru a putea executa actiunea butonului "RUN" pentru "Persoana"
     * din "PersoanaView".
     */
    class RunPersoanaButonActionListener implements ActionListener {
        /**
         * Suprascrierea metodei "actionPerformed" pentru butonul "RUN" din "PersoanaView".
         * @exception NumberFormatException Exceptie pentru introducerea formatului gresit pentru numere, ex: "12a", "f2" etc.
         * @param e Generare de eveniment la apasarea butonului.
         */
        public void actionPerformed(ActionEvent e) {
            PersoanaDAO2 persdao2=new PersoanaDAO2(Persoana.class);
            if (persoanaView.getComboBoxText().equals("VIEW ALL")) {
                persoanaView.resetStangaDreapta();
                ReflectionClass.reflectionMethod((List)persdao2.findAllPersoana() , persoanaView.getTabel());
            }
            if (persoanaView.getComboBoxText().equals("ADD")) {
                persoanaView.resetDreapta();
                try {
                    String idS, numeS, emailS;
                    Integer idI;
                    idS = persoanaView.getIdStanga();
                    numeS = persoanaView.getNumeStanga();
                    emailS = persoanaView.getEmailStanga();
                    idI = Integer.parseInt(idS);
                    Persoana deAdaugat = new Persoana(idI, numeS, emailS);
                    PersoanaDAO.insertPersoana(deAdaugat);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(persoanaView, "Reintrodu date numerice!");
                }
            }
            if (persoanaView.getComboBoxText().equals("DELETE")) {
                persoanaView.resetDreapta();
                try {
                    String idS, numeS, emailS;
                    Integer idI;
                    idS = persoanaView.getIdStanga();
                    numeS = persoanaView.getNumeStanga();
                    emailS = persoanaView.getEmailStanga();
                    idI = Integer.parseInt(idS);
                    if (!(idS.equals(""))) {
                        persdao2.deleteByIdPersoana(idI);
                    } else if (!(numeS.equals(""))) {
                        PersoanaDAO.deletePersoanaByNume(numeS);
                    } else if (!(emailS.equals(""))) {
                        PersoanaDAO.deletePersoanaByEmail(emailS);
                    } else
                        JOptionPane.showMessageDialog(persoanaView, "Nu ati introdus criteriu de stergere.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(persoanaView, "Reintrodu date numerice!");
                }
            }
            if (persoanaView.getComboBoxText().equals("FIND")) {
                persoanaView.resetDreapta();
                try {
                    String idS, numeS, emailS;
                    Integer idI;
                    idS = persoanaView.getIdStanga();
                    numeS = persoanaView.getNumeStanga();
                    emailS = persoanaView.getEmailStanga();
                    idI = Integer.parseInt(idS);
                    Persoana persoana;
                    if (!(idS.equals(""))) {
                        ReflectionClass.reflectionMethodOneObject(persdao2.findByIdPersoana(idI), persoanaView.getTabel());
                    } else if (!(numeS.equals(""))) {
                        persoana = PersoanaDAO.findPersoanaByNume(numeS);
                        ReflectionClass.reflectionMethodOneObject(persoana, persoanaView.getTabel());
                    } else if (!(emailS.equals(""))) {
                        persoana = PersoanaDAO.findPersoanaByEmail(emailS);
                        ReflectionClass.reflectionMethodOneObject(persoana, persoanaView.getTabel());
                    } else
                        JOptionPane.showMessageDialog(persoanaView, "Nu ati introdus criteriu de cautare.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(persoanaView, "Reintrodu date numerice!");
                }
            }
            if (persoanaView.getComboBoxText().equals("SET")) {
                String idSS, numeSS, emailSS, idDS, numeDS, emailDS;
                Integer idSI = null, idDI = null;
                idSS = persoanaView.getIdStanga();
                numeSS = persoanaView.getNumeStanga();
                emailSS = persoanaView.getEmailStanga();
                idDS = persoanaView.getIdDreapta();
                numeDS = persoanaView.getNumeDreapta();
                emailDS = persoanaView.getEmailDreapta();
                if (!(idSS.equals(""))) {
                    try {
                        idSI = Integer.parseInt(idSS);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(persoanaView, "Reintrodu date numerice ID Stanga!");
                    }
                    if (!(numeDS.equals("")) && !(emailDS.equals(""))) {
                        PersoanaDAO.setNumeEmailPersoanaById(idSI, numeDS, emailDS);
                    }
                } else if (!(numeSS.equals(""))) {
                    try {
                        idDI = Integer.parseInt(idDS);
                        if (!(idDS.equals(""))) {
                            PersoanaDAO.setIdPersoanaByNume(idDI, numeSS);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(persoanaView, "Reintrodu date numerice ID dreapta!");
                    }
                }
            }
        }
    }

    /**
     * Clasa interna care implementeaza interfata "ActionListener" pentru a putea executa actiunea butonului "RUN" pentru "Produs"
     * din "ProdusView".
     */
    class RunProdusButonActionListener implements ActionListener {
        /**
         * Suprascrierea metodei "actionPerformed" pentru butonul "RUN" din "ProdusView".
         * @exception NumberFormatException Exceptie pentru introducerea formatului gresit pentru numere, ex: "12a", "f2" etc.
         * @param e Generare de eveniment la apasarea butonului.
         */
        public void actionPerformed(ActionEvent e) {
            ProdusDAO2 produsDAO2=new ProdusDAO2(Produs.class);
            if (produsView.getComboBoxText().equals("VIEW ALL")) {
                produsView.resetStangaDreapta();
                ReflectionClass.reflectionMethod((List)produsDAO2.findAllProdus(), produsView.getTabel());
            }
            if (produsView.getComboBoxText().equals("ADD")) {
                produsView.resetDreapta();
                try {
                    String idS, numeS, cantitateS;
                    Integer id, cantitate;
                    idS = produsView.getIdStanga();
                    numeS = produsView.getNumeStanga();
                    cantitateS = produsView.getCantitateStanga();
                    id = Integer.parseInt(idS);
                    cantitate = Integer.parseInt(cantitateS);
                    Produs deAdaugat = new Produs(id, numeS, cantitate);
                    ProdusDAO.insertProdus(deAdaugat);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(persoanaView, "Reintrodu date numerice!");
                }
            }
            if (produsView.getComboBoxText().equals("DELETE")) {
                produsView.resetDreapta();
                try {
                    String idS, numeS, cantitateS;
                    Integer id;
                    idS = produsView.getIdStanga();
                    numeS = produsView.getNumeStanga();
                    cantitateS = produsView.getCantitateStanga();
                    id = Integer.parseInt(idS);
                    if (!(idS.equals(""))) {
                        produsDAO2.deleteByIdProdus(id);
                    } else if (!(numeS.equals(""))) {
                        ProdusDAO.deleteProdusByNume(numeS);
                    } else
                        JOptionPane.showMessageDialog(produsView, "Nu ati introdus criteriu de stergere.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(produsView, "Reintrodu date numerice!");
                }
            }
            if (produsView.getComboBoxText().equals("FIND")) {
                produsView.resetDreapta();
                try {
                    String idS, numeS, cantitateS;
                    Integer id, cantitate;
                    idS = produsView.getIdStanga();
                    numeS = produsView.getNumeStanga();
                    id = Integer.parseInt(idS);
                    Produs produs;
                    if (!(idS.equals(""))) {
                        ReflectionClass.reflectionMethodOneObject(produsDAO2.findByIdProdus(id), produsView.getTabel());
                    } else if (!(numeS.equals(""))) {
                        produs = ProdusDAO.findProdusByName(numeS);
                        ReflectionClass.reflectionMethodOneObject(produs, produsView.getTabel());
                    } else
                        JOptionPane.showMessageDialog(produsView, "Nu ati introdus criteriu de cautare.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(produsView, "Reintrodu date numerice!");
                }
            }
            if (produsView.getComboBoxText().equals("SET")) {
                String idSS, numeSS, cantitateSS, idDS, numeDS, cantitateDS;
                Integer idSI = null, idDI = null, cantitateDI = null;
                idSS = produsView.getIdStanga();
                numeSS = produsView.getNumeStanga();
                cantitateSS = produsView.getCantitateStanga();
                idDS = produsView.getIdDreapta();
                numeDS = produsView.getNumeDreapta();
                cantitateDS = produsView.getCantitateDreapta();
                if (!(idSS.equals(""))) {
                    try {
                        idSI = Integer.parseInt(idSS);
                        cantitateDI = Integer.parseInt(cantitateDS);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(produsView, "Reintrodu date numerice ID Stanga!");
                    }
                    if (!(numeDS.equals("")) && !(cantitateDS.equals(""))) {
                        ProdusDAO.setNumeCantitateProdusById(idSI, numeDS, cantitateDI);
                    }
                } else if (!(numeSS.equals(""))) {
                    try {
                        idDI = Integer.parseInt(idDS);
                        if (!(idDS.equals(""))) {
                            ProdusDAO.setIdProdusByNume(idDI, numeSS);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(produsView, "Reintrodu date numerice ID dreapta!");
                    }
                }
            }
        }
    }

    /**
     * Clasa interna care implementeaza interfata "ActionListener" pentru a putea executa actiunea butonului "RUN" pentru "Comanada"
     * din "ComandaView".
     */
    class RunComandaActionListener implements ActionListener {
        /**
         * Suprascrierea metodei "actionPerformed" pentru butonul "RUN" din "ComandaView".
         * @exception NumberFormatException Exceptie pentru introducerea formatului gresit pentru numere, ex: "12a", "f2" etc.
         * @param e Generare de eveniment la apasarea butonului.
         */
        public void actionPerformed(ActionEvent e) {
            PersoanaDAO2 persDAO2=new PersoanaDAO2(Persoana.class);
            ProdusDAO2 produsDAO2=new ProdusDAO2(Produs.class);
            ComandaDAO2 comandaDAO2=new ComandaDAO2(Comanda.class);
            if (comandaView.getComboBox().equals("VIEW ALL")) {
                comandaView.resetStrings();
                ReflectionClass.reflectionMethod((List)comandaDAO2.findAllComanda(), comandaView.getTabel());
            }
            if (comandaView.getComboBox().equals("ADD")) {
                try {
                    String idComandaString, idPersoanaString, idProdusString, cantitateString;
                    Integer idComanda, idPersoana, idProdus, cantitate;
                    idComandaString = comandaView.getIdComanda();
                    idPersoanaString = comandaView.getIdPersoana();
                    idProdusString = comandaView.getIdProdus();
                    cantitateString = comandaView.getCantitate();
                    idComanda = Integer.parseInt(idComandaString);
                    idPersoana = Integer.parseInt(idPersoanaString);
                    idProdus = Integer.parseInt(idProdusString);
                    cantitate = Integer.parseInt(cantitateString);
                    Persoana persoana = persDAO2.findByIdPersoana(idPersoana);
                    Produs produs = produsDAO2.findByIdProdus(idProdus);
                    if (persoana != null && produs != null)
                        ComandaDAO.addComanda(idComanda, persoana.getIdPersoana(), produs.getIdProdus(), cantitate, comandaView);
                    else {
                        if (produs == null && persoana == null) {
                            JOptionPane.showMessageDialog(comandaView, "Nu exista persoana si nici produsul in baza de date!");
                        } else if (produs == null) {
                            JOptionPane.showMessageDialog(comandaView, "Nu exista produsul in baza de date!");
                        } else if (persoana == null) {
                            JOptionPane.showMessageDialog(comandaView, "Nu exista persoana in baza de date!");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(persoanaView, "Reintrodu date numerice!");
                }
            }
            if(comandaView.getComboBox().equals("DELETE")){
                try{
                    String idS=comandaView.getIdComanda();
                    Integer id= Integer.parseInt(idS);
                    if(!(idS.equals(""))){
                        comandaDAO2.deleteByIdComanda(id);
                    }
                    else{
                        JOptionPane.showMessageDialog(comandaView, "Nu ati introdus criteriu de stergere.");
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(comandaView, "Reintrodu date numerice!");
                }
            }
            if(comandaView.getComboBox().equals("FIND")){
                try{
                    String idS= comandaView.getIdComanda();
                    Integer id = Integer.parseInt(idS);
                    if(!(idS.equals(""))){
                        ReflectionClass.reflectionMethodOneObject(comandaDAO2.findByIdComanda(id), comandaView.getTabel());
                    }
                    else
                        JOptionPane.showMessageDialog(produsView, "Nu ati introdus criteriu de cautare.");
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(produsView, "Reintrodu date numerice!");
                }
            }
        }
    }
}
