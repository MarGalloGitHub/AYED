package ejercicio1;

import java.util.*;
public class ejercicioTesteo {

	public static void main(String[] args) {
		
		
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);
		

		
		System.out.println(arbol.getData());  // preguntar pero por ahora devuelve el primer dato
		
		
		BinaryTree<Integer> hijo1 = new BinaryTree<Integer>(1);
		arbol.addLeftChild(hijo1);
		
		BinaryTree<Integer> hijo2 = new BinaryTree<Integer>(7);
		arbol.addRightChild(hijo2);
		
		BinaryTree<Integer> espejo = arbol.espejo();								//crear arbol espejo una vez cargado el arbol inicial
		
		if(arbol.hasLeftChild()) {
			System.out.println(arbol.getLeftChild());
		}
	
		if(arbol.hasRightChild()) {
			System.out.println(arbol.getRightChild());
		}
		
		if(arbol.isEmpty()) {	
			System.out.println("No tiene hijos");
		}	
		
		
		System.out.println("Ahora le toca al arbol espejo");
		
		System.out.println(espejo.getData());
		

		if(espejo.hasLeftChild()) {
			System.out.println(arbol.getLeftChild());
		}
		
		BinaryTree<Integer> hijo5 = new BinaryTree<Integer>(33);
		if(espejo.hasRightChild()) {
			System.out.println(arbol.getRightChild());
			espejo.getRightChild().addLeftChild(hijo5);						//buscar como agregar bien
		}
		
		if(espejo.isEmpty()) {	
			System.out.println("No tiene hijos");
		}	
		
		BinaryTree<Integer> hijo6 = new BinaryTree<Integer>(69);
		espejo.getRightChild().getLeftChild().addLeftChild(hijo6);   // preguntar como agregar correctamente
		
		//el contar hojas parte desde cierta base

		System.out.println("Hojas del arbol originl: " + arbol.contarHojas());
		
		System.out.println("Recorrido del original:  ");
		arbol.entreNiveles(0, 2);
		
		System.out.println("Recorrido del espejo:  ");
		espejo.entreNiveles(0, 3);
		
	}

}
