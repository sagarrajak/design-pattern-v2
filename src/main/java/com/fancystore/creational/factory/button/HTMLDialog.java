package com.fancystore.creational.factory.button;

public class HTMLDialog implements Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }

    @Override
    public void render() {
        Button button = this.createButton();
        button.render();
    }
}
