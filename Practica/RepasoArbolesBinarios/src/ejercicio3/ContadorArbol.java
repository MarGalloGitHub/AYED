package ejercicio3;
import java.util.*;
import Ejercicio2.BinaryTree;

public class ContadorArbol {

	public BinaryTree<Integer> arbol;

	public ContadorArbol(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
		public List<Integer> numerosParesPre(){
		
		List<Integer> lista = new LinkedList<Integer>();
		if(!(this.arbol.isEmpty())){
			armarListaPre(lista , this.arbol);
		}
		return lista;
		}
		
		private void armarListaPre(List<Integer> lista , BinaryTree<Integer> arbol) {
			if((arbol.getData()%2) == 0){
				lista.add(arbol.getData());
			}
			if(arbol.hasLeftChild()) {
				armarListaPre(lista,arbol.getLeftChild());
			}
			if(arbol.hasRightChild()) {
				armarListaPre(lista,arbol.getRightChild());
			}
		}
		
		
		public List<Integer> numerosParesPost(){
			
			List<Integer> lista = new LinkedList<Integer>();
			if(!(this.arbol.isEmpty())){
				armarListaPost(lista , this.arbol);
			}
			return lista;
		}
	
		private void armarListaPost(List<Integer> lista , BinaryTree<Integer> arbol) {
			
			if(arbol.hasLeftChild()) {
				armarListaPost(lista,arbol.getLeftChild());
			}
			if(arbol.hasRightChild()) {
				armarListaPost(lista,arbol.getRightChild());
			}
			if((arbol.getData()%2) == 0){
				lista.add(arbol.getData());
			}
		}
		
		public List<Integer> numerosParesIn(){
			
			List<Integer> lista = new LinkedList<Integer>();
			if(!(this.arbol.isEmpty())){
				armarListaIn(lista , this.arbol);
			}
			return lista;
		}
		
		private void armarListaIn(List<Integer> lista , BinaryTree<Integer> arbol) {
			
			if(arbol.hasLeftChild()) {
				armarListaIn(lista,arbol.getLeftChild());
			}
			if((arbol.getData()%2) == 0){
				lista.add(arbol.getData());
			}
			if(arbol.hasRightChild()) {
				armarListaIn(lista,arbol.getRightChild());
			}
			
		}
}
