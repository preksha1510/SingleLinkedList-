import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {
    private Node<T> head;
    private int size;

    SimpleLinkedList() {
        head = null;
        size = 0;
    }

    SimpleLinkedList(T[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            push(values[i]);
        }
    }

    void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    T pop() {
        if (head == null) {
            throw new NoSuchElementException("empty linked list.");
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    void reverse() {
        Node<T> current = head;
        Node<T> previous = null;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    T[] asArray(Class<T> clazz) {
        List<T> list = new ArrayList<>();
        Node<T> current = head;

        while (current != null) {
            list.add(current.value);
            current = current.next;
        }

        @SuppressWarnings("unchecked")
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, list.size());
        return list.toArray(array);
    }

    int size() {
        return size;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}



