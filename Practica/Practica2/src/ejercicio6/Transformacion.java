package ejercicio6;

import java.util.*;
import ejercicio3.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> _arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		_arbol = arbol;
	}
	
	public BinaryTree<Integer> suma(){
		sumaAux(_arbol);
		return _arbol;
	}
	
	

	
	private int sumaAux(BinaryTree<Integer> arbol) {
		int suma= 0;
		if(arbol.isLeaf()) {					//caso base, llega a una hoja y despues de juntar su numero lo pone en 0
			suma = arbol.getData();
			arbol.setData(0);
			return suma;
		}
		if(arbol.hasLeftChild()) {
			suma+= sumaAux(arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			suma+= sumaAux(arbol.getRightChild());
		}
		int actual = arbol.getData();
		arbol.setData(suma);
		return actual + suma;	
	}
	
	 public static void main (String[] args) {
	        System.out.println("Test Transformacion");
	        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
	        ab.addLeftChild(new BinaryTree<Integer>(2));
	        ab.addRightChild(new BinaryTree<Integer>(6));
	        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
	        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
	        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
	        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
	        
	        ab.imprimirArbolInOrden();
	        Transformacion tras = new Transformacion(ab);
	        System.out.println();
	        System.out.println("Arbol transformado");
	        tras.suma().imprimirArbolInOrden();
	    }
}
