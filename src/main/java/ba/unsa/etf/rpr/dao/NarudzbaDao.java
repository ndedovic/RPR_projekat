package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.util.List;

public interface NarudzbaDao extends Dao<Narudzba> {
    List<Narudzba> pronadjiNarudzbuPoID(int id) throws PekaraException;

    List<Narudzba> pronadjiNarudzbuPoKorisniku(int id) throws PekaraException;
}
