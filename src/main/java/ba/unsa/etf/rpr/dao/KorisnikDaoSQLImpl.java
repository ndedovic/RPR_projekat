package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.sql.ResultSet;
import java.util.Map;

public class KorisnikDaoSQLImpl extends AbstractDao<Korisnik> implements KorisnikDao{
    private static  KorisnikDaoSQLImpl instance = null;

    public KorisnikDaoSQLImpl() {
        super("Korisnik");
    }
    public static KorisnikDaoSQLImpl getInstance(){
        if(instance == null)
            instance = new KorisnikDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance != null)
            instance = null;
    }

    @Override
    public Korisnik row2object(ResultSet rs) throws PekaraException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Korisnik object) {
        return null;
    }
}
