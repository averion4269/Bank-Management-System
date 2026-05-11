package com.bank.app.people;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;

import java.util.ArrayList;
import java.util.Random;

public class Musteri extends Kisi {
    private String musteriNumarasi;
    private ArrayList<BankaHesabi> hesaplar;
    private ArrayList<KrediKarti> krediKartlari;

    public Musteri(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        this.musteriNumarasi = rastgeleNumaraUret(8); // Otomatik numara ataması
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
    }

    // Yardımcı metot: Rastgele numara üretici
    private String rastgeleNumaraUret(int uzunluk) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<uzunluk; i++) {
            sb.append(rnd.nextInt(10));
        }
        return sb.toString();
    }
    
    public void hesapEkle(String hesapTuru) {
        if (hesapTuru.equalsIgnoreCase("Vadesiz")) {
            VadesizHesap vh = new VadesizHesap(0.0); // Başlangıç bakiyesi 0
            hesaplar.add(vh);
            System.out.println("Vadesiz hesap eklendi: " + vh.getIban());
        } else if (hesapTuru.equalsIgnoreCase("Yatirim")) {
            YatirimHesabi yh = new YatirimHesabi(0.0);
            hesaplar.add(yh);
            System.out.println("Yatirim hesabi eklendi: " + yh.getIban());
        } else {
            System.out.println("Geçersiz hesap türü. Lütfen 'Vadesiz' veya 'Yatirim' giriniz.");
        }
    }

    public void krediKartiEkle(double limit) {
        KrediKarti kart = new KrediKarti(limit, 0.0); // Güncel borç başlangıçta 0
        krediKartlari.add(kart);
        System.out.println("Kredi karti eklendi: " + kart.getKartNumarasi());
    }

    public void hesapSil(BankaHesabi hesap) {
        if (hesap.getBakiye() > 0) {
            System.out.println("Lutfen oncelikle bakiyenizi baska bir hesaba aktariniz.");
        } else {
            hesaplar.remove(hesap);
            System.out.println("Hesap basariyla silindi: " + hesap.getIban());
        }
    }

    public void krediKartiSil(KrediKarti kart) {
        if (kart.getGuncelBorc() == 0) {
            krediKartlari.remove(kart);
            System.out.println("Kredi karti basariyla silindi: " + kart.getKartNumarasi());
        } else {
            System.out.println("Lutfen öncelikle borç ödemesi yapiniz. Güncel borc: " + kart.getGuncelBorc());
        }
    }

    // Get ve Set metotları
    public String getMusteriNumarasi() { return musteriNumarasi; }
    public ArrayList<BankaHesabi> getHesaplar() { return hesaplar; }
    public ArrayList<KrediKarti> getKrediKartlari() { return krediKartlari; }

    @Override
    public String toString() {
        return super.toString() + " Musteri Numarasi=" + musteriNumarasi;
    }
}