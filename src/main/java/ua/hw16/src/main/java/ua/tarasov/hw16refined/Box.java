package ua.tarasov.hw16refined;

class Box<T> {

    private T item;

    public Box(T item) {
        this.item = item;
    }

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}
