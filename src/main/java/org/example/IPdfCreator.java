package org.example;

public interface IPdfCreator {
    void addTextLine(String[] texts, boolean[] bolds, boolean disableBorder);
    void addEmptyLines(int number);

    String save(String fileName);
}
