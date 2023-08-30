package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.util.List;

public class ProizvodiManager {
    public void obrisiProizvod(int id) throws PekaraException {
        DaoFactory.proizvodiDao().delete(id);
    }
    public void azurirajProizvod(Proizvodi proizvod) throws PekaraException {
        DaoFactory.proizvodiDao().update(proizvod);
    }
    public void dodajProizvod(Proizvodi proizvod) throws PekaraException {
        DaoFactory.proizvodiDao().add(proizvod);
    }
    public List<Proizvodi> pronadjiSveProizvode() throws PekaraException {
        return DaoFactory.proizvodiDao().getAll();
    }
    public Proizvodi pronadjiProizvodPoID(int id) throws PekaraException {
        return DaoFactory.proizvodiDao().getById(id);
    }
    public List<Proizvodi> pronadjiProizvodPoKategoriji(int id) throws PekaraException {
        return DaoFactory.proizvodiDao().pronadjiProizvodPoKategoriji(id);
    }
}
