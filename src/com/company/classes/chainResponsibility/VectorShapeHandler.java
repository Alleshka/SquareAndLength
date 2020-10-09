package com.company.classes.chainResponsibility;

import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Shape;
import com.company.classes.shapes.Vector;

public class VectorShapeHandler extends BaseShapeHandler{
    public VectorShapeHandler(String shapeName) {
        super(shapeName);
    }

    @Override
    protected Shape handlePackage(String[] args) throws BuildShapeException {
        return new Vector(args);
    }
}
