package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.sql.ResultSet;
import java.util.Map;

public class KategorijaDaoSQLImpl extends AbstractDao<Kategorija> implements KategorijaDao {

    private static KategorijaDaoSQLImpl instance = null;
    private KategorijaDaoSQLImpl() {
        super("Kategorija");
    }

    //upotreba Singleton Patterna
    public static KategorijaDaoSQLImpl getInstance(){
        if (instance == null)
            instance = new KategorijaDaoSQLImpl();
        return instance;
    }
    public static void removeInstance(){
        if(instance!=null)
            instance = null;
    }
    @Override
    public Kategorija row2object(ResultSet rs) throws PekaraException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Kategorija object) {
        return null;
    }
}
