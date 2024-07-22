package ejercicio6;
import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import AuxP5.Queue;


public class BuscadoDeCaminos {

	private  Graph<String> bosque;

	public BuscadoDeCaminos(Graph<String> bsoque) {
		super();
		this.bosque = bsoque;
	}
	
	 public List<List<String>> recorridosMasSeguro() {
	        List<List<String>> recorridos = new LinkedList<List<String>>();
	        if(!this.bosque.isEmpty()) {
	            Vertex<String> origen = bosque.search("Casa Caperucita");
	            Vertex<String> destino = bosque.search("Casa Abuelita");
	            if((origen != null) && (destino != null)) {
	                this.dfs(origen , recorridos, new LinkedList<String>(), new boolean[this.bosque.getSize()]);
	            }
	        }
	     return recorridos;
	 }
	    
	    
	    private void dfs(Vertex<String> origen , List<List<String>> recorridos, List<String> camAct, boolean[] marcas) {
	        marcas[origen.getPosition()] = true;
	        camAct.add(origen.getData());
	        if(origen.getData().equals("Casa Abuelita")) 
	            recorridos.add(new LinkedList(camAct));
	        else {
	            List<Edge<String>> adys = this.bosque.getEdges(origen);
	            for(Edge<String> a: adys) {
	                Vertex<String> destino = a.getTarget();
	                if(!marcas[destino.getPosition()] && a.getWeight() < 5) 
	                    dfs(destino, recorridos, camAct, marcas);
	            }
	        }
	        marcas[origen.getPosition()] = false;
	        camAct.remove(camAct.size()-1);
	    }
	
}
