package ejercicio9;

import ejercicio3.BinaryTree;

public class ParcialArboles {
	
	
	public BinaryTree<Info> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<Info> arbolInfo = new BinaryTree<Info>();
		if(arbol != null) {
			int suma = 0;
			int valorPadre = 0;
			arbolInfo = sumAndDifAux( arbol , suma , valorPadre);
		}
		return arbolInfo;
	}

	private BinaryTree<Info> sumAndDifAux( BinaryTree<Integer> arbol , int suma , int valorP){
		suma+= arbol.getData();
		int diferencia = arbol.getData() - valorP;
		valorP = arbol.getData();
		Info a = new Info(suma , diferencia);
		BinaryTree<Info> resul = new BinaryTree<Info>(a);
		
		if(arbol.hasLeftChild()) {
    		resul.addLeftChild(sumAndDifAux(arbol.getLeftChild() , suma , valorP));
    	}
		
    	if(arbol.hasRightChild()) {
    		resul.addRightChild(sumAndDifAux(arbol.getRightChild(), suma , valorP));
    	}
		
		return resul;
	
	}
	
	
	public void PreOrden(BinaryTree<Info> arbol) {
		Info info = arbol.getData();
		System.out.println("Info nodo = " + info.getSuma() + " | " + info.getDiferencia());
		if(arbol.hasLeftChild()) {
			PreOrden(arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			PreOrden(arbol.getRightChild());
		}
	}
	
	public void PreOrdenNum(BinaryTree<Integer> arbol) {
		System.out.println(arbol.getData());
		if(arbol.hasLeftChild()) {
			PreOrdenNum(arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			PreOrdenNum(arbol.getRightChild());
		}
	}
	
	
	public static void main (String[] args) {
		
		System.out.println("Testeo ejercicio 9");
		
		BinaryTree<Integer> arbol1 = new BinaryTree<Integer>(3); 
		
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(1); //arbol1 			
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(12));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(13));
		
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(1);
		arbol1.addLeftChild(hijoIzquierdo);
		arbol1.addRightChild(hijoDerecho);
		
		
		
		ParcialArboles parcial = new ParcialArboles();
		parcial.PreOrdenNum(arbol1);
		
		
		BinaryTree<Info> nuevoArbol = new BinaryTree<Info>();
		
		nuevoArbol = parcial.sumAndDif(arbol1);
		
		parcial.PreOrden(nuevoArbol);
		
		
	}
	
}
