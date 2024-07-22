package Parciale;

import ejercicio3.BinaryTree;

public class ParcialArboles {
	
	
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> _arbol) {
		this.arbol = _arbol;
	}
	
	
	
	public void PreOrden(BinaryTree<Integer> arbol) {
		System.out.println(arbol);
		if(arbol.hasLeftChild()) {
			PreOrden(arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			PreOrden(arbol.getRightChild());
		}
	}
	
	public BinaryTree<Integer> devolverNuevo() {
		BinaryTree<Integer> arbolNuevo = new BinaryTree<Integer>();
		if(!this.arbol.isEmpty()) {
			Auxiliar aux2 = new Auxiliar();
			aux2.setValor(0);
			arbolNuevo = aux(this.arbol , aux2);
		}
		
		return arbolNuevo;
	}
	
	private BinaryTree<Integer> aux(BinaryTree<Integer> arbol , Auxiliar aux2){
		
		BinaryTree<Integer> arbolNuevo = new BinaryTree<Integer>();
		int suma= arbol.getData() + aux2.getValor();
		arbolNuevo.setData(suma);
		if(arbol.hasLeftChild()) {
			aux2.setValor(arbol.getData());
			arbolNuevo.addLeftChild(aux(arbol.getLeftChild() , aux2));
		}
		if(arbol.hasRightChild()) {
			aux2.setValor(0);
			arbolNuevo.addRightChild(aux(arbol.getRightChild() , aux2));
		}
		return arbolNuevo;
	}
	
	
	public static void main(String[] args) {
		
		BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(3);
		
		BinaryTree<Integer> hijoIzquierdo2 = new BinaryTree<Integer>(1); //arbol2
		hijoIzquierdo2.addLeftChild(new BinaryTree<Integer>(12));
		hijoIzquierdo2.addRightChild(new BinaryTree<Integer>(13));
		
		BinaryTree<Integer> hijoDerecho2 = new BinaryTree<Integer>(1);
		hijoDerecho2.addRightChild(new BinaryTree<Integer>(55));
		
		arbol2.addLeftChild(hijoIzquierdo2);
		arbol2.addRightChild(hijoDerecho2);
		
		ParcialArboles parcial = new ParcialArboles(arbol2);
		
		parcial.PreOrden(arbol2);
		
		BinaryTree<Integer> arbolFinal = parcial.devolverNuevo();
		
		System.out.println("Asi quedo al final");
		
		parcial.PreOrden(arbolFinal);
	}

}
