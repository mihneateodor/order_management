package dao;

import connection.ConnectionSql;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clasa in care se implementeaza metode pentru operatii pe baza de date(pentru orice tabel) folosind tehnica de Reflection.
 * @param <T> Orice clasa care este un element al bazei de date: "Persoana", "Produs" sau "Comanda".
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 20th 2021
 */
public class AbstractDAO<T> {
    /**
     * Logger-ul pentru conexiunea la baza de date.
     */
    protected static final Logger LOGGER= Logger.getLogger(AbstractDAO.class.getName());
    /**
     * Variabila instanta de orice clasa care este element al bazei de date: "Persoana", "Produs" sau "Comanda".
     */
    private final Class<T> type;

    /**
     * Constructorul clasei care initilizeaza variabila instanta cu tipul clasei din argumentul metodei cand este apelata.
     * @param type Clasa pe care se vor efectua operatii.
     */
    public AbstractDAO(Class<T> type) {
        this.type = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Metoda de creare a unui String care sa reprezinte interogarea pe baza de date pentru "find by id".
     * @param field Coloana din tabel
     * @return Interogarea ca String.
     */
    private String createFindByIdString(String field){
        String mesaj="SELECT * FROM "+type.getSimpleName()+" WHERE "+field+" = ?";
        return mesaj;
    }

    /**
     * Metoda de creare a unui String care sa reprezinte interogarea pe baza de date pentru "find all".
     * @return Interogarea ca String.
     */
    private String createFindAllString(){
        String mesaj="SELECT * FROM "+type.getSimpleName();
        return mesaj;
    }

    /**
     * Metoda de creare a unui String care sa reprezinte interogarea pe baza de date pentru "delete by id".
     * @param field Coloana din tabel
     * @return Interogarea ca String.
     */
    private String createDeleteByIdString(String field){
        String mesaj="DELETE FROM "+type.getSimpleName()+" WHERE "+field+" = ?";
        return mesaj;
    }

    /**
     * Metoda care foloseste tehnica de Reflection care returneaza intreaga lista de elemente dintr-ul tabel, clasa, care se afla in
     * baza de date.
     * @return Lista de elemente din tabel.
     */
    public List<T> findAll(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query=createFindAllString();
        try{
            connection=ConnectionSql.getConnection();
            preparedStatement=connection.prepareStatement(query);
            resultSet=preparedStatement.executeQuery();
            return createObjects(resultSet);
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "AbstractDAO: findAll"+ e.getMessage());
        }
        finally {
            ConnectionSql.close(resultSet);
            ConnectionSql.close(preparedStatement);
            ConnectionSql.close(connection);
        }
        return null;
    }

    /**
     * Metoda care foloseste tehnica de Reflection care sterge un element dintr-un tabel, clasa, care se afla in baza de date,
     * in functie de ID-ul sau.
     * @param id ID-ul elementului din tabel.
     * @param idString Coloana specifica clasei sub forma de String.
     */
    public void deleteById(int id, String idString){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String query=createDeleteByIdString(idString);
        try{
            connection= ConnectionSql.getConnection();
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "AbstractDAO: deleteById"+ e.getMessage());
        }
        finally {
            ConnectionSql.close(preparedStatement);
            ConnectionSql.close(connection);
        }
    }

    /**
     * Metoda care foloseste tehnica de Reflection care cauta un element dintr-un tabel, clasa, in functie de ID-ul sau,
     * dupa care il returneaza.
     * @param id ID-ul elementului din tabel.
     * @param idString Coloana specifica clasei sub forma de String.
     * @return Elementul cautat.
     */
    public T findById(int id, String idString){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String query=createFindByIdString(idString);
        try{
            connection= ConnectionSql.getConnection();
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();

            return createObjects(resultSet).get(0);
        }
        catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "AbstractDAO: findById"+ e.getMessage());
        }
        finally {
            ConnectionSql.close(resultSet);
            ConnectionSql.close(preparedStatement);
            ConnectionSql.close(connection);
        }
        return null;
    }

    /**
     * Metoda care creeaza o lista de obiecte de orice clasa, tabel, din baza de date, dupa care o returneaza.
     * @param resultSet Rezultatul unei interogari.
     * @return Lista de elemente din tabel.
     */
    private List<T> createObjects(ResultSet resultSet){
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }
}
