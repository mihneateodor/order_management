package model;
/**
 * Aceasta este clasa care contine informatiile legate de tebelul "Comanda".
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 17th 2021
 */
public class Comanda {
    /**
     * ID-ul comenzii.
     */
    private int idComanda;
    /**
     * ID-ul persoanei care realizeaza comanda.
     */
    private int idPersoanaComanda;
    /**
     * Numele persoane care realizeaza comanda.
     */
    private String numePersoanaComanda;
    /**
     * Adresa de email a persoanei care realizeaza comanda.
     */
    private String emailPersoanaComanda;
    /**
     * ID-ul produsului din comanda.
     */
    private int idProdusComanda;
    /**
     * Numele produsului din comanda.
     */
    private String numeProdusComanda;
    /**
     * Cantitatea produsului solicitata in comanda.
     */
    private int cantitateComanda;

    /**
     * Constructorul cu parametrii clasei.
     * @param idComanda ID-ul comenzii
     * @param idPersoana ID-ul persoanei care realizeaza comanda.
     * @param numePersoanaComanda Numele persoanei care realizeaza comanda.
     * @param emailPersoanaComanda Adresa de email a persoanei care realizeaza comanda.
     * @param idProdus ID-ul produsului din comanda.
     * @param numeProdusComanda Numele produsului din comanda.
     * @param cantitateComanda Cantitatea produsului solicitata in comanda.
     */
    public Comanda( int idComanda, int idPersoana, String numePersoanaComanda,String emailPersoanaComanda, int idProdus,String numeProdusComanda, int cantitateComanda){
        this.idComanda=idComanda;
        this.idPersoanaComanda =idPersoana;
        this.numePersoanaComanda=numePersoanaComanda;
        this.emailPersoanaComanda=emailPersoanaComanda;
        this.idProdusComanda =idProdus;
        this.numeProdusComanda=numeProdusComanda;
        this.cantitateComanda=cantitateComanda;
    }
    /**
     * Constructor fara parametrii folosit in contextul metodelor din AbstractDAO.
     */
    public Comanda(){}
    /**
     * Get-er pentru ID-ul comenzii.
     * @return ID-ul comenzii.
     */
    public int getIdComanda(){
        return this.idComanda;
    }
    /**
     * Get-er pentru ID-ul persoanei.
     * @return ID-ul persoanei.
     */
    public int getIdPersoanaComanda(){
        return this.idPersoanaComanda;
    }
    /**
     * Get-er pentru ID-ul produsului din comanda.
     * @return ID-ul produsului din comanda.
     */
    public int getIdProdusComanda(){
        return this.idProdusComanda;
    }
    /**
     * Get-er pentru cantitatea produsului solicitata in comanda.
     * @return Cantitatea prodului solicitata in comanda.
     */
    public int getCantitateComanda(){
        return this.cantitateComanda;
    }
    /**
     * Get-er pentru numele persoanei care realizeaza comanda.
     * @return Numele persoanei care realizeaza comanda.
     */
    public String getNumePersoanaComanda(){ return this.numePersoanaComanda;}
    /**
     * Get-er pentru adresa de email a persoanei care realizeaza comanda.
     * @return Adresa de email a persoanei care realizeaza comanda.
     */
    public String getEmailPersoanaComanda(){ return this.emailPersoanaComanda;}
    /**
     * Get-er pentru numele produsului din comanda.
     * @return Numele produsului din comanda.
     */
    public String getNumeProdusComanda() { return this.numeProdusComanda;}
    /**
     * Metoda care returneaza comanda sub forma unui String usor de interpretat.
     * @return Comanda sub forma unui String.
     */
    public String toString(){
        String mesaj;
        mesaj="Comanda <"+this.idComanda+"> pentru persoana <"+ this.idPersoanaComanda +"> <"+this.numePersoanaComanda+
                "> <"+this.emailPersoanaComanda+"> pentru produsul <" + this.idProdusComanda +
                "> <"+this.numeProdusComanda+">  in cantitate de <"+this.cantitateComanda+">.";
        return mesaj;
    }
    public void setIdComanda(int id){
        this.idComanda=id;
    }
    public void setNumePersoanaComanda(String nume){
        this.numePersoanaComanda=nume;
    }
    public void setEmailPersoanaComanda(String email){
        this.emailPersoanaComanda=email;
    }
    public void setNumeProdusComanda(String nume){
        this.numeProdusComanda=nume;
    }
    public void setCantitateComanda(int cantitate){
        this.cantitateComanda=cantitate;
    }
    public void setIdPersoanaComanda(int id){
        this.idPersoanaComanda=id;
    }
    public void setIdProdusComanda(int id){
        this.idProdusComanda=id;
    }
}
