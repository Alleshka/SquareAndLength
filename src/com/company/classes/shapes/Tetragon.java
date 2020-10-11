package com.company.classes.shapes;

import com.company.classes.Constants;
import com.company.classes.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Tetragon extends Shape {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Tetragon(Scanner scanner) throws BuildShapeException {
        super(scanner);
    }

    @Override
    protected void InitShapeByScanner(Scanner scanner) throws BuildShapeException {
        var points = new ArrayList<Point>(4);
        points.add(new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner)));
        points.add(new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner)));
        points.add(new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner)));
        points.add(new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner)));

        points.sort(null);

        // Если какие-то три точки лежат на прямой, то это не четырёхугольник
        if (!((Utils.isPointsOnLine(points.get(0), points.get(1), points.get(2)) ||
                Utils.isPointsOnLine(points.get(0), points.get(1), points.get(3)) ||
                Utils.isPointsOnLine(points.get(1), points.get(2), points.get(3))))) {
            this.a = points.get(0);
            this.b = points.get(1);
            this.c = points.get(2);
            this.d = points.get(3);
        } else {
            ThrowIfCannotBuild("Указанные точки не образуют четырёхугольник", a.toString(), b.toString(), c.toString(), d.toString());
        }
    }

    @Override
    public String getShapeName() {
        return Constants.TETRAGON_SHAPE_NAME;
    }

    @Override
    public double calcS() {
        var p = calcL() / 2;
        return Math.sqrt((p - Utils.calculateDistance(a, b)) * (p - Utils.calculateDistance(b, c)) * (p - Utils.calculateDistance(c, d)) * (p - Utils.calculateDistance(d, a)));
    }

    @Override
    public double calcL() {
        return Utils.calculateDistance(a, b) + Utils.calculateDistance(b, c) + Utils.calculateDistance(c, d) + Utils.calculateDistance(d, a);
    }

    @Override
    public String toString() {
        return "Tetragon[" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ']';
    }
}
