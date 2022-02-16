package com.teachmeskills.lesson_17.Parsers.DOM;

import com.teachmeskills.lesson_17.Parsers.IParser;
import com.teachmeskills.lesson_17.Poem.PoemFromXML;
import com.teachmeskills.lesson_17.Poem.PoemWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DOM implements IParser {

    List<PoemFromXML> poemFromDOM = new ArrayList<>();
    PoemFromXML poem1 = new PoemFromXML();

    public void process(String file) {

        try {
            File xmlFile = new File(file);

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nList1 = document.getElementsByTagName("author");
            getAuthorFromXLM(nList1);

            NodeList nList2 = document.getDocumentElement().getElementsByTagName("title");
            getTitleFromXLM(nList2);

            NodeList nList3 = document.getDocumentElement().getElementsByTagName("line");
            getLinesFromXLM(nList3);

            poemFromDOM.add(poem1);
            PoemWriter.writePoemInTxt(poemFromDOM);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAuthorFromXLM(NodeList nList) {

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) nNode;

                Node node1 = element.getElementsByTagName("firstName").item(0);
                if (node1 != null) {
                    String firstName = node1.getTextContent();
                    poem1.setFirstName(firstName);
                } else {
                    System.out.println("First name not found in this XML!");
                }

                Node node2 = element.getElementsByTagName("lastName").item(0);
                if (node2 != null) {
                    String lastName = node2.getTextContent();
                    poem1.setLastName(lastName);
                } else {
                    System.out.println("Last name not found in this XML!");
                }
            }
        }
    }

    private void getTitleFromXLM(NodeList nList) {

        String title;

        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            title = node.getTextContent();
            poem1.setTitle(title);
        }
    }

    private void getLinesFromXLM(NodeList nList) {

        List<String> linesOfPoem = new ArrayList<>();

        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            linesOfPoem.add(node.getTextContent());
        }

        poem1.setPoemLines(linesOfPoem);
    }
}
