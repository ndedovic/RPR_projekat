package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.util.List;

public class NarudzbaManager {
    public void obrisiNarudzbu(int id) throws PekaraException {
        DaoFactory.narudzbaDao().delete(id);
    }
    public void dodajNarudbu(Narudzba narudzba) throws PekaraException {
        DaoFactory.narudzbaDao().add(narudzba);
    }
    public List<Narudzba> pronadjiSveNarudzbe() throws PekaraException {
        return DaoFactory.narudzbaDao().getAll();
    }
    public Narudzba pronadjiNarudzbuPoID(int id) throws PekaraException {
        return DaoFactory.narudzbaDao().getById(id);
    }
    public void azurirajNarudzbu(Narudzba narudzba) throws PekaraException {
        DaoFactory.narudzbaDao().update(narudzba);
    }
    public List<Narudzba> pronadjiNarudzbuPoKorisniku(int id) throws PekaraException {
        return DaoFactory.narudzbaDao().pronadjiNarudzbuPoKorisniku(id);
    }
}
