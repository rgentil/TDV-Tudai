package main.java;

import java.time.LocalDateTime;

public class Programacion {

	private Tarea task;
	private LocalDateTime inicio;
	private LocalDateTime fin;

	public Programacion(LocalDateTime d1, LocalDateTime d2, Tarea t) {
		this.setInicio(d1);
		this.setFin(d2);
		this.task = t;
	}

	public Tarea getTask() {
		return task;	
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime d1) {
		this.inicio = d1;
	}
	
	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime d2) {
		this.fin = d2;
	}

}
