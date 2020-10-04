package com.company.classes.chainResponsibility;

import com.company.classes.Utils;
import com.company.classes.shapes.Point;
import com.company.classes.shapes.Shape;
import com.company.classes.shapes.Square;

// Обработчик аргументов для квадрата
public class SquareShapeHandler extends BaseShapeHandler {

    @Override
    protected boolean isCorrectShape(String[] args) {
        // Если точки 4 координат
        if (args.length == 8) {
            var a = new Point(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
            var b = new Point(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
            var c = new Point(Double.parseDouble(args[4]), Double.parseDouble(args[5]));
            var d = new Point(Double.parseDouble(args[6]), Double.parseDouble(args[7]));

            var s1 = Utils.calculateDistanceSq(a, b);
            var s2 = Utils.calculateDistanceSq(a, c);
            var s3 = Utils.calculateDistanceSq(a, d);
            var s4 = Utils.calculateDistanceSq(b, c);
            var s5 = Utils.calculateDistanceSq(b, d);
            var s6 = Utils.calculateDistanceSq(c, d);

            // Проверяем, что это квадрат
            return !Utils.isDoubleEquals(s1, 0) &&
                    ((Utils.isDoubleEquals(s1, s3, s4, s6) && Utils.isDoubleEquals(s2, s5, 2 * s1)) ||
                    (Utils.isDoubleEquals(s1, s2, s5, s6) && Utils.isDoubleEquals(s3, s4, 2 * s1)) ||
                    (Utils.isDoubleEquals(s2, s3, s4, s5) && Utils.isDoubleEquals(s1, s6, 2 * s2)));
        }

        return false;
    }

    @Override
    protected Shape handlePackage(String[] args) {
        var a = new Point(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        var b = new Point(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        var c = new Point(Double.parseDouble(args[4]), Double.parseDouble(args[5]));
        var d = new Point(Double.parseDouble(args[6]), Double.parseDouble(args[7]));

        return new Square(a, b, c, d);
    }
}
