package ArbolGeneral;
import AuxP3.Queue;
import java.util.*;
import AuxP3.Queue;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	
	
	
	
	
	public int altura () {
		int nivel = 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux;
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				List<GeneralTree<T>> children =  aux.getChildren();
				for(GeneralTree<T> child: children) {
					cola.enqueue(child);
				}
			}
			else {
				if(!cola.isEmpty()) {
					nivel++;
					cola.enqueue(null);
				}
			}
		}
		return nivel ;
	}
	
	
	public int nivel(T dato) {
		
		int nivel = 0;
		int nivelReal = 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux;
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				if(aux.getData().equals(dato)) {
					nivelReal = nivel;
				}
				List<GeneralTree<T>> children =  aux.getChildren();
				for(GeneralTree<T> child: children) {
					cola.enqueue(child);
				}
			}
			else {
				if(!cola.isEmpty()) {
					nivel++;
					cola.enqueue(null);
				}
			}
		}
		return nivelReal ;
		
	}
	
	public int ancho() {
		int anchoMax = 0;
		int anchoAux = 0;
		int nivel = 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux;
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				List<GeneralTree<T>> children =  aux.getChildren();
				anchoAux += children.size();
				for(GeneralTree<T> child: children) {
					cola.enqueue(child);
				}
			}
			else {
				if(!cola.isEmpty()) {
					nivel++;
					if(anchoAux > anchoMax) {
						anchoMax = anchoAux;
					}
					anchoAux = 0;
					cola.enqueue(null);
				}
			}
		}
	
		return anchoMax ;
	}
	
	public boolean esAncestro(T a, T b) {											//ES ANCESTRO
		boolean ok = false;
		if(this != null) {
			GeneralTree<T> arbolAncestro = buscarAncestro(a , b);
			if(arbolAncestro != null) {
				System.out.println("Encontre el ancestro");
				ok = chequear(arbolAncestro , b);
			}
		}
		return ok;
		
	}
	
	private GeneralTree<T> buscarAncestro(T a , T b){
		GeneralTree<T> arbolAncestro = new GeneralTree<T>();
		GeneralTree<T> aux;
		boolean encontre = false;
		boolean encontre2 = false;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		while((!cola.isEmpty())&&(encontre == false) && (encontre2 == false)) {
			aux = cola.dequeue();
			if(aux.getData().equals(a)) {
				arbolAncestro = aux;
				encontre = true;
			}
			if(aux.getData().equals(b)) {
				encontre2= true;
			}
			List<GeneralTree<T>> children = aux.getChildren();
			Iterator<GeneralTree<T>> it = children.iterator();
			while((it.hasNext()) && (encontre == false) && (encontre2 == false)) {
				cola.enqueue(it.next());
			}
		}
		if((encontre == true) && (encontre2 == false) ){
			return arbolAncestro;
		}
		else {
			return null;
		}
	}
	
	private boolean chequear(GeneralTree<T> arbol , T a) {
		boolean ok = false;
		if(arbol.getData().equals(a)) {
			ok = true;
		}	
		List<GeneralTree<T>>children = arbol.getChildren();
		Iterator<GeneralTree<T>> it = children.iterator();
		while((it.hasNext()) && (ok == false)) {
			ok = chequear(it.next() , a);
		}
		return ok;
	}
	
	
}