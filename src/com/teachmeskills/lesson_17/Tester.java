package com.teachmeskills.lesson_17;

import com.teachmeskills.lesson_17.Parsers.DOM.DOM;
import com.teachmeskills.lesson_17.Parsers.SAX.SAX;
import com.teachmeskills.lesson_17.Properties.Property;

public class Tester {
    public static void main(String[] args) {

        Property property = new Property("C:\\Users\\mradk\\IdeaProjects\\TeachMeSkills_HW_Lesson_17\\src\\com\\teachmeskills\\lesson_17\\FilesToParse\\hw.xml", 1);

        String xmlPath = property.getXMLPath();

        if (property.getParseValue() == 1) {
            SAX sax = new SAX();
            sax.process(xmlPath);
            System.out.println("Sax parser finished the job!");
        } else if (property.getParseValue() == 2) {
            DOM dom = new DOM();
            System.out.println("DOM parser finished the job!");
            dom.process(xmlPath);
        } else {
            System.out.println("Wrong properties parameter!");
        }
    }
}
