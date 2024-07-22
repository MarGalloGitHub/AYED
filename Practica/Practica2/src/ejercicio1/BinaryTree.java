package ejercicio1;


import java.util.*;

	public class BinaryTree <T> {
		
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
			return this.getData().toString();   // A PARTIR DE ACA ES CODIGO NUEVO
		}

		public  int contarHojas() {
			if (this.isEmpty()) { 
				return 0;
			}	
			else {
				if(this.isLeaf()) {
					return 1;
				}

			    else {
			    	int hijoIzq =0; 
					int hijoDer = 0;
			          if(this.hasLeftChild()) { 
			                hijoIzq = this.getLeftChild().contarHojas();
			          }
			           if(this.hasRightChild()) { 
			                hijoDer = this.getRightChild().contarHojas();
			           }
			            return hijoDer + hijoIzq;
			     }
			}
		}
			
			
	    	 
	    public BinaryTree<T> espejo(){
	    	BinaryTree<T> espejo = new BinaryTree<T>(this.getData());   // creo un arbol nuevo en base al primero pero en espejo
	    	if(this.hasLeftChild()) {
	    		espejo.addRightChild(this.getLeftChild().espejo());
	    	}
	    	if(this.hasRightChild()) {
	    		espejo.addLeftChild(this.getRightChild().espejo());
	    	}
	 	   return espejo;
	    }

		// 0<=n<=m
	    public void imprimirArbolInOrden() {    //InOrden												Recorrido
	        if(this.hasLeftChild()) this.getLeftChild().imprimirArbolInOrden();
	        System.out.print(this.getData() + " ");
	        if(this.hasRightChild()) this.getRightChild().imprimirArbolInOrden();
	    }
	    
	    public void imprimirArbolPreOrden() {    //PreOrden
	    	System.out.print(this.getData() + " ");
	        if(this.hasLeftChild()) this.getLeftChild().imprimirArbolInOrden();
	        if(this.hasRightChild()) this.getRightChild().imprimirArbolInOrden();
	    }
	    
	    public void imprimirArbolPostOrden() {    //PostOrden
	        if(this.hasLeftChild()) this.getLeftChild().imprimirArbolPostOrden();
	        if(this.hasRightChild()) this.getRightChild().imprimirArbolPostOrden();
	        System.out.print(this.getData() + " ");
	    }
	    
	    
		public void entreNiveles(int n, int m) {
		    if (this.isEmpty() || n < 0 || m < n) return; 
		    Queue<BinaryTree<T>> cola = new LinkedList();
		    cola.add(this);
		    int nivelActual = 0;
		    while(!cola.isEmpty()) {
		    	int nodoNivel = cola.size();
		        if(nivelActual >=n && nivelActual <= m) {
		        	for(int i=0; i < nodoNivel; i++) {
		        		BinaryTree<T> nodo = cola.remove();
		                System.out.println(nodo.getData() + " ");
		                if(nodo.hasLeftChild()) {
		                	cola.add(nodo.getLeftChild());
		                }
		                if(nodo.hasRightChild()) {
		                	cola.add(nodo.getRightChild());
		                }
		             }
		        } 
		        else {
		        	for(int i=0; i < nodoNivel; i++) {
		        		cola.remove();
		            }
		        }
		        nivelActual++;
		    }
		}
	   
			
	}

