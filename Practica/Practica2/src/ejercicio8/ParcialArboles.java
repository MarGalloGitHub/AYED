package ejercicio8;


import ejercicio3.BinaryTree;
public class ParcialArboles {
	
	private BinaryTree<Integer> arbol;
	
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1 , BinaryTree<Integer> arbol2) {
		if(arbol1.isEmpty() || arbol2.isEmpty()) {
			return false;
		}
		else
		{
			return esPrefijoAux(arbol1,arbol2);
		}
	}
	
	private boolean esPrefijoAux(BinaryTree<Integer> arbol1 , BinaryTree<Integer> arbol2) {
		if(arbol1.getData() != arbol2.getData()) {
			return false;
		}
		boolean res = true;
		if(arbol1.hasLeftChild()) {
			if(arbol2.hasLeftChild()) {
				res = res && esPrefijoAux(arbol1.getLeftChild(),arbol2.getLeftChild());
			}
			else
				return false;
		}
		if(arbol1.hasRightChild()) {
			if(arbol2.hasRightChild()) {
				res = res && esPrefijoAux(arbol1.getRightChild(),arbol2.getRightChild());
			}
			else
				return false;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println("Testeo ejercicio8");
		
		BinaryTree<Integer> hijo = new BinaryTree<Integer>(1);
		
		BinaryTree<Integer> arbol1 = new BinaryTree<Integer>(3);   //(deberias ser iguales)
		BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(3);
		
		BinaryTree<Integer> arbol3 = new BinaryTree<Integer>();  //deberian ser distintos
		BinaryTree<Integer> arbol4 = new BinaryTree<Integer>();
		
		
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(1); //arbol1 			
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(12));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(13));
		
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(1);
		arbol1.addLeftChild(hijoIzquierdo);
		arbol1.addRightChild(hijoDerecho);
		
		
		
		BinaryTree<Integer> hijoIzquierdo2 = new BinaryTree<Integer>(1); //arbol2
		hijoIzquierdo2.addLeftChild(new BinaryTree<Integer>(12));
		hijoIzquierdo2.addRightChild(new BinaryTree<Integer>(13));
		
		BinaryTree<Integer> hijoDerecho2 = new BinaryTree<Integer>(1);
		hijoDerecho2.addRightChild(new BinaryTree<Integer>(55));
		
		arbol2.addLeftChild(hijoIzquierdo2);
		arbol2.addRightChild(hijoDerecho2);
		
		
		
		ParcialArboles parcial1 = new ParcialArboles();					//testeo 1
		if(parcial1.esPrefijoAux(arbol1, arbol2)) {
			System.out.println("En este caso funciono");
			System.out.println("Arbol1:  ");
			arbol1.imprimirArbolPreOrden();
			System.out.println("Arbol2");
			arbol2.imprimirArbolPreOrden();;
		}
		else
		{
			System.out.println("No era prefijo");
		}
		
		
		arbol3.setData(77);
		arbol3.addLeftChild(hijo);
		arbol3.addRightChild(hijo);									//arbol3
		hijo = new BinaryTree<Integer>(12);
		arbol3.getLeftChild().addLeftChild(hijo);
		hijo = new BinaryTree<Integer>(13);
		arbol3.getLeftChild().addRightChild(hijo);
		
		
		arbol4.setData(3);
		hijo = new BinaryTree<Integer>(1);							//arbol4
		arbol4.addLeftChild(hijo);
		arbol4.addRightChild(hijo);
		hijo = new BinaryTree<Integer>(12);
		arbol4.getLeftChild().addLeftChild(hijo);
		hijo = new BinaryTree<Integer>(13);
		arbol4.getLeftChild().addRightChild(hijo);
		hijo = new BinaryTree<Integer>(55);
		arbol4.getLeftChild().getRightChild().addRightChild(hijo);
		
		System.out.println("2do caso, arboles distintos");
		
		parcial1 = new ParcialArboles();					//testeo 1
		if(parcial1.esPrefijoAux(arbol3, arbol4)) {
			System.out.println("En este caso funciono");
			System.out.println("Arbol1:  ");
			arbol3.imprimirArbolPreOrden();
			System.out.println("Arbol2");
			arbol4.imprimirArbolPreOrden();;
		}
		else
		{
			System.out.println("No era prefijo");
		}
	}
}
