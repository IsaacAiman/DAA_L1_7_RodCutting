/**
 * Versión ineficiente para la solución del problema (Basado en divide y vencerás)
 * Diseño y análisis de algoritmos
 * Pablo Pastor Martín, Isaac Aimán Salas, Javier RAmos Fernández
 * Marzo de 2017
 */
package ull.daa.rodcutting;

/**
 * Versión ineficiente para la solución del problema (Basado en divide y vencerás)
 * @author Grupo L1_7
 * @version 1.0.0
 */
public class BruteForce {
	
	private Rod rod;		// Barra
	
	/**
	 * Método recursivo que resuelve el problema
	 * @param size Tamaño 
	 */
	public int cutRod(int size) {
		if(size == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= size; i++) {
			int aux = getRod().getCoste(i) + cutRod(size - i);
			if(max < aux) {
				max = aux;
			}
		}
		return max;
	}
	
	public BruteForce(int size, int coste) {
		rod = new Rod(size, coste);
		//System.out.println(rod);
	}
	
	public static void main(String args[]) {
		Clock c = new Clock();
		for(int i = 20; i < 35; i++) {
			c.start();
			BruteForce b = new BruteForce(i, i * 3);
			b.cutRod(i);
			System.out.println("Tiempo transcurrido para n=" + i + ": " + c.stop() + "ms\n");
		}
	}

	/**
	 * @return the rod
	 */
	public Rod getRod() {
		return rod;
	}

	/**
	 * @param rod the rod to set
	 */
	public void setRod(Rod rod) {
		this.rod = rod;
	}
}
