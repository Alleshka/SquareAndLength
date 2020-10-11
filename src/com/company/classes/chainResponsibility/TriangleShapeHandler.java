package com.company.classes.chainResponsibility;

import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Shape;
import com.company.classes.shapes.Triangle;

import java.util.Scanner;

public class TriangleShapeHandler extends BaseShapeHandler {

    public TriangleShapeHandler(String shapeName) {
        super(shapeName);
    }

    @Override
    protected Shape handlePackage(Scanner scanner) throws BuildShapeException {
        return new Triangle(scanner);
    }
}
