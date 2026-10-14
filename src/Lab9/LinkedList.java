package Lab9;
//Intermediate

import java.util.Iterator;

// EXPLAIN: implementing Iterable is what allows the for-each loop
public class LinkedList<T> implements Iterable<T> {

    // EXPLAIN: static nested class: a Node needs no outer LinkedList object
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public int size() { return size; }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    // EXPLAIN: inner class: it reads the outer object's 'head' to know where to start
    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        public boolean hasNext() { return current != null; }

        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Tammy");
        list.add("Freddy");
        list.add("Rudaviro");

        for (String name : list) {
            System.out.println(name);
        }
        System.out.println("Size: " + list.size());

        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        System.out.println("Sum: " + sum);
    }
}