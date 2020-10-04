package com.company.classes.chainResponsibility;

import com.company.classes.Utils;
import com.company.classes.shapes.Point;
import com.company.classes.shapes.Shape;
import com.company.classes.shapes.Triangle;

public class TriangleShapeHandler extends BaseShapeHandler {
    @Override
    protected boolean isCorrectShape(String[] args) {
        // Если не 6 точек (по 2 координату на каждую), то уже не треугольник
        if (args.length == 6) {
            var p1 = new Point(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
            var p2 = new Point(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
            var p3 = new Point(Double.parseDouble(args[4]), Double.parseDouble(args[5]));

            // Если точки не лежат на одной прямой, значит это треугольник
            return !Utils.isPointsOnLine(p1, p2, p3);
        }
        return false;
    }

    @Override
    protected Shape handlePackage(String[] args) {
        var p1 = new Point(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        var p2 = new Point(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        var p3 = new Point(Double.parseDouble(args[4]), Double.parseDouble(args[5]));
        return new Triangle(p1, p2, p3);
    }
}
