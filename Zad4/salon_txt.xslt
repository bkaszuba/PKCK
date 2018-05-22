<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
  <xsl:output method="text"/>

    <xsl:template match="/">
       <xsl:apply-templates select="/salon/data_wykonania_raportu"/>
      <xsl:text>Autorzy:&#xA;&#xA;</xsl:text>
      <xsl:apply-templates select="/salon/autorzy/autor"/>
      <xsl:text>Statystyki ogólne:&#xA;&#xA;</xsl:text>
      <xsl:apply-templates select="/salon/statystyki_ogólne"/>
      <xsl:text>Statystyki szczegółowe:&#xA;&#xA;</xsl:text>
      <xsl:apply-templates select="/salon/marki/marka"/>
      <xsl:apply-templates select="/salon/statystyki/miasta/miasto"/>
    </xsl:template>
    
    
    <xsl:template match="/salon/statystyki_ogólne">

        <xsl:text>Liczba marek:</xsl:text>
        <xsl:call-template name="wyswietlSpacje">
          <xsl:with-param name="ilosc" select="30 - string-length('Liczba marek:')"/>
        </xsl:call-template>
        <xsl:value-of select="concat(liczba_marek,'&#xA;')" />
        
        <xsl:text>Liczba aut:</xsl:text>
        <xsl:call-template name="wyswietlSpacje">
          <xsl:with-param name="ilosc" select="30 - string-length('Liczba aut:')"/>
        </xsl:call-template>
        <xsl:value-of select="concat(liczba_aut,'&#xA;')" />
        
        <xsl:text>Liczba miast:</xsl:text>
        <xsl:call-template name="wyswietlSpacje">
          <xsl:with-param name="ilosc" select="30 - string-length('Liczba miast:')"/>
        </xsl:call-template>
        <xsl:value-of select="concat(liczba_miast,'&#xA;&#xA;')" />
             
    </xsl:template>
    
    <xsl:template match="/salon/marki/marka">

        <xsl:value-of select="concat(nazwa_marki,'&#xA;&#xA;')" />

        <xsl:text>Ilość modeli:</xsl:text>
        <xsl:call-template name="wyswietlSpacje">
          <xsl:with-param name="ilosc" select="30 - string-length('Ilość modeli:')"/>
        </xsl:call-template>
        <xsl:value-of select="concat(ilość_modeli,'&#xA;')" />

        <xsl:text>Ilość modeli Łódź:</xsl:text>
        <xsl:call-template name="wyswietlSpacje">
          <xsl:with-param name="ilosc" select="30 - string-length('Ilość modeli Łódź:')"/>
        </xsl:call-template>
        <xsl:value-of select="concat(ilość_modeli_Łódź,'&#xA;')" />

        <xsl:text>Ilość modeli Kraków:</xsl:text>
        <xsl:call-template name="wyswietlSpacje">
          <xsl:with-param name="ilosc" select="30 - string-length('Ilość modeli Kraków:')"/>
        </xsl:call-template>
        <xsl:value-of select="concat(ilość_modeli_Kraków,'&#xA;')" />

        <xsl:text>Ilość modeli Poznań:</xsl:text>
        <xsl:call-template name="wyswietlSpacje">
          <xsl:with-param name="ilosc" select="30 - string-length('Ilość modeli Poznań:')"/>
        </xsl:call-template>
        <xsl:value-of select="concat(ilość_modeli_Poznań,'&#xA;')" />

        <xsl:text>Ilość modeli Warszawa:</xsl:text>
        <xsl:call-template name="wyswietlSpacje">
          <xsl:with-param name="ilosc" select="30 - string-length('Ilość modeli Warszawa:')"/>
        </xsl:call-template>
        <xsl:value-of select="concat(ilość_modeli_Warszawa,'&#xA;&#xA;')" />
    </xsl:template>
    
    
    <xsl:template match="/salon/statystyki/miasta/miasto">

    <xsl:value-of select="concat(nazwa,'&#xA;&#xA;')" />

    <xsl:text>Liczba samochodów:</xsl:text>
    <xsl:call-template name="wyswietlSpacje">
      <xsl:with-param name="ilosc" select="30 - string-length('Liczba samochodów:')"/>
    </xsl:call-template>
    <xsl:value-of select="concat(liczba_samochodow,'&#xA;')" />
    
    <xsl:text>Średnia cena:</xsl:text>
    <xsl:call-template name="wyswietlSpacje">
      <xsl:with-param name="ilosc" select="30 - string-length('Średnia cena:')"/>
    </xsl:call-template>
    <xsl:value-of select="concat(średnia_cena,'&#xA;')" />
    
    <xsl:text>Średni przebieg:</xsl:text>
    <xsl:call-template name="wyswietlSpacje">
      <xsl:with-param name="ilosc" select="30 - string-length('Średni przebieg:')"/>
    </xsl:call-template>
    <xsl:value-of select="concat(średni_przebieg,'&#xA;')" />
    
    <xsl:text>Średni rok produkcji:</xsl:text>
    <xsl:call-template name="wyswietlSpacje">
      <xsl:with-param name="ilosc" select="30 - string-length('Średni rok produkcji:')"/>
    </xsl:call-template>
    <xsl:value-of select="concat(średni_rok_produkcji,'&#xA;&#xA;')" />
</xsl:template>

  <xsl:template match="/salon/autorzy/autor">
    <xsl:text>Imie:</xsl:text>
    <xsl:call-template name="wyswietlSpacje">
      <xsl:with-param name="ilosc" select="30 - string-length('Imie:')"/>
    </xsl:call-template>
    <xsl:value-of select="concat(imie,'&#xA;')" />

    <xsl:text>Nazwisko:</xsl:text>
    <xsl:call-template name="wyswietlSpacje">
      <xsl:with-param name="ilosc" select="30 - string-length('Nazwisko:')"/>
    </xsl:call-template>
    <xsl:value-of select="concat(nazwisko,'&#xA;')" />
    
    <xsl:text>Nr indeksu:</xsl:text>
    <xsl:call-template name="wyswietlSpacje">
      <xsl:with-param name="ilosc" select="30 - string-length('Nr indeksu:')"/>
    </xsl:call-template>
    <xsl:value-of select="concat(nr_indeksu,'&#xA;&#xA;')" />
  </xsl:template>

  <xsl:template match="/salon/data_wykonania_raportu">
    <xsl:text>Data Raportu:</xsl:text>
    <xsl:call-template name="wyswietlSpacje">
      <xsl:with-param name="ilosc" select="30 - string-length('Data Raportu:')"/>
    </xsl:call-template>
    <xsl:value-of select="concat(.,'&#xA;')" />
  </xsl:template>

  <xsl:template name="wyswietlSpacje" >
    <xsl:param name="ilosc"/>
    <xsl:if test="$ilosc > 0">
      <xsl:text> </xsl:text>
      <xsl:call-template name="wyswietlSpacje">
        <xsl:with-param name="ilosc" select="$ilosc - 1"/>
      </xsl:call-template>
    </xsl:if>
</xsl:template>
</xsl:stylesheet>