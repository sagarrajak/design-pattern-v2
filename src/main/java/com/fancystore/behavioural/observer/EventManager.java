package com.fancystore.behavioural.observer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

abstract class AbstractEvent<T> {
    protected String type;

    protected T payload;

    public AbstractEvent(String type, T payload) {
        this.type = type;
        this.payload = payload;
    }
}

interface EventListener<T> {
    void listen(AbstractEvent<T> event);
}

public class EventManager<T> {
    HashMap<String, List<EventListener<T>>> listeners = new HashMap<>();

    public EventManager(String ...operations) {
        for (String operation: operations) {
            listeners.put(operation, new ArrayList<>());
        }
    }

    public void addSubscriber(String eventType, EventListener<T> listener) {
        List<EventListener<T>> eventListeners = listeners.get(eventType);
        if (eventListeners == null) return;
        eventListeners.add(listener);
    }

    public void unsubscribe(String eventType, EventListener<T> listener) {
        List<EventListener<T>> eventListeners = listeners.get(eventType);
        eventListeners.remove(listener);
    }

    public  void notify(String eventType, AbstractEvent<T> event) {
        List<EventListener<T>> eventListeners = listeners.get(eventType);
        for (EventListener<T> eventListener: eventListeners) {
            eventListener.listen(event);
        }
    }
}


class Key {
    Integer keyId;
    String keyName;

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Key(Integer keyId, String keyName) {
        this.keyId = keyId;
        this.keyName = keyName;
    }

    @Override
    public String toString() {
        return "Key{" +
                "keyId=" + keyId +
                ", keyName='" + keyName + '\'' +
                '}';
    }
}

class TouchEvent extends AbstractEvent<String> {
    public TouchEvent(String payload) {
        super("touch", payload);
    }
}

class KeyPressEvent extends AbstractEvent<String> {
    @Override
    public String toString() {
        return "KeyPressEvent{" +
                "key=" + key +
                '}';
    }

    public Key key;

    public KeyPressEvent(String name, Key payload) {
        super("keypress", name);
        this.key = payload;
    }
}

class EventManagerPattern {
    public static void main(String[] args) {
        EventManager<String> stringEventManager = getStringEventManager();
        stringEventManager.notify("touch", new TouchEvent("you touched this!"));
        stringEventManager.notify("touch", new TouchEvent("you touched this2!"));
        stringEventManager.notify("touch", new TouchEvent("you touched this3!"));
        stringEventManager.notify("keypress", new KeyPressEvent("This is keypress", new Key(12, "Enter")));
    }

    private static EventManager<String> getStringEventManager() {
        EventManager<String> stringEventManager = new EventManager<>("touch", "keypress");
        stringEventManager.addSubscriber("touch", event -> {
            System.out.println("inside first touch event listener!");
        });
        stringEventManager.addSubscriber("touch", event -> {
            System.out.println("inside second touch event listener!");
        });
        stringEventManager.addSubscriber("keypress", event -> {
            var castEvent = (KeyPressEvent)event;
            System.out.println("inside first keypress listener!");
            System.out.println(castEvent.key);
        });
        return stringEventManager;
    }
}
