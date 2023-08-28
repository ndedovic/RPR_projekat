package ba.unsa.etf.rpr.domain;

import java.util.Objects;

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

    /**
     * Ispis kategorije
     * @return string sa id-em i nazivom kategorije
     */
    @Override
    public String toString() {
        return "Kategorija{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategorija that = (Kategorija) o;
        return id == that.id && Objects.equals(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv);
    }
}
