package Ejercicio2;
import java.util.*;


public class BinaryTree <T>{
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();			// HASTA ACA ESTABA ASI
	}

	public  int contarHojas() {
		int cantidad = 0;
		if(this.isLeaf()) {
			cantidad += 1;
		}
		else
		{
			if(this.hasLeftChild()) {
				cantidad += this.getLeftChild().contarHojas();
			}
			
			if(this.hasRightChild()) {
				cantidad+= this.getRightChild().contarHojas();
			}
		}
		return cantidad;
	}
		
    	 
    public BinaryTree<T> espejo(){
    	BinaryTree<T> arbolNuevo = new BinaryTree<T>(this.getData());
    	if(this.hasLeftChild()) {
    		arbolNuevo.addRightChild(this.getLeftChild().espejo());
    	}
    	if(this.hasRightChild()) {
    		arbolNuevo.addLeftChild(this.getRightChild().espejo());
    	}
 	   return arbolNuevo;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int nivelActual = 0;
		while (!cola.isEmpty()) {
			ab = cola.dequeue();
			if (ab != null) {
				 if((nivelActual >= n) && (nivelActual <= m)){
					 System.out.println(ab.getData());
				 }
				if (ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				if (ab.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
				}
			} 
			else if (!cola.isEmpty()) {
					 cola.enqueue(null);
					 nivelActual++;										//aca es cuando aumenta el nivel
			 }
		}
   }
}
