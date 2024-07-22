package ejercicio4;

import java.util.*;
import ejercicio3.BinaryTree;

public class RedBinariaLlena {
	 private BinaryTree<Integer> red;
	    
	    public RedBinariaLlena(BinaryTree<Integer> unArbolLleno) {
	        this.red = unArbolLleno;
	    }
	    
	    public int retardoReenvio() {
	        return (!red.isEmpty()) ? retardoReenvio(red) : 0;  //if (!red.isEmpty())then retardoReenvio(red) , else 0
	    }
	    
	    private int retardoReenvio(BinaryTree<Integer> red) {
	        int retHI = 0;
	        int retHD = 0;
	        if(red.hasLeftChild())
	            retHI = retardoReenvio(red.getLeftChild());
	        if(red.hasRightChild())
	            retHD = retardoReenvio(red.getRightChild());
	        System.out.println("Valor retHI: " + retHI + " - Valor retHD:  " + retHD);
	        System.out.println("vALOR RED.GETDATA: " + red.getData());
	        return (Math.max(retHI, retHD)+ red.getData());
	    }
	    
	    public static void main (String[] args) {
	        System.out.println("Test mayor retardo");
	        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
	        ab.addLeftChild(new BinaryTree<Integer>(2));
	        ab.addRightChild(new BinaryTree<Integer>(6));
	        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
	        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
	        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
	        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
	        
	        RedBinariaLlena red = new RedBinariaLlena(ab);
	        System.out.println("El mayor retardo posible es de: " + red.retardoReenvio() + " segundos");
	    }
	}

