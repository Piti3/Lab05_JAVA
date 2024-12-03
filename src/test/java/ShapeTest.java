package org.example;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.hibernate.SessionFactory;
import java.util.List;


class ColorTest {

    @Test
    void toAnsiCode() {
        Color color = new Color(255, 0, 0);
        String expectedAnsiCode = "\u001B[38;2;255;0;0m";
        assertEquals(expectedAnsiCode, color.toAnsiCode());
    }

    @Test
    void testToString() {
        Color color = new Color(255, 0, 0, 128);
        String expectedString = "Red: 255, Green: 0, Blue: 0, Alpha: 128";
        assertEquals(expectedString, color.toString());
    }

    @Test
    void getR() {
        Color color = new Color(255, 0, 0);
        assertEquals(255, color.getR());
    }

    @Test
    void getG() {
        Color color = new Color(255, 128, 0);
        assertEquals(128, color.getG());
    }

    @Test
    void getB() {
        Color color = new Color(255, 128, 64);
        assertEquals(64, color.getB());
    }

    @Test
    void getAlpha() {
        Color color = new Color(255, 128, 64, 200);
        assertEquals(200, color.getAlpha());
    }
}


class MainTest {

    @Test
    void main() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

class RectangleTest {

    @Test
    void getArea() {
        Rectangle rectangle = new Rectangle(5.0, 4.0, new Color(255, 0, 0));
        assertEquals(20.0, rectangle.getArea());
    }

    @Test
    void getPerimeter() {
        Rectangle rectangle = new Rectangle(5.0, 4.0, new Color(255, 0, 0));
        assertEquals(18.0, rectangle.getPerimeter());
    }

    @Test
    void getA() {
        Rectangle rectangle = new Rectangle(5.0, 4.0, new Color(255, 0, 0));
        assertEquals(5.0, rectangle.getA());
    }

    @Test
    void getB() {
        Rectangle rectangle = new Rectangle(5.0, 4.0, new Color(255, 0, 0));
        assertEquals(4.0, rectangle.getB());
    }
}

class ShapeDAOTest {

    private ShapeDAO shapeDAO;

    @BeforeEach
    void setUp() {
        shapeDAO = new ShapeDAO();
    }

    @AfterEach
    void tearDown() {
        shapeDAO.close();
    }

    @Test
    void saveColor() {
        Color color = new Color(128, 64, 32);
        shapeDAO.saveColor(color);
        assertNotNull(color.getR());
    }

    @Test
    void save() {
        Shape rectangle = new Rectangle(5.0, 4.0, new Color(128, 64, 32));
        shapeDAO.save(rectangle);
        assertNotNull(rectangle.getColor());
    }

    @Test
    void findAll() {
        assertDoesNotThrow(() -> shapeDAO.findAll());
    }
}

class ShapeDescriberTest {

    @Test
    void describe() {
        ShapeDescriber describer = new ShapeDescriber();
        Rectangle rectangle = new Rectangle(4, 5, new Color(0, 0, 255));

        assertDoesNotThrow(() -> describer.describe(rectangle));
    }
}

class ShapeRendererTest {

    @Test
    void render() {
        ShapeRenderer renderer = new ShapeRenderer();
        List<Shape> shapes = List.of(
                new Rectangle(5.0, 4.0, new Color(255, 0, 0)),
                new Triangle(3.0, 4.0, 5.0, 2.5, new Color(0, 255, 0))
        );

        assertDoesNotThrow(() -> renderer.render(shapes));
    }
}

class ShapeTest {

    @Test
    void getColorDescription() {
        Shape rectangle = new Rectangle(5.0, 4.0, new Color(255, 128, 0));
        String expectedDescription = "Red: 255, Green: 128, Blue: 0, Alpha: 0";
        assertEquals(expectedDescription, rectangle.getColorDescription());
    }
}

class TriangleTest {

    @Test
    void getArea() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, 2.5, new Color(0, 255, 0));
        assertEquals(3.75, triangle.getArea());
    }

    @Test
    void getPerimeter() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, 2.5, new Color(0, 255, 0));
        assertEquals(12.0, triangle.getPerimeter());
    }

    @Test
    void getA() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, 2.5, new Color(0, 255, 0));
        assertEquals(3.0, triangle.getA());
    }

    @Test
    void getH() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, 2.5, new Color(0, 255, 0));
        assertEquals(2.5, triangle.getH());
    }
}
