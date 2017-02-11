package com.los;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    static void countAndPrint(String file) {
        try (Stream<String> stream = Files.lines(Paths.get(file)).parallel()) {
            Map<String, Long> result = countWordsOccurrences(stream);
            result = sortAndLimitTop(result);
            printFrequentPhrases(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Long> countWordsOccurrences(Stream<String> stream) {
        return stream
                .flatMap(line -> Stream.of(line.split("\\|")))
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static Map<String, Long> sortAndLimitTop(Map<String, Long> map) {
        return map.entrySet()
                .parallelStream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(100000)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private static void printFrequentPhrases(Map<String, Long> result) {
        StringBuffer sb = new StringBuffer();
        sb.append("Most recently used phrases: \n");
        for (Map.Entry entry : result.entrySet()) {
            sb.append(String.format("%s : %s \n", entry.getKey(), entry.getValue()));
        }
        System.out.println(sb.toString());
    }
}
