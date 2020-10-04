package com.company.classes.chainResponsibility;

import com.company.classes.shapes.Circle;
import com.company.classes.shapes.Point;
import com.company.classes.shapes.Shape;

// Обработчик аргументов задающих круг
public class CircleShapeHandler extends BaseShapeHandler {

    @Override
    protected boolean isCorrectShape(String[] args) {
        return args.length == 3; // Если 3 координаты, то это точка и радиус
    }

    @Override
    protected Shape handlePackage(String[] args) {
        var x = Double.parseDouble(args[0]);
        var y = Double.parseDouble(args[1]);

        var r = Double.parseDouble(args[2]);
        return new Circle(new Point(x, y), r);
    }
}
