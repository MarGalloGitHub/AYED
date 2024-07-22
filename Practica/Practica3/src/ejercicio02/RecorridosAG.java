package ejercicio02;
import AuxP3.Queue;
import java.util.*;
import ArbolGeneral.GeneralTree;

public class RecorridosAG {

	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a,Integer n){		// PREORDEN
		List<Integer> resul = new LinkedList<Integer>();
		if(a != null) {
			 PreOrdenAux(resul , a , n);
		}
		return resul;
	}
	
	private void PreOrdenAux( List<Integer> resul  ,GeneralTree<Integer> a , int valor) {
		int dato = a.getData();
		if((dato > valor)) {  // (((dato%2) != 0) && (dato > valor)) 
			resul.add(dato);
		}
		
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child: children) {
			PreOrdenAux(resul , child,valor);
		}
		
		
		/*
		Iterator<GeneralTree<Integer>> it = children.iterator();
		while(it.hasNext()) {
			
			GeneralTree<Integer> child = it.next();
			lista = PreOrdenAux(child , valor);
		}
		
		return lista;
		
		*/
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){		//INORDEN
		List<Integer> resul = new LinkedList<Integer>();
		if(a != null) {
			 InOrdenAux(resul , a , n);
		}
		return resul;
	}
	
	private void InOrdenAux( List<Integer> resul  ,GeneralTree<Integer> a , int valor) {
		
		List<GeneralTree<Integer>> children = a.getChildren();
		if(!children.isEmpty()) {
			InOrdenAux(resul , children.get(0) ,valor);
			children.remove(0);
		}
		
		int dato = a.getData();
		if((dato > valor)) {  // (((dato%2) != 0) && (dato > valor)) 
			resul.add(dato);
		}
		
		if(!children.isEmpty()) {
			
			for(GeneralTree<Integer> child: children) {
				InOrdenAux(resul , child , valor);
			}
		}
		
	}
	
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){		//POSTORDEN
		List<Integer> resul = new LinkedList<Integer>();
		if(a != null) {
			 PostOrdenAux(resul , a , n);
		}
		return resul;
	}
	
	private void PostOrdenAux( List<Integer> resul  ,GeneralTree<Integer> a , int valor) {
		
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child: children) {
			PostOrdenAux(resul , child,valor);
		}
		
		int dato = a.getData();
		if((dato > valor)) {
			resul.add(dato);
		}
	}
	
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){  //POR NIVELES
		List<Integer> resul = new LinkedList<Integer>();
		if(a != null) {
			 PorNivelesAux(resul , a , n);
		}
		return resul;
	}
	
	private void PorNivelesAux(List<Integer> resul , GeneralTree<Integer> a , Integer n) {
		
		GeneralTree<Integer> aux;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(a);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux.getData() > n) {
				resul.add(aux.getData());
			}
			List<GeneralTree<Integer>> children = aux.getChildren();
			for(GeneralTree<Integer> child:children) {
				cola.enqueue(child);
			}
		}
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
		System.out.println("Datos del Arbol: ");
		
		RecorridosAG parcial = new RecorridosAG();
		
		List<Integer> lista4 = parcial.numerosImparesMayoresQuePorNiveles(a, 0);
		System.out.println("PorNiveles:" +lista4);
		
		List<Integer> lista3 = parcial.numerosImparesMayoresQuePostOrden(a, 0);
		System.out.println("PostOrden:" + lista3);
		
		List<Integer> lista = parcial.numerosImparesMayoresQuePreOrden(a, 0);
		System.out.println("PreOrden:" +lista);
		
		List<Integer> lista2 = parcial.numerosImparesMayoresQueInOrden(a, 0);
		System.out.println("InOrden:" +lista2);
		
		
	}

}


