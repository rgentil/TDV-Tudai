package main.java;

public class Usuario {

	public Usuario(String nombre, String fechaNacimiento, int edad, boolean habilitadoParaVotar) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.habilitadoParaVotar = habilitadoParaVotar;
	}

	String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isHabilitadoParaVotar() {
		return habilitadoParaVotar;
	}

	public void setHabilitadoParaVotar(boolean habilitadoParaVotar) {
		this.habilitadoParaVotar = habilitadoParaVotar;
	}

	String fechaNacimiento;
	int edad;
	boolean habilitadoParaVotar;

}
