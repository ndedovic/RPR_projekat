package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.util.List;

public class KorisnikManager {
    public static List<Korisnik> pronadjiKorisnikaPoEmailu(String email) throws PekaraException {
        return DaoFactory.korisnikDao().pronadjiKorisnikaPoEmailu(email);
    }
    public static List<Korisnik> pronadjiKorisnikaPoID(int id) throws PekaraException {
        return DaoFactory.korisnikDao().pronadjiKorisnikaPoID(id);
    }
}
