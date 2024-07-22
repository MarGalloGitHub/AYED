/*
 * 1. Escriba tres métodos de clase (static) que reciban por parámetro dos números enteros (tipo
int) a y b e impriman todos los números enteros comprendidos entre a; b (inclusive), uno por
cada línea en la salida estándar. Para ello, dentro de una nueva clase escriba un método por
cada uno de los siguientes incisos:
a. Que realice lo pedido con un for.
b. Que realice lo pedido con un while.
c. Que realice lo pedido sin utilizar estructuras de control iterativas (for, while, do
while).
Por último, escriba en el método de clase main el llamado a cada uno de los métodos
creados, con valores de ejemplo. En su computadora, ejecute el programa y verifique
que se cumple con lo pedido.

 */

package ejercicio1;

import  java.util.*;
public class ejer1 {
	
	public static void procedimientoA(int num1 , int num2) {
		if(num1 > num2) {
			System.out.println("El segundo numero tiene que ser mas grande que el primero bruto");
		}
		else
		{
		   int num = num2 - num1;
		   
		   for(int i = 0 ; i<= (num) ; i++) {
			   System.out.println(num1 + i);
		   }
		}
	}
	
	public static void procedimientoB(int num1 , int num2) {
		if(num1 > num2) {
			System.out.println("El segundo numero tiene que ser mas grande que el primero bruto");
		}
		else
		{
			int num = num2 - num1;
			int i = 0;
			while(i <= (num)) {
				System.out.println(num1 + i);
				i++;
			}
		}
	}
	
	public static void procedimientoC(int num1 , int num2) {
		if(num1 > num2) {
			System.out.println("Listo");
		}
		else
		{
			System.out.println(num1);
			procedimientoC(num1 + 1 , num2);
		}
	}

	public static void main(String[] args) {
		
	
	Scanner s = new Scanner(System.in);    // para ingresar datos
	
	System.out.println("Escriba limite inferior");
	
	int num1 = s.nextInt();
	
	System.out.println("Escriba limite superior");
	int num2 = s.nextInt();
	
	System.out.println("Inciso A");
	procedimientoA(num1,num2);
	System.out.println("Inciso B");
	procedimientoB(num1,num2);
	System.out.println("Inciso C");
	procedimientoC(num1 , num2);
	
	}
}	