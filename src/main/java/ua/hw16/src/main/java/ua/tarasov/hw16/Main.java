package ua.tarasov.hw16;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        MyTreeMap lengthWithWords = new MyTreeMap();
        List<String> words = new ArrayList<>();

        words.add("1one");
        words.add("two");
        words.add("three");

        System.out.println(lengthWithWords.getLengthWithWords(words));

        MyTreeMap keyValueChangeOfValues = new MyTreeMap();
        Map<String, String> map = new TreeMap<>();

        map.put("one", "один");
        map.put("two", "два");
        map.put("three", "три");
        map.put("four", "четыре");
        map.put("five", "пять");

        keyValueChangeOfValues.replaceKeyValue(map);
    }
}
