package Parciales;

import ArbolGeneral.GeneralTree;
import AuxP3.Queue;
import java.util.*;
public class ParcialArboles {
	
	private GeneralTree<Integer> arbol;

	public ParcialArboles(GeneralTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public List<Integer> listaGenerica(int num){
		List<Integer> resul = new LinkedList<Integer>();
		if(!this.arbol.isEmpty()) {
			resul = aux(this.arbol , num);
		}
		return resul;
	}
	
	private List<Integer> aux (GeneralTree<Integer> arbol , int num){
		List<Integer> resul = new LinkedList<Integer>();
		boolean encontre = false;
		boolean cumple = false;
		GeneralTree<Integer> auxArbol;
		Queue<GeneralTree<Integer>> cola = new 	Queue<GeneralTree<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while((!cola.isEmpty()) && ( encontre == false)){
			auxArbol = cola.dequeue();
			cumple = true;
			if(auxArbol != null) {
				
				resul.add(auxArbol.getData());
				List<GeneralTree<Integer>> children = auxArbol.getChildren();
				if(children.size() < num) {
					cumple = false;
				}
				
				for(GeneralTree<Integer> child: children) {
					cola.enqueue(child);
				}
			}
			else
			{
				if(!cola.isEmpty()) {
					if(cumple = true) {
						encontre = true;
					}
					else
					{
						resul.clear();
					}
					cola.enqueue(null);
					
				}
			}
		}
		
		return resul;
	}

}
