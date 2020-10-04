package com.company.classes.chainResponsibility;

import com.company.classes.shapes.Shape;

// Базовый обработчик структур
abstract class BaseShapeHandler implements IShapeHandler {
    protected IShapeHandler _nextHandler;

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
    public Shape handle(String[] args) throws Exception {
        // Если обработчик может обработать - обрабатываем
        if (isCorrectShape(args)) {
            return handlePackage(args);
        } else {
            // Если не может, то передаём следующему
            if (getNextHandler() != null) {
                return getNextHandler().handle(args);
            } else {
                // Если следующего нет, то никто не смог обработать и сообщаем об ошибке
                var builder = new StringBuilder();
                builder.append("Описание неизвестной фигуры");
                builder.append(System.lineSeparator());
                builder.append("args = ");
                builder.append(String.join(" ", args));
                throw new Exception(builder.toString());
            }
        }
    }

    // Возвращает возможность обработчика обработать указанные аргументы
    protected abstract boolean isCorrectShape(String[] args);

    // Обрабатывает указанные аргументы
    protected abstract Shape handlePackage(String[] args);
}
