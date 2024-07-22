package ejercicio6;

import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import AuxP5.Queue;


public class Testeo {
	
	public static void main(String[] args){
		
		Graph<String> grafeno = new AdjListGraph<>();
	    Vertex<String> casaCaperusita = grafeno.createVertex("Casa Caperucita");
	    Vertex<String> casaAbuelita = grafeno.createVertex("Casa Abuelita");
	    Vertex<String> claro1 = grafeno.createVertex("Claro 1");
	    Vertex<String> claro2 = grafeno.createVertex("Claro 2");
	    Vertex<String> claro3 = grafeno.createVertex("Claro 3");
	    Vertex<String> claro4 = grafeno.createVertex("Claro 4");
	    Vertex<String> claro5 = grafeno.createVertex("Claro 5");

	    grafeno.connect(casaCaperusita, claro3, 4);
	    grafeno.connect(claro3, casaCaperusita, 4);

	    grafeno.connect(claro3, claro5, 15);
	    grafeno.connect(claro5, claro3, 15);

	    grafeno.connect(casaCaperusita, claro1, 3);
	    grafeno.connect(claro1, casaCaperusita, 3);

	    grafeno.connect(claro1, claro5, 3);
	    grafeno.connect(claro5, claro1, 3);

	    grafeno.connect(claro5, casaAbuelita, 4);
	    grafeno.connect(casaAbuelita, claro5, 4);

	    grafeno.connect(casaCaperusita, claro2, 4);
	    grafeno.connect(claro2, casaCaperusita, 4);

	    grafeno.connect(claro1, claro2, 4);
	    grafeno.connect(claro2, claro1, 4);

	    grafeno.connect(claro2, claro5, 11);
	    grafeno.connect(claro5, claro2, 11);

	    grafeno.connect(claro2, claro4, 10);
	    grafeno.connect(claro4, claro2, 10);

	    grafeno.connect(claro4, casaAbuelita, 9);
	    grafeno.connect(casaAbuelita, claro4, 9);
	    
	    BuscadoDeCaminos buscadorDeCaminos = new BuscadoDeCaminos(grafeno);

	    List<List<String>> listas = buscadorDeCaminos.recorridosMasSeguro();
        for (List<String> lista : listas) {
            System.out.println(lista);
        }
		
	}
	
}
