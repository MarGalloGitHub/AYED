package Ejercicio2;

public class Ejercicio {

	public static void main(String[] args) {
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
		BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		System.out.println("Cantidad de hojas = " + ab.contarHojas());
		
		BinaryTree<Integer> abEspejo = ab.espejo();
		
		System.out.println("arbol original");
		ab.entreNiveles(0, 2);
		
		System.out.println("arbol espejo");
		abEspejo.entreNiveles(1, 3);
	}
}
