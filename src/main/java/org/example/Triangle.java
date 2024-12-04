package org.example;
import jakarta.persistence.*;

@Entity
@Table(name = "triangle")
public class Triangle extends Shape {

    @Column(nullable = false)
    private double a;
    @Column(name = "b_1", nullable = false)
    private double b;
    @Column(nullable = false)
    private double c;
    @Column(nullable = false)
    private double h;


    public Triangle() {}

    public Triangle (double a, double b, double c, double h, Color color) {
        super(color);
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("zle wartosci scian trojkata.");
        }
        if (h <= 0) {
            throw new IllegalArgumentException("Wysokosc musi byc wieksza od zera.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public double getArea() {
        return (a * h)/2;
    }
    @Override
    public double getPerimeter() {
        return a+b+c;
    }


    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getH() {
        return h;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setH(double h) {
        this.h = h;
    }
}
