package ua.tarasov.collectionsHw15;

import java.util.*;
import java.util.stream.IntStream;


class MyCollections {

    private final Set<String> hashSet = new HashSet<>();
    private final Set<String> treeSet = new TreeSet<>();
    private final Set<String> linkedHashSet = new LinkedHashSet<>();
    private final List<String> arrayList = new ArrayList<>();
    private final List<String> linkedList = new LinkedList<>();
    private final Deque<String> arrayDeque = new ArrayDeque<>();
    private final Queue<String> priorityQueue = new PriorityQueue<>();
    private final Map<Integer, String> hashMap = new HashMap<>();
    private final Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
    private final Map<Integer, String> treeMap = new TreeMap<>();

    void setCollections() {

        arrayList.add("January");
        arrayList.add("February");
        arrayList.add("March");
        arrayList.add("April");
        arrayList.add("May");
        arrayList.add("Jun");
        arrayList.add("July");
        arrayList.add("August");
        arrayList.add("September");
        arrayList.add("October");
        arrayList.add("November");
        arrayList.add("December");

        hashSet.addAll(arrayList);

        treeSet.addAll(arrayList);

        linkedHashSet.addAll(arrayList);

        linkedList.addAll(arrayList);

        arrayDeque.addAll(arrayList);

        priorityQueue.addAll(arrayList);

        IntStream.range(0, arrayList.size()).forEach(i -> hashMap.put(i + 1, arrayList.get(i)));

        linkedHashMap.putAll(hashMap);

        treeMap.putAll(hashMap);
    }

    public List<String> getArrayList() {
        return arrayList;
    }

    public Set<String> getHashSet() {
        return hashSet;
    }

    public Set<String> getTreeSet() {
        return treeSet;
    }

    public Set<String> getLinkedHashSet() {
        return linkedHashSet;
    }

    public List<String> getLinkedList() {
        return linkedList;
    }

    public Deque<String> getArrayDeque() {
        return arrayDeque;
    }

    public Queue<String> getPriorityQueue() {
        return priorityQueue;
    }

    public Map<Integer, String> getHashMap() {
        return hashMap;
    }

    public Map<Integer, String> getLinkedHashMap() {
        return linkedHashMap;
    }

    public Map<Integer, String> getTreeMap() {
        return treeMap;
    }

    public Collection<String> myClearCollection(Collection<String> collection) {
        List<String> tempList = new ArrayList<>(collection);
        tempList.forEach(collection::remove);
        return collection;
    }

    public Map<Integer, String> myClearMap(Map<Integer, String> map) {
        Map<Integer, String> tempMap = new HashMap<>(map);
        tempMap.forEach(map::remove);
        return map;
    }
}
