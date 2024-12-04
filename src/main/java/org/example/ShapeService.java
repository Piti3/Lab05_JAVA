package org.example;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class ShapeService {
    private final ShapeRepository shapeRepository;
    private final ColorRepository colorRepository;

    public ShapeService(ShapeRepository shapeRepository, ColorRepository colorRepository) {
        this.shapeRepository = shapeRepository;
        this.colorRepository = colorRepository;
    }

    @Transactional
    public void saveColor(Color color) {
        colorRepository.save(color);
    }

    @Transactional
    public Shape saveShape(Shape shape) {
        if (shape.getColor() != null) {
            colorRepository.save(shape.getColor());
        }
        return shapeRepository.save(shape);
    }

    public List<Shape> getAllShapes() {
        return shapeRepository.findAll();
    }
}
