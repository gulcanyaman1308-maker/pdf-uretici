package com.gulcan.resume;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Tasmalari onlemek icin uzun ozet metnini satirlara bolduk
        String[] summary = {
                "Kirklareli Universitesi Yazilim Muhendisligi bolumunde egitimime devam ediyorum.",
                "Modern yazilim gelistirme sureclerine, nesne yonelimli programlamaya ve temiz kod",
                "(Clean Code) prensiplerine odaklaniyorum. Universitede edindigim teorik",
                "muhendislik altyapisini kisisel ve takim projeleriyle pekistiriyor; kendimi surekli",
                "gelistirerek dinamik bir ekibin parcasi olarak deger uretmeyi hedefliyorum."
        };

        // Kişisel Bilgi Nesnesi (Pdf'teki verilerin[cite: 8])
        Person person = new Person(
                "Gulcan Yaman",
                "Yazilim Muhendisligi Ogrencisi",
                "gulcanyaman1308@gmail.com",
                "5457861466",
                "Kizilpinar Ataturk mah. Malkoclar cad. no: 22 daire: 2 Cerkezkoy/Tekirdag",
                summary,
                "profile.jpg"
        );

        // Eğitim Nesnesi (Pdf'teki verilerin[cite: 8])
        Education education = new Education(
                "Kirklareli Universitesi - Muhendislik Fakultesi",
                "Yazilim Muhendisligi (Lisans) | Dersler: NYP, Veri Yapilari, Veritabani",
                "2025 - Devam Ediyor",
                "EGITIM / BASARI SERTIFIKASI KODU: CERT-991E9526"
        );

        // 3 Fiktif İş Deneyimi (İlgili derslerine[cite: 8] ve özetine[cite: 8] uygun)
        List<Experience> experiences = new ArrayList<>();
        experiences.add(new Experience("CodeCraft Ar-Ge", "Yazilim Mimari Stajyeri", "2026 Guz", "Nesne Yonelimli Programlama (OOP) ve Clean Code prensipleri ile yazilim tasarimi."));
        experiences.add(new Experience("TechNova Bilisim", "Veritabani Asistani", "2026 Bahar", "Veritabani Yonetim Sistemleri uzerinde sorgu optimizasyonu ve veri modelleme."));
        experiences.add(new Experience("KLU Teknopark", "Algoritma Gelistirici", "2025 Yaz", "Veri yapilari ve algoritmalar kullanilarak performansi yuksek yazilim modulleri uretimi."));

        ResumeGenerator generator = new ResumeGenerator(person, education, experiences);
        generator.generatePdf("Gulcan_Yaman_CV_Detayli.pdf");
    }
}
