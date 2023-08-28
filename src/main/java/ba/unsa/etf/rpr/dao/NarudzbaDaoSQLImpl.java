package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.sql.ResultSet;
import java.util.Map;

public class NarudzbaDaoSQLImpl extends AbstractDao<Narudzba> implements NarudzbaDao {
    private static NarudzbaDaoSQLImpl instance = null;
    public NarudzbaDaoSQLImpl() {
        super("Narudzba");
    }
    public static NarudzbaDaoSQLImpl getInstance(){
        if (instance == null)
            instance = new NarudzbaDaoSQLImpl();
        return instance;
    }
    public static void removeInstance(){
        if (instance != null)
            instance = null;
    }
    @Override
    public Narudzba row2object(ResultSet rs) throws PekaraException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Narudzba object) {
        return null;
    }
}
