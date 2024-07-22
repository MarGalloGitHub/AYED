/*
 * a. Cree una clase llamada Estudiante con los atributos especificados abajo y sus
correspondientes métodos getters y setters (haga uso de las facilidades que brinda
eclipse)
● nombre
● apellido
● comision
● email
● direccion
 */

package ejercicio3;

public class Estudiante {
	private String nombre;
	private String apellido;
	private int comision;
	private String email;
	private String direccion;
	
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
	public int getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String aux = "Datos del estudiante: "  + "\n " + "Nombre: " + this.getNombre() + "\n" + "Apellido: " + this.getApellido() + "\n" + "Email: " + this.getEmail() + "\n" + "Comision: " + this.getComision() + "\n" + "Direccion: " + this.getDireccion();
		return aux;
	}
}
