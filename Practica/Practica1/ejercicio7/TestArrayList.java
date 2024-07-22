package ejercicio7;

import java.util.*;
public class TestArrayList {

	public static List<Estudiante>  crearLista() {
	
	
		 
		Scanner s = new Scanner(System.in);
		List<Estudiante>  lista = new LinkedList();
		int i;
		for(i = 0 ; i<= 2 ; i++) {
			Estudiante estu = new Estudiante();
			System.out.println("Escriba el nombre del estudiante");
			estu.setNombre(s.next());
			System.out.println("Escriba el apellido del estudiante");
			estu.setApellido(s.next());
			System.out.println("Escriba la comision del estudiante");
			estu.setComision(s.nextInt());
			System.out.println("Escriba el email del estudiante");
			estu.setEmail(s.next());
			System.out.println("Escriba la direccion del estudiante");
			estu.setDireccion(s.next());
			lista.add(estu);
		}
		return lista;
	}
	
	public static void mostrarLista(List<Estudiante> lista) {
		int elementos = lista.size();
		int i = 0;
		while(i < elementos) {
			System.out.println(lista.get(i).tusDatos());
			i++;
		}
	}
	
	public static void modificarLista(List<Estudiante> lista) {
		int elementos = lista.size();
		Estudiante EstudianteNuevo;
		String nombreNuevo;
		int i = 0;
		while(i < elementos) {
			EstudianteNuevo = lista.get(i);
			nombreNuevo = EstudianteNuevo.getNombre() + "- - Tilino/a - - " + (i+1);
			EstudianteNuevo.setNombre(nombreNuevo);
			lista.remove(i);
			lista.add(i, EstudianteNuevo);
			i++;
		}
	}
	
	public static void agregarSiNoEstaEnLaLista(List<Estudiante> lista , Estudiante est1) {
		String nombreComp = est1.getNombre();
		int elementos = lista.size();
		int i = 0;
		while((i < elementos) && (lista.get(i).getNombre() != nombreComp)){
			i++;
		}
		
		if(i <= elementos) {
			lista.add(est1);
		}
	}
	
	
	
	public static boolean esCapicua(List<Integer> lista) {
		boolean aux = true;
		int elementos = lista.size();
		int i = 0;
		while(i < elementos) {
			if(lista.get(i) != lista.get(elementos - i - 1)) {
				aux = false;
			}
			i++;
		}
		return aux;
	}
	
	public static List<Integer> devolverSucesion(int num) {
		List <Integer> lista = new LinkedList<Integer>();               // cambiar a ArrayList si es necesario
		
		lista.add(num);
		
		if(num == 1) {
			return lista;
		}
		
		if((num % 2 ) == 0) {
			lista.addAll(devolverSucesion((int) num / 2));
			return lista;
		}
		else
		{
			lista.addAll(devolverSucesion((int) 3*num + 1));
			return lista;
		}
	}
		
		public static void mostrarListaEnteros(List<Integer> lista) {
			int i = 0;
			int elementos = lista.size();
			while(i < elementos) {
				System.out.println(lista.get(i));
				i++;
			}
		}
			
		public static List <Integer> invertirArrayList (List <Integer> lista){     // manera iterativa
			
			List <Integer> aux = new ArrayList<Integer>();
			int elementos = lista.size();
			int i = 0;
			int num;
			while(i < elementos) {
				num = lista.get(elementos - i - 1);
				aux.add(num);
				i++;
			}
			return aux;
		}
		
		public static List <Integer> invertirArrayListRecursivo(List <Integer> lista){
			
			List <Integer> aux = new ArrayList<Integer>();
			
			int elementos = lista.size();
			aux.add(lista.get(elementos - 1));
			
			if(aux.size() == lista.size()) {
				return aux;
			}
			else
			{
				int num = lista.get(elementos - 1);
				lista.remove(elementos - 1);										// preguntar pero quedo pioloso
				aux.addAll(invertirArrayListRecursivo(lista));
				lista.add(elementos - 1, num);
				return aux;
			}
			
		}
		
		public static int sumarLinkedList(List <Integer> lista) {
			int aux = 0;
			
			int elementos = lista.size();
			int valor = lista.get(elementos - 1);								// preguntar pero anda
			aux += valor;
			
			if(elementos - 1 == 0) {
				return aux;
			}
			else
			{
				lista.remove(elementos - 1);
				aux+= sumarLinkedList(lista);
				lista.add(valor);
				return aux;
			}
		}
		
		
		public static List <Integer> combinarOrdenado(List <Integer> lista1 , List <Integer> lista2){
			
			List <Integer> aux = new LinkedList<Integer>();
			
			int elementos = lista1.size();
			int i = 0;
			System.out.println("Carga de la primera lista");
			
			while(i < elementos) {
				aux.add(lista1.get(i));
				i++;
			}
			
			elementos = lista2.size();
			i = 0;
			System.out.println("Carga de la segunda lista");
			
			while(i < elementos) {
				aux.add(lista2.get(i));
				i++;
			}
			
			return aux;
		}

	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Lista 1, escriba un numero");						//Inciso J			
		int num = s.nextInt();
		List <Integer> lista1 = devolverSucesion(num);  
		mostrarListaEnteros(lista1);
		
		System.out.println("Lista 2, escriba un numero");
		num = s.nextInt();
		List <Integer> lista2 = devolverSucesion(num);
		mostrarListaEnteros(lista2);
		
		List <Integer> listaCombinado = combinarOrdenado(lista1 , lista2);
		mostrarListaEnteros(listaCombinado);
		
		
		/*
		System.out.println("Escriba un numero");								// Inciso I
		int num = s.nextInt();
		List <Integer> lista = devolverSucesion(num);                     
		mostrarListaEnteros(lista);
		
		int suma = sumarLinkedList(lista);
		System.out.println("El valor de la es de : " + suma);
		
		System.out.println("Elementos de la lista : " + lista.size());
		
		/*
		 * 
		System.out.println("Escriba un numero");
		int num = s.nextInt();
		
		List <Integer> lista = devolverSucesion(num);                     // Inciso G
		mostrarListaEnteros(lista);
		
		List <Integer> listaInvertida = invertirArrayList(lista);
		System.out.println("Lista invertida iterativa");
		mostrarListaEnteros(listaInvertida);  
		
		List <Integer> listaInvertida2 = invertirArrayListRecursivo(lista);   // Inciso H
		System.out.println("Lista invertida iterativa recursiva"); 
		mostrarListaEnteros(listaInvertida2); 
		
		System.out.println(lista.size());
		
        */                        
		
		/*
		Scanner s = new Scanner(System.in);
		List <Integer> lista = new ArrayList<Integer>();
		
		int valor;
		
		System.out.println("Escriba un numero");
		int num = s.nextInt();
		while(num != 0) {
			while(num != 0) {
				valor = num % 10;
				lista.add(valor);
				num = num / 10;
			}
			System.out.println("Escriba otro numero");
			num = s.nextInt();
		}
		
		boolean casa = esCapicua(lista);
		
		if(casa == true ) {
			System.out.print("Es capicua");
		}
		else
		{
			System.out.print("No es capicua");
		}
		
		*/
		/*
		 * 
		List<Estudiante> estudiantes = crearLista();  //								Inciso D
		List<Estudiante> estudiantes2 = estudiantes;
		mostrarLista(estudiantes);
		System.out.println("Ahora le toca a la lista copiada");
		mostrarLista(estudiantes2);
		
		modificarLista(estudiantes);
		
		mostrarLista(estudiantes);
		System.out.println("Ahora le toca a la lista copiada");
		mostrarLista(estudiantes2);
		
		Estudiante est1 = new Estudiante();
		
		agregarSiNoEstaEnLaLista(estudiantes,est1);//										Inciso e
		mostrarLista(estudiantes);
		
		*/
		/*
		 * Scanner s = new Scanner(System.in);	//para leer de teclado
		List<Integer> lista = new ArrayList <Integer>();		//creacion basica de lista  
		
		System.out.println("Escriba un numero para agregar a la lista");          
		int num = s.nextInt();
		while(num != 0) {                                              //alternativa ArrayList
			lista.add(num);
			System.out.println("Escriba otro numero para agregar a la lista");
			num = s.nextInt();
		}
		
															manera alternativa
		while(!(lista.isEmpty())) {
			System.out.println(lista.get(0));
			lista.remove(0);
		}
		
		
		List<Integer> lista = new LinkedList<Integer>();
		int i = 0;
		System.out.println("Escriba un numero para agregar a la lista");          
		int num = s.nextInt();
		while(num != 0) {                                             
			lista.add(num);
			System.out.println("Escriba otro numero para agregar a la lista");
			num = s.nextInt();
		}	
		
		int elementos = lista.size();
		while(i < (elementos)) {
			System.out.println(lista.get(i));
			i++;
		}
		*/																				//		Incisos A,B Y C
	}
}
