package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Klasa za narudzbe
 * @author Nejra
 */
public class Narudzba implements Idable{
    private int id;
    private int idKorisnik;
    private String cijena;
    private String naziv;

    /**
     * Konstruktor sa svim parametrima
     * @param id
     * @param idKorisnik
     * @param cijena
     */
    public Narudzba(int id, int idKorisnik, String cijena, String naziv) {
        this.id = id;
        this.idKorisnik = idKorisnik;
        this.cijena = cijena;
        this.naziv = naziv;
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
    public int getKorisnik() {
        return idKorisnik;
    }

    public void setKorisnik(int idK) {
        this.idKorisnik = idK;
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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * Ispis narudzbe
     * @return id naruzbe. korisnika koji je narucio i cijenu narudzbe
     */
    @Override
    public String toString() {
        return "Narudzba{" +
                "id=" + id +
                ",id korisnika=" + idKorisnik +
                ", cijena='" + cijena + '\'' +
                '}';
    }

    /**
     * Porede se dvije narudzbe
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Narudzba narudzba = (Narudzba) o;
        return id == narudzba.id && idKorisnik == narudzba.idKorisnik && Objects.equals(cijena, narudzba.cijena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idKorisnik, cijena);
    }
}
