package com.company.classes.chainResponsibility;

import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Shape;
import com.company.classes.shapes.Tetragon;

// Обработчик аргументов для прямоугольника
public class TetragonShapeHandler extends BaseShapeHandler {

    public TetragonShapeHandler(String shapeName) {
        super(shapeName);
    }

    @Override
    protected Shape handlePackage(String[] args) throws BuildShapeException {
        return new Tetragon(args);
    }
}
