package ejercicio03;
import java.util.*;
import ArbolGeneral.GeneralTree;

public class testeo3 {

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
		
		System.out.println("Altura del arbol: " + a.altura() );
		
		System.out.println("Nivel del dato:  " + a.nivel(1));
		
		System.out.println("Ancho del arbol:  " +  a.ancho());
	}

}
