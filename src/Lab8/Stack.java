package Lab8;
//Intermediate

import java.util.ArrayList;
import java.util.List;

// EXPLAIN: T is a type parameter chosen by the caller, e.g. Stack<String>
public class Stack<T> {
    private final List<T> items = new ArrayList<>();

    public void push(T item) {
        items.add(item);                    // top of the stack = end of the list
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());
        System.out.println("Pop: " + s.pop());
        System.out.println("Empty? " + s.isEmpty());
        System.out.println("Pop: " + s.pop());
        System.out.println("Empty? " + s.isEmpty());

        Stack<String> words = new Stack<>();
        words.push("a");
        words.push("b");
        System.out.println("String stack pop: " + words.pop());

        try {
            s.pop();                        // stack is empty now
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}