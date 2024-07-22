package ejercicio2;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;

import java.util.*;
import AuxP5.Queue;

public class Recorridos {
	
	
	public <T> List<T> dfs(Graph<T> grafo) {												//RECORRIDOS PARA DEVOLVER LISTA DE VERTICES
		 boolean[] marca = new boolean[grafo.getSize()];
		 List<T> lista = new LinkedList<T>();
		 for (int i = 0; i < grafo.getSize(); i++) {
			 if (!marca[i]) {
				 	dfsAux(i, grafo, marca , lista);
			 }
		 }
		 return lista;
	}	
	
	private <T> void dfsAux(int i, Graph<T> grafo, boolean[] marca , List<T> lista) {
		marca[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		lista.add(v.getData());
		List<Edge<T>> adyacentes = grafo.getEdges(v); //adyacentes
		for (Edge<T> e: adyacentes){
		  int j = e.getTarget().getPosition();
		  if (!marca[j]) {
			  dfsAux(j, grafo, marca , lista);
		  }
		}
	} 
	
	 public <T> List<T> bfs(Graph<T> grafo) {
		 	boolean[] marca = new boolean[grafo.getSize()];
		 	List<T> lista = new LinkedList<T>();
		 	for (int i = 1; i < marca.length; i++) {  //PREGUNTAR
		 			if (!marca[i]){
		 					 bfs(i, grafo, marca , lista); //las listas empiezan en la pos 1
		 			}
		 	}
		 	
		 	return lista;
		}

	private <T> void bfs(int i, Graph<T> grafo, boolean[] marca , List<T> lista) {
		 Queue<Vertex<T>> q = new Queue<Vertex<T>>();
		 q.enqueue(grafo.getVertex(i));
		 marca[i] = true;
		 while (!q.isEmpty()) {
			 Vertex<T> w = q.dequeue();
			 lista.add(w.getData());
			 List<Edge<T>> adyacentes = grafo.getEdges(w); // para todos los vecinos de w:
			 for (Edge<T> e: adyacentes) {
				 int j = e.getTarget().getPosition();
				 if (!marca[j]) {
					 marca[j] = true;						
					 q.enqueue(e.getTarget());   //Vertex<T> v = e.getTarget();
				 }
			 }
		 }
	}
	
	
	
	
	public <T> void dfsPrint(Graph<T> grafo) {												//RECORRIDO SOLO PARA IMPRIMIR
		 boolean[] marca = new boolean[grafo.getSize()];
		 for (int i = 0; i < grafo.getSize(); i++) {
			 if (!marca[i]) {
				 	System.out.println("largo con: "+grafo.getVertex(i).getData());
				 	dfsPrint(i, grafo, marca);
			 }
		 }
	}
	
	private <T> void dfsPrint(int i, Graph<T> grafo, boolean[] marca) {
		marca[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		System.out.println(v.getData());
		List<Edge<T>> adyacentes = grafo.getEdges(v); //adyacentes
		for (Edge<T> e: adyacentes){
		  int j = e.getTarget().getPosition();
		  if (!marca[j]) {
			  dfsPrint(j, grafo, marca);
		  }
		}
	} 
	
	
	public <T> void bfsPrint(Graph<T> grafo) {
	 	boolean[] marca = new boolean[grafo.getSize()];
	 	for (int i = 0; i < marca.length; i++) {
	 			if (!marca[i]){
	 					 bfsPrint(i, grafo, marca); //las listas empiezan en la pos 1
	 			}
	 	}
	 	
	}
	
	public <T> void bfsPrint(int i, Graph<T> grafo, boolean[] marca) {
		 Queue<Vertex<T>> q = new Queue<Vertex<T>>();
		 q.enqueue(grafo.getVertex(i));
		 marca[i] = true;
		 while (!q.isEmpty()) {
			 Vertex<T> w = q.dequeue();
			 System.out.println(w.getData());				
			 List<Edge<T>> adyacentes = grafo.getEdges(w); // para todos los vecinos de w:
			 for (Edge<T> e: adyacentes) {
				 int j = e.getTarget().getPosition();
				 if (!marca[j]) {
					 marca[j] = true;						
					 q.enqueue(e.getTarget());   //Vertex<T> v = e.getTarget();
				 }
			 }
		 }
	}


}
