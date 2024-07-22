package ejercicio6;
import Ejercicio2.BinaryTree;

public class Transformacion {

	private BinaryTree<Integer> arbol;

	public Transformacion(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public void preOrden() {
		if(!this.arbol.isEmpty()) {
			preOrdenAux(this.arbol);
		}
	}
	
	private void preOrdenAux(BinaryTree<Integer> arbol) {
		System.out.println(arbol.getData());
		if(arbol.hasLeftChild()) {
			preOrdenAux(arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			preOrdenAux(arbol.getRightChild());
		}
	}
	
	public BinaryTree<Integer> suma(){
		
		if(!this.arbol.isEmpty()) {
			sumaAux(this.arbol);
		}
		
		return this.arbol;
	}
	
	private int sumaAux(BinaryTree<Integer> arbol){
		int suma = 0;
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
}
