package com.univer.slownews.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElementReader {
    private static final String RESOURCES_PATH = "src/main/resources/";
    private String fileName;
    private List<String> lines;

    public ElementReader(String fileName) {
        this.fileName = fileName;
        readFromFile();
    }

    private void readFromFile() {
        lines = new ArrayList<>();
        try (BufferedReader fileBuffer = new BufferedReader(new FileReader(RESOURCES_PATH + fileName));) {
            while (fileBuffer.ready()) {
                lines.add(fileBuffer.readLine());
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
