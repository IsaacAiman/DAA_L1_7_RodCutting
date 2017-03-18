package ull.daa.rodcutting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Implementación BottomUp para el corte de vástagos.
 * @author grupo L1_7
 *
 */
public class RodCuttingBottomUp {
	
	private static ArrayList<Integer> r = new ArrayList<Integer>();
	private static ArrayList<Integer> s = new ArrayList<Integer>();

	public static void main(String args[]){
		

		start(new Integer(args[0]), new Integer(args[1]));
		
		
	}
	
	/**
	 * Comienza la ejecución del algoritmo.
	 */
	public static void start(Integer rodSize, Integer price){
		
		setS(new ArrayList<Integer>());
		setR(new ArrayList<Integer>());
		
		Integer n = new Integer(rodSize);
		for (int i = 0; i < n + 1; i++){
			getS().add(0);
			getR().add(0);
		}
		
		Rod rod = new Rod(new Integer(rodSize), new Integer(price));
		System.out.print("Tamaño = ");
		Scanner scanner = new Scanner(System.in);
		Integer cortes = scanner.nextInt();
		scanner.close();
		extendedBottomUpCutRod(rod, cortes);
		printSolution(rod, cortes);

	}

	/**
	 * @param rod cuerda que se desea cortar.
	 * @param n Tamaño a cortar
	 */
	public static void extendedBottomUpCutRod(Rod rod, Integer n){
		
		for (int j = 1; j <= n; j++){
			Integer q = new Integer(Integer.MIN_VALUE);
			for (int i = 1; i <= j; i++){
				
				if (q < (rod.getCoste(i) + getR().get(j - i))){
					q = rod.getCoste(i) + getR().get(j - i);
					getS().set(j, i);
				}
			}

			getR().set(j, q);
		}		
	}
	
	/**
	 * Imprime los vástagos que hay que cortar para obtener el máximo beneficio.
	 * @param rod
	 * @param n
	 */
	public static void printSolution(Rod rod, Integer n){
		
		while (n > 0){
			System.out.println(getS().get(n));
			n = n - getS().get(n);
		}
		
	}

	public static ArrayList<Integer> getR() {
		return r;
	}

	public static void setR(ArrayList<Integer> rCopy) {
		r = rCopy;
	}

	public static ArrayList<Integer> getS() {
		return s;
	}

	public static void setS(ArrayList<Integer> sCopy) {
		s = sCopy;
	}
	
	
	
}
