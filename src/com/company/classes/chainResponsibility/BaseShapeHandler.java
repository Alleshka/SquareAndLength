package com.company.classes.chainResponsibility;

import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Shape;

import java.util.Scanner;

// Базовый обработчик структур
abstract class BaseShapeHandler implements IShapeHandler {

    protected String _shapeName;
    protected IShapeHandler _nextHandler;

    public BaseShapeHandler(String shapeName) {
        _shapeName = shapeName;
    }

    @Override
    public IShapeHandler getNextHandler() {
        return _nextHandler;
    }

    @Override
    public void setNextHandler(IShapeHandler handler) {
        _nextHandler = handler;
    }

    @Override
    // Обработка аргументов из файла
    public Shape handle(String figureName, Scanner scanner) throws BuildShapeException {
        // Если обработчик может обработать - обрабатываем
        // Проверка обработки происходит по имени фигуры, заданной в конструкторе
        if (figureName.equals(_shapeName)) {
            return handlePackage(scanner);
        } else {
            // Если не может, то передаём следующему
            if (getNextHandler() != null) {
                return getNextHandler().handle(figureName, scanner);
            } else {
                // Если следующего нет, то никто не смог обработать и сообщаем об ошибке
                throw new BuildShapeException("Описание неизвестной фигуры: [" + figureName + "];");
            }
        }
    }

    // Обрабатывает указанные аргументы
    protected abstract Shape handlePackage(Scanner scanner) throws BuildShapeException;
}
