package com.bank.app.accounts;

import java.util.Random;

public class BankaHesabi {
    private String iban;
    private double bakiye;

    public BankaHesabi(double bakiye) {
        this.bakiye = bakiye;
        this.iban = ibanUret();
    }

    private String ibanUret() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder("TR");
        for(int i=0; i<24; i++) {
            sb.append(rnd.nextInt(10));
        }
        return sb.toString();
    }

    public String getIban() { return iban; }
    public double getBakiye() { return bakiye; }
    public void setBakiye(double bakiye) { this.bakiye = bakiye; }

    @Override
    public String toString() {
        return "BankaHesabi [IBAN=" + iban + ", Bakiye=" + bakiye + "]";
    }
}