/*
 * Escriba una clase llamada Test con el método main, el cual cree un arreglo con 2
objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego recorra ambos
arreglos imprimiendo los valores obtenidos mediante el método tusDatos(). Recuerde
asignar los valores de los atributos de los objetos Estudiante y Profesor invocando los
respectivos métodos setters.

 */
package ejercicio3;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		Estudiante[] estudiantes = new Estudiante[2];
		
		Profesor[] profesores = new Profesor[3];
		
		int i;
		for(i=0 ; i < 2 ; i++) {
			System.out.println("Escriba datos de un estudiante ");
			Estudiante est1 = new Estudiante();
			System.out.println("Escriba el nombre del estudiante: ");
			est1.setNombre(s.next());
			System.out.println("Escriba el apellido del estudiante: ");
			est1.setApellido(s.next());
			System.out.println("Escriba la comision del estudiante: ");
			est1.setComision(s.nextInt());
			System.out.println("Escriba la direccion del estudiante: ");
			est1.setDireccion(s.next());
			System.out.println("Escriba el email del estudiante: ");
			est1.setEmail(s.next());
			estudiantes[i] = est1;
		}
		
		for(i=0 ; i < 3 ; i++) {
			System.out.println("Escriba datos de un profesor ");
			Profesor prof1 = new Profesor();
			System.out.println("Escriba el nombre del profesor");
			prof1.setNombre(s.next());
			System.out.println("Escriba el apellido del profesor");
			prof1.setApellido(s.next());
			System.out.println("Escriba el email del profesor");
			prof1.setEmail(s.next());
			System.out.println("Escriba la catedra del profesor");
			prof1.setCatedra(s.nextInt());
			System.out.println("Escriba la facultad del profesor");
			prof1.setFacultad(s.next());
			profesores[i] = prof1;
		}

		System.out.println("Informacion de los alumnos: ");
		for(i = 0 ; i<= 1 ; i++) {
			System.out.println(estudiantes[i].tusDatos());
		}
		
		System.out.println("Informacion de los profesores: ");
		for(i = 0 ; i<= 2 ; i++) {
			System.out.println(profesores[i].tusDatos());
		}
		
	
	}

}
