
# Java Nesne Yönelimli Özgeçmiş (PDF) Üreteci

Bu proje, Java programlama dili ve Nesne Yönelimli Programlama (NYP) prensipleri kullanılarak geliştirilmiş, dinamik PDF formatında özgeçmiş üreten bir konsol uygulamasıdır.

## Kullanılan Nesneler ve Bileşenler (Components & Objects)
- **`Person` Sınıfı:** Adayın kimlik bilgilerini ve görsel dosya yolunu kapsüller (Encapsulation).
- **`Education` Sınıfı:** Üniversite ve bölüm bilgilerini nesne halinde saklar.
- **`Experience` Sınıfı:** Fiktif 3 iş deneyiminin her birini bağımsız bir nesne olarak temsil eder (Koleksiyon yapısı içinde `List<Experience>` olarak yönetilir).
- **`ResumeGenerator` Sınıfı:** Apache PDFBox kütüphanesine ait `PDDocument`, `PDPage`, `PDPageContentStream` ve `PDImageXObject` sınıflarını çağırarak bileşenleri PDF sayfasına çizer.
- **`Main` Sınıfı:** Yalnızca nesneler arası bağımlılıkları birbirine bağlar (`DI`) ve süreci başlatır.

## Neden Bu Mimari Tercih Edildi?
- **Single Responsibility Principle (Tek Sorumluluk):** Veri tutma, iş mantığı ve PDF çizim işlemleri ayrı sınıflara ayrılarak kodun okunabilirliği ve sürdürülebilirliği en üst düzeye çıkarılmıştır.
- **Erişim Düzenleyiciler (Access Modifiers):** Sınıf üye değişkenleri `private` yapılarak dış müdahalelere karşı korunmuş, kontrollü veri erişimi `getter` metotları ile sağlanmıştır.
