/*
 * Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2).
a) Implemente el método realizando un recorrido InOrden.
b) Implemente el método realizando un recorrido PostOrden.
 */

package ejercicio3;
import java.util.*;

public class contadorArbolJava {

	private BinaryTree<Integer> arbol;

	public contadorArbolJava(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public List<Integer> numerosPares(BinaryTree<Integer> arbol){
		
		List<Integer> lista = new LinkedList<Integer>();
		if(!(arbol.isEmpty())){
			armarListaA(lista , arbol);
		}
		return lista;
	}
	
	public List<Integer> numerosParesIn(BinaryTree<Integer> arbol){
		
		List<Integer> lista = new LinkedList<Integer>();
		if(!(arbol.isEmpty())){
			armarListaA(lista , arbol);
		}
		return lista;
	}

	public List<Integer> numerosParesPost(BinaryTree<Integer> arbol){
	
	List<Integer> lista = new LinkedList<Integer>();
	if(!(arbol.isEmpty())){
		armarListaA(lista , arbol);
	}
	return lista;
}
	
	public void armarListaA(List<Integer> lista , BinaryTree <Integer> arbol){  //armar estructura con lo que saco del arbol
		if(arbol.getData() % 2 == 0) {
			lista.add(arbol.getData());
		}
		if(arbol.hasLeftChild()) {												// este es caso pre orden
			armarListaA(lista, arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			armarListaA(lista, arbol.getRightChild());
		}
		
	}
	
	public void armarListaB(List<Integer> lista , BinaryTree <Integer> arbol){  
	
		if(arbol.hasLeftChild()) {												// este es caso in orden
			armarListaB(lista, arbol.getLeftChild());
		}
		if(arbol.getData() % 2 == 0) {
			lista.add(arbol.getData());
		}
		if(arbol.hasRightChild()) {
			armarListaB(lista, arbol.getRightChild());
		}
		
	}
	
	public void armarListaC(List<Integer> lista , BinaryTree <Integer> arbol){  
		
		if(arbol.hasLeftChild()) {												// este es caso post orden
			armarListaC(lista, arbol.getLeftChild());
		}
		
		
		if(arbol.hasRightChild()) {
			armarListaC(lista, arbol.getRightChild());
		}
		
		if(arbol.getData() % 2 == 0) {
			lista.add(arbol.getData());
		}
		
	}
	
}
