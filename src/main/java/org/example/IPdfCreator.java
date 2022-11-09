package org.example;

// Cel klasy: zdefiniowanie funckji jakie powinien miec kreator PDF-ow
public interface IPdfCreator {
    void addTextLine(String[] texts, boolean[] bolds, boolean disableBorder);
    void addEmptyLines(int number);
    String save(String fileName);
}
