package dao;

import model.Produs;

import java.util.List;

/**
 * Clasa care contine metode/operatii pe tebelul "Produs", folosindu-se tehnica de Reflection. Extinde clasa AbstractDAO
 * pentru a avea posibilitatea de a folosi metodele de tip Reflection.
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 18th 2021
 */
public class ProdusDAO2 extends AbstractDAO<Produs>{

    /**
     * Constructorul clasei care apeleaza super constructorul din clasa AbstractDAO.
     * @param type Obiect de tipul Class{@literal <Produs>} pentru a se putea folosi metodele pe obiectul de clasa Produs.
     */
    public ProdusDAO2(Class<Produs> type) {
        super(type);
    }
    /**
     * Metoda de cautare a unui produs dupa ID-ul sau.
     * @param id ID-ul produsului.
     * @return Obiect de tip Produs.
     */
    public Produs findByIdProdus(int id){
        Produs produs=findById(id,"idProdus");
        return produs;
    }
    /**
     * Metoda de cautare si afisare a tuturor inregistrarilor din tabelul "Produs".
     * @return Lista de produse existente in tabel.
     */
    public List<Produs> findAllProdus(){
        List<Produs> lista= findAll();
        return lista;
    }
    /**
     * Metoda de stergere a unui produs in functie de ID-ul sau.
     * @param id ID-ul produsului.
     */
    public void deleteByIdProdus(int id){
        deleteById(id,"idProdus");
    }
}
