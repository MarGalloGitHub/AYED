package ejercicio11;

import ArbolGeneral.GeneralTree;
import java.util.*;
import AuxP3.Queue;

public class ParcialArboles {
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		boolean ok = false;
		if(!arbol.isEmpty()) {
			ok = aux(arbol);
		}
		
		return ok;
	}
	
	private static boolean aux(GeneralTree<Integer> arbol) {
		boolean ok = true;
		int anterior = 0;
		int actual = 0;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> aux;
		cola.enqueue(arbol);
		cola.enqueue(null);
		while((!cola.isEmpty()) && (ok)) {
			aux = cola.dequeue();
			if(aux != null) {
				actual++;
				System.out.println("Actual: " + actual);
				List<GeneralTree<Integer>> children = aux.getChildren();
				Iterator<GeneralTree<Integer>> it = children.iterator();
				while(it.hasNext()) {
					cola.enqueue(it.next());
				}
			}
			else
			{
				if(!cola.isEmpty()) {
					System.out.println("Actual: " + actual + " anterior:  " + anterior );
					if(actual != ( anterior + 1)) {
						ok = false;
					}
					cola.enqueue(null);
					anterior = actual;
					actual = 0;
				}
			}
			
		}
		
		return ok;
	}
	
	
	public static void main(String[] args) {
		
		   List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
	        subChildren1.add(new GeneralTree<Integer>(83));
	        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(18, subChildren1);
	        
	        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
	        subChildren2.add(subAb1);
	        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(5, subChildren2);
	        
	        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
	        subChildren3.add(new GeneralTree<Integer>(33));
	        subChildren3.add(new GeneralTree<Integer>(12));
	        subChildren3.add(new GeneralTree<Integer>(17));
	        subChildren3.add(new GeneralTree<Integer>(9));
	        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(3, subChildren3);
	        
	        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
	        subChildren4.add(new GeneralTree<Integer>(7));
	        subChildren4.add(new GeneralTree<Integer>(11));
	        subChildren4.add(subAb3);
	        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(4, subChildren4);
	        
	        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
	        subArbIzq.add(subAb2);
	        subArbIzq.add(subAb4);
	        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(1, subArbIzq);
	        
	        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
	        subArbDer.add(new GeneralTree<Integer>(13));
	        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
	        
	        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
	        arbol.add(arbIzq);
	        arbol.add(arbDer);
	        GeneralTree<Integer> a = new GeneralTree<Integer>(2, arbol);
	        
	        ParcialArboles parcial = new ParcialArboles();
	        
	        System.out.println(parcial.resolver(a));
	}

}
