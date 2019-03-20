import java.util.Scanner;
/**
 * 
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class Driver_nQueens {
	
	/**
	 * 
	 */
	public static void runDFS(int nQueens) {
		nQueenBoard n = new nQueenBoard(nQueens);
		
		long startTime = System.nanoTime();
		SearchAlgorithms.DFS(n,0);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		
		System.out.println("\nDFS time: " + duration/1000000000.0 );
		System.out.println("DFS was called " + SearchAlgorithms.numDFS+ " times.\n");
	}
	
	/**
	 * 
	 */
	public static void runOptimizedDFS(int nQueens) {
		nQueenBoard n1 = new nQueenBoard(nQueens);
		
		long startTime = System.nanoTime();
		SearchAlgorithms.optimizedDFS(n1,0);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		
		System.out.println("Optimized DFS time: " + duration/1000000000.0);
		System.out.println("Optimized DFS was called " + SearchAlgorithms.numOptimizedDFS + " times.\n");
	}
	
	/**
	 * 
	 */
	public static void main(String[] args) {
		//Get number of queens
		Scanner s = new Scanner(System.in);
		System.out.println("How many queens do you want?");
		int nQueens = s.nextInt();
		s.close();
		
		runDFS(nQueens);
		runOptimizedDFS(nQueens);
	}
	
}