package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        try {
            Kategorija cat = new Kategorija();
            cat.setId(rs.getInt("idKategorija"));
            cat.setNaziv(rs.getString("naziv"));
            return cat;
        } catch (SQLException e) {
            throw new PekaraException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Kategorija object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("idKategorija", object.getId());
        row.put("naziv", object.getNaziv());
        return row;
    }

    /**
     * Metoda za pronalazak kategorije na osnovu id-a
     * @param id
     * @return
     * @throws PekaraException
     */
    @Override
    public List<Kategorija> pronadjiKategorijuPoID(int id) throws PekaraException{
        return executeQuery("SELECT * from Kategorija WHERE idKategorija = ?", new Object[]{id});
    }
}
