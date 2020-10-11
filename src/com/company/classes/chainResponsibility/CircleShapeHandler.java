package com.company.classes.chainResponsibility;

import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Circle;
import com.company.classes.shapes.Shape;

import java.util.Scanner;

// Обработчик аргументов задающих круг
public class CircleShapeHandler extends BaseShapeHandler {

    public CircleShapeHandler(String shapeName) {
        super(shapeName);
    }

    @Override
    protected Shape handlePackage(Scanner scanner) throws BuildShapeException {
        return new Circle(scanner);
    }
}
