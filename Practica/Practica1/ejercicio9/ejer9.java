package ejercicio9;

import java.util.*;
public class ejer9 {
	
	public static boolean validarExpresion(String exp) {
		int i = 0;
		boolean esValida = true;
		String poppedElem;
		Stack pilaChar = new Stack();
		while (i < exp.length() && esValida) {
			
			if (exp.charAt(i) == '(') {
					pilaChar.push("(");
			} 
			else 
				if (exp.charAt(i) == '[') {
					pilaChar.push("[");
				} 
				else 
					if (exp.charAt(i) == '{') {
						pilaChar.push("{");
					} 
					else 
						if (pilaChar.isEmpty()) {
							esValida = false;
						} 
						else 
							if (exp.charAt(i) != ' ') {
								poppedElem = (String)pilaChar.pop();
								
								if (exp.charAt(i) == ')') {
									if (!poppedElem.equals("(")) {
										esValida = false;
									}
								}
								if (exp.charAt(i) == ']') {
									if (!poppedElem.equals("["))
										esValida = false;
								}
								if (exp.charAt(i) == '}') {
									if (!poppedElem.equals("{"))
										esValida = false;
								}
							} i++;
		}
		
		if (!pilaChar.isEmpty()) {
			esValida = false;
		}
		return esValida;
		}
	
	public static void main (String [] args) {
		
		String exp = "[()]";
		if(validarExpresion(exp) == true) {
			System.out.println("funca");
		}
		else
		{
			System.out.println(" no funca");
		}
	}
		
}
