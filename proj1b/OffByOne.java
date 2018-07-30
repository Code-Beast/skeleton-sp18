public class OffByOne implements CharacterComparator {

    /**
     * Returns true for characters that are different by exactly one
     * @param x
     * @param y
     * @return
     */
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}