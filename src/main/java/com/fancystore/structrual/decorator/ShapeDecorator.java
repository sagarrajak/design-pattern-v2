package com.fancystore.structrual.decorator;

interface Shape {
    String getInfo();
}

class CircleShape implements  Shape {
    private int radious;

    CircleShape(int radious) {
        this.radious = radious;
    }

    @Override
    public String getInfo() {
        return "Circle of radius " + radious;
    }
}

class SqrareShape implements Shape {
    private int sideLength;

    SqrareShape(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String getInfo() {
        return "Square of side " + sideLength;
    }
}

class ColorShapeDecorator implements Shape {
    private Shape shape;
    private String color;

    public  ColorShapeDecorator(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String getInfo() {
        return shape.getInfo() + " of color " + this.color;
    }
}

class TransparencyShapeDecorator implements Shape {
    private Shape shape;
    private float transperency;

    public  TransparencyShapeDecorator(Shape shape, float transperency) {
        this.shape = shape;
        this.transperency = transperency;
    }

    @Override
    public String getInfo() {
        return shape.getInfo() + " of transparency " + this.transperency;
    }
}

public class ShapeDecorator {
    public static void main(String[] args) {
        CircleShape circleShape = new CircleShape(12);
        TransparencyShapeDecorator transparencyShapeDecorator = new TransparencyShapeDecorator(circleShape, 12);
        ColorShapeDecorator red = new ColorShapeDecorator(transparencyShapeDecorator, "Red");
        System.out.println(red.getInfo());
    }
}
