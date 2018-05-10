<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">
        <xsl:element name="salon">
            <data_wykonania_raportu>
                <xsl:value-of select="current-dateTime()"/>
            </data_wykonania_raportu>
            <autorzy>
                <xsl:apply-templates select="/salon/opis/autorzy"/>
            </autorzy>
            <statystyki_ogólne>
                <liczba_marek>
                    <xsl:value-of select="count(/salon/marki/marka)"/>
                </liczba_marek>
                <liczba_aut>
                    <xsl:value-of select="count(/salon/samochody/samochód)"/>
                </liczba_aut>
                <liczba_miast>
                    <xsl:value-of select="count(distinct-values(/salon/samochody/samochód/miasto/@miasto))"/>
                </liczba_miast>
            </statystyki_ogólne>  
            <marki>
                <xsl:apply-templates select="/salon/marki"/>
            </marki>
            <statystyki>
                <miasta>
                    <miasto>
                        <nazwa>Łódź</nazwa>
                        <liczba_samochodow>
                            <xsl:value-of select="count(/salon/samochody/samochód/miasto[@miasto = 'Łódź'])"/>
                        </liczba_samochodow>
                        <średnia_cena>
                            <xsl:value-of select="concat(format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Łódź']/preceding-sibling::cena) div count(/salon/samochody/samochód/miasto[@miasto = 'Łódź'])),'##,###.00'),' ',/salon/samochody/samochód[1]/miasto[@miasto = 'Łódź']/preceding-sibling::cena/@waluta)"/>
                        </średnia_cena>
                        <średni_przebieg>
                            <xsl:value-of select="concat(format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Łódź']/preceding-sibling::przebieg) div count(/salon/samochody/samochód/miasto[@miasto = 'Łódź'])),'###,###'),' ', /salon/samochody/samochód[1]/miasto[@miasto = 'Łódź']/preceding-sibling::przebieg/@jednostka)"/>
                        </średni_przebieg>
                        <średni_rok_produkcji>
                            <xsl:value-of select="format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Łódź']/preceding-sibling::dataProdukcji) div count(/salon/samochody/samochód/miasto[@miasto = 'Łódź'])),'####')"/>
                        </średni_rok_produkcji>
                    </miasto>
                    <miasto>
                        <nazwa>Kraków</nazwa>
                        <liczba_samochodow>
                            <xsl:value-of select="count(/salon/samochody/samochód/miasto[@miasto = 'Kraków'])"/>
                        </liczba_samochodow>
                        <średnia_cena>
                            <xsl:value-of select="concat(format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Kraków']/preceding-sibling::cena) div count(/salon/samochody/samochód/miasto[@miasto = 'Kraków'])),'##,###.00'),' ',/salon/samochody/samochód[2]/miasto[@miasto = 'Kraków']/preceding-sibling::cena/@waluta)"/>
                        </średnia_cena>
                        <średni_przebieg>
                            <xsl:value-of select="concat(format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Kraków']/preceding-sibling::przebieg) div count(/salon/samochody/samochód/miasto[@miasto = 'Kraków'])),'###,###'),' ', /salon/samochody/samochód[2]/miasto[@miasto = 'Kraków']/preceding-sibling::przebieg/@jednostka)"/>
                        </średni_przebieg>
                        <średni_rok_produkcji>
                            <xsl:value-of select="format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Kraków']/preceding-sibling::dataProdukcji) div count(/salon/samochody/samochód/miasto[@miasto = 'Kraków'])),'####')"/>
                        </średni_rok_produkcji>
                    </miasto>
                    <miasto>
                        <nazwa>Poznań</nazwa>
                        <liczba_samochodow>
                            <xsl:value-of select="count(/salon/samochody/samochód/miasto[@miasto = 'Poznań'])"/>
                        </liczba_samochodow>
                        <średnia_cena>
                            <xsl:value-of select="concat(format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Poznań']/preceding-sibling::cena) div count(/salon/samochody/samochód/miasto[@miasto = 'Poznań'])),'##,###.00'),' ',/salon/samochody/samochód[3]/miasto[@miasto = 'Poznań']/preceding-sibling::cena/@waluta)"/>
                        </średnia_cena>
                        <średni_przebieg>
                            <xsl:value-of select="concat(format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Poznań']/preceding-sibling::przebieg) div count(/salon/samochody/samochód/miasto[@miasto = 'Poznań'])),'###,###'),' ', /salon/samochody/samochód[3]/miasto[@miasto = 'Poznań']/preceding-sibling::przebieg/@jednostka)"/>
                        </średni_przebieg>
                        <średni_rok_produkcji>
                            <xsl:value-of select="format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Poznań']/preceding-sibling::dataProdukcji) div count(/salon/samochody/samochód/miasto[@miasto = 'Poznań'])),'####')"/>
                        </średni_rok_produkcji>
                    </miasto>
                    <miasto>
                        <nazwa>Warszawa</nazwa>
                        <liczba_samochodow>
                            <xsl:value-of select="count(/salon/samochody/samochód/miasto[@miasto = 'Warszawa'])"/>
                        </liczba_samochodow>
                        <średnia_cena>
                            <xsl:value-of select="concat(format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Warszawa']/preceding-sibling::cena) div count(/salon/samochody/samochód/miasto[@miasto = 'Warszawa'])),'##,###.00'),' ',/salon/samochody/samochód[9]/miasto[@miasto = 'Warszawa']/preceding-sibling::cena/@waluta)"/>
                        </średnia_cena>
                        <średni_przebieg>
                            <xsl:value-of select="concat(format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Warszawa']/preceding-sibling::przebieg) div count(/salon/samochody/samochód/miasto[@miasto = 'Warszawa'])),'###,###'),' ', /salon/samochody/samochód[9]/miasto[@miasto = 'Warszawa']/preceding-sibling::przebieg/@jednostka)"/>
                        </średni_przebieg>
                        <średni_rok_produkcji>
                            <xsl:value-of select="format-number((sum(/salon/samochody/samochód/miasto[@miasto = 'Warszawa']/preceding-sibling::dataProdukcji) div count(/salon/samochody/samochód/miasto[@miasto = 'Warszawa'])),'####')"/>
                        </średni_rok_produkcji>
                    </miasto>
                </miasta>
            </statystyki>
        </xsl:element>
    </xsl:template>
    <xsl:template match="/salon/opis/autorzy">
        <xsl:for-each select="autor">
            <xsl:sort select="nazwisko" data-type="text"/>
            <autor>
                <imie>
                    <xsl:value-of select="imię"/>
                </imie>
                <nazwisko>
                    <xsl:value-of select="nazwisko"/>
                </nazwisko>
                <nr_indeksu>
                    <xsl:value-of select="nr_indeksu"/>
                </nr_indeksu>
            </autor>
        </xsl:for-each>
    </xsl:template>
    <xsl:template match="/salon/marki">
        <xsl:for-each select="marka">
            <xsl:sort select="@idAuta" data-type="text"/>
            <xsl:variable name="nazwaMarki" select="@idAuta"/>
                    <marka>
                        <nazwa_marki>
                          <xsl:value-of select="$nazwaMarki"/>
                        </nazwa_marki>
                        <ilość_modeli>
                            <xsl:value-of select="count(/salon/samochody/samochód[@idref = $nazwaMarki])"/>
                        </ilość_modeli>
                        <ilość_modeli_Łódź>
                            <xsl:value-of select="count(/salon/samochody/samochód[miasto/@miasto = 'Łódź' and @idref = $nazwaMarki])"/>
                        </ilość_modeli_Łódź>
                        <ilość_modeli_Kraków>
                            <xsl:value-of select="count(/salon/samochody/samochód[miasto/@miasto = 'Kraków' and @idref = $nazwaMarki])"/>
                        </ilość_modeli_Kraków>
                        <ilość_modeli_Poznań>
                            <xsl:value-of select="count(/salon/samochody/samochód[miasto/@miasto = 'Poznań' and @idref = $nazwaMarki])"/>
                        </ilość_modeli_Poznań>
                        <ilość_modeli_Warszawa>
                            <xsl:value-of select="count(/salon/samochody/samochód[miasto/@miasto = 'Warszawa' and @idref = $nazwaMarki])"/>
                        </ilość_modeli_Warszawa>
                    </marka>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>