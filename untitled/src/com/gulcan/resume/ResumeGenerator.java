package com.gulcan.resume;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
import java.util.List;

public class ResumeGenerator {
    private Person person;
    private Education education;
    private List<Experience> experiences;

    public ResumeGenerator(Person person, Education education, List<Experience> experiences) {
        this.person = person;
        this.education = education;
        this.experiences = experiences;
    }

    public void generatePdf(String outputFileName) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Başlık
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 22);
            contentStream.newLineAtOffset(50, 730);
            contentStream.showText(person.getFullName());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
            contentStream.newLineAtOffset(50, 710);
            contentStream.showText(person.getTitle());
            contentStream.endText();

            // İletişim ve Adres
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.newLineAtOffset(50, 690);
            contentStream.showText("Tel: " + person.getPhone() + " | E-Mail: " + person.getEmail());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.newLineAtOffset(50, 675);
            contentStream.showText("Adres: " + person.getAddress());
            contentStream.endText();

            // Fotoğraf (Yoksa atlar)
            try {
                PDImageXObject pdImage = PDImageXObject.createFromFile(person.getPhotoPath(), document);
                contentStream.drawImage(pdImage, 450, 650, 80, 100);
            } catch (Exception e) {
                // Fotoğraf yoksa konsola bilgi ver, programı çökertme
            }

            // Profesyonel Özet
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.newLineAtOffset(50, 640);
            contentStream.showText("Profesyonel Ozet");
            contentStream.endText();

            int yOffset = 620;
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.newLineAtOffset(50, yOffset);
            for (String line : person.getSummaryLines()) {
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -15);
                yOffset -= 15;
            }
            contentStream.endText();

            // Eğitim Bilgileri
            yOffset -= 10;
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.newLineAtOffset(50, yOffset);
            contentStream.showText("Egitim Bilgileri");
            contentStream.endText();

            yOffset -= 20;
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 11);
            contentStream.newLineAtOffset(50, yOffset);
            contentStream.showText(education.getUniversity() + " (" + education.getYear() + ")");
            contentStream.endText();

            yOffset -= 15;
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.newLineAtOffset(50, yOffset);
            contentStream.showText(education.getDepartment());
            contentStream.endText();

            // Sertifikalar
            yOffset -= 25;
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.newLineAtOffset(50, yOffset);
            contentStream.showText("Sertifikalar");
            contentStream.endText();

            yOffset -= 20;
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.newLineAtOffset(50, yOffset);
            contentStream.showText(education.getCertificate());
            contentStream.endText();

            // Fiktif İş Deneyimleri
            yOffset -= 35;
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.newLineAtOffset(50, yOffset);
            contentStream.showText("Is Deneyimleri");
            contentStream.endText();

            yOffset -= 25;
            for (Experience exp : experiences) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 11);
                contentStream.newLineAtOffset(50, yOffset);
                contentStream.showText("- " + exp.getPosition() + " @ " + exp.getCompany() + " (" + exp.getDuration() + ")");
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 10);
                contentStream.newLineAtOffset(70, yOffset - 15);
                contentStream.showText(exp.getDescription());
                contentStream.endText();

                yOffset -= 35;
            }

            contentStream.close();
            document.save(outputFileName);
            System.out.println("CV Basariyla Olusturuldu: " + outputFileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}