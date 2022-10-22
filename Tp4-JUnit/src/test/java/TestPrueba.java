package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.java.Programa;
import main.java.Programacion;
import main.java.ProgrmacionNoEncontradaException;
import main.java.Tarea;

public class TestPrueba {

	Tarea _defaultTarea;
	Programacion _defaultProgramacion;
	Programa _defaultPrograma;

	@BeforeEach
	public void setUp() throws Exception {

		System.out.println("La fecha actual es: " + LocalDate.now());
		System.out.println("La hora actual es: " + LocalTime.now());
		System.out.println("La fecha y hora actuales son: " + LocalDateTime.now());
		System.out.println("El instante actual es: " + Instant.now());
		System.out.println("La fecha y hora actuales con zona horaria son: " + ZonedDateTime.now());

		LocalDateTime d1 = LocalDateTime.of(LocalDate.of(2015, 12, 24), LocalTime.of(22, 00));
		LocalDateTime d2 = LocalDateTime.of(LocalDate.of(2015, 12, 25), LocalTime.of(06, 00));
		System.out.println("Setup");

		_defaultTarea = new Tarea("Festejar Navidad");
		_defaultProgramacion = new Programacion(d1, d2, _defaultTarea);
		_defaultPrograma = new Programa();
	}

	@DisplayName("Test de contar la cantidad de ocurrencias")
	@RepeatedTest(5)
	@Test
	public void testGetCantOcurrencias() {
		System.out.println("test GetCantOcurrencias");
		_defaultPrograma.eliminarProgramaciones();
		Assertions.assertEquals(0, _defaultPrograma.getCantProgramaciones());
		_defaultPrograma.addProgramacion(_defaultProgramacion);

		LocalDateTime d1 = LocalDateTime.of(LocalDate.of(2016, 01, 23), LocalTime.of(00, 00));
		LocalDateTime d2 = LocalDateTime.of(LocalDate.of(2015, 01, 23), LocalTime.of(23, 59));
		LocalDateTime d3 = LocalDateTime.of(LocalDate.of(2016, 01, 06), LocalTime.of(00, 00));
		LocalDateTime d4 = LocalDateTime.of(LocalDate.of(2016, 01, 06), LocalTime.of(06, 00));

		Tarea t1 = new Tarea("Festejar Cumpleanios");
		Tarea t2 = new Tarea("Cortar pasto para camellos");

		Programacion cumpleanios = new Programacion(d1, d2, t1);
		Programacion reyes = new Programacion(d3, d4, t2);

		_defaultPrograma.addProgramacion(cumpleanios);
		_defaultPrograma.addProgramacion(reyes);

		Assertions.assertEquals(3, _defaultPrograma.getCantProgramaciones(), "la cantidad debe ser 3");
	}

	@DisplayName("Agregar programacion nueva")
	@Test
	public void testAddProgramacion() {
		System.out.println("testAddProgramacion");
		int programacionesHastaElMomento = _defaultPrograma.getCantProgramaciones();
		_defaultPrograma.addProgramacion(_defaultProgramacion);
		Assertions.assertEquals(programacionesHastaElMomento + 1, _defaultPrograma.getCantProgramaciones());
	}

	@DisplayName("Remover una programacion")
	@Test
	public void testRemoveProgramacion() throws ProgrmacionNoEncontradaException {
		System.out.println("testRemoveProgramacion");
		LocalDateTime d1 = LocalDateTime.of(LocalDate.of(2015, 12, 31), LocalTime.of(22, 00));
		LocalDateTime d2 = LocalDateTime.of(LocalDate.of(2016, 01, 01), LocalTime.of(06, 59));

		Tarea t = new Tarea("Recibir año uevo");

		Programacion otraProgramacion = new Programacion(d1, d2, t);
		_defaultPrograma.addProgramacion(otraProgramacion);
		int programacionesHastaElMomento = _defaultPrograma.getCantProgramaciones();

		_defaultPrograma.removeProgramacion(otraProgramacion);
		assertEquals(programacionesHastaElMomento - 1, _defaultPrograma.getCantProgramaciones());

	}

	// ----------------------------------------------
	// Reemplazar
	/*
	@Test
	public void testExpectedProgramacionNoEnconreadaException() {

		Assertions.assertThrows(ProgrmacionNoEncontradaException.class, () -> {
			_defaultPrograma.eliminarProgramaciones();
			_defaultPrograma.removeProgramacion(_defaultProgramacion);
		});

	}

	// --------------------------------------------
	@Test
	public void testEliminarProgramaciones() {
		System.out.println("testEliminarProgramaciones");
		_defaultPrograma.eliminarProgramaciones();
		assertEquals(0, _defaultPrograma.getCantProgramaciones());

	}

	// -------------------------------------------
	@Test
	public void testProgramaVacio() {
		System.out.println("testProgramaVacio");
		_defaultPrograma.eliminarProgramaciones();
		assertEquals(true, _defaultPrograma.programaVacio());
	}
	// -----------------------------------------
	*/

}
