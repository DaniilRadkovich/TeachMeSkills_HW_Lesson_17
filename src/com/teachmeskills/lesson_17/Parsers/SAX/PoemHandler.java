package com.teachmeskills.lesson_17.Parsers.SAX;

import com.teachmeskills.lesson_17.Poem.PoemFromXML;
import com.teachmeskills.lesson_17.Poem.PoemWriter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PoemHandler extends DefaultHandler {

    private List<PoemFromXML> poemList = new ArrayList<>();
    private List<String> lineList = new ArrayList<>();
    private String firstName, lastName, title, lastElementName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        lastElementName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String information = new String(ch, start, length);

        information = information.replace("\n", "").trim();

        if (!information.isEmpty()) {
            if (lastElementName.equals("firstName"))
                firstName = information;
            if (lastElementName.equals("lastName"))
                lastName = information;
            if (lastElementName.equals("title"))
                title = information;
            if (lastElementName.equals("line")) {
                lineList.add(information);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if ((lastName != null && !lastName.isEmpty()) && (firstName != null && !firstName.isEmpty())
                && (title != null && !title.isEmpty()) && "lines".equals(qName)) {

            poemList.add(new PoemFromXML(firstName, lastName, title, lineList));
            lastName = null;
            firstName = null;
            title = null;
            lineList = null;
        }
    }

    @Override
    public void endDocument() throws SAXException {

        PoemWriter.writePoemInTxt(poemList);

    }
}
