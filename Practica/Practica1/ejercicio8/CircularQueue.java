package ejercicio8;

import Ejercicio1.Queue;

public class CircularQueue<T> extends Queue<T> {

	public CircularQueue() {
		super();
		// TODO Auto-generated constructor stub
	}

	 public T shift() {
	        T data = dequeue();
	        enqueue(data);
	        return data;
	 }
}
