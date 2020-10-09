package com.company.classes.chainResponsibility;

import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Circle;
import com.company.classes.shapes.Shape;

// Обработчик аргументов задающих круг
public class CircleShapeHandler extends BaseShapeHandler {

    public CircleShapeHandler(String shapeName) {
        super(shapeName);
    }

    @Override
    protected Shape handlePackage(String[] args) throws BuildShapeException {
        return new Circle(args);
    }
}
