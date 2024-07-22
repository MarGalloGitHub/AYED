/*
 * Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio
en un único método. Escriba tres métodos de clase, donde respectivamente:
a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").
b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de
tipo arreglo).
c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".

 */
package ejercicio5;

public class ejer5 {
	
	public static Datos incisoA(int[] vector) {
		Datos aux = new Datos();
		int elementos = vector.length;
		int i;
		int max = -1;
		int min = 999;
		double prom = 0;
		for(i=0 ; i < elementos ; i++) {
			if(vector[i] > max) {
				max = vector[i];
				aux.setMax(max);
			}
		
			if(vector[i] < min) {
				min = vector[i];
				aux.setMin(min);
			}
			
			prom += vector[i];
		}
		prom = prom / elementos;
		aux.setPromedio(prom);
		return aux;
	}
	
	public static void incisoB(int[] vector , Datos datos2) {
		
		int elementos = vector.length;
		int i;
		int max = -1;
		int min = 999;
		double prom = 0;
		for(i=0 ; i < elementos ; i++) {
			if(vector[i] > max) {
				max = vector[i];
				datos2.setMax(max);
			}
		
			if(vector[i] < min) {
				min = vector[i];
				datos2.setMin(min);
			}
			
			prom += vector[i];
		}
		prom = prom / elementos;
		datos2.setPromedio(prom);
	}
	
	public static void incisoC(int[] vector) {
		Datos aux = new Datos();
		int elementos = vector.length;
		int i;
		int max = -1;
		int min = 999;
		double prom = 0;
		for(i=0 ; i < elementos ; i++) {
			if(vector[i] > max) {
				max = vector[i];
				aux.setMax(max);
			}
		
			if(vector[i] < min) {
				min = vector[i];
				aux.setMin(min);
			}
			
			prom += vector[i];
		}
		prom = prom / elementos;
		aux.setPromedio(prom);
		System.out.println("Datos: " + "\n" + "Maximo: " + aux.getMax() + "\n" + "Minimo: " + aux.getMin() + "\n" + "´Promedio: " + aux.getPromedio());
	}

	public static void main(String[] args) {
		
		System.out.println("Ahora va el inciso 1                                          ");
		
		int[] vector = new int[4];
		vector[0] = 1;
		vector[1] = 88;
		vector[2] = 5;
		vector[3] = 25;
		
		Datos datos = incisoA(vector);  								//primer inciso
		
		System.out.println("Datos: " + "\n" + "Maximo: " + datos.getMax() + "\n" + "Minimo: " + datos.getMin() + "\n" + "´Promedio: " + datos.getPromedio());
		
		System.out.println("Ahora va el inciso 2                                          ");
		int[] vector2 = new int[6];
		vector2[0] = 1;
		vector2[1] = 88;
		vector2[2] = 5;
		vector2[3] = -1;
		vector2[4] = 44;
		vector2[5] = 89;
			
		Datos datos2 = new Datos();								//segundo inciso
		incisoB(vector2 , datos2);
		System.out.println("Datos: " + "\n" + "Maximo: " + datos2.getMax() + "\n" + "Minimo: " + datos2.getMin() + "\n" + "´Promedio: " + datos2.getPromedio());
		
		System.out.println("Ahora va el inciso 3                                        ");
		int[] vector3 = new int[7];
		vector3[0] = 1;
		vector3[1] = 88;
		vector3[2] = 5;
		vector3[3] = -30;
		vector3[4] = 44;
		vector3[5] = 77;
		vector3[6] = 150;
		
		incisoC(vector3);
	}
}
