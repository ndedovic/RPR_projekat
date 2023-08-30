package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.Proizvodi;

/**
 * Klasa napravljena za praćenje trenutnih podataka u aplikaciji
 */
public class ModelManager {
    private static ModelManager instance;
    private Kategorija kategorija;
    private Korisnik korisnik;
    private Narudzba narudzba;
    private Proizvodi proizvod;
    public ModelManager() {
    }

    public static ModelManager getInstance() {
        if (instance == null)
            instance = new ModelManager();
        return instance;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Narudzba getNarudzba() {
        return narudzba;
    }

    public void setNarudzba(Narudzba narudzba) {
        this.narudzba = narudzba;
    }

    public Proizvodi getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvodi proizvod) {
        this.proizvod = proizvod;
    }

}
