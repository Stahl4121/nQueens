import java.util.Scanner;

/**
 * The driver for the n-queens problem. 
 * Handles user input for solving the problem.
 * Creates the necessary objects and runs/times 
 * the algorithms chosen by the user.
 * 
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class Driver_nQueens {

	/**
	 * Runs and records elapsed time for the DFS algorithm.
	 */
	public static void runDFS(int nQueens) {
		nQueenBoard n = new nQueenBoard(nQueens);
		DFSAlgorithms dfsRun = new DFSAlgorithms();

		long startTime = System.nanoTime();
		dfsRun.DFS(n,0);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("DFS time: " + duration/1000000000.0 );
		System.out.println("DFS expanded " + dfsRun.getNumNodes()+ " nodes.\n");
	}

	/**
	 * Runs and records elapsed time for the DFS with Backtracking algorithm.
	 */
	public static void runBTDFS(int nQueens) {
		nQueenBoard n = new nQueenBoard(nQueens);
		DFSAlgorithms btDFSRun = new DFSAlgorithms();

		long startTime = System.nanoTime();
		btDFSRun.btDFS(n,0);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("Backtracking DFS time: " + duration/1000000000.0);
		System.out.println("Backtracking DFS expanded " + btDFSRun.getNumNodes() + " nodes.\n");
	}


	/**
	 * Runs and records elapsed time for the DFS with Forward Checking algorithm.
	 */
	public static void runFCDFS(int nQueens) {
		nQueenBoard n = new nQueenBoard(nQueens);
		DFSAlgorithms fcDFSRun = new DFSAlgorithms();

		long startTime = System.nanoTime();
		fcDFSRun.fcDFS(n,0);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("Forward Checking DFS time: " + duration/1000000000.0);
		System.out.println("Forward Checking DFS expanded " + fcDFSRun.getNumNodes() + " nodes.\n");
	}

	/**
	 * Main for the n-queens problem. Handles user input for solving the problem.
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		//Get the user's choice of algorithm
		System.out.println("Which search algorithm would you like to use?");
		System.out.println("\t1. Depth First Search");
		System.out.println("\t2. Depth First Search with Backtracking");
		System.out.println("\t3. Depth First Search with Forward Checking");
		System.out.println("\t4. Local Search with Random Restart");
		int algChoice = s.nextInt();

		//Get the dimension of the board
		System.out.println("\nWhat size of board would you like to solve? (i.e. how many queens?)");
		int nQueens = s.nextInt();
		
		System.out.println("\n\n");
		
		s.close();

		//Run a different algorithm's method depending on the user's choice
		switch (algChoice) {
		case 1:
			runDFS(nQueens);
			break;
		case 2:
			runBTDFS(nQueens);
			break;
		case 3:
			runFCDFS(nQueens);
			break;
		case 4:
			//runLSRR()...
			break;
		default:
			break;
		}

	}
}