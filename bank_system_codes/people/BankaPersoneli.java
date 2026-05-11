package com.bank.app.people;

import java.util.ArrayList;
import java.util.Random;

public class BankaPersoneli extends Kisi {
    private String personelID;
    private ArrayList<Musteri> musteriler;

    public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        this.musteriler = new ArrayList<>();
        // Rastgele Personel ID ataması
        this.personelID = "P" + (new Random().nextInt(9000) + 1000); 
    }

    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }

    // Get ve Set metotları
    public String getPersonelID() { return personelID; }
    public ArrayList<Musteri> getMusteriler() { return musteriler; }

    @Override
    public String toString() {
        return super.toString() + " Personel ID=" + personelID;
    }
}