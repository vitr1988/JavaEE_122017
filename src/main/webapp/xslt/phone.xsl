<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <table border="1">
            <tr bgcolor="#9acd32">
                <th>Тип</th>
                <th>Телефон</th>
            </tr>
            <xsl:for-each select="phones/phone">
                <tr>
                    <td><xsl:value-of select="@type"/></td>
                    <td><xsl:value-of select="value"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>