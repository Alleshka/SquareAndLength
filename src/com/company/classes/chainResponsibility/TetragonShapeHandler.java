package com.company.classes.chainResponsibility;

import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Shape;
import com.company.classes.shapes.Tetragon;

import java.util.Scanner;

// Обработчик аргументов для прямоугольника
public class TetragonShapeHandler extends BaseShapeHandler {

    public TetragonShapeHandler(String shapeName) {
        super(shapeName);
    }

    @Override
    protected Shape handlePackage(Scanner scanner) throws BuildShapeException {
        return new Tetragon(scanner);
    }
}
