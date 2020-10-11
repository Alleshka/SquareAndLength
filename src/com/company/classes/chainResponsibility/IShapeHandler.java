package com.company.classes.chainResponsibility;

import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Shape;

import java.util.Scanner;

// Интерфейс обработчика в цепочке обязханностей
public interface IShapeHandler {

    // следующий обработчик
    IShapeHandler getNextHandler();
    void setNextHandler(IShapeHandler handler);

    // Обрабатывает аргументы и возвращает фигуру
    Shape handle(String figureName, Scanner scanner) throws BuildShapeException;
}
