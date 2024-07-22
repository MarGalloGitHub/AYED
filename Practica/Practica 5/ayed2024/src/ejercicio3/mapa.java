package ejercicio3;
import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;

public class mapa {
	
	private Graph<String> mapaCiudades;
	
	public mapa(Graph<String> _grafo) {
		mapaCiudades = _grafo;
	}

	public List<String> devolverCamino (String ciudad1 , String ciudad2){
		 List<String> camino = new LinkedList<String>();
	        if(!this.mapaCiudades.isEmpty()) {
	            Vertex origen = this.mapaCiudades.search(ciudad1);
	            Vertex destino = this.mapaCiudades.search(ciudad2);
	            if(origen != null && destino != null) {
	            	boolean[] marca = new boolean[mapaCiudades.getSize()];
	                devolverCamino(origen, destino, camino, marca);
	            }
	        }
	      return camino;
	}
	
	private boolean devolverCamino(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marcas) {
        boolean encontre = false;
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if(origen == destino) {
            return true;
        } else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !encontre) {
                Vertex<String> v = it.next().getTarget();
                int j = v.getPosition();
                if(!marcas[j]) {
                    encontre = devolverCamino(v, destino, camino, marcas);
                }
            }
        }
        if(!encontre) {
            camino.remove(camino.size()-1); //marcas[origen.getPosition()] = false; Cuando haya encontrado el camino hacia destino, deja marcadas las posiciones del vector de marcas
        }
        marcas[origen.getPosition()] = false; //Deja desmarcadas todas las posiciones del vector de marcas: no es necesario desmarcar en este ejemplo.
        return encontre;
    }
	
	
	public <T> List<String> devolverCaminoExceptuando (String ciudad1 , String ciudad2 , List<String> limitantes){
		 List<String> camino = new LinkedList<String>();
	        if(!this.mapaCiudades.isEmpty()) {
	            Vertex origen = this.mapaCiudades.search(ciudad1);
	            Vertex destino = this.mapaCiudades.search(ciudad2);
	            if(origen != null && destino != null) {
	            	boolean[] marca = new boolean[mapaCiudades.getSize()];
	            	limitarCiudades(limitantes , marca);
	                devolverCamino(origen, destino, camino, marca);
	            }
	        }
	      return camino;
	}
	
	private void limitarCiudades(List<String> limitantes , boolean[] marca){
		for(String limite : limitantes) {
			Vertex<String> v = this.mapaCiudades.search(limite);
			if(v != null) {
				marca[v.getPosition()] = true;
			}
		}
	}
	
	  public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
	        List<String> camino = new LinkedList<String>();
	        if(!this.mapaCiudades.isEmpty()) {
	            Vertex origen = this.mapaCiudades.search(ciudad1);
	            Vertex destino = this.mapaCiudades.search(ciudad2);
	            if(origen != null && destino != null) {
	            	boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
	                caminoMasCorto(origen, destino, camino, new LinkedList<String>(), marcas, 0, Integer.MAX_VALUE);
	            }
	        }
	        return camino;
	    }
	    
	    private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo, List<String> caminoAct, boolean[] marcas, int total, int min) {
	        marcas[origen.getPosition()] = true;
	        caminoAct.add(origen.getData());
	        if(origen == destino && total < min) {
	            caminoMinimo.removeAll(caminoMinimo);
	            caminoMinimo.addAll(caminoAct);
	            min = total;
	        } else {
	            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
	            Iterator<Edge<String>> it = ady.iterator();
	            while(it.hasNext() && total < min) {
	                Edge<String> v = it.next();
	                int j = v.getTarget().getPosition();
	                int aux = total + v.getWeight();
	                if(!marcas[j] && aux < min) {
	                    min = caminoMasCorto(v.getTarget(), destino, caminoMinimo, caminoAct, marcas, aux, min);
	                }
	            }
	        }
	        marcas[origen.getPosition()] = false;
	        caminoAct.remove(caminoAct.size()-1);
	        return min;
	    }
	    
	    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
	        List<String> camino = new LinkedList<String>();
	        if(!this.mapaCiudades.isEmpty()) {
	            Vertex origen = this.mapaCiudades.search(ciudad1);
	            Vertex destino = this.mapaCiudades.search(ciudad2);
	            if(origen != null && destino != null) {
	            	boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
	                caminoSinCargarCombustible(origen, destino, camino, marcas, tanqueAuto);
	            }
	        }
	        return camino;
	    }
	    
	    private boolean caminoSinCargarCombustible(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marcas, int tanqueAuto) {
	        boolean encontre = false;
	        marcas[origen.getPosition()] = true;
	        camino.add(origen.getData());
	        if(origen == destino) {
	            return true;
	        } else {
	            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
	            Iterator<Edge<String>> it = ady.iterator();
	            while(it.hasNext() && !encontre) {
	                Edge<String> v = it.next();
	                int j = v.getTarget().getPosition();
	                if(!marcas[j] && tanqueAuto - v.getWeight() > 0) {
	                    encontre = caminoSinCargarCombustible(v.getTarget(), destino, camino, marcas, tanqueAuto - v.getWeight());
	                }
	            }
	        }
	        if(!encontre) {
	            camino.remove(camino.size()-1); 
	        }
	        marcas[origen.getPosition()] = false;
	        return encontre;
	    }
	    
	    /*-------------------------------------5-------------------------------------*/
	    public List<String> caminoConMenorCargaCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
	        List<String> camino = new LinkedList<String>();
	        if(!this.mapaCiudades.isEmpty()) {
	            Vertex origen = this.mapaCiudades.search(ciudad1);
	            Vertex destino = this.mapaCiudades.search(ciudad2);
	            if(origen != null && destino != null) {
	            	boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
	                caminoConMenorCargaCombustible(origen, destino, camino, new LinkedList<String>(), marcas, tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE);
	            }
	        }
	        return camino;
	    }
	    
	    //PREGUNTAR
	    
	    private int caminoConMenorCargaCombustible(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo, List<String> caminoAct, boolean[] marcas, int tanqueActual, int tanque, int recargas, int recargasMin) {
	        marcas[origen.getPosition()] = true;
	        caminoAct.add(origen.getData());
	        if(origen == destino && recargas < recargasMin) {
	            caminoMinimo.clear();
	            caminoMinimo.addAll(caminoAct);
	            recargasMin = recargas;
	        } else {
	            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
	            Iterator<Edge<String>> it = ady.iterator();
	            while(it.hasNext() && recargas < recargasMin) {
	                Edge<String> v = it.next();
	                int j = v.getTarget().getPosition();
	                int distancia = v.getWeight();
	                if(!marcas[j]) {
	                    if(tanqueActual >= distancia) {
	                        recargasMin = caminoConMenorCargaCombustible(v.getTarget(), destino, caminoMinimo, caminoAct, marcas, tanqueActual - distancia, tanque, recargas, recargasMin);
	                    } else if (tanque >= distancia) {
	                        recargasMin = caminoConMenorCargaCombustible(v.getTarget(), destino, caminoMinimo, caminoAct, marcas, tanque - distancia, tanque, recargas+1, recargasMin);
	                    }
	                }
	            }
	        }
	        marcas[origen.getPosition()] = false;
	        caminoAct.remove(caminoAct.size()-1);
	        return recargasMin;
	    }
	
}
