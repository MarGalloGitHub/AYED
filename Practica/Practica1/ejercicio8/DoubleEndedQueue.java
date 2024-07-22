package ejercicio8;

import Ejercicio1.Queue;

public class DoubleEndedQueue<T> extends Queue<T>{

	public DoubleEndedQueue() {
		super();
		// TODO Auto-generated constructor stub
	}

	 public void enqueueFirst(T data) {
	        super.data.add(0, data); //Accedo a la variable protegida data del padre por medio de super y agrego data en la pos 0, o sea primero
	    }
}
