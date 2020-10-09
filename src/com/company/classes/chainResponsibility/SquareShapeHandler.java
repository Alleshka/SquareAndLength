package com.company.classes.chainResponsibility;

import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Shape;
import com.company.classes.shapes.Square;

// Обработчик аргументов для квадрата
public class SquareShapeHandler extends BaseShapeHandler {

    public SquareShapeHandler(String shapeName) {
        super(shapeName);
    }

    @Override
    protected Shape handlePackage(String[] args) throws BuildShapeException {
        return new Square(args);
    }
}
