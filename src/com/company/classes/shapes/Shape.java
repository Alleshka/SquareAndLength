package com.company.classes.shapes;

public abstract class Shape {

    public abstract double calcS();

    public abstract double calcL();

    protected Shape() {

    }

    public Shape(String[] args) throws BuildShapeException {
        var needArgs = NeedArgumentsToBuild() + 1;
        if (args.length >= needArgs) {
            InitShapeByArgs(args);
        } else {
            ThrowIfCannotBuild("Не хватает аргументов для построения фигуры (Требуется: " + needArgs + "; Указано: " + args.length + ")", args);
        }
    }

    protected abstract void InitShapeByArgs(String[] args) throws BuildShapeException;

    public abstract String getShapeName();

    protected void ThrowIfCannotBuild(String message, String... args) throws BuildShapeException {
        var builder = new StringBuilder();
        builder.append("Невозможно построить фигуру ").append(getShapeName()).append(" (" + message + ") ");
        if (args.length > 0) {
            builder.append("Args: [" + String.join("; ", args) + "]").append("; ");
        }
        throw new BuildShapeException(builder.toString());
    }

    protected abstract int NeedArgumentsToBuild();
}
