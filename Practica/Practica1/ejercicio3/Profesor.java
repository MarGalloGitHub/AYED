/*
 * . Cree una clase llamada Profesor con los atributos especificados abajo y sus
correspondientes métodos getters y setters (haga uso de las facilidades que brinda
eclipse)
● nombre
● apellido
● email
● catedra
● facultad
 */

package ejercicio3;

public class Profesor {
	private String nombre;
	private String apellido;
	private String email;
	private int catedra;
	private String facultad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCatedra() {
		return catedra;
	}
	public void setCatedra(int catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String tusDatos() {
		String aux = "Datos del profesor: "  + "\n " + "Nombre: " + this.getNombre() + "\n" + "Apellido: " + this.getApellido() + "\n" + "Email: " + this.getEmail() + "\n" + "Catedra: " + this.getCatedra() + "\n" + "Facultad: " + this.getFacultad();
		return aux;
	}
}
