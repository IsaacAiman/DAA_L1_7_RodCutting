/**
 * Reloj para encontrar el tiempo de ejecución de un algoritmo que lo use
 * Diseño y análisis de algoritmos
 * Pablo Pastor Martín, Isaac Aimán Salas, Javier RAmos Fernández
 * Marzo de 2017
 */
package ull.daa.rodcutting;

/**
 * Reloj para encontrar el tiempo de ejecución de un algoritmo que lo use
 * @author Pablo Pastor Martín
 */
public class Clock {
	
	private long startTime;				// Instante inicial
	
	/**
	 * Constructor, pone a -1 el instante inicial
	 */
	public Clock() {
		startTime = -1;
	}
	
	/**
	 * Pone en marcha el reloj
	 */
	public void start() {
		setStartTime(System.currentTimeMillis());
	}
	
	/**
	 * Para el reloj y devuelve el tiempo transcurrido desde el inicio
	 * @return Tiempo transcurrido, -1 si no se inició
	 */
	public long stop() {
		long aux = System.currentTimeMillis() - getStartTime();
		setStartTime(-1);
		return aux;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
}
