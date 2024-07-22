package ejercicio06;
import ArbolGeneral.GeneralTree;
import java.util.*;
public class RedAguaPotable {
	
	private GeneralTree<Integer> arbol;
	

	public RedAguaPotable(GeneralTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}


	public double minimoCaudal(double caudal) {
		double minimo = 999;
		double caudalMinimo = 0;
		if(!this.arbol.isEmpty()) {
			caudalMinimo = caudalAux(arbol , caudal , minimo);
		}
		return caudalMinimo ;
	}
	
	private double caudalAux(GeneralTree<Integer> arbol , double caudal , double minimo) {
		
		if(arbol.hasChildren()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			if(caudal / children.size() < minimo) {
				minimo = caudal / children.size();
				caudal = caudal / children.size();
			}
			for(GeneralTree<Integer> child:children) {
				minimo = caudalAux(child , caudal , minimo);
			}
		}
		
		return minimo;
	}
	
	
	public static void main(String[] args) {
		
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(22));
		children2.add(new GeneralTree<Integer>(23));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(32));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
		List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
		childen.add(a1);childen.add(a2);childen.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(0, childen);
		
		RedAguaPotable red = new RedAguaPotable(a);
		System.out.println("Caudal minimo: " + red.minimoCaudal(1000));
		
	}
	
}
