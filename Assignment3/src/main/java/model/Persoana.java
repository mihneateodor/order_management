package model;
/**
 * Aceasta este clasa care contine informatiile legate de tebelul "Persoana".
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 17th 2021
 */
public class Persoana {
    /**
     * ID-ul persoanei.
     */
    private int idPersoana;
    /**
     * Numele persoanei.
     */
    private String numePersoana;
    /**
     * Adresa de email a persoanei.
     */
    private String emailPersoana;

    /**
     * Constructorul cu parametrii clasei.
     * @param idPersoana ID-ul persoanei care va fi creata.
     * @param numePersoana Numele persoanei care va fi creata.
     * @param emailPersoana Adresa de email a persoanei care va fi creata.
     */
    public Persoana(int idPersoana, String numePersoana, String emailPersoana){
        this.idPersoana=idPersoana;
        this.emailPersoana=emailPersoana;
        this.numePersoana=numePersoana;
    }
    /**
     * Constructor fara parametrii folosit in contextul metodelor din AbstractDAO.
     */
    public Persoana(){}
    /**
     * Get-er pentru ID-ul persoanei.
     * @return ID-ul persoanei.
     */
    public int getIdPersoana(){
        return this.idPersoana;
    }
    /**
     * Get-er pentru numele persoanei.
     * @return Numele persoanei.
     */
    public String getNumePersoana(){
        return this.numePersoana;
    }
    /**
     * Get-er pentru adresa de email a persoanei.
     * @return Adresa de email a persoanei.
     */

    public String getEmailPersoana(){
        return this.emailPersoana;
    }
    /**
     * Metoda care returneaza persoana sub forma unui String usor de interpretat.
     * @return Persoana sub forma unui String.
     */
    public String toString(){
        String mesaj;
        mesaj="Persoana cu numarul / ID-ul <"+this.idPersoana+"> se numeste <"+this.numePersoana+"> si are emailul: <"+
                this.emailPersoana+">";
        return mesaj;
    }
    public void setIdPersoana(int id){
        this.idPersoana=id;
    }
    public void setNumePersoana(String nume){
        this.numePersoana=nume;
    }
    public void setEmailPersoana(String email){
        this.emailPersoana=email;
    }
}
