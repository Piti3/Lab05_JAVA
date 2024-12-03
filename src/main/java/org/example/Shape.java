package org.example;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "shape_type", discriminatorType = DiscriminatorType.STRING) //problem z instancjowaniem klasy abstrakcyjnej
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="color_id", nullable = false)
    private Color color;


    public Shape() {}

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public String getColorDescription() {
        return "Red: " + color.getR() + ", Green: " + color.getG() + ", Blue: " + color.getB() + ", Alpha: " + color.getAlpha();
    }
}
