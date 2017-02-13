package com.los;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TopPhrases {

    static Map<String, Long> countTopPhrases(String file) {
        try (Stream<String> stream = Files.lines(Paths.get(file)).parallel()) {
            return stream
                    .flatMap(line -> Stream.of(line.split("\\|")))
                    .map(String::trim)
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .parallelStream()
                    .sorted((o1, o2) -> new PhrasesComparator().compare(o1, o2))
                    .limit(100000)
                    .collect(Collectors.toMap(
                            Entry::getKey,
                            Entry::getValue,
                            (v1, v2) -> v1,
                            LinkedHashMap::new)
                    );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PhrasesComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Entry<String, Long> e1 = (Entry<String, Long>) o1;
        Entry<String, Long> e2 = (Entry<String, Long>) o2;
        if (e1.getValue().equals(e2.getValue())) {
            return e1.getKey().compareTo(e2.getKey());
        } else return -e1.getValue().compareTo(e2.getValue());
    }
}
