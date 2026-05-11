package com.bank.app.accounts;

import com.bank.app.cards.KrediKarti;

public class VadesizHesap extends BankaHesabi {
    private String hesapTürü = "Vadesiz Hesap";

    public VadesizHesap(double bakiye) {
        super(bakiye);
    }

    /**
     * Gönderen hesaptan alıcı hesaba belirtilen miktarı transfer eder.
     */
    public void paraTransferi(BankaHesabi aliciHesap, BankaHesabi gonderenHesap, double miktar) {
        if (gonderenHesap.getBakiye() >= miktar) {
            gonderenHesap.setBakiye(gonderenHesap.getBakiye() - miktar);
            aliciHesap.setBakiye(aliciHesap.getBakiye() + miktar);
            System.out.println("Transfer Basarili. " + miktar + " TL aktarildi.");
        } else {
            System.out.println("Yetersiz bakiye! Transfer gerceklestirilemedi.");
        }
    }

    /**
     * Kredi kartı borcunu vadesiz hesaptaki bakiye ile öder.
     */
    public void krediKartiBorcOdeme(KrediKarti kart, double miktar) {
        if (this.getBakiye() >= miktar) {
            this.setBakiye(this.getBakiye() - miktar);
            kart.setGuncelBorc(kart.getGuncelBorc() - miktar);
            System.out.println(miktar + " TL kredi karti borcu ödendi.");
        } else {
            System.out.println("Hesapta yeterli bakiye yok!");
        }
    }

    public String getHesapTürü() { return hesapTürü; }

    @Override
    public String toString() {
        return super.toString() + " Tür: " + hesapTürü;
    }
}