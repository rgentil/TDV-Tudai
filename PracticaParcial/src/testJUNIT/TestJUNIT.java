package testJUNIT;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import clases.Arco;
import clases.Caminos;
import clases.IdMayorException;
import clases.Nodo;

public class TestJUNIT {

	private Nodo i;
	private Nodo j; 
	private Arco a; 
	private ArrayList<Caminos> caminos; 

	@Test
	@DisplayName("Nodo i menor que nodo j")
	public void chequeoOrdenNodos() {
		i = new Nodo(5, 100);
		j = new Nodo(7, 25);
		a = new Arco();
		assertThrows(IdMayorException.class, () -> {
			a.setExtremos(i, j, 10);
		});
	}
	
	@Test
	public void chequearEcoPath() {
		Caminos caminoEco = caminos.getEcoPath();
		float energia = caminoEco.getEnergy();
		for(Caminos c: caminos) {
			assertFalse(c.getEnergy()>energia));
		}
	}
	
	@Test
	
	
}
