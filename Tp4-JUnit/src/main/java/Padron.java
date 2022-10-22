package main.java;

import java.util.HashMap;
import java.util.Map;

public class Padron {

	private Map<String, Usuario> participantes = new HashMap<>();

	public Padron() {
		Usuario u1 = new Usuario("Juan", "1979-01-01", 42, true);
		Usuario u2 = new Usuario("Pedro", "1980-02-01", 41, true);
		Usuario u3 = new Usuario("Maria", "1981-03-01", 47, true);
		Usuario u4 = new Usuario("Cecilia", "1983-04-01", 38, true);
		Usuario u5 = new Usuario("Carlos", "1985-04-01", 36, true);
		Usuario u6 = new Usuario("Jose", "1987-04-01", 34, true);

		participantes.put("Juan", u1);
		participantes.put("Pedro", u2);
		participantes.put("Maria", u3);
		participantes.put("Cecilia", u4);
		participantes.put("Carlos", u5);
		participantes.put("Jose", u6);

	}

	public Usuario getUsuario(String key) {
		return participantes.get(key);
	}

}
