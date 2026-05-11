package com.bank.app.accounts;

public class YatirimHesabi extends BankaHesabi {
    private String hesapTürü = "Yatırım Hesabı";

    public YatirimHesabi(double bakiye) {
        super(bakiye);
    }

    public void paraEkle(double miktar) {
        this.setBakiye(this.getBakiye() + miktar);
        System.out.println(miktar + " TL yatirim hesabına eklendi. Yeni bakiye: " + this.getBakiye());
    }

    public void paraCek(double miktar) {
        if (this.getBakiye() >= miktar) {
            this.setBakiye(this.getBakiye() - miktar);
            System.out.println(miktar + " TL cekildi. Kalan bakiye: " + this.getBakiye());
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }

    public String getHesapTürü() { return hesapTürü; }

    @Override
    public String toString() {
        return super.toString() + " Tur: " + hesapTürü;
    }
}