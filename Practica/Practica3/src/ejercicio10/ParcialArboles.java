package ejercicio10;
import java.util.*;
import ArbolGeneral.GeneralTree;

public class ParcialArboles {

	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> resul = new LinkedList<Integer>();
		List<Integer> actual = new LinkedList<Integer>();
		if(!arbol.isEmpty()) {
			int nivel = 0;
			aux(arbol , resul , actual , nivel , 0 , -1);
		}
		return resul;
	}
	
	private static int aux(GeneralTree<Integer> arbol , List<Integer> resul , List<Integer> act , int nivel, int actnum, int max) {
		
		
		if(arbol.getData() == 1 ){
			actnum += (arbol.getData() * nivel);
			act.add(arbol.getData());
		}
		if(!arbol.isLeaf()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for(GeneralTree<Integer> child : children) {
					max = aux(child , resul , act , nivel+1, actnum, max);
			}
		}
		else
		{
			if(actnum > max) {
				max = actnum;
				resul.clear();
				resul.addAll(act);
			}
			
		}
		if (arbol.getData() == 1 ){
				act.remove(act.size() - 1);
			}
		return max;
	}
	
	
	public static void main(String[] args) {
		
		 List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
	        subChildren1.add(new GeneralTree<Integer>(1));
	        subChildren1.add(new GeneralTree<Integer>(1));
	        subChildren1.add(new GeneralTree<Integer>(1));
	        GeneralTree<Integer> subA = new GeneralTree<Integer>(1, subChildren1);
	        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
	        subChildren2.add(subA);
	        subChildren2.add(new GeneralTree<Integer>(1));
	        GeneralTree<Integer> a1 = new GeneralTree<Integer>(0, subChildren2);
	        
	        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
	        subChildren3.add(new GeneralTree<Integer>(1));
	        GeneralTree<Integer> subB = new GeneralTree<Integer>(0, subChildren3);
	        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
	        subChildren4.add(subB);
	        GeneralTree<Integer> subC = new GeneralTree<Integer>(0, subChildren4);
	        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
	        subChildren5.add(new GeneralTree<Integer>(1));
	        subChildren5.add(subC);
	        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subChildren5);
	        
	        List<GeneralTree<Integer>> subChildren6 = new LinkedList<GeneralTree<Integer>>();
	        subChildren6.add(new GeneralTree<Integer>(0));
	        subChildren6.add(new GeneralTree<Integer>(0));
	        GeneralTree<Integer> subD = new GeneralTree<Integer>(0, subChildren6);
	        List<GeneralTree<Integer>> subChildren7 = new LinkedList<GeneralTree<Integer>>();
	        subChildren7.add(subD);
	        GeneralTree<Integer> subE = new GeneralTree<Integer>(0, subChildren7);
	        List<GeneralTree<Integer>> subChildren8 = new LinkedList<GeneralTree<Integer>>();
	        subChildren8.add(subE);
	        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subChildren8);
	        
	        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
	        arbol.add(a1);
	        arbol.add(a2);
	        arbol.add(a3);
	        GeneralTree<Integer> a = new GeneralTree<Integer>(1, arbol);
	        
	        ParcialArboles parcial = new ParcialArboles();
	        
	        List<Integer> lista = parcial.resolver(a);
	        
	       System.out.println(lista);
	
	}

}
