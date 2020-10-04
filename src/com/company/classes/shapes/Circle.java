package com.company.classes.shapes;

// Круг
public class Circle extends Shape {

    private final Point center;
    private Double r;

    public Circle(Point a, Double r) {
        this.center = a;
        setR(r);
    }

    @Override
    public double calcS() {
        return Math.pow(this.getR(), 2) * Math.PI;
    }

    @Override
    public double calcL() {
        return 2 * Math.PI * this.getR();
    }

    public Double getR() {
        return r;
    }

    protected void setR(double value) {
        if (value < 0) throw new IllegalArgumentException("Радиус не может быть меньше нуля");
        else {
            this.r = value;
        }
    }

    public Point getCenter() {
        return center;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", r=" + r +
                '}';
    }
}
