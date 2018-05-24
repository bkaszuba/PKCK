<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
      xmlns:fo="http://www.w3.org/1999/XSL/Format">
  <xsl:output method="xml" indent="yes"/>
  <xsl:template match="/">
    <fo:root language="PL">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="Raport" page-height="297mm" page-width="210mm" margin-top="5mm" margin-bottom="5mm" margin-left="5mm" margin-right="5mm">
          <fo:region-body margin-top="10mm" margin-bottom="10mm"/>
          <fo:region-before region-name="xsl-region-before" extent="100mm"/>
          <fo:region-after region-name="xsl-region-after" extent="5mm"/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="Raport">
        <fo:static-content flow-name="xsl-region-before">
          <fo:block>
             <xsl:apply-templates select="/salon/data_wykonania_raportu"/>
          </fo:block>
<!--          <fo:block text-align="center">
             <xsl:apply-templates select="/salon/autorzy/autor"/> 
          </fo:block>-->
        </fo:static-content>
        <fo:static-content flow-name="xsl-region-after">
          <fo:block text-align="left">
             <xsl:apply-templates select="/salon/autorzy/autor"/> 
          </fo:block>
        </fo:static-content>
        <fo:flow flow-name="xsl-region-body">
           <fo:block font-weight="bold" text-align="center" font-size="large">
                <xsl:text>Statystyki ogólne</xsl:text>
          </fo:block>
          <xsl:apply-templates select="/salon/statystyki_ogólne"/>
          <fo:block font-weight="bold" text-align="center" font-size="large" margin-bottom="1mm" margin-top="1mm" line-height="10mm">
            <xsl:text>Dostępne marki</xsl:text>
          </fo:block>
          <fo:table margin-left="1mm" margin-right="10mm" margin-bottom="55mm" margin-top="10mm" table-layout="fixed" width="200mm" >
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-header>
              <fo:table-row>
                <fo:table-cell text-align="center">
                  <fo:block font-weight="bold">Marka</fo:block>
                </fo:table-cell>
                <fo:table-cell text-align="center">
                  <fo:block font-weight="bold">Ilość modeli</fo:block>
                </fo:table-cell>
                <fo:table-cell text-align="center">
                  <fo:block font-weight="bold">Ilość w Łodzi</fo:block>
                </fo:table-cell>
                <fo:table-cell text-align="center">
                  <fo:block font-weight="bold">Ilość w Krakowie</fo:block>
                </fo:table-cell>
                <fo:table-cell text-align="center">
                  <fo:block font-weight="bold">Ilość w Poznaniu</fo:block>
                </fo:table-cell>
                <fo:table-cell text-align="center">
                  <fo:block font-weight="bold">Ilość w Warszawie</fo:block>
                </fo:table-cell>
              </fo:table-row>
            </fo:table-header>
            <fo:table-body>
                <xsl:apply-templates select="/salon/marki/marka" />
            </fo:table-body>
            </fo:table>
            <fo:block font-weight="bold" text-align="center" font-size="large">
                <xsl:text>Statystyki poszczególnych miast</xsl:text>
          </fo:block>
          <xsl:apply-templates select="/salon/statystyki/miasta/miasto"/>
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>
  
  <!-- Statystyki marek-->
<xsl:template match="/salon/marki/marka">
      <fo:table-row line-height="20mm" border-color="black" border-width="0.6mm" border-style="solid" margin-top="5mm" margin-bottom="5mm" margin-left="5mm" margin-right="5mm">
        <fo:table-cell>
          <fo:block>
            <xsl:value-of select="nazwa_marki" />
          </fo:block>
        </fo:table-cell>
        <fo:table-cell>
          <fo:block>
            <xsl:value-of select="ilość_modeli" />
          </fo:block>
        </fo:table-cell>
        <fo:table-cell>
          <fo:block>
            <xsl:value-of select="ilość_modeli_Łódź" />
          </fo:block>
        </fo:table-cell>
        <fo:table-cell>
          <fo:block>
            <xsl:value-of select="ilość_modeli_Kraków" />
          </fo:block>
        </fo:table-cell>
        <fo:table-cell>
          <fo:block>
            <xsl:value-of select="ilość_modeli_Poznań" />
          </fo:block>
        </fo:table-cell>
        <fo:table-cell>
          <fo:block>
            <xsl:value-of select="ilość_modeli_Warszawa" />
          </fo:block>
        </fo:table-cell>
      </fo:table-row>
</xsl:template>
  
<!--Autorzy-->
    <xsl:template match="/saon/autorzy/autor">
        <fo:block>
            <xsl:value-of select="concat(imie,' ',nazwisko,' ', nr_indeksu)"/>
            <xsl:text>&#xA;&#xA;</xsl:text>
        </fo:block>
    </xsl:template>
<!--Data raportu-->
    <xsl:template match="/salon/data_wykonania_raportu">
        <fo:block text-align="right">
            <xsl:value-of select="concat(' ',.)" />
        </fo:block>
    </xsl:template>
<!--Statystyka miast-->
 <xsl:template match="/salon/statystyki/miasta/miasto">
    <fo:block border-color="black" border-width="0.6mm" border-style="solid" margin-top="5mm" margin-bottom="5mm" margin-left="5mm" margin-right="5mm">
      <fo:block>
        <xsl:value-of select="nazwa"/>
      </fo:block>
      <fo:list-block>
        <fo:list-item>
          <fo:list-item-label>
            <fo:block>Liczba samochodow:</fo:block>
          </fo:list-item-label>
          <fo:list-item-body>
            <fo:block margin-left="150mm">
              <xsl:value-of select="liczba_samochodow"/>
            </fo:block>
          </fo:list-item-body>
        </fo:list-item>
        <fo:list-item>
          <fo:list-item-label>
            <fo:block>Srednia cena wypozyczenia:</fo:block>
          </fo:list-item-label>
          <fo:list-item-body>
            <fo:block margin-left="150mm">
              <xsl:value-of select="średnia_cena"/>
            </fo:block>
          </fo:list-item-body>
        </fo:list-item>
        <fo:list-item>
          <fo:list-item-label>
            <fo:block>Sredni przebieg:</fo:block>
          </fo:list-item-label>
          <fo:list-item-body>
            <fo:block margin-left="150mm">
              <xsl:value-of select="średni_przebieg"/>
            </fo:block>
          </fo:list-item-body>
        </fo:list-item>
        <fo:list-item>
          <fo:list-item-label>
            <fo:block>Sredni rocznik:</fo:block>
          </fo:list-item-label>
          <fo:list-item-body>
            <fo:block margin-left="150mm">
              <xsl:value-of select="średni_rok_produkcji"/>
            </fo:block>
          </fo:list-item-body>
        </fo:list-item>
      </fo:list-block>
    </fo:block>
</xsl:template>

 <xsl:template match="/salon/statystyki_ogólne">
    <fo:block border-color="black" border-width="0.6mm" border-style="solid" margin-top="5mm" margin-bottom="5mm" margin-left="5mm" margin-right="5mm">
      <fo:block>
        <xsl:value-of select="nazwa"/>
      </fo:block>
      <fo:list-block>
        <fo:list-item>
          <fo:list-item-label>
            <fo:block>Liczba marek:</fo:block>
          </fo:list-item-label>
          <fo:list-item-body>
            <fo:block margin-left="150mm">
              <xsl:value-of select="liczba_marek"/>
            </fo:block>
          </fo:list-item-body>
        </fo:list-item>
        <fo:list-item>
          <fo:list-item-label>
            <fo:block>Liczba aut:</fo:block>
          </fo:list-item-label>
          <fo:list-item-body>
            <fo:block margin-left="150mm">
              <xsl:value-of select="liczba_aut"/>
            </fo:block>
          </fo:list-item-body>
        </fo:list-item>
        <fo:list-item>
          <fo:list-item-label>
            <fo:block>Liczba miast</fo:block>
          </fo:list-item-label>
          <fo:list-item-body>
            <fo:block margin-left="150mm">
              <xsl:value-of select="liczba_miast"/>
            </fo:block>
          </fo:list-item-body>
        </fo:list-item>
      </fo:list-block>
    </fo:block>
</xsl:template>

</xsl:stylesheet>