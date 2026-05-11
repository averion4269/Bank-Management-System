package com.bank.app.service;

import com.bank.app.people.Musteri;
import com.bank.app.accounts.BankaHesabi;
import com.bank.app.cards.KrediKarti;

public class BankaService {
    
    public void musteriBilgiGoster(Musteri m) {
        System.out.println("--- Musteri Bilgileri ---");
        System.out.println(m.toString());
        System.out.println("Hesaplar:");
        for(BankaHesabi h : m.getHesaplar()) {
            System.out.println(" - " + h.toString());
        }
        System.out.println("Kredi Kartları:");
        for(KrediKarti k : m.getKrediKartlari()) {
            System.out.println(" - " + k.toString());
        }
        System.out.println("-------------------------");
    }
}