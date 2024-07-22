/*
 * 2. Escriba un método de clase que dado un número n devuelva un nuevo arreglo de tamaño n
con los n primeros múltiplos enteros de n mayores o iguales que 1.
Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {n*k donde k : 1..k}
Agregue al programa la posibilidad de probar con distintos valores de n ingresandolos por
teclado, mediante el uso de System.in. La clase Scanner permite leer de forma sencilla
valores de entrada.
 */
package ejercicio2;

import java.util.*;
public class ejer2 {
	
	public static int[] calcularVector(int num , int mult) {
		int [] aux = new int[mult];
		
		int i;
		for(i=0 ; i<= (mult - 1) ; i++) {
			aux[i] = num * (i + 1);
		}
		return aux;
	}
	
	public static void mostrarVector(int[] vector) {
		int i;
		int elementos = vector.length;
		for(i=0 ; i<= (elementos - 1) ; i++) {
			System.out.println(vector[i]);
		}
		
	}

	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Escriba un numero");
		int num = s.nextInt();
		System.out.println("Escriba la cantidad de multiplos que desea ver del numero");
		int mult = s.nextInt();
		
		int[] vector = calcularVector(num,mult);
		
		mostrarVector(vector);
	}
}
