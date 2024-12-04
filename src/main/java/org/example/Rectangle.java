package org.example;
import jakarta.persistence.*;

@Entity
@Table(name = "rectangle")
public class Rectangle extends Shape {
    @Column(nullable = false)
    private double width;
    @Column(nullable = false)
    private double height;


    public Rectangle() {}

    public Rectangle(double width, double height, Color color) {
        super(color);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Zmienne musza byc dodatnie.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
    @Override
    public double getPerimeter() {
        return 2*(width+height);
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

}
