package main.java;

public class Tarea implements Executable {
	String nombre;
	boolean isRunning;

	public Tarea(String nombreTarea) {
		this.nombre = nombreTarea;
		isRunning = false;
	}

	public boolean IsRunning() {
		return isRunning;
	}

	public String toString() {
		return nombre;

	}

	@Override
	public void Execute(Object obj) {
		System.out.println("Ejecutando la tarea " + nombre);
		isRunning = true;

	}

	@Override
	public void Stop() {
		isRunning = false;
	}

}
