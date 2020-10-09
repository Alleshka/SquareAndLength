package com.company.classes.shapes;

import com.company.classes.Constants;
import com.company.classes.Utils;

public class Vector extends Shape {

    private Point a;
    private Point b;

    public Vector(String[] args) throws BuildShapeException {
        super(args);
    }

    @Override
    public String getShapeName() {
        return Constants.VECTOR_SHAPE_NAME;
    }

    @Override
    protected int NeedArgumentsToBuild() {
        return 4;
    }

    @Override
    public double calcS() {
        return 0;
    }

    @Override
    public double calcL() {
        return Utils.calculateDistance(a, b);
    }

    @Override
    protected void InitShapeByArgs(String[] args) throws BuildShapeException {
        this.a = new Point(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        this.b = new Point(Double.parseDouble(args[3]), Double.parseDouble(args[4]));
    }

    @Override
    public String toString() {
        return "Vector{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
