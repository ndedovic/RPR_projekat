package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Klasa za korisnike
 * @author Nejra
 */
public class Korisnik implements Idable{
    private int id;
    private String ime;
    private String prezime;
    private String email;
    private String password;

    /**
     * Konstruktor sa svim parametrima
     * @param id
     * @param ime
     * @param prezime
     * @param email
     * @param password
     */
    public Korisnik(int id, String ime, String prezime, String email, String password) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
    }

    /**
     * Konstruktor bez parametara
     */
    public Korisnik() {
    }

    /**
     * Getter za id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Getter za ime
     * @return
     */
    public String getIme() {
        return ime;
    }

    /**
     * Getter za prezime
     * @return
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Getter za email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter za password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter za id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter za ime
     * @param ime
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Setter za prezime
     * @param prezime
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Setter za email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter za password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Ispis korisnika
     * @return
     */
    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * Poređenje dva korisnika
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return id == korisnik.id && ime.equals(korisnik.ime) && prezime.equals(korisnik.prezime) && email.equals(korisnik.email) && password.equals(korisnik.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, email, password);
    }
}
