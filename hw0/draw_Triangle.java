public class draw_Triangle {
	/** Draw a triangle of height 5. */
    public static void main(String[] args) {
        int i, j;
        for(i = 1; i <= 5; i ++) {
        	for(j = 0; j < i; j ++) {
        		System.out.print('*');
        	}
        	System.out.print('\n');
        }
    }
}