package com.tul.pkck.Parser;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tul.pkck.Model.Marka;
import com.tul.pkck.Model.Marki;
import com.tul.pkck.Model.Salon;
import com.tul.pkck.Model.Samochod;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.stream.Stream;

import static java.lang.String.*;

public class PDFConverter implements Converter {
    Salon salon;

    @Override
    public void convert(String path, Salon salon) {
        this.salon = salon;
        Document document = new Document(PageSize.A4, 0f, 0f, 20f, 0f);
        try {
            try {
                PdfWriter.getInstance(document, new FileOutputStream(path));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();
        Paragraph paragraph1 = new Paragraph("Wszystkie dostepne marki");
        paragraph1.setSpacingAfter(8f);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        PdfPTable marki = new PdfPTable(2);
        addMarkiHeaders(marki);
        addRowsMarki(marki);
        try {
            document.add(paragraph1);
            document.add(marki);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Paragraph paragraph2 = new Paragraph("Wszystkie dostepne samochody");
        paragraph2.setSpacingBefore(50f);
        paragraph2.setSpacingAfter(8f);
        paragraph2.setAlignment(Element.ALIGN_CENTER);

        PdfPTable samochody = new PdfPTable(6);
        addTableHeader(samochody);
        addRows(samochody);
        try {
            document.add(paragraph2);
            document.add(samochody);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }

    private void addRows(PdfPTable table) {
        for (Samochod samochod : salon.getSamochody().getSamochody()) {
            table.addCell(samochod.getIdRef());
            table.addCell(samochod.getModel());
            table.addCell(valueOf(samochod.getSilnik()));
            table.addCell(samochod.getCena().getCena() + samochod.getCena().getWaluta());
            table.addCell(samochod.getPrzebieg().getPrzebieg() + samochod.getPrzebieg().getJednostka());
            table.addCell(valueOf(samochod.getDataProdukcji()));
        }
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Marka", "Model", "Silnik", "Cena", "Przebieg", "Rocznik")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addMarkiHeaders(PdfPTable table) {
        Stream.of("Marka", "Ilosc aut")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRowsMarki(PdfPTable table) {
        for (Marka marka : salon.getMarki().getMarki()) {
            table.addCell(marka.getMarka());
            table.addCell(countMarka(marka));
        }
    }

    private String countMarka(Marka marka) {
        int count = 0;
        for (Samochod samochod: salon.getSamochody().getSamochody()) {
            if(samochod.getIdRef().equals(marka.getMarka())) {
                count++;
            }
        }
        return valueOf(count);
    }
}
