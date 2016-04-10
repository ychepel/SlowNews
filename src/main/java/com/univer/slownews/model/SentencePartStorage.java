package com.univer.slownews.model;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SentencePartStorage {
    private String fileName;

    public SentencePartStorage(String fileName) {
        this.fileName = fileName;
        readFromFile();
    }

    private List<String> readFromFile() {
        List<String> lines = new ArrayList<>();

        try (BufferedReader fileBuffer = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName)));) {
            while (fileBuffer.ready()) {
                String s = fileBuffer.readLine();
                lines.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public String getRandomElement() {
        List<String> lines = readFromFile();
        if(lines.size() > 0) {
            int randomElement = new Random().nextInt(lines.size());
            return lines.get(randomElement);
        }
        else {
            return "";
        }
    }

}
