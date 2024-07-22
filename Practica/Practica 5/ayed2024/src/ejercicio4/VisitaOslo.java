package ejercicio4;

import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;

public class VisitaOslo {
	
	public List<String> paseoEnBici(Graph<String> lugares , String destino , int maxTiempo , List<String> lugaresRestringidos){
		List<String> camino = new LinkedList<String>();
		 if(!lugares.isEmpty()) {
	            Vertex origenG = lugares.search("Ayuntamiento");
	            Vertex destinoG = lugares.search(destino);
	            if(origenG != null && destinoG != null) {
	            	boolean[] marca = new boolean[lugares.getSize()];
	                paseoAux(lugares , origenG, destinoG, camino, marca , maxTiempo , lugaresRestringidos);
	            }
	        }
	      return camino;
	}

	
	private boolean paseoAux(Graph<String> grafo , Vertex<String> origen , Vertex<String> destino , List<String> camino , boolean[] marcas , int maxTiempo , List<String> lugaresR) {
		camino.add(origen.getData());
		marcas[origen.getPosition()] = true;
		
		boolean termine = false;
		if(origen.getData() == destino.getData()) {
			return true;
		}
			
		List<Edge<String>> adyacentes = grafo.getEdges(origen);
		for(Edge<String> adyacente : adyacentes)  {
			Vertex<String> v = adyacente.getTarget();
			int pos = v.getPosition();
			if((!marcas[pos]) && (!lugaresR.contains(v.getData())) && (adyacente.getWeight() <= maxTiempo) ){
				if(paseoAux(grafo , v , destino , camino , marcas , maxTiempo - adyacente.getWeight() , lugaresR)) {
					return true;
				}
			}
		}
		
		marcas[origen.getPosition()] = false;
		camino.remove(camino.size() - 1);
		return false;
			
	}

}
