package ua.tarasov.hw16;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyTreeMap {

    public TreeMap<Integer, List<String>> getLengthWithWords(List<String> words) {

        TreeMap<Integer, List<String>> lengthWithWords = new TreeMap<>();
        for (String word : words) lengthWithWords.put(word.length(), Collections.singletonList(word));
        return lengthWithWords;
    }

    public void replaceKeyValue(Map<String, String> map) {

        Map<String, String> tempMap = new TreeMap<>();
        map.forEach((key, value) -> tempMap.put(value, key));
        map.clear();
        map.putAll(tempMap);
        System.out.println(map);
    }
}
