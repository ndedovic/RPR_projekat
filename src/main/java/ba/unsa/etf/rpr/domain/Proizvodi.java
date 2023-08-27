package ba.unsa.etf.rpr.domain;

/**
 * Klasa za proizvode
 * @author Nejra
 */
public class Proizvodi implements Idable{

    private int id;
    private String naziv;
    private String cijena;
    private Kategorija kategorija;

    /**
     * Konstruktor sa svim parametrima
     * @param id
     * @param naziv
     * @param cijena
     * @param kategorija
     */
    public Proizvodi(int id, String naziv, String cijena, Kategorija kategorija) {
        this.id = id;
        this.naziv = naziv;
        this.cijena = cijena;
        this.kategorija = kategorija;
    }

    /**
     * Konstruktor bez parametara
     */
    public Proizvodi() {
    }

    /**
     * Getter i setter za id
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter i setter za naziv
     * @return
     */
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * Getter i setter za cijenu
     * @return
     */
    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }

    /**
     * Getter i setter za kategoriju
     * @return
     */
    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
}
