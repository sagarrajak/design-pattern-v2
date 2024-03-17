package com.fancystore.creational.siimple;

public class BasicSingleton {
    private int value;
    public static BasicSingleton instance = new BasicSingleton();
    private BasicSingleton() {}

    public static BasicSingleton getInstance() {
        return instance;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        BasicSingleton instance = BasicSingleton.getInstance();
        instance.setValue(125);
        System.out.println(instance.getValue());
        BasicSingleton instance2 = BasicSingleton.getInstance();
        instance2.setValue(123);
        System.out.println(instance2.getValue());
    }
}
