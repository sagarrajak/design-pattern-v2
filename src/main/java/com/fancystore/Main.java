package com.fancystore;

import com.fancystore.creational.factory.button.HTMLDialog;
import com.fancystore.creational.factory.button.WindowDialog;

public class Main {
    public static void main(String[] args) {
//        ConcreteProduct1 concreteProduct1 = new ConcreteProduct1();
//        ConcreteProduct2 concreteProduct2 = new ConcreteProduct2();
//        Product product1 = concreteProduct1.ceateProduct();
//        Product product2 = concreteProduct2.ceateProduct();
//        product1.operation();
//        product2.operation();

        WindowDialog windowDialog = new WindowDialog();
        windowDialog.createButton();
        HTMLDialog htmlDialog = new HTMLDialog();
        htmlDialog.render();
    }
}