package com.company.classes.chainResponsibility;

import com.company.classes.Constants;
import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Point;
import com.company.classes.shapes.Shape;

// Обработчик аргументов для точки
public class PointShapeHandler extends BaseShapeHandler {


    public PointShapeHandler(String shapeName) {
        super(shapeName);
    }

    @Override
    protected Shape handlePackage(String[] args) throws BuildShapeException {
        return new Point(args);
    }
}
