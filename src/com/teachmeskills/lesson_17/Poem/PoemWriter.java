package com.teachmeskills.lesson_17.Poem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PoemWriter {

    public static void writePoemInTxt(List<PoemFromXML> list) {

        String fileName = list.get(0).getFirstName() + "_" + list.get(0).getLastName() + "_" + list.get(0).getTitle();

        try (FileWriter poemTxt = new FileWriter(fileName + ".txt")) {

            for (PoemFromXML poem : list) {
                for (String line : poem.getPoemLines()) {
                    poemTxt.write(line);
                    poemTxt.write(System.lineSeparator());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
