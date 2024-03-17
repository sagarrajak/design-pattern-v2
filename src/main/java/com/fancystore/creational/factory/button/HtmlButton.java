package com.fancystore.creational.factory.button;

public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button>Button</button>");
    }

    @Override
    public void onClick() {
        System.out.println("HTML button click was called");
    }

    public HtmlButton() {
        System.out.println("This is html button!");
    }
}
