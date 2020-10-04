package com.company.classes.chainResponsibility;

import com.company.classes.Utils;
import com.company.classes.shapes.Point;
import com.company.classes.shapes.Shape;
import com.company.classes.shapes.Tetragon;

import java.util.ArrayList;

// Обработчик аргументов для прямоугольника
public class TetragonShapeHandler extends BaseShapeHandler {

    @Override
    protected boolean isCorrectShape(String[] args) {
        if (args.length == 8) {

            var points = new ArrayList<Point>(4);
            points.add(new Point(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
            points.add(new Point(Double.parseDouble(args[2]), Double.parseDouble(args[3])));
            points.add(new Point(Double.parseDouble(args[4]), Double.parseDouble(args[5])));
            points.add(new Point(Double.parseDouble(args[6]), Double.parseDouble(args[7])));

            points.sort(null);

            // Если какие-то три точки лежат на прямой, то это не четырёхугольник
            return !((Utils.isPointsOnLine(points.get(0), points.get(1), points.get(2)) ||
                    Utils.isPointsOnLine(points.get(0), points.get(1), points.get(3)) ||
                    Utils.isPointsOnLine(points.get(1), points.get(2), points.get(3))));

        }

        return false;
    }

    @Override
    protected Shape handlePackage(String[] args) {
        var points = new ArrayList<Point>(4);
        points.add(new Point(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
        points.add(new Point(Double.parseDouble(args[2]), Double.parseDouble(args[3])));
        points.add(new Point(Double.parseDouble(args[4]), Double.parseDouble(args[5])));
        points.add(new Point(Double.parseDouble(args[6]), Double.parseDouble(args[7])));

        points.sort(null);

        return new Tetragon(points.get(0), points.get(1), points.get(2), points.get(3));
    }
}
