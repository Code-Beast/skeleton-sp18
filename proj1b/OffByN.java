public class OffByN implements CharacterComparator {

    private int N;

    /**
     * Default constructor
     */
    public OffByN() {
        this.N = 0;
    }

    /**
     * Constructor with parameter N
     * @param N
     */
    public OffByN(int N) {
        this.N = N;
    }
    /**
     * Returns true for characters that are different by N
     * @param x
     * @param y
     * @return
     */
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == N;
    }
}