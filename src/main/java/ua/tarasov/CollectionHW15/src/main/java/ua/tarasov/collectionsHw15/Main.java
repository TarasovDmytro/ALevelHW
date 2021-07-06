package ua.tarasov.collectionsHw15;


public class Main {
    public static void main(String[] args) {
        MyCollections collection = new MyCollections();
        collection.setCollections();
        System.out.println(collection.getArrayList());
        System.out.println(collection.getLinkedList());
        System.out.println(collection.getHashSet());
        System.out.println(collection.getLinkedHashSet());
        System.out.println(collection.getTreeSet());
        System.out.println(collection.getPriorityQueue());
        System.out.println(collection.getArrayDeque());
        System.out.println(collection.getHashMap());
        System.out.println(collection.getLinkedHashMap());
        System.out.println(collection.getTreeMap());
        System.out.println(collection.myClearCollection(collection.getArrayList()));
        System.out.println(collection.myClearCollection(collection.getLinkedList()));
        System.out.println(collection.myClearCollection(collection.getArrayDeque()));
        System.out.println(collection.myClearCollection(collection.getPriorityQueue()));
        System.out.println(collection.myClearCollection(collection.getHashSet()));
        System.out.println(collection.myClearCollection(collection.getLinkedHashSet()));
        System.out.println(collection.myClearCollection(collection.getTreeSet()));
        System.out.println(collection.myClearMap(collection.getTreeMap()));
        System.out.println(collection.myClearMap(collection.getHashMap()));
        System.out.println(collection.myClearMap(collection.getLinkedHashMap()));
    }
}
