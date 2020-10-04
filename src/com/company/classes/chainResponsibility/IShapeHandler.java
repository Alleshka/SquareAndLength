package com.company.classes.chainResponsibility;

import com.company.classes.shapes.Shape;

// Интерфейс обработчика в цепочке обязханностей
public interface IShapeHandler {

    // следующий обработчик
    IShapeHandler getNextHandler();
    void setNextHandler(IShapeHandler handler);

    // Обрабатывает аргументы и возвращает фигуру
    Shape handle(String[] args) throws Exception;
}
