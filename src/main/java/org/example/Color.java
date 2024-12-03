package org.example;
import jakarta.persistence.*;

@Entity
@Table(name="color")
public class Color  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int r;

    @Column(nullable = false)
    private int g;

    @Column(nullable = false)
    private int b;

    @Column(nullable = false)
    private int alpha;


    public Color() {}

    public Color (int r, int g, int b, int alpha){
        if(r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255 || alpha < 0 || alpha > 255) {
            throw new IllegalArgumentException("Skladowe nie mieszcza sie w przedziale.");
        }
        this.r = r;
        this.g = g;
        this.b = b;
        this.alpha = alpha;
    }

    public Color (int r, int g, int b) {
        this(r, g, b, 0);
    }

    public String toAnsiCode() {
        return String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
    }

    @Override
    public String toString() {
        return "Red: " + r + ", Green: " + g + ", Blue: " + b + ", Alpha: " + alpha;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getAlpha() {
        return alpha;
    }
}