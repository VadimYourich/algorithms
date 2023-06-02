package lesson3;

public class MyLinkedList {

    /**
     * Реализовать следующие методы
     * 1. public int size() - получить размер списка
     * 2. public boolean contains(int value) - проверить наличие элемента в списке
     * 3.* public MyLinkedList reversed() - создать НОВЫЙ список с обратным порядком
     * 4.** Заменить все int значения на дженерик T
     * 5.* Любые другие доработки, которые захотите для тренировки
     */

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node last = findLast();
            last.next = new Node(value);
        }
    }

    public int getFirst() {
        return get(0);
    }

    public int get(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException(index);
        }

        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        if (currentIndex == index && current != null) {
            return current.value;
        }
        throw new IndexOutOfBoundsException(index);
    }

    public int popFirst() {
        return pop(0);
    }

    public int pop(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            int pop = head.value;
            head = head.next;
            return pop;
        }

        Node previous = head; // предыдущая от искомой
        int currentIndex = 1;
        while (previous.next != null) {
            if (currentIndex == index) {
                int pop = previous.next.value;
                previous.next = previous.next.next;
                return pop;
            }

            previous = previous.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException(index);
    }

    // НОВЫЙ список с обратным порядком
    public MyLinkedList reversed() {
        if (head == null) {
            throw new UnsupportedOperationException();
        }
        MyLinkedList myLinkedListRevers = new MyLinkedList();
        int count = size();
        for (int i = count-1; i >= 0; i--) {
            myLinkedListRevers.add(get(i));
        }
        return myLinkedListRevers;
    }

    private Node findLast() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            result.append(current.value).append(" -> ");
            current = current.next;
        }

        int length = result.length();
        if (length > 4) {
            result.delete(length - 4, length);
        }

        result.append("]");
        return result.toString();
    }

    // размер списка
    public int size() {
        int count = 0;
        if (head == null) {
            return count;
        }
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // проверка наличия элемента в списке
    public boolean contains(int value) {
        boolean temp = false;
        if (head == null) {
            return temp;
        }
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                temp = true;
                return temp;
            }
            current = current.next;
        }
        return temp;
    }
    
}
