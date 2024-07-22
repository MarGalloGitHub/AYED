package ejercicio5;

import java.util.*;
import ejercicio3.BinaryTree;
public class ProfundidadArbolBinario {

	private BinaryTree<Integer> _arbol;
	
	public ProfundidadArbolBinario (BinaryTree<Integer> arbol) {
		this._arbol = arbol;
	}
	
	public int sumaElementos(int prof)
	{
		int nivelActual = 0;
		int num = 0;
		if(!this._arbol.isEmpty()) {
			num = profundidadB(_arbol , prof , nivelActual);
		}
		return num;
	}
	
	private int profundidadB(BinaryTree<Integer> arbol , int prof , int nivelActual) {
		if(prof == nivelActual) {
			return arbol.getData();
		}
		else
		{
			int suma = 0;
			if(arbol.hasLeftChild()) {
				suma+= profundidadB(arbol.getLeftChild(), prof , nivelActual + 1);
			}
			if(arbol.hasRightChild()) {
				suma+= profundidadB(arbol.getRightChild(), prof ,nivelActual + 1);
			}
			return suma;
		}
		
		
	}
	
	 public static void main (String[] args) {
	        System.out.println("Test Profundidad");
	        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
	        ab.addLeftChild(new BinaryTree<Integer>(2));
	        ab.addRightChild(new BinaryTree<Integer>(6));
	        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
	        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
	        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
	        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
	        
	        ProfundidadArbolBinario prof = new ProfundidadArbolBinario(ab);
	        System.out.println(prof.sumaElementos(1));
	        
	    }
	
}
