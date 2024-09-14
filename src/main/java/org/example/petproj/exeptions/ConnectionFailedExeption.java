package org.example.petproj.exeptions;

public class ConnectionFailedExeption extends Throwable {
    public ConnectionFailedExeption(String s) {
        super(s);
    }
}
