package ba.unsa.etf.rpr.exceptions;

public class PekaraException extends Exception{

    public PekaraException(String msg, Exception reason){super(msg,reason);}
    public PekaraException(String msg){super(msg);}
}
