package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProizvodiDaoSQLImpl extends AbstractDao<Proizvodi> implements ProizvodiDao {
    private static ProizvodiDaoSQLImpl instance = null;
    public ProizvodiDaoSQLImpl(){
        super("Proizvodi");
    }
    public static ProizvodiDaoSQLImpl getInstance(){
        if (instance == null)
            instance = new ProizvodiDaoSQLImpl();
        return instance;
    }
    public static void removeInstance(){
        if (instance != null)
            instance = null;
    }
    @Override
    public Proizvodi row2object(ResultSet rs) throws PekaraException {
        try{
            Proizvodi proizvodi = new Proizvodi();
            proizvodi.setId(rs.getInt("idProizvodi"));
            proizvodi.setCijena(rs.getString("cijena"));
            proizvodi.setKategorija(rs.getInt("idKategorija"));
            proizvodi.setNaziv(rs.getString("naziv"));
            return proizvodi;
        } catch (SQLException e) {
            throw new PekaraException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(Proizvodi object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("idProizvodi", object.getId());
        row.put("idKategorija", object.getKategorija());
        row.put("naziv", object.getNaziv());
        row.put("cijena", object.getCijena());
        return row;
    }

    /**
     * Metoda za pronalazak proizvoda koji odgovara proslijeđenom id-u
     * @param id
     * @return List<Proizvod>
     * @throws PekaraException
     */
    @Override
    public List<Proizvodi> pronadjiProizvodePoID(int id) throws PekaraException{
        return executeQuery("SELECT * from Proizvodi WHERE id = ?", new Object[]{id});
    }
}
