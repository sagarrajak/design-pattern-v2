package com.fancystore.structrual.bridge;


// vector renderer and circle renderer
// shape circle

interface Renderer {
    void render(float radius);
}

public class RenderExample {
    public static void main(String[] args) {
        VectorRenderer vectorRenderer = new VectorRenderer();
        RasterRenderer rasterRenderer = new RasterRenderer();
        CicrleShape cicrleShapeVector = new CicrleShape(vectorRenderer, 12);
        CicrleShape cicrleShapeRaster = new CicrleShape(rasterRenderer, 20);
        cicrleShapeVector.draw();
        cicrleShapeRaster.draw();
    }
}

class VectorRenderer implements Renderer {

    @Override
    public void render(float radius) {
        System.out.println("Rendering using vector render of radius" + radius);
    }
}

class RasterRenderer implements Renderer {

    @Override
    public void render(float radius) {
        System.out.println("Rendering using vector render of radius" + radius);
    }
}


abstract class Shape {
    Renderer renderer;
    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    abstract  public void draw();
}

class CicrleShape extends  Shape {
    private int radius;
    public CicrleShape(Renderer renderer, int radius) {
        super(renderer);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("drawing circle shape");
        this.renderer.render(this.radius);
    }
}





