package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

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
        return null;
    }
}
