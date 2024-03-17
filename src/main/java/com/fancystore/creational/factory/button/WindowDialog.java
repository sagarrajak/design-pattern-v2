package com.fancystore.creational.factory.button;

public class WindowDialog implements Dialog{
    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public void render() {
        Button button = this.createButton();
        button.render();
    }
}
