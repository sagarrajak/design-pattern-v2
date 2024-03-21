package com.fancystore.behavioural.chainofresponsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EventHandlerChain {
    public static void main(String[] args) throws IOException {
        DomElement domElement = new DomElement("div");
        domElement.addEventHandler(new TouchEventHandler());
        domElement.addEventHandler(new FocusEventHandler());
        domElement.addEventHandler(new InputEventHandler());
        domElement.onEvent();
    }
}

class DomElement {
    private String name;
    public DomElement(String name) {
        this.name = name;
    }

    private DomEventHandler eventHandler = new BaseEventHandler();

    public void addEventHandler(DomEventHandler eventHandler) {
        this.eventHandler.setNext(eventHandler);
    }

    public void onEvent() throws IOException {
        this.eventHandler.handleEvent();
    }
    @Override
    public String toString() {
        return "DomElement{" +
                "name='" + name + '\'' +
                '}';
    }
}

abstract class DomEventHandler {
    public DomEventHandler getNextEventHandler() {
        return nextEventHandler;
    }

    private DomEventHandler nextEventHandler;
    public void setNextEventHandler(DomEventHandler nextEventHandler) {
        this.nextEventHandler = nextEventHandler;
    }

    abstract void handleEvent() throws IOException;

    public void handleNextEvent() throws IOException {
        if (this.nextEventHandler != null)
            this.nextEventHandler.handleEvent();
    }

    public void setNext(DomEventHandler next) {
        if (this.nextEventHandler == null)
            this.nextEventHandler = next;
        else
            this.nextEventHandler.setNext(next);
    }

    public static DomEventHandler init(DomEventHandler start, DomEventHandler ...rest) {
        DomEventHandler first = start;
        for (DomEventHandler handler: rest) {
            first.setNextEventHandler(handler);
            first = handler;
        }
        return start;
    }
}

class BaseEventHandler extends DomEventHandler {
    @Override
    void handleEvent() throws IOException {
        this.handleNextEvent();
    }
}

class TouchEventHandler extends DomEventHandler {
    @Override
    void handleEvent() throws IOException {
        System.out.println("handling touch event here");
        this.handleNextEvent();
    }
}

class InputEventHandler extends DomEventHandler {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    @Override
    void handleEvent() throws IOException {
        String s = reader.readLine();
        System.out.println("User input "+ s);
        this.handleNextEvent();
    }
}

class FocusEventHandler extends DomEventHandler {

    @Override
    void handleEvent() throws IOException {
        System.out.println("user focus in this element");
        this.handleNextEvent();
    }
}


