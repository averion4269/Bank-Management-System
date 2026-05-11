package com.bank.app.main;

import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.people.BankaPersoneli;
import com.bank.app.people.Musteri;
import com.bank.app.service.BankaService;

public class main {
    public main(String[] args) {
        BankaService servis = new BankaService();
        System.out.println("=== BANKA UYGULAMASI TEST SENARYOSU ===\n");

        // 1. Müşteri Oluşturma
        BankaPersoneli personel = new BankaPersoneli("Mehmet", "Postaci", "postaci1905@gmail.com", 356432);
        Musteri musteri = new Musteri("Hacer", "Yilmaz", "haceryilmaz@hotmail.com", 654334);
        personel.musteriEkle(musteri);
        System.out.println("Musteri olusturuldu: " + musteri.getAd() + " " + musteri.getSoyad());

        // 2. Müşteri adına hesap açma (Parametreler: String)
        musteri.hesapEkle("Vadesiz");
        musteri.hesapEkle("Yatirim");

        // Listeden ilgili hesapları çekip değişkenlere atıyoruz
        VadesizHesap vadesiz = (VadesizHesap) musteri.getHesaplar().get(0);
        YatirimHesabi yatirim = (YatirimHesabi) musteri.getHesaplar().get(1);

        // 3. Hesaba para yatırma
        // BankaHesabi sınıfındaki setBakiye() ve YatirimHesabi'ndaki paraEkle() metotlarını kullanıyoruz
        vadesiz.setBakiye(10000.0);
        System.out.println("Vadesiz hesaba para eklendi. Güncel bakiye: " + vadesiz.getBakiye());
        yatirim.paraEkle(3000.0);

        // 4. Hesaplar arasında para transferi gerçekleştirme
        System.out.println("\n--- Transfer Islemi ---");
        // VadesizHesap sınıfındaki paraTransferi(AliciHesap, GonderenHesap, Miktar) metodu
        vadesiz.paraTransferi(yatirim, vadesiz, 2000.0);

        // 5. Müşteriye kredi kartı tanımlama
        System.out.println("\n--- Kredi Kartı Islemleri ---");
        musteri.krediKartiEkle(150000.0); // 150.000 TL limitli kart
        KrediKarti kart = musteri.getKrediKartlari().get(0);
        
        // Simüle edilmiş borç oluşturma
        kart.setGuncelBorc(5000.0);
        System.out.println("Kredi kartina 5000 TL borc eklendi.");

        // 6. Kredi kartı borcu ödeme işlemi yapma
        System.out.println("\n--- Borc Odeme Islemi ---");
        // VadesizHesap sınıfındaki krediKartiBorcOdeme(KrediKarti, Miktar) metodu
        vadesiz.krediKartiBorcOdeme(kart, 1000.0);
        System.out.println("Kalan kart borcu: " + kart.getGuncelBorc());

        // 7. Gerekli şartlar sağlandığında hesap silme işlemi gerçekleştirme
        System.out.println("\n--- Hesap Silme Testi ---");
        // İçinde para olan yatırım hesabını silmeye çalışıyoruz (Uyarı vermeli)
        musteri.hesapSil(yatirim);

        // Parayı çekip bakiyeyi sıfırlıyoruz ve tekrar deniyoruz (Silmeli)
        yatirim.paraCek(yatirim.getBakiye());
        musteri.hesapSil(yatirim);

        // Final Raporu
        System.out.println("\n=== SISTEMDEKI SON DURUM ===");
        servis.musteriBilgiGoster(musteri);
    }
}