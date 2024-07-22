package ejercicio2;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import java.util.*;

public class Testeo {

	public static void main(String[] args) {
		 
			System.out.println("Lista ciudades ");
		 
		    Graph<String> ciudades = new AdjListGraph<String>();
	        Recorridos rec = new Recorridos();
	        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
	        Vertex<String> v2 = ciudades.createVertex("Santiago");
	        Vertex<String> v3 = ciudades.createVertex("Asunción");
	        Vertex<String> v4 = ciudades.createVertex("Tokio");
	        Vertex<String> v5 = ciudades.createVertex("Roma");
	        Vertex<String> v6 = ciudades.createVertex("Paris");
	        Vertex<String> v7 = ciudades.createVertex("Madrid");
	        Vertex<String> v8 = ciudades.createVertex("Caracas");
	        ciudades.connect(v1, v2);
	        ciudades.connect(v1, v3);
	        ciudades.connect(v2, v5);
	        ciudades.connect(v3, v7);
	        ciudades.connect(v3, v8);
	        ciudades.connect(v8, v7);
	        ciudades.connect(v8, v4);
	        ciudades.connect(v5, v4);
	        ciudades.connect(v7, v4);
	        ciudades.connect(v6, v5);
	        ciudades.connect(v6, v7);
	        ciudades.connect(v6, v4);
	        ciudades.connect(v4, v1);
	        
	        System.out.println("lista ciudades dfs");
	        
	        List<String> lisDFS = rec.dfs(ciudades);
	        for(String cosa : lisDFS) {
	        	System.out.print(" - " +cosa);
	        }
	        
	        System.out.println("");
	        System.out.println("lista ciudades bfs");
	        
	        List<String> lisBFS = rec.bfs(ciudades);
		 
	        for(String cosa : lisBFS) {
	        	System.out.print(" - " + cosa);
	        }
	}
	
}
