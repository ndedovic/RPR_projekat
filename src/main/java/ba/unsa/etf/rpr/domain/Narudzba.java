package ba.unsa.etf.rpr.domain;

/**
 * Klasa za narudzbe
 * @author Nejra
 */
public class Narudzba implements Idable{
    private int id;
    private Korisnik korisnik;
    private String cijena;

    /**
     * Konstruktor sa svim parametrima
     * @param id
     * @param korisnik
     * @param cijena
     */
    public Narudzba(int id, Korisnik korisnik, String cijena) {
        this.id = id;
        this.korisnik = korisnik;
        this.cijena = cijena;
    }

    /**
     * Konstruktor bez parametara
     */
    public Narudzba() {
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
     * Getter i setter za korisnika
     * @return
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
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
}
