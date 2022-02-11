package dao;

import model.Comanda;

import java.util.List;
/**
 * Clasa care contine metode/operatii pe tebelul "Comanda", folosindu-se tehnica de Reflection. Extinde clasa AbstractDAO
 * pentru a avea posibilitatea de a folosi metodele de tip Reflection.
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 18th 2021
 */
public class ComandaDAO2 extends AbstractDAO<Comanda>{
    /**
     * Constructorul clasei care apeleaza super constructorul din clasa AbstractDAO.
     * @param type Obiect de tipul Class{@literal <Comanda>} pentru a se putea folosi metodele pe obiectul de clasa Comanda.
     */
    public ComandaDAO2(Class<Comanda> type) {
        super(type);
    }
    /**
     * Metoda de cautare a unei comenzi dupa ID-ul sau.
     * @param id ID-ul comenzii.
     * @return Obiect de tip Comanda.
     */
    public Comanda findByIdComanda(int id){
        Comanda comanda=findById(id,"idComanda");
        return comanda;
    }
    /**
     * Metoda de cautare si afisare a tuturor inregistrarilor din tabelul "Comanda".
     * @return Lista de comenzi existente in tabel.
     */
    public List<Comanda> findAllComanda(){
        List<Comanda> lista= findAll();
        return lista;
    }
    /**
     * Metoda de stergere a unei comenzi in functie de ID-ul sau.
     * @param id ID-ul comenzii.
     */
    public void deleteByIdComanda(int id){
        deleteById(id,"idComanda");
    }
}
