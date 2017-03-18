/**
 * Fichero con la clase que representa a la barra que hay que cortar
 * Diseño y análisis de algoritmos
 * Pablo Pastor Martín, Isaac Aimán Salas, Javier Ramos Fernández
 * Marzo de 2017
 */
package ull.daa.rodcutting;

import java.util.*;

/**
 * Clase de la barra a cortar
 * @author Grupo L1_7
 * @version 1.0.0
 */
public class Rod {
	
	private ArrayList<Integer> costes;		// Costes de los cortes de la barra
	private int size;						// Tamaño de la barra
	
	/**
	 * Constructor que dado un tamaño de la barra y el costo de la barra total, construye unos costes aleatorios
	 * @param n Tamaño de la barra
	 * @param costeTotal Coste total de la barra
	 */
	public Rod(int n, int cTotal) {
		costes = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++) {
			costes.add(null);
		}
		costes.set(n - 1, cTotal);
		size = n;
		Random generador = new Random();
		for(int i = 1; i < n; i++) {
			int costeAux = ((i * (cTotal / n)) + (generador.nextInt(5) - 2));
			if(costeAux < 1) {
				costeAux = 1;
			}
			costes.set(i - 1, costeAux);
		}
	}

	/**
	 * @return the costes
	 */
	public ArrayList<Integer> getCostes() {
		return costes;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Selecciona el coste para un tamaño dado
	 * @param size Tamaño a seleccionar
	 * @return Coste correspondiente
	 */
	public int getCoste(int index) {
		return costes.get(index - 1);
	}
	
	/**
	 * Método para imprimir los costes de la barra
	 * @return Cadena que representa los costos de la barra
	 */
	public String toString() {
		String toReturn = "";
		toReturn = "Tamaño de sección  |  Coste de sección\n";
		for(int i = 1; i <= getSize(); i++) {
			toReturn += String.format("%18d", i) + " |" + String.format("%18d", getCoste(i)) + "\n";
		}
		return toReturn;
	}
	
	public static void main(String args[]) {
		Rod r = new Rod(20, 40);
		System.out.println(r);
	}
}
