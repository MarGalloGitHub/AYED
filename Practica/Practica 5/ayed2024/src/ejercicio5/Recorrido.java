package ejercicio5;
import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import AuxP5.Queue;

public class Recorrido {
	
	
	public List<Jubilado> bfs (Graph<Persona> grafo , Empleado emple , int distancia){
		List<Jubilado> lista = new LinkedList<Jubilado>();
		int cantMaxima = 40;
		Vertex<Persona> empleOrigen = grafo.search(emple);
		if(!grafo.isEmpty() && (empleOrigen != null)) {
			boolean[]marcas = new boolean[grafo.getSize()];
			int pos = empleOrigen.getPosition();
			bfsAux(grafo , pos , marcas , distancia  ,  lista , cantMaxima);	// SI ES UNO PARTICULAR MANDAR SU POS
		}
		
		return lista;
	}
	
	private void bfsAux(Graph<Persona> grafo , int i , boolean[] marcas , int distancia , List<Jubilado> lista , int cantMaxima){
			Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
			marcas[i] = true;
			cola.enqueue(grafo.getVertex(i));
			cola.enqueue(null);
			while((!cola.isEmpty()) && (distancia >= 0) && (lista.size() < cantMaxima)) {
				Vertex<Persona> aux = cola.dequeue();
				if(aux != null) {
					List<Edge<Persona>> adyacentes = grafo.getEdges(aux);
					Iterator<Edge<Persona>> it = adyacentes.iterator();
					while((it.hasNext()) && (lista.size() < cantMaxima)) {
						Vertex<Persona> destino = it.next().getTarget();
						int pos = destino.getPosition();
						if(!marcas[pos]) {
							marcas[pos] = true;
							cola.enqueue(destino);
							if(destino.getData() instanceof Jubilado) {
								Jubilado jubilado = (Jubilado)destino.getData();
								if((!jubilado.cumple())) {
									lista.add(jubilado);
								}
							}
						}
					}
				
				}
				else
				{
					if(!cola.isEmpty()){
						distancia--;
						cola.enqueue(null);
					}
				}
			}
	}
}