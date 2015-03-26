/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringxmltotextconverter.parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author nsekhar
 */
public class StringXMLToHashConverter
{

    private String filePath;
    private HashMap<String, String> stringList;

    public StringXMLToHashConverter(String filePath)
    {
        this.filePath = filePath;
        this.stringList = new LinkedHashMap<>();
    }

    public void parse()
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try
        {
            saxParser = factory.newSAXParser();
            SaxHandler handler = new SaxHandler(stringList);
            saxParser.parse(filePath, handler);

        } catch (ParserConfigurationException | SAXException | IOException ex)
        {
            Logger.getLogger(StringXMLToHashConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public HashMap<String,String> getStringList()
    {
        return stringList;
    }

}
