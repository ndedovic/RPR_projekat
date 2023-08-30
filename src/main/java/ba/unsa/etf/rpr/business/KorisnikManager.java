package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.util.List;

/**
 * Sloj biznis logike za upravljanje korisnicima
 */
public class KorisnikManager {
    public void obrisiKorisnika(int id) throws PekaraException {
        DaoFactory.korisnikDao().delete(id);
    }
    public void dodajKorisnika(Korisnik korisnik) throws PekaraException {
        DaoFactory.korisnikDao().add(korisnik);
    }
    public Korisnik pronadjiKorisnikaPoID(int id) throws PekaraException {
        return DaoFactory.korisnikDao().getById(id);
    }
    public void azurirajKorisnika(Korisnik korisnik) throws PekaraException {
        DaoFactory.korisnikDao().update(korisnik);
    }
    public List<Korisnik> dajSveKorisnike() throws PekaraException {
        return DaoFactory.korisnikDao().getAll();
    }
    public static List<Korisnik> pronadjiKorisnikaPoEmailu(String email) throws PekaraException {
        return DaoFactory.korisnikDao().pronadjiKorisnikaPoEmailu(email);
    }
    public void validacijaImenaKorisnika(String ime) throws PekaraException {
        if (ime == null || ime.length() <= 2 || !ime.matches("^[a-zA-Z]+$"))
            throw new PekaraException("Ime mora sadržavati samo slova, i dužina imena ne smije biti manja ili jednaka 2");

    }
    public void validacijaPrezimenaKupca(String prezime) throws PekaraException {
        if (prezime == null || prezime.length() <= 2 || !prezime.matches("^[a-zA-Z]+$")) {
            throw new PekaraException("Prezime mora sadržavati samo slova, i dužina prezimena ne smije biti manja ili jednaka 2");
        }
    }

}
