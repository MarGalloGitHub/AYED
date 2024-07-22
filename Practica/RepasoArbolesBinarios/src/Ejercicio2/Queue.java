package Ejercicio2;

import java.util.*;

public class Queue<T> extends Sequence {
	
	protected List<T> data;
	
	public Queue() {
		super();
		this.data = new ArrayList<T>();
	}

	public void enqueue(T dato) {
		data.add(dato);
	}
	
	public T dequeue() {
	
		return data.remove(0);
	}

	public T head() {
		 
		return data.get(0);
	} 
	
	 public int size() {
		 return data.size();
	 }
	 
	 public boolean isEmpty() {
		 return data.size()==0;
	}
	 
	public String toString() {
		String str = "[";
		for(T d: data)
		str = str + d +", ";
		str = str.substring(0, str.length()-2)+"]";
		return str;
	}

}
