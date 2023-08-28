package ba.unsa.etf.rpr.domain;

import java.util.Objects;

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

    /**
     * Ispis određenog proizvoda
     * @return
     */
    @Override
    public String toString() {
        return "Proizvodi{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", cijena='" + cijena + '\'' +
                ", kategorija=" + kategorija +
                '}';
    }

    /**
     * Poređenje dva proizvoda
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proizvodi proizvodi = (Proizvodi) o;
        return id == proizvodi.id && Objects.equals(naziv, proizvodi.naziv) && Objects.equals(cijena, proizvodi.cijena) && Objects.equals(kategorija, proizvodi.kategorija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, cijena, kategorija);
    }
}
