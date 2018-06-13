package com.tul.pkck.Parser;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tul.pkck.Model.Salon;
import com.tul.pkck.Model.Samochod;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.stream.Stream;

import static java.lang.String.*;

public class PDFParser {
    Salon salon;

    public void saveToPDF(String path, Salon salon) throws DocumentException {
        this.salon = salon;
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();
        PdfPTable table = new PdfPTable(6);
        addTableHeader(table);
        addRows(table);
        document.add(table);
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
}
