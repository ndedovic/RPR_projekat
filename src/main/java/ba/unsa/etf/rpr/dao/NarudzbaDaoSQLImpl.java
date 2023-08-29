package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        try{
            Narudzba narudzba = new Narudzba();
            narudzba.setId(rs.getInt("idNarudzba"));
            narudzba.setCijena(rs.getString("cijena"));
            narudzba.setKorisnik(rs.getInt("idKorisnik"));
            return narudzba;
        } catch (SQLException e) {
            throw new PekaraException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Narudzba object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("idNarudzba", object.getId());
        row.put("cijena", object.getCijena());
        row.put("idKorisnik", object.getKorisnik());
        return row;
    }

    /**
     * Metoda za pronalazak narudzbe koja odgovara id-u
     * @param id
     * @return List<Narudzba>
     * @throws PekaraException
     */
    @Override
    public List<Narudzba> pronadjiNarudzbuPoID(int id) throws PekaraException{
        return executeQuery("SELECT * from Narudzba WHERE idNarudzba = ?", new Object[]{id});
    }
}
