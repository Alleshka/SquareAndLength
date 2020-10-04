package com.company.classes.chainResponsibility;

import com.company.classes.shapes.Point;
import com.company.classes.shapes.Shape;

// Обработчик аргументов для точки
public class PointShapeHandler extends BaseShapeHandler {

    @Override
    protected boolean isCorrectShape(String[] args) {
        return args.length == 2; // Если всего 2 числа, то это точка
    }

    @Override
    protected Shape handlePackage(String[] args) {
        var x = Double.parseDouble(args[0]);
        var y = Double.parseDouble(args[1]);
        return new Point(x, y);
    }
}
