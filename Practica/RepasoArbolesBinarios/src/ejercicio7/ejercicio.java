package ejercicio7;

import Ejercicio2.BinaryTree;

public class ejercicio {

	public static void main(String[] args) {
	
		
						
	;
		
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(7);
		BinaryTree<Integer> hijoIzquierdo1 = new BinaryTree<Integer>(23);			//ARBOL IZQ
		hijoIzquierdo1.addLeftChild(new BinaryTree<Integer>(-3));
		BinaryTree<Integer> hijoDerecho1= new BinaryTree<Integer>(6);
		hijoDerecho1.addLeftChild(new BinaryTree<Integer>(55));
		hijoDerecho1.addRightChild(new BinaryTree<Integer>(11));
		
		hijoIzquierdo.addLeftChild(hijoIzquierdo1);
		hijoIzquierdo.addRightChild(hijoDerecho1);	
		
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(-5);  
		BinaryTree<Integer> hijoDerecho2 = new BinaryTree<Integer>(4);  					//ARBOL DER
		hijoDerecho2.addLeftChild(new BinaryTree<Integer>(18));
		BinaryTree<Integer> hijoIzquierdo2 = new BinaryTree<Integer>(19); 
		hijoIzquierdo2.addRightChild(hijoDerecho2);
		hijoDerecho.addLeftChild(hijoIzquierdo2);
		
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
		
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		ParcialArboles parcial = new ParcialArboles(ab);
		
		parcial.preOrden();
		boolean ok = parcial.isLeftTree(-5);
		System.out.println(ok);
		
		
		
		
	}

}
