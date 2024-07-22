package ejercicio3;

import java.util.*;

public class testeo3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(20);
		
		
		BinaryTree<Integer> hijo = new BinaryTree<Integer>(4);
		arbol.addLeftChild(hijo);
		hijo = new BinaryTree<Integer>(8);
		arbol.addRightChild(hijo);
		hijo = new BinaryTree<Integer>(25);
		arbol.getLeftChild().addLeftChild(hijo);
		hijo = new BinaryTree<Integer>(37);
		arbol.getRightChild().addLeftChild(hijo);
		hijo = new BinaryTree<Integer>(2);
		arbol.getRightChild().addRightChild(hijo);
		/*
		arbol.agregarMio(arbol, hijo);	
		hijo = new BinaryTree<Integer>(15);
		arbol.agregarMio(arbol, hijo);	
		hijo = new BinaryTree<Integer>(18);					//testeo
		arbol.agregarMio(arbol, hijo);	
		hijo = new BinaryTree<Integer>(3);
		arbol.agregarMio(arbol, hijo);
		hijo = new BinaryTree<Integer>(24);
		arbol.agregarMio(arbol, hijo);
		
		
		System.out.println("imprimir in orden");
		arbol.imprimirArbolInOrden();
		System.out.println("imprimir post orden");
		arbol.imprimirArbolPostOrden();
		System.out.println("imprimir pre orden");
		arbol.imprimirArbolPreOrden();
		*/
		
		contadorArbolJava contador = new contadorArbolJava(arbol);
		
		System.out.println("Hojas: " + arbol.contarHojas());
		
		/*
		List<Integer> lista = contador.numerosPares(arbol);
		int elementos = lista.size();
		int i;
		for(i=0 ; i < elementos ; i++) {
			System.out.println("Valor: " + lista.get(i));
		}
		*/
	}
}
