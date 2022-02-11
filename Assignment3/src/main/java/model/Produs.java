package model;
/**
 * Aceasta este clasa care contine informatiile legate de tebelul "Produs".
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 17th 2021
 */
public class Produs {
    /**
     * ID-ul produsului.
     */
    private int idProdus;
    /**
     * Numele produsului.
     */
    private String numeProdus;
    /**
     * Cantitatea din stoc a produsului.
     */
    private int cantitate;

    /**
     * Constructorul cu parametrii clasei.
     * @param idProdus ID-ul produsului care va fi creat.
     * @param numeProdus Numele produslui care va fi creat.
     * @param cantitate Cantitatea din stoc a produsului.
     */
    public Produs(int idProdus, String numeProdus, int cantitate){
        this.idProdus=idProdus;
        this.numeProdus=numeProdus;
        this.cantitate=cantitate;
    }

    /**
     * Constructor fara parametrii folosit in contextul metodelor din AbstractDAO.
     */
    public Produs(){}

    /**
     * Get-er pentru ID-ul produsului.
     * @return ID-ul produsului.
     */
    public int getIdProdus(){
        return this.idProdus;
    }

    /**
     * Get-er pentru numele produsului.
     * @return Numele produsului
     */
    public String getNumeProdus(){
        return this.numeProdus;
    }

    /**
     * Get-er pentru cantitatea din stoc a produsului.
     * @return Cantitatea din stoc a produsului
     */
    public int getCantitate(){
        return this.cantitate;
    }

    /**
     * Metoda care returneaza produsul sub forma unui String usor de interpretat.
     * @return Produsul sub forma unui String.
     */
    public String toString(){
        String mesaj;
        mesaj="Produsul cu numarul / ID-ul "+this.idProdus+", "+this.numeProdus+" se afla in cantitatea de: "+this.cantitate;
        return mesaj;
    }
    public void setIdProdus(int id){
        this.idProdus=id;
    }
    public void setNumeProdus(String nume){
        this.numeProdus=nume;
    }
    public void setCantitate(int cantitate){
        this.cantitate=cantitate;
    }
}
