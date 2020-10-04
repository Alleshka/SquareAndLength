package com.company.classes.chainResponsibility;

import com.company.classes.shapes.Point;
import com.company.classes.shapes.Shape;
import com.company.classes.shapes.Vector;

public class VectorShapeHandler extends BaseShapeHandler{
    @Override
    protected boolean isCorrectShape(String[] args) {
        return args.length == 4; // Если 4 аргумента, то это координаты двух точек
    }

    @Override
    protected Shape handlePackage(String[] args) {
        var x1 = Double.parseDouble(args[0]);
        var x2 = Double.parseDouble(args[1]);
        var x3 = Double.parseDouble(args[3]);
        var x4 = Double.parseDouble(args[4]);

        return new Vector(new Point(x1, x2), new Point(x3, x4));
    }
}
