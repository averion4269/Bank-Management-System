# Banka Yönetim Sistemi (Bank Management System)

Bu proje, **Bursa Teknik Üniversitesi Bilgisayar Mühendisliği** bölümü Nesne Yönelimli Programlama dersi kapsamında geliştirilmiştir. Java dili kullanılarak hazırlanan sistemde, temel OOP (Nesne Yönelimli Programlama) prensipleri uygulanmış ve modüler bir banka otomasyonu simüle edilmiştir.

## 🚀 Proje Özellikleri

- **Kalıtım (Inheritance):** `Kisi`, `Musteri` ve `BankaPersoneli` sınıfları arasında hiyerarşik yapı kurulmuştur.
- **Kapsülleme (Encapsulation):** Veri güvenliği için `private` erişim belirleyicileri ve `getter/setter` metotları kullanılmıştır.
- **Dinamik Veri Yönetimi:** Hesaplar ve kredi kartları için `ArrayList` koleksiyon yapısı tercih edilmiştir.
- **Otomatik Veri Üretimi:** Personel ID, Müşteri No, IBAN ve Kart No değerleri sistem tarafından rastgele (Random) üretilmektedir.
- **İş Mantığı Kontrolleri:** Bakiye yetersizliği, borç ödeme ve hesap silme kuralları (bakiye sıfırlama şartı vb.) uygulanmıştır.

## 📁 Paket Yapısı

Proje, nesne yönelimli mimariye uygun olarak 5 ana paketten oluşmaktadır:
- `com.bank.app.people`: Kişi ve aktör sınıfları.
- `com.bank.app.accounts`: Hesap türleri ve bankacılık işlemleri.
- `com.bank.app.cards`: Kredi kartı yönetimi.
- `com.bank.app.service`: Raporlama ve iş mantığı servisi.
- `com.bank.app.main`: Sistemin test edildiği ana giriş noktası.

## 🛠️ Kullanılan Teknolojiler
- **Dil:** Java
- **IDE:** Eclipse 
- **Sürüm Kontrolü:** Git & GitHub

## 📝 Akademik Bilgiler
- **Geliştiren:** Hamza ÖZÜTÜRK - 25360859334
- https://youtu.be/mk8OiJOgquU
- **Ders:** Nesne Yönelimli Programlama
- **Teslim Tarihi:** 11 Mayıs 2026
