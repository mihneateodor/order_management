package dao;

import connection.ConnectionSql;
import model.Comanda;
import model.Persoana;
import model.Produs;
import view.ComandaView;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clasa care contine metode/operatii pe tebelul "Comanda".
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 18th 2021
 */
public class ComandaDAO {
    /**
     * Logger-ul pentru conexiunea la baza de date.
     */
    protected static final Logger LOGGER = Logger.getLogger(ComandaDAO.class.getName());
    /**
     * Variabila instanta sub forma de String care contine operatia de insert pentru baza de date pe tabelul Comanda.
     */
    private static final String insertComandaString = "INSERT INTO comanda (idComanda, idPersoanaComanda, numePersoanaComanda," +
            "emailPersoanaComanda, idProdusComanda,numeProdusComanda, cantitateComanda) " +
            "VALUES(?,?,?,?,?,?,?)";

    /**
     * Metoda de inserare a unei comenzi.
     * @param comanda Comanda de inserat.
     */
    public static void insertComanda(Comanda comanda) {
        Connection dbConnection = ConnectionSql.getConnection();
        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(insertComandaString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, comanda.getIdComanda());
            insertStatement.setInt(2, comanda.getIdPersoanaComanda());
            insertStatement.setString(3, comanda.getNumePersoanaComanda());
            insertStatement.setString(4, comanda.getEmailPersoanaComanda());
            insertStatement.setInt(5, comanda.getIdProdusComanda());
            insertStatement.setString(6, comanda.getNumeProdusComanda());
            insertStatement.setInt(7, comanda.getCantitateComanda());
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ComandaDAO:insert " + e.getMessage());
        } finally {
            ConnectionSql.close(insertStatement);
            ConnectionSql.close(dbConnection);
        }
    }

    /**
     * Metoda de creare si ulterior inserare a unei comenzi in functie de valorile din parametrii. Se verifica daca cantitatea ceruta
     * in comanda este mai mica decat cea din stoc pentru a se procesa comanda. Ulterior se creeaza un fisier text care sa contina datele
     * comenzii sub forma unei "Facturi de comanda".
     * @param idComanda  ID-ul comenzii.
     * @param idPersoanaComanda ID-ul persoanei care solicita comanda.
     * @param idProdusComanda ID-ul produsuli comandat.
     * @param cantitateComanda Cantitatea produsului care sa fie comandat.
     * @param comandaView Interfata grafica pentru tabelul Comanda.
     */
    public static void addComanda(int idComanda, int idPersoanaComanda, int idProdusComanda, int cantitateComanda, ComandaView comandaView) {
        PersoanaDAO2 persDAO2 = new PersoanaDAO2(Persoana.class);
        Persoana persoana = persDAO2.findByIdPersoana(idPersoanaComanda);
        ProdusDAO2 produsDAO2 = new ProdusDAO2(Produs.class);
        Produs produs = produsDAO2.findByIdProdus(idProdusComanda);
        if (produs.getCantitate() < cantitateComanda) {
            JOptionPane.showMessageDialog(comandaView, "Nu sunt destule elemente in stoc!");
        } else {
            ProdusDAO.setNumeCantitateProdusById(idProdusComanda, produs.getNumeProdus(), produs.getCantitate() - cantitateComanda);
            Comanda comanda = new Comanda(idComanda, idPersoanaComanda, persoana.getNumePersoana(), persoana.getEmailPersoana(), idProdusComanda, produs.getNumeProdus(), cantitateComanda);
            insertComanda(comanda);
            try {
                FileWriter file = new FileWriter("comanda" + idComanda+"_"+ idPersoanaComanda+"_" + idProdusComanda +"_"+ cantitateComanda + ".txt");
                String mesaj = "";
                mesaj = "Detalii factura:\n" + "Comanda cu numarul <" + comanda.getIdComanda() + ">\n";
                mesaj = mesaj + "Clientul numarul <" + comanda.getIdPersoanaComanda() + "> cu numele <" + comanda.getNumePersoanaComanda() + "> " +
                        "a achizitionat produsul <" + comanda.getIdProdusComanda() + "> cu numele <" + comanda.getNumeProdusComanda() +
                        "> in cantitate de <" + comanda.getCantitateComanda() + "> unitati.\n";
                file.write(mesaj);
                file.close();
            } catch (IOException e) {
                System.out.println("Nu s-a putut crea sau scrie in fisier.");
            }
        }
    }
}


