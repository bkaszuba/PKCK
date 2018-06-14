package com.tul.pkck.Parser;

import com.tul.pkck.Model.Autor;
import com.tul.pkck.Model.Marka;
import com.tul.pkck.Model.Salon;
import com.tul.pkck.Model.Samochod;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TXTConverter implements Converter{

    public void convert(String path, Salon salon) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sB = new StringBuilder();
        String formatStr = "%-15s %-15s %-20s %-15s %-15s %-15s %-25s %-25s %-25s %-25s%n";
        out.write("Dostępne marki" + "\n");
        sB.append("Dostępne marki" + "\n");
        out.write("===========================================================================================================================================================================================\n");
        sB.append("===========================================================================================================================================================================================\n");
        for (Marka marka: salon.getMarki().getMarki()) {
            out.write(marka.getMarka()+"\n");
            sB.append(marka.getMarka()+"\n");
        }
        out.write("===========================================================================================================================================================================================\n");
        sB.append("===========================================================================================================================================================================================\n");
        out.write(String.format(formatStr, "ID", "Model", "Pojemność silnika", "Cena", "Data produkcji", "Data ostat wła", "Imię ostat wła", "Nazwisko ostat wła","Nr ostat wła", "Czy nowy?"));
        sB.append(String.format(formatStr, "ID", "Model", "Pojemność silnika", "Cena", "Data produkcji", "Data ostat wła", "Imię ostat wła", "Nazwisko ostat wła","Nr ostat wła", "Czy nowy?"));
        out.write("===========================================================================================================================================================================================\n");
        sB.append("===========================================================================================================================================================================================\n");
        for (Samochod samochod : salon.getSamochody().getSamochody()) {
            out.write(String.format(formatStr, samochod.getId(), samochod.getIdRef(), samochod.getSilnik(), samochod.getCena().getCena() + samochod.getCena().getWaluta(), samochod.getDataProdukcji(), samochod.getDataOstatniegoWłaściciela(), samochod.getDaneWłaściciela().getImie(), samochod.getDaneWłaściciela().getNazwisko(), samochod.getDaneWłaściciela().getNrTelefonu(), samochod.getJestNowy()));
            sB.append(String.format(formatStr, samochod.getId(), samochod.getIdRef(), samochod.getSilnik(), samochod.getCena().getCena() + samochod.getCena().getWaluta(), samochod.getDataProdukcji(), samochod.getDataOstatniegoWłaściciela(), samochod.getDaneWłaściciela().getImie(), samochod.getDaneWłaściciela().getNazwisko(), samochod.getDaneWłaściciela().getNrTelefonu(), samochod.getJestNowy()));
        }
        out.write("\n\n\n\n");
        out.write("Made By\n======================================\n");
        String nameFormat = "%-15s %-15s %-20s%n";
        for (Autor autor: salon.getOpis().getAutorzy().getAutorzy()) {
            out.write(String.format(nameFormat, autor.getImię(), autor.getNazwisko(), autor.getNr_indeksu()));
        }
        out.close();
    }
}
