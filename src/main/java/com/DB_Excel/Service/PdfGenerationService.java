package com.DB_Excel.Service;

import com.DB_Excel.Entity.User;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfGenerationService {

    @Autowired
    private UserService userService;

    public byte[] generatePdf() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdfDocument = new PdfDocument(writer);
             Document document = new Document(pdfDocument)) {

            List<User> users = userService.getAllUsers();
            for (User user : users) {
                document.add(new Paragraph("User ID: " + user.getId()));
                document.add(new Paragraph("Name: " + user.getName()));
                document.add(new Paragraph("Email: " + user.getEmail()));
                document.add(new Paragraph("Mobile: " + user.getMobile()));
                // Add more fields as needed
                document.add(new Paragraph("\n"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }
}
