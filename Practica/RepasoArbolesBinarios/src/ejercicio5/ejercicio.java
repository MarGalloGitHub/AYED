package ejercicio5;

import Ejercicio2.BinaryTree;

public class ejercicio {

	public static void main(String[] args) {
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));				//ARBOL COMPLETO
		BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(77));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(79));
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		ProfundidArbolBinario prof = new ProfundidArbolBinario(ab);
		
		System.out.println("Suma en profundidad = " + prof.sumaElementosProfundidad(3));
	}
}
