package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.util.List;

public interface KorisnikDao extends Dao<Korisnik> {
    List<Korisnik> pronadjiKorisnikaPoID(int id) throws PekaraException;
}
