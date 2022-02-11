package dao;

import model.Persoana;

import java.util.List;
/**
 * Clasa care contine metode/operatii pe tebelul "Persoana", folosindu-se tehnica de Reflection. Extinde clasa AbstractDAO
 * pentru a avea posibilitatea de a folosi metodele de tip Reflection.
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 18th 2021
 */
public class PersoanaDAO2 extends AbstractDAO<Persoana>{

    /**
     * Constructorul clasei care apeleaza super constructorul din clasa AbstractDAO.
     * @param type Obiect de tipul Class{@literal <Persoana>} pentru a se putea folosi metodele pe obiectul de clasa Persoana.
     */
    public PersoanaDAO2(Class<Persoana> type) {
        super(type);
    }
    /**
     * Metoda de cautare a unei persoane dupa ID-ul sau.
     * @param id ID-ul persoanei.
     * @return Obiect de tip Persoane.
     */
    public Persoana findByIdPersoana(int id){
        Persoana pers=findById(id,"idPersoana");
        return pers;
    }
    /**
     * Metoda de cautare si afisare a tuturor inregistrarilor din tabelul "Persoana".
     * @return Lista de persoane existente in tabel.
     */
    public List<Persoana> findAllPersoana(){
        List<Persoana> lista= findAll();
        return lista;
    }
    /**
     * Metoda de stergere a unei persoane in functie de ID-ul sau.
     * @param id ID-ul produsului.
     */
    public void deleteByIdPersoana(int id){
        deleteById(id,"idPersoana");
    }
}
