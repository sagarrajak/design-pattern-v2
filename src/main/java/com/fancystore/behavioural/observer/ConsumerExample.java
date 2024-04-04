package com.fancystore.behavioural.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        PersonNew personNew = new PersonNew();
        personNew.eventsHandler.addHandler(personNewPropertyChangeEventArg -> {
            System.out.println(personNewPropertyChangeEventArg.propertyName+" "+personNewPropertyChangeEventArg.newValue);
        });
        for (int i=0; i<100; i++)
            personNew.setAge(i);
    }
}

class Event<TArgs> {
    private int count = 0;
    private final Map<Integer, Consumer<TArgs>> handlers = new HashMap<>();

    public MySubscription addHandler(Consumer<TArgs> consumer) {
        int i = count++;
        handlers.put(i, consumer);
        return new MySubscription(this, i);
    }

    public void fire(TArgs args) {
        for (var handler: handlers.values()) {
            handler.accept(args);
        }
    }

    private class MySubscription implements AutoCloseable {
        private Event<TArgs> event;
        private Integer counter;

        public MySubscription(Event<TArgs> event, Integer counter) {
            this.event = event;
            this.counter = counter;
        }

        @Override
        public void close() throws Exception {
            event.handlers.remove(counter);
        }
    }
}

class PersonNew {
    public Event<PropertyChangeEventArg<PersonNew>> eventsHandler = new Event<>();
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        this.eventsHandler.fire(new PropertyChangeEventArg<>(this, "age", age));
    }

    private int age;
}



