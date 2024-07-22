package ejercicio3;
import java.util.*;
import Ejercicio2.BinaryTree;

public class ejercicio {

	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
		BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		System.out.println("lista preOrden");
		
		ContadorArbol contador = new ContadorArbol(ab);
		List<Integer> listaPre = contador.numerosParesPre();
		for(Integer e: listaPre){
			System.out.println(e);
		}
		
		System.out.println("lista postOrden");
		
		List<Integer>listaPost = contador.numerosParesPost();
		for(Integer e: listaPost){
			System.out.println(e);
		}
		
		System.out.println("lista inOrden");
		
		List<Integer>listaIn = contador.numerosParesIn();
		for(Integer e: listaIn){
			System.out.println(e);
		}
	}
}
