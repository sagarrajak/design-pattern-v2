package com.fancystore.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class PropertyChangeExample implements Observer<Person> {

    public PropertyChangeExample() {
        Person person = new Person();
        person.subscribe(this);
        for (int i=0; i<10; i++) {
            person.setAge(i);
        }
    }

    @Override
    public void handle(PropertyChangeEventArg<Person> args) {
        System.out.println(args.propertyName+" "+args.newValue);
    }

    public static void main(String[] args) {
        PropertyChangeExample propertyChangeExample = new PropertyChangeExample();
    }
}

class Person extends Observable<Person>{
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.propertyChange(this, "age", age);
        this.age = age;
    }

    private int age;
}


class PropertyChangeEventArg<T> {
    public T source;
    public String propertyName;
    public Object newValue;

    public PropertyChangeEventArg(T source, String propertyName, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}

interface Observer<T> {
    void handle(PropertyChangeEventArg<T> args);
}

class Observable<T> {
    private final List<Observer<T>> observers = new ArrayList<>();
    public void subscribe(Observer<T> observer) {
        observers.add(observer);
    }

    protected void propertyChange(T source, String propertyName, Object newvalue) {
        for(var observer: observers) {
            observer.handle(new PropertyChangeEventArg<T>(source, propertyName, newvalue));
        }
    }
}