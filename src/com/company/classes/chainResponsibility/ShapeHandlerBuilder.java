package com.company.classes.chainResponsibility;

// Строит цепочку обязанностей
public class ShapeHandlerBuilder {

    private IShapeHandler _head;
    private IShapeHandler _last;

    public IShapeHandler getFirst() {
        return _head;
    }

    // Добавляет в цепочку обязанностей новый обработчик
    public void add(IShapeHandler item) {
        if (_head == null) {
            _head = item;
            _last = _head;
        } else {
            _last.setNextHandler(item);
            _last = _last.getNextHandler();
        }
    }
}
