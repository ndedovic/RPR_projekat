package ba.unsa.etf.rpr;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import ba.unsa.etf.rpr.domain.Korisnik;
import org.junit.Test;

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
}
