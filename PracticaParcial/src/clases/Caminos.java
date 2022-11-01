package clases;

import java.util.ArrayList;

public class Caminos {

	private ArrayList<Nodo> nodos;
	private ArrayList<Arco> arcos;

	public Caminos() {
		this.nodos = new ArrayList<Nodo>();
		this.arcos = new ArrayList<Arco>();
	}

	//El camino con mayor energía resultante (Nodo [] getEcoPath(int nodo_i, int nodo j)
	public ArrayList<Nodo> getEcoPath(int nodo_i, int nodo_j){
		nodos.add(new Nodo(1, 100));
		nodos.add(new Nodo(5, 25));
		return nodos;		
	}


	//El camino con mayor energía consumida (Nodo [] getWorstPath(int nodo_i, int nodo j)
	public ArrayList<Nodo> getWorstPath(int nodo_i, int nodo_j){
		return nodos;
		
	}


	//Energía remanente al final de un camino (float getEnergy(Nodo [])
	public float getEnergy(ArrayList<Nodo> nodos) {
		return 0;
		
	}


}

