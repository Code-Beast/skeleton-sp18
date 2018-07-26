import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayDeque class.
 *  @author Yufeng Gao
 */

public class ArrayDequeTest {

    /** Add 10 items first and remove 3 items first, print, check size and isEmpty
     * Add 10 items first, print, check size and isEmpty
     * Remove 15 items first, print, check size and isEmpty
     * Remove 2 items first, print, check size and isEmpty
     */
    @Test
    public void testCase1() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();

        addItemsFirst(arr, 10);
        arr.printDeque();
        assertEquals(arr.get(4), (Integer)5);
        assertNull(arr.get(10));
        assertNull(arr.get(-3));
        removeItemsFirst(arr, 3);
        arr.printDeque();
        assertEquals(arr.size(), 7);
        assertSame(arr.isEmpty(), false);
        assertEquals(arr.get(1), (Integer)5);

        addItemsFirst(arr, 10);
        arr.printDeque();
        assertEquals(arr.size(), 17);
        assertSame(arr.isEmpty(), false);
        assertEquals(arr.get(11), (Integer)5);

        removeItemsFirst(arr, 15);
        arr.printDeque();
        assertEquals(arr.size(), 2);
        assertSame(arr.isEmpty(), false);

        removeItemsFirst(arr, 2);
        arr.printDeque();
        assertEquals(arr.size(), 0);
        assertSame(arr.isEmpty(), true);
    }

    /** Add 10 items last and remove 3 items last, print, check size and isEmpty
     * Add 10 items first, print, check size and isEmpty
     * Remove 15 items first, print, check size and isEmpty
     * Remove 2 items first, print, check size and isEmpty
     */
    @Test
    public void testCase2() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();

        addItemsLast(arr, 10);
        removeItemsLast(arr, 3);
        arr.printDeque();
        assertEquals(arr.size(), 7);
        assertSame(arr.isEmpty(), false);

        addItemsFirst(arr, 10);
        arr.printDeque();
        assertEquals(arr.size(), 17);
        assertSame(arr.isEmpty(), false);

        removeItemsFirst(arr, 15);
        arr.printDeque();
        assertEquals(arr.size(), 2);
        assertSame(arr.isEmpty(), false);

        removeItemsFirst(arr, 2);
        arr.printDeque();
        assertEquals(arr.size(), 0);
        assertSame(arr.isEmpty(), true);
    }


    /** Add 2 items first and add 2 items last, print, check size and isEmpty
     * remove 3 items last, print, check size and isEmpty
     * add 3 items last, print, check size and isEmpty
     * Remove 3 items first, print, check size and isEmpty
     */
    @Test
    public void testCase3() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();

        addItemsFirst(arr, 2);
        addItemsLast(arr, 2);
        arr.printDeque();
        assertEquals(arr.size(), 4);
        assertSame(arr.isEmpty(), false);

        removeItemsLast(arr, 3);
        arr.printDeque();
        assertEquals(arr.size(), 1);
        assertSame(arr.isEmpty(), false);

        addItemsLast(arr, 3);
        arr.printDeque();
        assertEquals(arr.size(), 4);
        assertSame(arr.isEmpty(), false);

        removeItemsFirst(arr, 3);
        arr.printDeque();
        assertEquals(arr.size(), 1);
        assertSame(arr.isEmpty(), false);
    }

    private void addItemsFirst(ArrayDeque<Integer> arr, int num) {
        for (int i = 0; i < num; i ++) {
            arr.addFirst(i);
        }
    }

    private void addItemsLast(ArrayDeque<Integer> arr, int num) {
        for (int i = 0; i < num; i ++) {
            arr.addLast(i);
        }
    }

    private void removeItemsFirst(ArrayDeque<Integer> arr, int num) {
        for (int i = 0; i < num; i ++) {
            arr.removeFirst();
        }
    }

    private void removeItemsLast(ArrayDeque<Integer> arr, int num) {
        for (int i = 0; i < num; i ++) {
            arr.removeLast();
        }
    }
} 