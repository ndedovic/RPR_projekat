package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.util.List;

/**
 * Sloj biznis logike za upravljanje kategorijama
 */
public class KategorijaManager {
    public void obrisiKategoriju(int id) throws PekaraException {
        DaoFactory.kategorijaDao().delete(id);
    }
    public void azurirajKategoriju(Kategorija kategorija) throws PekaraException {
        DaoFactory.kategorijaDao().update(kategorija);
    }
    public void dodajKategoriju(Kategorija kategorija) throws PekaraException {
        DaoFactory.kategorijaDao().add(kategorija);
    }
    public List<Kategorija> dajSveKategorije() throws PekaraException {
        return DaoFactory.kategorijaDao().getAll();
    }
    public Kategorija pronadjiKategorijuPoID(int id) throws PekaraException {
        return DaoFactory.kategorijaDao().getById(id);
    }
}
