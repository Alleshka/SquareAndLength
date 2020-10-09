package com.company.classes.shapes;

import com.company.classes.Constants;
import com.company.classes.Utils;

public class Square extends Shape {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    private double size;

    public Square(String[] args) throws BuildShapeException {
        super(args);
    }

    @Override
    public String getShapeName() {
        return Constants.SQUARE_SHAPE_NAME;
    }

    @Override
    protected int NeedArgumentsToBuild() {
        return 8;
    }

    @Override
    public double calcS() {
        return Math.pow(this.size, 2);
    }

    @Override
    public double calcL() {
        return 4 * this.size;
    }

    @Override
    protected void InitShapeByArgs(String[] args) throws BuildShapeException {
        var a = new Point(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        var b = new Point(Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        var c = new Point(Double.parseDouble(args[5]), Double.parseDouble(args[6]));
        var d = new Point(Double.parseDouble(args[7]), Double.parseDouble(args[8]));
        InitSquare(a, b, c, d);
    }

    protected void InitSquare(Point a, Point b, Point c, Point d) throws BuildShapeException {
        double s1, s2, s3, s4, s5, s6;

        s1 = Utils.calculateDistanceSq(a, b);
        s2 = Utils.calculateDistanceSq(a, c);
        s3 = Utils.calculateDistanceSq(a, d);
        s4 = Utils.calculateDistanceSq(b, c);
        s5 = Utils.calculateDistanceSq(b, d);
        s6 = Utils.calculateDistanceSq(c, d);

        if (Utils.isDoubleEquals(s1, s3, s4, s6) && Utils.isDoubleEquals(s2, s5, 2 * s1)) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        } else if (Utils.isDoubleEquals(s1, s2, s5, s6) && Utils.isDoubleEquals(s3, s4, 2 * s1)) {
            this.a = a;
            this.b = b;
            this.c = d;
            this.d = c;
        } else if (Utils.isDoubleEquals(s2, s3, s4, s5) && Utils.isDoubleEquals(s1, s6, 2 * s2)) {
            this.a = a;
            this.b = c;
            this.c = b;
            this.d = d;
        } else {
            ThrowIfCannotBuild("Указанные точки не образуют квадрат", a.toString(), b.toString(), c.toString(), d.toString());
        }

        this.size = Utils.calculateDistance(a, b);
    }

    @Override
    public String toString() {
        return "Square [" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ']';
    }
}
