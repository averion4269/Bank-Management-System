package com.bank.app.cards;

import java.util.Random;

public class KrediKarti {
    private String kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;

    public KrediKarti(double limit, double guncelBorc) {
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        this.kullanilabilirLimit = limit - guncelBorc;
        this.kartNumarasi = kartNumarasiUret();
    }

    private String kartNumarasiUret() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<16; i++) {
            sb.append(rnd.nextInt(10));
        }
        return sb.toString();
    }

    // Get ve Set metotları
    public String getKartNumarasi() { return kartNumarasi; }
    
    public double getLimit() { return limit; }
    public void setLimit(double limit) { 
        this.limit = limit;
        limitGuncelle();
    }

    public double getGuncelBorc() { return guncelBorc; }
    public void setGuncelBorc(double guncelBorc) { 
        this.guncelBorc = guncelBorc; 
        limitGuncelle();
    }

    public double getKullanilabilirLimit() { return kullanilabilirLimit; }

    // Borç veya limit değiştiğinde kullanılabilir limiti güncelleyen yardımcı metot
    private void limitGuncelle() {
        this.kullanilabilirLimit = this.limit - this.guncelBorc;
    }

    @Override
    public String toString() {
        return "KrediKarti [Kart No=" + kartNumarasi + ", Limit=" + limit + 
               ", Borç=" + guncelBorc + ", Kullanılabilir=" + kullanilabilirLimit + "]";
    }
}