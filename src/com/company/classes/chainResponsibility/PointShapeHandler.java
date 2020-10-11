package com.company.classes.chainResponsibility;

import com.company.classes.Constants;
import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Point;
import com.company.classes.shapes.Shape;

import java.util.Scanner;

// Обработчик аргументов для точки
public class PointShapeHandler extends BaseShapeHandler {
    public PointShapeHandler(String shapeName) {
        super(shapeName);
    }

    @Override
    protected Shape handlePackage(Scanner scanner) throws BuildShapeException {
        return new Point(scanner);
    }
}
