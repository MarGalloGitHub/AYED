package ejercicio4;

import Ejercicio2.BinaryTree;
import java.util.*;

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

		RedBinariaLlena red = new RedBinariaLlena(ab);
		
		System.out.println("El maximo retardo es: " + red.retardoReenvio());
		
		System.out.println("El maximo retardo2 es: " + red.retardoReenvi2o());
	}

}
