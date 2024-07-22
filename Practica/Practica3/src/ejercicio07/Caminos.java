package ejercicio07;

import ArbolGeneral.GeneralTree;
import java.util.*;
public class Caminos {
	private GeneralTree<Integer> arbol;

	public Caminos(GeneralTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> max = new LinkedList<Integer>();
		List<Integer> act = new LinkedList<Integer>();
		if(this.arbol != null) {
			caminoLejanoAux(arbol , max , act);
		}
		return max;
	}
	
	private void caminoLejanoAux(GeneralTree<Integer> arbol , List<Integer>max , List<Integer> act) {
		act.add(arbol.getData());
		if(!arbol.isLeaf()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for(GeneralTree<Integer> child : children) {
				caminoLejanoAux(child , max , act);
			}
		}
		else
		{
			if(act.size() > max.size()) {
				max.removeAll(max);
				max.addAll(act);
			}
		}
		
		act.remove(act.size() - 1);
		
	}
	
	public static void main (String[] args) {
		
		 List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
	        subChildren1.add(new GeneralTree<Integer>(1));
	        GeneralTree<Integer> subA = new GeneralTree<Integer>(6, subChildren1);
	        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
	        subChildren2.add(new GeneralTree<Integer>(10));
	        subChildren2.add(subA);
	        GeneralTree<Integer> a1 = new GeneralTree<Integer>(17, subChildren2);
	        
	        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
	        subChildren3.add(new GeneralTree<Integer>(8));
	        GeneralTree<Integer> a2 = new GeneralTree<Integer>(9, subChildren3);
	        
	        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
	        subChildren4.add(new GeneralTree<Integer>(16));
	        subChildren4.add(new GeneralTree<Integer>(7));
	        GeneralTree<Integer> subB = new GeneralTree<Integer>(14, subChildren4);
	        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
	        subChildren5.add(subB);
	        subChildren5.add(new GeneralTree<Integer>(18));
	        GeneralTree<Integer> a3 = new GeneralTree<Integer>(15, subChildren5);
	        
	        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
	        arbol.add(a1);
	        arbol.add(a2);
	        arbol.add(a3);
	        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol);
	        
	        Caminos camino = new Caminos(a);
	        
	        List<Integer> caminoLargo = camino.caminoAHojaMasLejana();
	        
	        System.out.println(caminoLargo);
		
	}

}
