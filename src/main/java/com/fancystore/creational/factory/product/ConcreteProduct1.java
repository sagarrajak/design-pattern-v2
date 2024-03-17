package com.fancystore.creational.factory.product;

public class ConcreteProduct1 implements Creator {

    @Override
    public Product ceateProduct() {
        return new Product1();
    }
}
