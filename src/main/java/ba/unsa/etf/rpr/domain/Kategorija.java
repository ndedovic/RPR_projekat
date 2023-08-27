package ba.unsa.etf.rpr.domain;

/**
 * Klasa za kategorije proizvoda
 * @author Nejra
 */
public class Kategorija implements Idable{

    private int id;
    private String naziv;

    /**
     * Konstruktor sa parametrima
     * @param id
     * @param naziv
     */
    public Kategorija(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    /**
     * Konstruktor bez parametara
     */
    public Kategorija() {
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
}
