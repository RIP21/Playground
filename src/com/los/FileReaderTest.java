package com.los;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;

class FileReaderTest {
    @Test
    void wordCount() {
        FileReader.countAndPrint("test.txt");
    }

    @Test
    void generateData() { //Must be a setup method, but to not regenerate it all the time when dev. let it be "Test"
        try (PrintWriter writer = new PrintWriter("test.txt", "UTF-8")) {
            for (int i = 0; i < 1000000; i++) {
                writer.println("Line | is | Long | Made | for | TeStInG | this | awesome     | case | Russian word: ворд |" +
                        "Line | is | Long | Made | for | TeStInG | this | awesome     | case | Russian word: ворд |" +
                        "Line | is | Long | Made | for | TeStInG | this | awesome     | case | Russian word: ворд |" +
                        "Line | is | Long | Made | for | TeStInG | this | awesome     | case | Russian word: ворд |" +
                        "Line | is | Long | Made | for | TeStInG | this | awesome     | case | Russian word: ворд"); // 50 phrases in row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}