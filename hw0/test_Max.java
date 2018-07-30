public class test_Max {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
    	int i;
    	int max = m[0];
    	for (i = 1; i < m.length; i ++) {
    		if (max < m[i]) {
    			max = m[i];
    		}
    	}
        return max;
    }

    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};  
       System.out.println(max(numbers));   
    }
}