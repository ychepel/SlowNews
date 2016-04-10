package com.univer.slownews.model;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SentencePartStorage {
    private String fileName;
    private List<String> lines;

    public SentencePartStorage(String fileName) {
        this.fileName = fileName;
        readFromFile();
    }

    private void readFromFile() {
        lines = new ArrayList<>();

        try (BufferedReader fileBuffer = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName)));) {
            while (fileBuffer.ready()) {
                String s = fileBuffer.readLine();
                lines.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomElement() {
        if(lines.size() > 0) {
            int randomElement = new Random().nextInt(lines.size());
            return lines.get(randomElement);
        }
        else {
            return "";
        }
    }

}
