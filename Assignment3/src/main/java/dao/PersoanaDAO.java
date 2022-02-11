package dao;

import connection.ConnectionSql;
import model.Persoana;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clasa care contine metode/operatii pe tebelul "Persoana".
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 18th 2021
 */
public class PersoanaDAO {
    /**
     * Logger-ul pentru conexiunea la baza de date.
     */
    protected static final Logger LOGGER = Logger.getLogger(PersoanaDAO.class.getName());
    /**
     * Variabila instanta sub forma de String care contine operatia de insert pentru baza de date pe tabelul Persoana.
     */
    private static final String insertPersoanaStatementString = "INSERT INTO persoana (idPersoana,numePersoana,emailPersoana)"
            + " VALUES (?,?,?)";
    /**
     * Variabila instanta sub forma de String care contine interogare pentru cautarea unei persoane in functie de numele sau.
     */
    private final static String findPersoanaByNumeStatementString = "SELECT * FROM persoana where numePersoana = ?";
    /**
     * Variabila instanta sub forma de String care contine interogare pentru cautarea unei persoane in functie de adresa sa de email.
     */
    private final static String findPersoanaByEmailStatementString = "SELECT * FROM persoana where emailPersoana = ?";
    /**
     * Variabila instanta sub forma de String care contine operatia de stergere a unei persoane in functie de numele sau.
     */
    private final static String deletePersoanaByNumeString = "DELETE from persoana where numePersoana = ?";
    /**
     * Variabila instanta sub forma de String care contine operatia de stergere a unei persoane in functie de adresa sa de email.
     */
    private final static String deletePersoanaByEmailString = "DELETE from persoana where emailPersoana = ?";
    /**
     * Variabila instanta sub forma de String care contine operatia de "SET" a numelui si adresei de email ale unei persoanei, in functie
     * de ID-ul sau.
     */
    private final static String setNumeEmailPersoanaByIdString= "UPDATE persoana SET numePersoana = ? , emailPersoana = ? WHERE idPersoana = ? ";
    /**
     * Variabila instanta sub forma de String care contine operatia de "SET" ID-ului unei persoanei, in functie
     * de numele sau.
     */
    private final static String setIdPersoanaByNumeString= "UPDATE persoana SET idPersoana = ? WHERE numePersoana = ? ";

    /**
     * Metoda de cautare a unei persoane in functie de numele sau.
     * @param numePersoana Numele persoanei cautate.
     * @return Persoana cautata.
     */
    public static Persoana findPersoanaByNume(String numePersoana){
        Persoana toReturn=null;

        Connection dbConnection=ConnectionSql.getConnection();
        PreparedStatement findNumeStatement=null;
        ResultSet resultSet=null;
        try{
            findNumeStatement=dbConnection.prepareStatement(findPersoanaByNumeStatementString);
            findNumeStatement.setString(1, numePersoana);
            resultSet=findNumeStatement.executeQuery();
            resultSet.next();

            int idPersoana=resultSet.getInt("idPersoana");
            String emailPersoana=resultSet.getString("emailPersoana");
            toReturn=new Persoana(idPersoana,numePersoana,emailPersoana);
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING,"PersoanaDAO:findByName" + e.getMessage());
        }
        finally{
            ConnectionSql.close(resultSet);
            ConnectionSql.close(findNumeStatement);
            ConnectionSql.close(dbConnection);
        }
        return toReturn;
    }
    /**
     * Metoda de cautare a unei persoane in functie de adresa sa de email.
     * @param emailPersoana Adresa de email a persoanei cautate.
     * @return Persoana cautata.
     */
    public static Persoana findPersoanaByEmail(String emailPersoana){
        Persoana toReturn=null;

        Connection dbConnection=ConnectionSql.getConnection();
        PreparedStatement findEmailStatement=null;
        ResultSet resultSet=null;
        try{
            findEmailStatement=dbConnection.prepareStatement(findPersoanaByEmailStatementString);
            findEmailStatement.setString(1, emailPersoana);
            resultSet=findEmailStatement.executeQuery();
            resultSet.next();

            int idPersoana=resultSet.getInt("idPersoana");
            String numePersoana=resultSet.getString("numePersoana");
            toReturn=new Persoana(idPersoana,numePersoana,emailPersoana);
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING,"PersoanaDAO:findByEmail" + e.getMessage());
        }
        finally{
            ConnectionSql.close(resultSet);
            ConnectionSql.close(findEmailStatement);
            ConnectionSql.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * Metoda de inserare a unei persoane.
     * @param persoana Persoana de inserat.
     */
    public static void insertPersoana(Persoana persoana) {
        Connection dbConnection = ConnectionSql.getConnection();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(insertPersoanaStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, persoana.getIdPersoana());
            insertStatement.setString(2, persoana.getNumePersoana());
            insertStatement.setString(3, persoana.getEmailPersoana());
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "PersoanaDAO:insert " + e.getMessage());
        } finally {
            ConnectionSql.close(insertStatement);
            ConnectionSql.close(dbConnection);
        }
    }


    /**
     * Metoda de stergere a unei persoane in functie de numele sau.
     * @param numePersoana Numele persoanei.
     */
    public static void deletePersoanaByNume(String numePersoana){
        Connection dbConnection=ConnectionSql.getConnection();
        PreparedStatement deleteByNumeStatement=null;
        try{
            deleteByNumeStatement= dbConnection.prepareStatement(deletePersoanaByNumeString, Statement.RETURN_GENERATED_KEYS);
            deleteByNumeStatement.setString(1,numePersoana);
            deleteByNumeStatement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING,"PersoanaDAO:deleteByNume" + e.getMessage());
        }
        finally{
            ConnectionSql.close(deleteByNumeStatement);
            ConnectionSql.close(dbConnection);
        }
    }
    /**
     * Metoda de stergere a unei persoane in functie de adresa sa de email.
     * @param emailPersoana Adresa de email a persoanei.
     */
    public static void deletePersoanaByEmail(String emailPersoana){
        Connection dbConnection=ConnectionSql.getConnection();
        PreparedStatement deleteByEmailStatement=null;
        try{
            deleteByEmailStatement= dbConnection.prepareStatement(deletePersoanaByEmailString, Statement.RETURN_GENERATED_KEYS);
            deleteByEmailStatement.setString(1,emailPersoana);
            deleteByEmailStatement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING,"PersoanaDAO:deleteByEmail" + e.getMessage());
        }
        finally{
            ConnectionSql.close(deleteByEmailStatement);
            ConnectionSql.close(dbConnection);
        }
    }

    /**
     * Metoda de modificare a numelui si adresei de email a persoanei in functie de ID-ul sau.
     * @param idPersoana ID-ul persoanei.
     * @param numePersoana Numele persoanei.
     * @param emailPersoana Adresa de email a persoanei.
     */
    public static void setNumeEmailPersoanaById(int idPersoana, String numePersoana, String emailPersoana){
        Connection dbConnection=ConnectionSql.getConnection();
        PreparedStatement setNumeEmailByIdStatement=null;
        try{
            setNumeEmailByIdStatement=dbConnection.prepareStatement(setNumeEmailPersoanaByIdString);
            setNumeEmailByIdStatement.setString(1, numePersoana);
            setNumeEmailByIdStatement.setString(2,emailPersoana);
            setNumeEmailByIdStatement.setInt(3,idPersoana);
            setNumeEmailByIdStatement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING,"PersoanaDAO:setNumeEmailPersoanaById" + e.getMessage());
        }
        finally{
            ConnectionSql.close(setNumeEmailByIdStatement);
            ConnectionSql.close(dbConnection);
        }
    }
    /**
     * Metoda de modificare a ID-ului persoanei in functie de numele sau.
     * @param idPersoana ID-ul persoanei.
     * @param numePersoana Numele persoanei.
     */
    public static void setIdPersoanaByNume(int idPersoana, String numePersoana){
        Connection dbConnection=ConnectionSql.getConnection();
        PreparedStatement setIdPersoanaByNumeStatement=null;
        try{
            setIdPersoanaByNumeStatement=dbConnection.prepareStatement(setIdPersoanaByNumeString);
            setIdPersoanaByNumeStatement.setInt(1, idPersoana);
            setIdPersoanaByNumeStatement.setString(2,numePersoana);
            setIdPersoanaByNumeStatement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING,"PersoanaDAO:setIdPersoanaByNume" + e.getMessage());
        }
        finally{
            ConnectionSql.close(setIdPersoanaByNumeStatement);
            ConnectionSql.close(dbConnection);
        }
    }


}
