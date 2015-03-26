/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringxmltotextconverter.parser;

import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author nsekhar
 */
public class SaxHandler extends DefaultHandler
{

    private HashMap<String, String> stringList;
    private String currentStringKey;
    private String currentStringVal = "";
    private boolean checkOn;
    private int itemNo;

    SaxHandler(HashMap<String, String> stringList)
    {
        this.stringList = stringList;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        if (checkOn)
        {
            String s = new String(ch, start, length);
            if (!s.isEmpty())
            {
                currentStringVal += s.trim();
            }

        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.contentEquals("string") || qName.contentEquals("string-array"))
        {
            stringList.put(currentStringKey, currentStringVal);
            //System.out.println(currentStringKey + "->" + currentStringVal);
            currentStringVal = "";
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {

        if (qName.contentEquals("string") || qName.contentEquals("string-array"))
        {
            currentStringKey = attributes.getValue("name");
            checkOn = true;
            itemNo = 0;
        } else if (qName.contentEquals("item"))
        {
            checkOn = true;
            itemNo++;
            currentStringVal += itemNo + ".";
        } else
        {
            checkOn = false;
        }
    }
}
