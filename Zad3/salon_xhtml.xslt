<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
  <xsl:output method="xml" indent="yes" version="1.0" encoding="utf-8" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"/>

  <xsl:template match="/">
    <html>
        <head>
          <title>Raport salonu samochodowego</title>
        </head>
      <body>
        <div>
           
          <a href="#autorzy">Autorzy</a>
          <a href="#stats_base">Statystyki ogólne</a>
          <a href="#marki">Marki</a>
          <a href="#stats">Statystyki miast</a>
          <h1 id="salon">Salon samochodowy</h1>
            <p>
		<img src="salon.jpg" alt="Salon" width="300" height="200" />
          </p>
          <div class="autorzy">
          <h3 id="autorzy">Autorzy</h3>
          <xsl:for-each select="/salon/autorzy/autor">
            <p>
              <xsl:value-of select="."/>
            </p>
          </xsl:for-each>
        </div>
        
        <div class="stats_base">
          <h3 id="stats_base">Statystyki ogólne</h3>
          <table>
            <tr>
              <th>Liczba aut</th>
              <th>Liczba marek</th>
              <th>Liczba miast</th>
            </tr>
              <tr>
                <td>
                  <xsl:value-of select="/salon/statystyki_ogólne/liczba_aut"/>
                </td>
                <td>
                  <xsl:value-of select="/salon/statystyki_ogólne/liczba_marek"/>
                </td>
                <td>
                    <xsl:value-of select="/salon/statystyki_ogólne/liczba_miast"/>
                </td>
              </tr>
          </table>
        </div>
        
        <div class="marki">
          <h3 id="marki">Dostępne marki w salonie</h3>
          <table>
            <tr>
              <th>Nazwa marki</th>
              <th>Ilość modeli</th>
              <th>Ilość w Łodzi</th>
              <th>Ilość w Krakowie</th>
              <th>Ilość w Poznaniu</th>
              <th>Ilość w Warszawie</th>
            </tr>
            <xsl:for-each select="/salon/marki/marka">
              <tr>
                <td>
                  <xsl:value-of select="nazwa_marki"/>
                </td>
                <td>
                  <xsl:value-of select="ilość_modeli"/>
                </td>
                <td>
                  <xsl:value-of select="ilość_modeli_Łódź"/>
                </td>
                <td>
                  <xsl:value-of select="ilość_modeli_Kraków"/>
                </td>
                <td>
                  <xsl:value-of select="ilość_modeli_Poznań"/>
                </td>
                <td>
                  <xsl:value-of select="ilość_modeli_Warszawa"/>
                </td>
              </tr>
            </xsl:for-each>
          </table>
        </div>
        
        </div>
        <div class="stats">
          <h3 id="stats">Statystki Miast</h3>
          <table>
            <tr>
              <th>Miasto</th>
              <th>Liczba samochodów</th>
              <th>Średnia cena samochodu</th>
              <th>Średni przebieg samochodu</th>
              <th>Średni rok produkcji</th>
            </tr>
            <xsl:for-each select="/salon/statystyki/miasta/miasto">
              <tr>
                <td>
                  <xsl:value-of select="nazwa"/>
                </td>
                <td>
                  <xsl:value-of select="liczba_samochodow"/>
                </td>
                <td>
                  <xsl:value-of select="średnia_cena"/>
                </td>
                <td>
                  <xsl:value-of select="średni_przebieg"/>
                </td>
                <td>
                  <xsl:value-of select="średni_rok_produkcji"/>
                </td>
              </tr>
            </xsl:for-each>
          </table>
        </div>
        <p>
            Raport wygenerowano: 
            <xsl:value-of select="/salon/data_wykonania_raportu"/>
        </p>
        <p>
      <a href="#salon">Do góry</a>
        </p>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>