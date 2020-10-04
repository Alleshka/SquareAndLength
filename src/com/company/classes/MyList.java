package com.company.classes;

// Базовый класс списка
public class MyList<T> {

    protected class MyListItem<T> {

        private T data;
        private MyListItem<T> next;


        public MyListItem(T item) {
            data = item;
            next = null;
        }

        public MyListItem getNext() {
            return next;
        }

        public void setNext(MyListItem next) {
            this.next = next;
        }

        public void setNext(T next) {
            this.setNext(new MyListItem(next));
        }

        public T getData() {
            return data;
        }
    }

    protected MyListItem<T> head;
    protected MyListItem<T> last;

    public T getHead() {
        return head.getData();
    }

    public T getLast() {
        return last.getData();
    }

    public boolean add(T item) {
        if (head == null) {
            head = new MyListItem<T>(item);
            last = head;
        } else {
            last.setNext(item);
            last = last.getNext();
        }
        return true;
    }
}
