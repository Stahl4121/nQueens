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
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);				//Scanner to read in user input
		DFSAlgorithms dfsAlgs = new DFSAlgorithms();	//Object from which to run the algorithms
		
		long startTime = 0, endTime = 0, duration;		//Variables to track elapsed time
		
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
			
			nQueenBoard n = new nQueenBoard(nQueens);
			startTime = System.nanoTime();
			dfsAlgs.DFS(n,0,1);
			endTime = System.nanoTime();
			
			break;
		case 2:
			
			nQueenBoard bt = new nQueenBoard(nQueens);
			startTime = System.nanoTime();
			dfsAlgs.btDFS(bt,0,1);
			endTime = System.nanoTime();
			
			break;
		case 3:
			
			nQueenBoardFC fc = new nQueenBoardFC(nQueens);
			startTime = System.nanoTime();
			dfsAlgs.fcDFS(fc,0,1);
			endTime = System.nanoTime();

			break;
		case 4:
			//runLSRR()...
			break;
		default:
			break;
		}
		
		//Calculate and print elapsed time
		duration = (endTime - startTime);
		System.out.println("Time Elapsed: \t" + duration/1000000000.0 + " seconds");
	}
}