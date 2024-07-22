package ejercicio5;

public class Jubilado extends Persona{
 
	private boolean jubilacion;

	public Jubilado(String nombre, boolean jubilacion) {
		super(nombre);
		this.jubilacion = jubilacion;
	}

	public boolean cumple() {
		return jubilacion;
	}

	
	
}
