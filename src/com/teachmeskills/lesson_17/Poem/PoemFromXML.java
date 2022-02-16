package com.teachmeskills.lesson_17.Poem;

import java.util.List;

public class PoemFromXML {
    private String firstName;
    private String lastName;
    private String title;
    private List<String> poemLines;

    public PoemFromXML(String firstName, String lastName, String title, List<String> poemLines) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.poemLines = poemLines;
    }

    public PoemFromXML(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPoemLines() {
        return poemLines;
    }

    public void setPoemLines(List<String> poemLines) {
        this.poemLines = poemLines;
    }

    @Override
    public String toString() {
        return "PoemFromXML{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", poemLines=" + poemLines +
                '}';
    }
}
