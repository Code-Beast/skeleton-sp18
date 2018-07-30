/**
 * This is a class written to realize and manipulate a Double-Ended-Deque with Array.
 * @author Yufeng Gao
 */

public class ArrayDeque <T> implements Deque <T> {
    /**
     * Circular sentinel
     */
    private T[] items;

    /**
    * front is the position of the first node in the array
    * end is the position where the next last node will be put
    * if front is equal to end, the array is full
    */
    int front, end;
    private int size;

    /**
     * Creates an empty linked list deque.
     */
    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        // if the array is empty, then front is -1.
        // otherwise, if it is not empty, the front cannot be -1.
        front = 0;
        end = 0;
    }

    /**
     * Adds an item of type T to the front of the deque.
     */
    @Override
    public void addFirst(T item) {
        if (front == 0) {
            front = items.length - 1;
        } else {
            front --;
        }
        items[front] = item;
        size ++;

        // after the addition, if front == end, then four times the length.
        if (front == end) {
            resize(4);
        }
    }

    /**
     * Adds an item of type T to the back of the deque.
     */
    @Override
    public void addLast(T item) {
        items[end] = item;
        size ++;
        end ++;
        if (end == items.length) {
            end = 0;
        }

        // after the addition, if front == end, then four times the length.
        if (front == end) {
            resize(4);
        }
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    @Override
    public void printDeque() {
        // if size == 0, print nothing
        if (size == 0) {
            System.out.println("This deque is empty");
        } 
        // elif front < end || end == 0, print from front to end - 1 || length - 1
        else if (front < end || end == 0) {
            int endForCalc = ((end == 0) ? items.length : end);

            for (int i = front; i < endForCalc; i ++) {
                System.out.print(items[i] + " ");
            }

            System.out.println();
        }
        // elif front >= end, print from from to length - 1 and then print from 0 to end - 1
        else if (front >= end) {
            for (int i = front; i < items.length; i ++) {
                System.out.print(items[i] + " ");
            }

            for (int i = 0; i < end; i ++) {
                System.out.print(items[i] + " ");
            }

            System.out.println();
        }
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        // if size == 0, return null;
        if (size == 0) {
            return null;
        }

        // if size != 0, remove the item at position front
        T rem = items[front];
        front = (front == items.length - 1) ? 0 : front + 1;
        size --;

        // if size is 1/4 of items.length and items.length > 8, resize with ratio 0.25
        if (items.length > 8 && items.length / (size + 1) == 4 && items.length % (size + 1) == 0) {
            resize(0.25);
        }

        // after the removement, if size == 0, then set front = 0, end = 0;
        if (size == 0) {
            front = 0;
            end = 0;
        }

        return rem;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeLast() {
        // if size == 0, return null;
        if (size == 0) {
            return null;
        }

        // if size != 0, remove the item at position end - 1
        end = (end == 0) ? items.length - 1 : end - 1;
        size --;
        T rem = items[end];

        // if size is 1/4 of items.length and items.length > 8, resize with ratio 0.25
        if (items.length > 8 && items.length / (size + 1)== 4 && items.length % (size + 1) == 0) {
            resize(0.25);
        }

        // after the removement, if size == 0,  then set front = 0, end = 0;
        if (size == 0) {
            front = 0;
            end = 0;
        }

        return rem;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     */
    @Override
    public T get(int index) {
        int indexInArray = front + index;

        // if index < 0 || index > size - 1, return null
        if (index < 0 || index > size - 1) {
            return null;
        }

        // elif front < end || end == 0, return items[front + index]
        else if (front < end || end == 0) {
            return items[indexInArray];
        }

        // elif front > end, return items[front + index - items.length] or items[front + index]
        return ((indexInArray > items.length - 1) ? items[indexInArray - items.length] : items[indexInArray]);
    }

    /**
     * resize the array according to the ratio and
     * put the original array content into the new array in a way that
     * first = 0
     * end = size
     */
    private void resize(double ratio) {
        int newLength = (int)(ratio * items.length);
        T[] newItems = (T[]) new Object[newLength];
        int count = 0;

        // if front < end || end == 0, copy from front to end - 1 || length - 1
        if (front < end || end == 0) {
            int endForCalc = ((end == 0) ? items.length : end);

            for (int i = front; i < endForCalc; i ++, count ++) {
                newItems[count] = items[i];
            }
        }
        // elif front > end, copy from from to length - 1 and then copy from 0 to end - 1
        else if (front >= end) {
            for (int i = front; i < items.length; i ++, count ++) {
                newItems[count] = items[i];
            }

            for (int i = 0; i < end; i ++, count ++) {
                newItems[count] = items[i];
            }
        }

        items = newItems;
        front = 0;
        end = size;
    }
}