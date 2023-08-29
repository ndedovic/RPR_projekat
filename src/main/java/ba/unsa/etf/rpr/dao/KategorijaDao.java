package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.util.List;

public interface KategorijaDao extends Dao<Kategorija> {
    List<Kategorija> pronadjiKategorijuPoID(int id) throws PekaraException;
}
