package ejercicio4;

	public class ejer4 {
		public static void swap1 (int x, int y) {
		if (x < y) {
		int tmp = x ;
		x = y ;
		y = tmp;
		}
		}
		public static void swap2 (Integer x, Integer y) {
		if (x < y) {
		int tmp = x ;
		x = y ;
		y = tmp;
		}
		}
		
	
		public static void main(String[] args) {
		int a = 1, b = 2;
		Integer c = 3, d = 4;
		swap1(a,b);
		swap2(c,d);
		System.out.println("a=" + a + " b=" + b) ; //no los cambia porque los esta pasando por valor, para pasar por referencia usar return o un objeto
		System.out.println("c=" + c + " d=" + d) ;
		}
}

