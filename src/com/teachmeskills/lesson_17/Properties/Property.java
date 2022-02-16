package com.teachmeskills.lesson_17.Properties;


public class Property {

    private String XMLPath;
    private int parseValue;

    public Property(String XMLPath, int parseValue) {
        this.XMLPath = XMLPath;
        this.parseValue = parseValue;
    }

    public Property() {
    }

    public String getXMLPath() {
        return XMLPath;
    }
    public int getParseValue() {
        return parseValue;
    }
}
