package main.java;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/**
 * Programación de tareas. Se trata de una serie de tareas ejecutadas en
 * determinados horarios.
 *
 * @author <a href="mailto:oegoni@gmail.com"> Oscar E. Goñi</a>
 */

public class Programa {

	private ArrayList<Programacion> _items;

	/**
	 * Construye una instancia de un programa
	 */
	public Programa() {
		_items = new ArrayList<Programacion>();
	}

	/**
	 * Retorna cantidad de veces q se repetirá una tarea.
	 * 
	 * @param Tarea tarea que se tomará en cuenta para contar
	 * @return Ocurrencias de la tarea en la programación actual.
	 */
	public int getCantOcurrencias(Tarea tSearch) {
		Iterator<Programacion> i = _items.iterator();
		int cont = 0;
		while (i.hasNext()) {
			Programacion p = (Programacion) i.next();
			Tarea t = p.getTask();
			if (t == tSearch)
				cont++;

		}
		return cont;
	}

	/**
	 * Retorna cantidad de tareas que se ejecutan entre dos horarios
	 * 
	 * @param t1 tiempo de inicio
	 * @param t2 tiempo de fin
	 * @return Ocurrencias de la tarea en la programación actual.
	 */
	public int getCantTareasEntre(LocalDateTime t1, LocalDateTime t2) {
		Iterator<Programacion> i = _items.iterator();
		int cont = 0;
		while (i.hasNext()) {
			Programacion p = (Programacion) i.next();
			if ((p.getInicio().isAfter(t1)) && (p.getFin().isBefore(t2)))
				cont++;
		}
		return cont;
	}	

	/**
	 * Agrega una programacion al programa actual
	 * 
	 * @param p Programacion.
	 */
	public void addProgramacion(Programacion p) {
		_items.add(p);
	}

	/**
	 * Elimina una programaci'on.
	 * 
	 * @param p Programacion a eliminar del programa.
	 * @throws ProgramacionNoEncontradaFoundException Si no existe esa programaci'on
	 *                                                dentro del programa.
	 */
	public void removeProgramacion(Programacion p) throws ProgrmacionNoEncontradaException {
		if (!_items.remove(p)) {
			throw new ProgrmacionNoEncontradaException();
		}
	}

	/**
	 * Retorna la cantidad de programaciones ue posee un programa
	 * 
	 * @return Cantidad de programaciones.
	 */
	public int getCantProgramaciones() {
		return _items.size();
	}

	/**
	 * Elimina todas las programaciones.
	 */
	public void eliminarProgramaciones() {
		_items = new ArrayList<Programacion>();
	}

	/**
	 * Indica si no hay programaciones por realizar.
	 * 
	 * @return true si no hay programaciones y falso en caso contrario.
	 */
	public boolean programaVacio() {
		return (_items.size() == 0);
	}

	@SuppressWarnings("unused")
	public void iniciar() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);

		// latch.await();

		/*
		 * for(int i =0;i<100; i++) try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}
}