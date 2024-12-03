package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Utworzenie obiektu DAO
        ShapeDAO shapeDAO = new ShapeDAO();

        // Tworzenie obiektów Color
        System.out.println("Zapisywanie kolorów do bazy");
        Color red = new Color(255, 129, 0);
        Color green = new Color(220, 255, 0);

        // Zapis kolorów najpierw
        shapeDAO.saveColor(red);
        shapeDAO.saveColor(green);
        System.out.println("Kolory zapisane");

        // Tworzenie obiektów Rectangle i Triangle z referencją do zapisanych kolorów
        Rectangle rectangle = new Rectangle(5.0, 4.0, red);
        Triangle triangle = new Triangle(7.0, 4.0, 4.0, 4, green);

        // Zapis obiektów do bazy
        System.out.println("\nZapisywanie figur do bazy");
        shapeDAO.save(rectangle);
        shapeDAO.save(triangle);
        System.out.println("Figury zapisane!");

        // Odczyt danych z bazy
        System.out.println("\nOdczytywanie wszystkich figur z bazy:");
        List<Shape> shapes = shapeDAO.findAll();
        for (Shape shape : shapes) {
            System.out.println("\nFigura: " + shape.getClass().getSimpleName());
            System.out.println("Kolor: " + shape.getColorDescription());
            System.out.println("Pole: " + shape.getArea());
            System.out.println("Obwód: " + shape.getPerimeter());
        }

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        System.out.println("\n================= Rysowanie figur =================");
        shapeRenderer.render(shapes);

        // Zamknięcie zasobów
        shapeDAO.close();
    }
}
