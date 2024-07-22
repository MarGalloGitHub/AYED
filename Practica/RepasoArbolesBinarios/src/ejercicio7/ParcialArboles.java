package ejercicio7;
import Ejercicio2.BinaryTree;

public class ParcialArboles {

	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
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
	

	public boolean isLeftTree(int num) {
		boolean ok = false;
		BinaryTree<Integer> subArbol = buscarSubArbol(this.arbol , num);
		if(!subArbol.isEmpty()) {
			ok = isLeftTreeAux1(subArbol);
		}
		
		return ok;
	}
	
	private BinaryTree<Integer> buscarSubArbol(BinaryTree<Integer> arbol , int num){
		
		BinaryTree<Integer> arbolRet = null;
		if(arbol.getData() == num) {
			arbolRet = arbol;
			System.out.println("Lo encontre");
		}
		else {
			if((arbol.hasLeftChild()) && (arbolRet == null))  {
				arbolRet = buscarSubArbol(arbol.getLeftChild() , num);
			}
			if((arbol.hasRightChild()) && (arbolRet == null)) {
				arbolRet = buscarSubArbol(arbol.getRightChild() , num);
			}
		}
		
		return arbolRet;
		
	}
	
	
	private boolean isLeftTreeAux1(BinaryTree<Integer> arbol) {
		
		int hijoIzq = 0;
		int hijoDer = 0;
		if(arbol.hasLeftChild()) {
			hijoIzq = ContarHijos(arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			hijoDer = ContarHijos(arbol.getRightChild());
		}
		
		return (hijoIzq > hijoDer);
	}
	
	private int ContarHijos(BinaryTree<Integer> arbol) {
		int cont = 0;
		if(arbol.hasLeftChild()) {
			cont += ContarHijos(arbol.getLeftChild());
			if(!arbol.hasRightChild()) {
				cont++;
			}
		}
		if(arbol.hasRightChild()) {
			cont += ContarHijos(arbol.getRightChild());
			if(!arbol.hasLeftChild()) {
				cont++;
			}
		}
		
		return cont;
	}

}
