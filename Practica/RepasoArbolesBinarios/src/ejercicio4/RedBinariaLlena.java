package ejercicio4;
import Ejercicio2.BinaryTree;
import java.util.*;

public class RedBinariaLlena {

	private BinaryTree<Integer> arbol;

	public RedBinariaLlena(BinaryTree<Integer> arbol1) {
		super();
		this.arbol = arbol1;
	}
	
	public int retardoReenvi2o() {
		int maximo = 0;
		int suma = 0;
		if(!this.arbol.isEmpty()) {
			  maximo = retardoAux2(this.arbol , maximo, suma);
		}
		
		return maximo;
	}
	
	private int retardoAux2(BinaryTree<Integer> arbol, int suma , int max) {
		suma += arbol.getData();
		if (arbol.isLeaf()) {
			
			if (max < suma) {
				max = suma;
			}
		}
		else {
			if (arbol.hasLeftChild()) {
				max = retardoAux2(arbol.getLeftChild(), suma , max);
			}
			if (arbol.hasRightChild()) {
				max = retardoAux2(arbol.getRightChild(), suma, max);
			}
		}
		return max;
	}
	
	public int retardoReenvio() {
		int maximo = 0;
		Chequeo x = new Chequeo(-1);
		List<Integer> listaA = new LinkedList<Integer>();
		if(!this.arbol.isEmpty()) {
			  retardoAux(this.arbol , listaA , x);
		}
		
		maximo = x.getMax();
		
		return maximo;
	}
	
	private void retardoAux(BinaryTree<Integer> arbol , List<Integer> listaA , Chequeo x) {
		
		listaA.add(arbol.getData());
		
		if(arbol.isLeaf()) {
			int valor = 0;
			for(Integer u: listaA) {
				valor+= u;
			}
			int j = x.chequearMaximo(valor);
			System.out.println("nuevo maximo . " + j);
		}
		else
		{
			if(arbol.hasLeftChild()) {
				retardoAux(arbol.getLeftChild() , listaA , x);
				listaA.remove(listaA.size() - 1);
			}
			if(arbol.hasRightChild()) {
				retardoAux(arbol.getRightChild() , listaA , x);
				listaA.remove(listaA.size() - 1);
			}
		}
		
		
				
		
	}
}
