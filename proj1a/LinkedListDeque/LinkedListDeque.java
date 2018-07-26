/**
 * This is a class written to realize and manipulate a Double-Ended-Deque with Linked-List.
 * @author Yufeng Gao
 */

public class LinkedListDeque <T> {
    /**
     * Node class
     */
    private class Node{
        private T item;
        private Node next;
        private Node previous;

        private Node(T i, Node n, Node p) {
            item = i;
            next = n;
            previous = p;
        }
    }

    /**
     * Circular sentinel
     */
    private Node sentinel;

    private int size;

    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
    }

    /**
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel.next, sentinel);
        size ++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        sentinel.previous = new Node(item, sentinel, sentinel.previous);
        size ++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        Node curr = sentinel.next;

        while (curr != sentinel) {
            System.out.print(curr.item + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node first = sentinel.next;
            sentinel.next = sentinel.next.next;
            size --;
            return first.item;
        }
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            Node last = sentinel.previous;
            sentinel.previous = sentinel.previous.previous;
            size --;
            return last.item;
        }
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            Node curr = sentinel.next;
            int count = 0;

            while (count != index) {
                curr = curr.next;
                count ++;
            }

            return curr.item;
        }
    }

    /**
     * Same as get, but uses recursion.
     */
    public T getRecursive(int index) {
        Node getR = getRecursiveHelper(sentinel.next, index);
        if (getR == null) {
            return null;
        } else {
            return getR.item;
        }
    }

    /**
     * The helper function for getRecursive(int index)
     */
    private Node getRecursiveHelper(Node front, int index) {
        if (front == sentinel) {
            return null;
        } else if (index == 0) {
            return front;
        } else {
            return getRecursiveHelper(front.next, index - 1);
        }
    }
}