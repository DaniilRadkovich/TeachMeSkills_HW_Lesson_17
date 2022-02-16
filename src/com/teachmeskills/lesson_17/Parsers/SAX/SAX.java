package com.teachmeskills.lesson_17.Parsers.SAX;

import com.teachmeskills.lesson_17.Parsers.IParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAX implements IParser {

    public void process(String file) {

        try{
            File inputFile = new File(file);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            PoemHandler poemHandler = new PoemHandler();
            saxParser.parse(inputFile, poemHandler);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}
