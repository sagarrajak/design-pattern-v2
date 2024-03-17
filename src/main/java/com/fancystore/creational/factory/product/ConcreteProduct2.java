package com.fancystore.creational.factory.product;

public class ConcreteProduct2 implements Creator {

    @Override
    public Product ceateProduct() {
        return new Product2();
    }
}
