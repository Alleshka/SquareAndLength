package com.company.classes.chainResponsibility;

import com.company.classes.shapes.BuildShapeException;
import com.company.classes.shapes.Shape;

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
    public Shape handle(String[] args) throws BuildShapeException {
        // Если обработчик может обработать - обрабатываем
        // Проверка обработки происходит по имени фигуры, заданной в конструкторе
        if (args.length > 0 && args[0].equals(_shapeName)) {
            return handlePackage(args);
        } else {
            // Если не может, то передаём следующему
            if (getNextHandler() != null) {
                return getNextHandler().handle(args);
            } else {
                // Если следующего нет, то никто не смог обработать и сообщаем об ошибке
                throw new BuildShapeException("Описание неизвестной фигуры: [" + String.join("; ", args) + "];");
            }
        }
    }

    // Обрабатывает указанные аргументы
    protected abstract Shape handlePackage(String[] args) throws BuildShapeException;
}
