public class draw_Triangle_N {
	/** Draw a triangle of height N */
	public static void drawTriangle (int N) {
		int i, j;
		for(i = 1; i <= N; i ++) {
        	for(j = 0; j < i; j ++) {
        		System.out.print('*');
        	}
        	System.out.print('\n');
        }
	}

	public static void main (String[] args) {
		drawTriangle(10);
	}
}