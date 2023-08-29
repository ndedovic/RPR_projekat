package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.PekaraException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        try{
            Korisnik korisnik = new Korisnik();
            korisnik.setId(rs.getInt("idKorisnik"));
            korisnik.setIme(rs.getString("Ime"));
            korisnik.setPrezime(rs.getString("Prezime"));
            korisnik.setEmail(rs.getString("Email"));
            korisnik.setPassword(rs.getString("Password"));
            return korisnik;
        } catch (SQLException e) {
            throw new PekaraException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Korisnik object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("idKorisnik", object.getId());
        row.put("Ime", object.getIme());
        row.put("Prezime", object.getPrezime());
        row.put("Email", object.getEmail());
        row.put("Password", object.getPassword());
        return row;
    }

    /**
     * Metoda za pronalazak određenog korisnika koji odgovara proslijeđenom id-u
     * @param id
     * @return
     * @throws PekaraException
     */
    @Override
    public List<Korisnik> pronadjiKorisnikaPoID(int id) throws PekaraException{
        return executeQuery("SELECT * from Korisnik WHERE id = ?", new Object[]{id});
    }
}
