package com.los;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopPhrasesTest {
    //I would prefer to have here Spock Framework to allow shared local variables across tests to not read file
    // again and again, and also to make them stepwise. But JUnit is goes with any IDE so I took it for now.

    @BeforeAll
    static void setup() {
        try (PrintWriter writer = new PrintWriter("test.txt", "UTF-8")) {
            for (int i = 0; i < 100000; i++) {
                writer.println(
                        "Line | " + i + "| Long | Made | for | TeStInG | this | awesome     | case | Russian word: ворд |" +
                                "Line | is | Long | Made | " + i + " | TeStInG | this | awesome     | case | Russian word: ворд |" +
                                "Line | is | Long | Made | for | TeStInG | this | awesome     | case | Russian word: ворд |" +
                                "Line | is | Long | Made | for | TeStInG | this | awesome     | case | Russian word: ворд |" +
                                "Line | is | Long | Made | for | TeStInG | this | awesome     | case | Russian word: ворд"
                ); // 50 phrases in row
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    @DisplayName("Working fine with correct input")
    void test1() {
        Map<String, Long> actual = TopPhrases.countTopPhrases("test.txt");
        assertTrue(500000L == actual.get("line"));
        assertTrue(100000 == actual.size());
    }

    @Test
    @DisplayName("No uppercase symbols in keys")
    void test2() {
        Map<String, Long> actual = TopPhrases.countTopPhrases("test.txt");
        assertTrue(actual.keySet().stream().noneMatch((String key) -> key.matches("[A-Z]+")));
    }

    @Test
    @DisplayName("Have phrases not only single words")
    void test3() {
        Map<String, Long> actual = TopPhrases.countTopPhrases("test.txt");
        assertTrue(actual.keySet().stream().anyMatch((String key) -> key.contains(" ")));
    }

    @Test
    @DisplayName("Fails fast when input is missing")
    void test4() {
        assertThrows(RuntimeException.class, () -> TopPhrases.countTopPhrases("notExistfile.txt"));
    }
}