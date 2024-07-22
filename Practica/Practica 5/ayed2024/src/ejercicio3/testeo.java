package ejercicio3;
import java.util.*;

import ejercicio2.Recorridos;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;


public class testeo {

	public static void main(String[] args) {
		
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
        
        mapa ejercicio = new mapa(ciudades);											//A
        System.out.println("Para devolver camino");
        List<String> lista1 = ejercicio.devolverCamino("Buenos Aires", "Tokio");
        for(String ciudad: lista1) {
        	System.out.println(ciudad);
        }
        System.out.println("");
        
        System.out.println("Para devolver camino con limitantes");
        List<String> listaAux1 = new LinkedList<String>();
        listaAux1.add("Santiago");
        
        List<String> lista2 = ejercicio.devolverCaminoExceptuando("Buenos Aires", "Tokio", listaAux1);
        for(String ciudad: lista2) {
        	System.out.println(ciudad);
        }
        System.out.println("");
        
        
	}
}
