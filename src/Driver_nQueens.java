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
		DFSAlgorithms dfsRun = new DFSAlgorithms();

		long startTime = System.nanoTime();
		dfsRun.DFS(n,0);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("DFS time: " + duration/1000000000.0 );
		System.out.println("DFS expanded " + dfsRun.getNumNodes()+ " nodes.\n");
	}

	/**
	 * 
	 */
	public static void runBTDFS(int nQueens) {
		nQueenBoard n1 = new nQueenBoard(nQueens);
		DFSAlgorithms btDFSRun = new DFSAlgorithms();

		long startTime = System.nanoTime();
		btDFSRun.btDFS(n1,0);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("Backtracking DFS time: " + duration/1000000000.0);
		System.out.println("Backtracking DFS expanded " + btDFSRun.getNumNodes() + " nodes.\n");
	}


	/**
	 * 
	 */
	public static void runFCDFS(int nQueens) {
		nQueenBoard n1 = new nQueenBoard(nQueens);
		DFSAlgorithms fcDFSRun = new DFSAlgorithms();

		long startTime = System.nanoTime();
		fcDFSRun.fcDFS(n1,0);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("Forward Checking DFS time: " + duration/1000000000.0);
		System.out.println("Forward Checking DFS expanded " + fcDFSRun.getNumNodes() + " nodes.\n");
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		//Get number of queens
		Scanner s = new Scanner(System.in);
		System.out.println("Which search algorithm would you like to use?");
		System.out.println("\t1. Depth First Search");
		System.out.println("\t2. Depth First Search with Backtracking");
		System.out.println("\t3. Depth First Search with Forward Checking");
		System.out.println("\t4. Local Search with Random Restart");
		int algChoice = s.nextInt();

		System.out.println("\nWhat size of board would you like to solve? (i.e. how many queens?)");
		int nQueens = s.nextInt();
		s.close();

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