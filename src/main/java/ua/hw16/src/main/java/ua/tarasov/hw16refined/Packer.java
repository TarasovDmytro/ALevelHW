package ua.tarasov.hw16refined;

public class Packer<T> {

    public static void main(String[] args) {

        Food foodItem = new Food();
        Cake cakeItem = new Cake();
        Packer<Food> packer = new Packer<>();
        Box<Food> foodBox = new Box<>(foodItem);
        Box<Cake> cakeBox = new Box<>(cakeItem);
        packer.repackage(foodBox, cakeBox);
    }

    public void repackage(Box<T> to, Box<? extends T> from) {
        to.put(from.get());
    }

}

