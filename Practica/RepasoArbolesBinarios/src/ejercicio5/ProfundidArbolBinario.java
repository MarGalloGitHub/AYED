package ejercicio5;
import Ejercicio2.BinaryTree;

public class ProfundidArbolBinario {
	
	private BinaryTree<Integer> arbolA;

	public ProfundidArbolBinario(BinaryTree<Integer> arbolA) {
		super();
		this.arbolA = arbolA;
	}
	
	public int sumaElementosProfundidad(int p) {
		int nivelP = 0;
		int suma = 0;
		if(!this.arbolA.isEmpty()) {
			suma = sumaPaux(this.arbolA,p,suma,nivelP);
		}
		
		return suma;
	}
	
	private int sumaPaux(BinaryTree<Integer> arbol, int p, int suma , int nivelP) {
			
		if (p == nivelP) {
			suma += arbol.getData();
		}
		
			if (arbol.hasLeftChild()) {
				nivelP++;
				suma = sumaPaux(arbol.getLeftChild(), p , suma , nivelP);
				nivelP--;
			}
			if (arbol.hasRightChild()) {
				nivelP++;
				suma= sumaPaux(arbol.getRightChild(), p , suma , nivelP);
				nivelP--;
			}
			
		return suma;
	}

}
