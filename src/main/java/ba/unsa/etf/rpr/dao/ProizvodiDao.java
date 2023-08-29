package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.util.List;

public interface ProizvodiDao extends Dao<Proizvodi> {
    List<Proizvodi> pronadjiProizvodePoID(int id) throws PekaraException;

    List<Proizvodi> pronadjiProizvodPoKategoriji(int id) throws PekaraException;
}
