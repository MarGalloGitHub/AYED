package ejercicio7;

import ejercicio3.BinaryTree;
public class ParcialArboles {

	private BinaryTree<Integer> arbol;
	
	
	public ParcialArboles(BinaryTree<Integer> _arbol) {
		arbol = _arbol;
	}
	
	
	public boolean isLeftTree(int num) {
		boolean aux = false;
		BinaryTree<Integer> arbolNuevo = busqueda(this.arbol , num);
		if(arbolNuevo != null) {
			arbolNuevo.imprimirArbolInOrden();
			aux = chequearCondicion(arbolNuevo);
		}
		return aux;
	}
	
	
	private BinaryTree<Integer> busqueda(BinaryTree<Integer> arbolX , int num){
		
		BinaryTree<Integer> arbolEncontrado = new BinaryTree<Integer>(); 
		
		if(arbolX.getData() == num) {
			System.out.println("Encontre el arbol");
			arbolEncontrado = arbolX;
		}
		else
		{
			if(arbolX.hasLeftChild()) {
				return busqueda(arbolX.getLeftChild() , num);
			}
			if(arbolX.hasRightChild()) {
				return busqueda(arbolX.getRightChild() , num);
			}
		}
		return arbolEncontrado;
	}
	
	private boolean chequearCondicion(BinaryTree<Integer> arbolNuevo) {				//chequeo de condicion
		int hijosIzq;
		int hijosDer;
		boolean aux = false;
		if(arbolNuevo.hasLeftChild()) {
			hijosIzq = contarHijos(arbolNuevo.getLeftChild());
		}
		else
		{
			hijosIzq = -1;
		}
		if(arbolNuevo.hasRightChild()) {
			hijosDer = contarHijos(arbolNuevo.getRightChild());
		}
		else
		{
			hijosDer = -1;
		}
		
		if(hijosIzq > hijosDer) {
			aux = true;
		}
		return aux;
	}
	
	private int contarHijos(BinaryTree<Integer> arbolAux) {
		if(arbolAux.isLeaf()) {
			return 0;
		}
		if(arbolAux.hasLeftChild() && !arbolAux.hasRightChild()) {
			return 1 + contarHijos(arbolAux.getLeftChild());
		}
		if(arbolAux.hasRightChild() && !arbolAux.hasLeftChild()) {
			return 1 + contarHijos(arbolAux.getRightChild());
		}		
		return contarHijos(arbolAux.getLeftChild()) + contarHijos(arbolAux.getRightChild());
	}

	public static void main(String[] args) {
		System.out.println("Testeo ejercicio 7");
		
		BinaryTree<Integer> hijo = new BinaryTree<Integer>(7);
		
		BinaryTree<Integer> arbol1 = new BinaryTree<Integer>();
		
		arbol1.setData(2);
		arbol1.addLeftChild(hijo);
								
		hijo = new BinaryTree<Integer>(23);
		arbol1.getLeftChild().addLeftChild(hijo);
		hijo = new BinaryTree<Integer>(6);
		arbol1.getLeftChild().addRightChild(hijo);						//lado izq
		hijo = new BinaryTree<Integer>(-3);
		arbol1.getLeftChild().getLeftChild().addLeftChild(hijo);
		hijo = new BinaryTree<Integer>(55);
		arbol1.getLeftChild().getRightChild().addLeftChild(hijo);
		hijo = new BinaryTree<Integer>(11);
		arbol1.getLeftChild().getRightChild().addRightChild(hijo);
		
		hijo = new BinaryTree<Integer>(-5);
		arbol1.addRightChild(hijo);		
		hijo = new BinaryTree<Integer>(19);									//lado derecho
		arbol1.getRightChild().addLeftChild(hijo);
		hijo = new BinaryTree<Integer>(4);
		arbol1.getRightChild().getLeftChild().addRightChild(hijo);
		hijo = new BinaryTree<Integer>(18);
		arbol1.getRightChild().getLeftChild().getRightChild().addLeftChild(hijo);
		
		
		arbol1.imprimirArbolPreOrden();
		
		ParcialArboles parcial = new ParcialArboles(arbol1);
		
		System.out.println("PRIMER CASO                                            ");
		
		if(parcial.isLeftTree(7)) {
			System.out.println("Para 7 funciona");
		}
		else
		{
			System.out.println("Para 7 no funciona");
		}
		
		System.out.println("PROXIMO CASO                                            ");

		if(parcial.isLeftTree(2)) {
			System.out.println("Para 2 funciona");
		}
		else
		{
			System.out.println("Para 2 no funciona");
		}
		
		
	}
	
}