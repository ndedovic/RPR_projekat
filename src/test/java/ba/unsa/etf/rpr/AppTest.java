package ba.unsa.etf.rpr;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import ba.unsa.etf.rpr.business.KategorijaManager;
import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.business.ProizvodiManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.KorisnikDao;
import ba.unsa.etf.rpr.dao.KorisnikDaoSQLImpl;
import ba.unsa.etf.rpr.dao.ProizvodiDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.PekaraException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Korisnik k1 = new Korisnik(1, "Nejra", "Dedovic", "nejra.dedovic@gmail.com", "12345678");

    @Test
    public void Test1(){
        assertEquals(1, k1.getId());
        assertEquals("Nejra", k1.getIme());
        assertEquals("Dedovic", k1.getPrezime());
        assertEquals("nejra.dedovic@gmail.com", k1.getEmail());
        assertEquals("12345678", k1.getPassword());
    }
    @Test
    public void Test2(){
        assertEquals(8, k1.getPassword().length());
    }
    Kategorija kategorija1 = new Kategorija(1,"slatko");
    Kategorija kategorija2 = new Kategorija(2, "slano");
    Proizvodi p = new Proizvodi(1, "hljeb", "2", 2);

    @Test
    public void Test3(){
        assertTrue(p.getKategorija()==kategorija2.getId());
    }
    Korisnik k2 = new Korisnik(11, "Meho", "Mehic", "meho@gmail.com", "11111111");

    @Test
    public void Test4() throws PekaraException {
        KorisnikManager manager = new KorisnikManager();
        assertTrue(manager.dajSveKorisnike().contains(k2));
    }
    @Test
    public void Test5(){
        Narudzba n1 = new Narudzba(1, 11, "2");
        assertEquals(n1.getCijena(), p.getCijena());
    }
    @Test
    public void Test6(){
        KorisnikManager manager = new KorisnikManager();
        try{
            manager.validacijaImenaKorisnika("n");
        } catch (PekaraException e) {
            assertEquals("Ime mora sadržavati samo slova, i dužina imena ne smije biti manja ili jednaka 2", e.getMessage());
        }
    }
    @Test
    public void Test7(){
        KorisnikManager manager = new KorisnikManager();
        try{
            manager.validacijaPrezimenaKupca("123");
        } catch (PekaraException e) {
            assertEquals("Prezime mora sadržavati samo slova, i dužina prezimena ne smije biti manja ili jednaka 2", e.getMessage());
        }
    }
    @Test
    public void Test8() throws PekaraException {
        KategorijaManager manager = new KategorijaManager();
        assertEquals(1, manager.dajSveKategorije().size());
    }

    @Test
    public void Test9() throws PekaraException {
        ProizvodiManager manager = new ProizvodiManager();
        manager.obrisiProizvod(1);
        assertNotNull(manager.pronadjiSveProizvode().size());
    }

    @Mock
    public Proizvodi proizvod = new Proizvodi();
    private ProizvodiDaoSQLImpl sqlProizvod = Mockito.mock(ProizvodiDaoSQLImpl.class);
    private KorisnikManager korisnikManager = new KorisnikManager();
    private KategorijaManager kategorijaManager = new KategorijaManager();
    private ProizvodiManager proizvodManager = new ProizvodiManager();

    @BeforeEach
    public void setUp() {
        proizvod.setId(15);
        proizvod.setCijena("5");
        proizvod.setNaziv("pita");
        proizvod.setKategorija(1);
        MockitoAnnotations.openMocks(this);
        proizvodManager= new ProizvodiManager();
        kategorijaManager = Mockito.mock(KategorijaManager.class);
        korisnikManager = Mockito.mock(KorisnikManager.class);
    }

    @Test
    public void Test10() throws PekaraException {
        Proizvodi proizvod = new Proizvodi(18, "supa", "10", 2);
        MockedStatic<DaoFactory> mockedFactory = Mockito.mockStatic(DaoFactory.class);
        mockedFactory.when(DaoFactory::proizvodiDao).thenReturn(sqlProizvod);
        Proizvodi proizvod1 = new Proizvodi();
        when(sqlProizvod.add(Mockito.any(Proizvodi.class))).thenReturn(proizvod1);
        Proizvodi proizvod2 = sqlProizvod.add(new Proizvodi());
        assertEquals(proizvod1, proizvod2);
        mockedFactory.close();
    }
}
