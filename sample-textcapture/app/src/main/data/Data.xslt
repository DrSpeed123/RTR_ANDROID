<?xml version="1.0" encoding="windows-1251"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="data">
        <person>
            <xsl:apply-templates/>
        </person>
    </xsl:template>

    <xsl:template match="some_element2">
        <Surname>
            <xsl:apply-templates/>
        </Surname>
    </xsl:template>

    <xsl:template match="some_element1">
        <Name>
            <xsl:apply-templates/>
        </Name>
    </xsl:template>

    <xsl:template match="some_element3">
        <PatrName>
            <xsl:apply-templates/>
        </PatrName>
    </xsl:template>

    <xsl:template match="some_element4">
        <Birthday>
            <xsl:apply-templates/>
        </Birthday>
    </xsl:template>

    <xsl:template match="some_element5">
        <PassportSeries>
            <xsl:apply-templates/>
            <xsl:apply-templates select="following-sibling::some_element6" mode="PassportSeries"/>
        </PassportSeries>
    </xsl:template>

    <xsl:template match="some_element6"/>

    <xsl:template match="some_element6" mode="PassportSeries">
        <xsl:text> </xsl:text>
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="some_element7">
        <PassportNumber>
            <xsl:apply-templates/>
        </PassportNumber>
    </xsl:template>

</xsl:stylesheet>