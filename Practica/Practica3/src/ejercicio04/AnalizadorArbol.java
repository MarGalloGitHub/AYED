package ejercicio04;
import ArbolGeneral.GeneralTree;
import java.util.*;
import AuxP3.Queue;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		double promedio = 0;
		if(arbol != null) {
			promedio = aux(arbol);
		}
		
		return promedio;
	}
	
	private double aux(GeneralTree<AreaEmpresa> arbol) {
		double prom = 0;
		double promMax = 0;
		double suma = 0;
		Integer cant = 0;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		GeneralTree<AreaEmpresa> aux;
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				suma += aux.getData().getTardanza();
				cant++;
				List<GeneralTree<AreaEmpresa>> children = aux.getChildren();
				for(GeneralTree<AreaEmpresa> child:children) {
					cola.enqueue(child);
				}
			}
			else {
				if(!cola.isEmpty()){
					cola.enqueue(null);
				}
				prom = suma / cant;												//TODO LO QUE SEA DE CAMBIAR NIVEL A NIVEL FUERA DEL
				System.out.println("Promedio de nivel = " + prom);				// IF Y DENTRO DEL ELSE
				suma = 0;
				cant = 0;
				if(prom > promMax) {
					promMax = prom;
				}
				
			}
		}
			
		return promMax;
	}
	
	
	public static void main(String[] args) {
		
		
		
		List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<GeneralTree<AreaEmpresa>>();  //PRIMER SUBARBOL
		AreaEmpresa area = new AreaEmpresa("A" , 4);
		children1.add(new GeneralTree<AreaEmpresa>(area));
		area = new AreaEmpresa("B" , 7);
		children1.add(new GeneralTree<AreaEmpresa>(area));
		area = new AreaEmpresa("C" , 5);
		children1.add(new GeneralTree<AreaEmpresa>(area));
		
		area = new AreaEmpresa("J" , 13);
		GeneralTree<AreaEmpresa> a1 = new GeneralTree<AreaEmpresa>(area , children1);
		
		
		List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<GeneralTree<AreaEmpresa>>();  //SEGUNDO SUBARBOL
		area = new AreaEmpresa("D" , 6);
		children2.add(new GeneralTree<AreaEmpresa>(area));
		area = new AreaEmpresa("E" , 10);
		children2.add(new GeneralTree<AreaEmpresa>(area));
		area = new AreaEmpresa("F" , 18);
		children2.add(new GeneralTree<AreaEmpresa>(area));
		
		area = new AreaEmpresa("K" , 25);
		GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(area , children2);
		
		
		List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<GeneralTree<AreaEmpresa>>();  //TERCER SUBARBOL
		area = new AreaEmpresa("G" , 9);
		children3.add(new GeneralTree<AreaEmpresa>(area));
		area = new AreaEmpresa("H" , 12);
		children3.add(new GeneralTree<AreaEmpresa>(area));
		area = new AreaEmpresa("I" , 19);
		children3.add(new GeneralTree<AreaEmpresa>(area));
		
		area = new AreaEmpresa("L" , 10);
		GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(area , children3);
		
		
		List<GeneralTree<AreaEmpresa>> childen = new LinkedList<GeneralTree<AreaEmpresa>>();		//ARBOL GENERAL
		childen.add(a1);childen.add(a2);childen.add(a3);
		area = new AreaEmpresa("M" , 14);
		GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(area,childen);
		
		
		
		AnalizadorArbol ejercicio = new AnalizadorArbol();
		
		System.out.println("Promedio maximo: " + ejercicio.devolverMaximoPromedio(a));
	}

}
