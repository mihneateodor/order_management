package dao;

import connection.ConnectionSql;
import model.Produs;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clasa care contine metode/operatii pe tebelul "Produs".
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 18th 2021
 */
public class ProdusDAO {
    /**
     * Logger-ul pentru conexiunea la baza de date.
     */
    protected static final Logger LOGGER = Logger.getLogger(ProdusDAO.class.getName());
    /**
     * Variabila instanta sub forma de String care contine operatia de insert pentru baza de date pe tabelul Produs.
     */
    private static final String insertProdusStatementString = "INSERT INTO produs (idProdus,numeProdus,cantitate)"
            + " VALUES (?,?,?)";
    /**
     * Variabila instanta sub forma de String care contine interogare pentru cautarea unui produs in functie de numele sau.
     */
    private final static String findProdusByNumeStatementString = "SELECT * FROM produs where numeProdus = ?";

    /**
     * Variabila instanta sub forma de String care contine operatia de stergere a unui produs in functie de numele sau.
     */
    private final static String deleteProdusByNumeString = "DELETE from produs where numeProdus = ?";
    /**
     * Variabila instanta sub forma de String care contine operatia de "SET" a numelui si cantitatii din stoc a unui produs, in functie
     * de numele sau.
     */
    private final static String setNumeCantitateProdusByIdString = "UPDATE produs SET numeProdus = ? , cantitate = ? WHERE idProdus = ?";
    /**
     * Variabila instanta sub forma de String care contine operatia de "SET" a ID-ului unui produs, in functie de numele sau.
     */
    private final static String setIdProdusByNumeString = "UPDATE produs SET idProdus = ? WHERE numeProdus = ?";

    /**
     * Metoda de inserare a unui produs.
     * @param produs Produsul care sa fie inserat.
     */
    public static void insertProdus(Produs produs){
        Connection dbConnection = ConnectionSql.getConnection();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(insertProdusStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, produs.getIdProdus());
            insertStatement.setString(2, produs.getNumeProdus());
            insertStatement.setInt(3, produs.getCantitate());
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProdusDAO:insert " + e.getMessage());
        } finally {
            ConnectionSql.close(insertStatement);
            ConnectionSql.close(dbConnection);
        }
    }

    /**
     * Metoda de cautare a unui produs in functie de numele sau.
     * @param numeProdus Numele produsului.
     * @return Produsul cautat.
     */
    public static Produs findProdusByName(String numeProdus){
        Produs toReturn = null;

        Connection dbConnection = ConnectionSql.getConnection();
        PreparedStatement findNumeStatement = null;
        ResultSet resultSet = null;
        try {
            findNumeStatement = dbConnection.prepareStatement(findProdusByNumeStatementString);
            findNumeStatement.setString(1, numeProdus);
            resultSet = findNumeStatement.executeQuery();
            resultSet.next();

            int idProdus = resultSet.getInt("idProdus");
            int cantitate = resultSet.getInt("cantitate");
            toReturn = new Produs(idProdus, numeProdus, cantitate);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProdusDAO:findByNume " + e.getMessage());
        } finally {
            ConnectionSql.close(resultSet);
            ConnectionSql.close(findNumeStatement);
            ConnectionSql.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * Metoda de stergere a unui produs in functie de numele sau.
     * @param numeProdus Numele produsului.
     */
    public static void deleteProdusByNume(String numeProdus){
        Connection dbConnection=ConnectionSql.getConnection();
        PreparedStatement deleteByNumeStatement=null;
        try{
            deleteByNumeStatement= dbConnection.prepareStatement(deleteProdusByNumeString, Statement.RETURN_GENERATED_KEYS);
            deleteByNumeStatement.setString(1,numeProdus);
            deleteByNumeStatement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING,"ProdusDAO:deleteByNume" + e.getMessage());
        }
        finally{
            ConnectionSql.close(deleteByNumeStatement);
            ConnectionSql.close(dbConnection);
        }
    }

    /**
     * Metoda de modificare a numelui si cantitatii din stoc a unui produs in functie de ID-ul sau.
     * @param idProdus ID-ul produsului.
     * @param numeProdus Numele produsului.
     * @param cantitate Cantitatea din stoc a produsului.
     */
    public static void setNumeCantitateProdusById(int idProdus, String numeProdus, int cantitate){
        Connection dbConnection=ConnectionSql.getConnection();
        PreparedStatement setNumeCantitateByIdStatement=null;
        try{
            setNumeCantitateByIdStatement=dbConnection.prepareStatement(setNumeCantitateProdusByIdString, Statement.RETURN_GENERATED_KEYS);
            setNumeCantitateByIdStatement.setString(1, numeProdus);
            setNumeCantitateByIdStatement.setInt(2,cantitate);
            setNumeCantitateByIdStatement.setInt(3,idProdus);
            setNumeCantitateByIdStatement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING,"ProdusDAO:setNumeCantitateById" + e.getMessage());
        }
        finally{
            ConnectionSql.close(setNumeCantitateByIdStatement);
            ConnectionSql.close(dbConnection);
        }
    }
    /**
     * Metoda de modificare a ID-ului unui produs in functie de numele sau.
     * @param idProdus ID-ul produsului.
     * @param numeProdus Numele produsului.
     */
    public static void setIdProdusByNume(int idProdus, String numeProdus){
        Connection dbConnection=ConnectionSql.getConnection();
        PreparedStatement setIdByNumeStatement=null;
        try{
            setIdByNumeStatement=dbConnection.prepareStatement(setIdProdusByNumeString, Statement.RETURN_GENERATED_KEYS);
            setIdByNumeStatement.setInt(1, idProdus);
            setIdByNumeStatement.setString(2,numeProdus);
            setIdByNumeStatement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING,"ProdusDAO:setIdByNume" + e.getMessage());
        }
        finally{
            ConnectionSql.close(setIdByNumeStatement);
            ConnectionSql.close(dbConnection);
        }
    }

}
