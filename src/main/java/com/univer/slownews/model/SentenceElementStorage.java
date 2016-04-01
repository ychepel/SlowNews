package com.univer.slownews.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SentenceElementStorage {
    private static final String RESOURCES_PATH = "/WEB-INF/classes/";
    private String fileName;
    private List<String> lines;

    public SentenceElementStorage(String fileName) {
        this.fileName = fileName;
        readFromFile();
    }

    private void readFromFile() {
        lines = new ArrayList<>();
        try (BufferedReader fileBuffer = new BufferedReader(new FileReader(RESOURCES_PATH + fileName));) {
            while (fileBuffer.ready()) {
                String s = fileBuffer.readLine();
                lines.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomElement() {
        int randomElement = new Random().nextInt(lines.size());
        return lines.get(randomElement);
    }
}
