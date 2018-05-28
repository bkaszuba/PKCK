<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns="http://www.w3.org/2000/svg"
		>
  <xsl:output
      method="xml"
      indent="yes"
      standalone="no"
      doctype-public="-//W3C//DTD SVG 1.1//EN"
      doctype-system="http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"
      media-type="image/svg" />

  <xsl:template match="/">
    <svg xmlns="http://www.w3.org/2000/svg" width="1200" height="1200" >
      
            <script type="text/ecmascript"> 
                <![CDATA[
                    function onMouseOverWykresAut(evt) 
                    {
                        var liczby = document.getElementsByClassName("liczbaSamochodow");
                        for (i = 0; i < liczby.length; ++i) 
                        {
                          liczby[i].setAttribute("visibility", "visible");
                        }
                    }
                    function onMouseOutWykresAut(evt) 
                    {
                        var liczby = document.getElementsByClassName("liczbaSamochodow");
                        for (i = 0; i < liczby.length; ++i) 
                        {
                          liczby[i].setAttribute("visibility", "hidden");
                        }
                    }
                    function onMouseOverWykresMarek(evt) 
                    {
                        var liczby = document.getElementsByClassName("liczbaMarek");
                        for (i = 0; i < liczby.length; ++i) 
                        {
                          liczby[i].setAttribute("visibility", "visible");
                        }
                    }
                    function onMouseOutWykresMarek(evt) 
                    {
                        var liczby = document.getElementsByClassName("liczbaMarek");
                        for (i = 0; i < liczby.length; ++i) 
                        {
                          liczby[i].setAttribute("visibility", "hidden");
                        }
                    }
                    function onClickAutorzy(evt)
                    {
                        var autorzy = document.getElementById("autorzy");
                        var visibility = autorzy.getAttribute("visibility");
                        if(visibility==="visible")
                        {
                            autorzy.setAttribute("visibility", "hidden");
                        }
                        else
                        {
                            autorzy.setAttribute("visibility", "visible");
                        }
                    }
                    
                    function onClickData(evt)
                    {
                        var autorzy = document.getElementById("data");
                        var visibility = autorzy.getAttribute("visibility");
                        if(visibility==="visible")
                        {
                            autorzy.setAttribute("visibility", "hidden");
                        }
                        else
                        {
                            autorzy.setAttribute("visibility", "visible");
                        }
                    }
            ]]>
            </script>      
      
      <rect x="0" y="0" width="1100" height="450" fill="DarkGrey"/>
      <text x="80" y="20" font-size="24" fill="black" font-weight="bold">Liczba dostępnych samochodów</text>
      <g id="poleWykresu" width="450" height="265" onmouseover="onMouseOverWykresAut(evt)" onmouseout="onMouseOutWykresAut(evt)">
        <rect x="25" y="30" width="450" height="285" fill="Grey" stroke="DimGrey"/>
        <xsl:apply-templates select="/salon/statystyki/miasta/miasto"/>
      </g>
      <text x="650" y="20" font-size="24" fill="black" font-weight="bold" onclick="onClickAutorzy(evt)">Liczba dostępnych marek</text> 
      <g id="poleWykresu2" width="605" height="265" onmouseover="onMouseOverWykresMarek(evt)" onmouseout="onMouseOutWykresMarek(evt)">
        <rect x="490" y="30" width="605" height="285" fill="Grey" stroke="DimGrey"/>
        <xsl:apply-templates select="/salon/marki/marka"/>
      </g>
      <text x="25" y="380" font-size="24" fill="black" font-weight="bold" onclick="onClickAutorzy(evt)">Autorzy:</text>
      <g id="autorzy" visibility="visible">
        <xsl:apply-templates select="/salon/autorzy/autor"/>
      </g>
      <text x="600" y="380" font-size="24" fill="black" font-weight="bold" onclick="onClickData(evt)">Wykonano: </text>
      <g id="data" visibility="visible">
        <xsl:apply-templates select="/salon/data_wykonania_raportu"/>
      </g>
    </svg>
  </xsl:template>

  <xsl:template match="/salon/statystyki/miasta/miasto">
      <xsl:variable name="postitionX" select="position()*50 + (position() - 1)*50 + 20"/>
      <xsl:variable name="height" select="liczba_samochodow * 40"/>
      <xsl:variable name="positionY" select="40 + (250 - $height)"/>
      <rect x="{$postitionX}" width="50" fill="blue" stroke="black">
        <animate attributeName="height" from="0" to="{$height}" dur="3s" fill="freeze"/>
        <animate attributeName="y" from="290" to="{$positionY}" dur="3s" fill="freeze"/>
      </rect>
      <text x="{$postitionX}" y="305" font-size="16" fill="black" font-weight="bold">
        <xsl:value-of select="nazwa"/>
      </text>
      <text class="liczbaSamochodow" visibility="hidden" x="{$postitionX + 20}" y="{$positionY - 5}" font-size="16" fill="black" font-weight="bold">
        <xsl:value-of select="liczba_samochodow"/>
      </text>
  </xsl:template>
  
  <xsl:template match="/salon/marki/marka">
      <xsl:variable name="postitionX" select="position()*30 + (position() - 1)*50"/>
      <xsl:variable name="height" select="ilość_modeli * 40"/>
      <xsl:variable name="positionY" select="40 + (250 - $height)"/>
      <rect x="{$postitionX + 500}" width="50" fill="white" stroke="black">
        <animate attributeName="height" from="0" to="{$height}" dur="5s" fill="freeze"/>
        <animate attributeName="y" from="290" to="{$positionY}" dur="5s" fill="freeze"/>
      </rect>
      <text x="{$postitionX + 500}" y="305" font-size="16" fill="black" font-weight="bold">
        <xsl:value-of select="nazwa_marki"/>
      </text>
      <text class="liczbaMarek" visibility="hidden" x="{$postitionX + 520}" y="{$positionY - 5}" font-size="16" fill="black" font-weight="bold">
        <xsl:value-of select="ilość_modeli"/>
      </text>
  </xsl:template>

  <xsl:template match="/salon/autorzy/autor">
    <xsl:variable name="positionY" select="360 + position()*20"/>
    <text x="150" y="{$positionY}" font-size="18" fill="red" font-weight="bold">
      <xsl:value-of select="concat(imie,' ',nazwisko,' ',nr_indeksu)"/>
    </text>
  </xsl:template>
  
  <xsl:template match="/salon/data_wykonania_raportu">
    <xsl:variable name="positionY" select="360 + position()*20"/>
    <text x="740" y="{$positionY}" font-size="18" fill="red" font-weight="bold">
      <xsl:value-of select="concat(.,'&#xA;')"/>
    </text>
  </xsl:template>
</xsl:stylesheet>