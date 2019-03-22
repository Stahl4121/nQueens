import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);				//Scanner to read in user input
		DFSAlgorithms dfsAlgs = new DFSAlgorithms();	//Object from which to run the algorithms
		long startTime = 0, endTime = 0, duration;		//Variables to track elapsed time

		//Get the user's choice of algorithm
		System.out.println("Which search algorithm would you like to use?");
		System.out.println("\t1. Depth First Search");
		System.out.println("\t2. Depth First Search with Backtracking");
		System.out.println("\t3. Depth First Search with Forward Checking");
		System.out.println("\t4. Local Search with Random Restart");
		int algChoice;// = s.nextInt();

		//Get the dimension of the board
		System.out.println("\nWhat size of board would you like to solve? (i.e. how many queens?)");
		int nQueens;// = s.nextInt();

		System.out.println("\n\n");

		s.close();
		
		
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt")), true));

		for(algChoice = 4; algChoice <= 4; algChoice++) {
			for(nQueens = 0; nQueens <= 32; nQueens++) {
				for(int trial = 1; trial<=3; trial++) {

					//Run a different algorithm's method depending on the user's choice
					switch (algChoice) {
					case 1:

						nQueenBoard n = new nQueenBoard(nQueens);
						dfsAlgs.resetNumNodes();	//Resets the expanded node count
						
						startTime = System.nanoTime();
						dfsAlgs.DFS(n,0);
						endTime = System.nanoTime();

						break;
					case 2:
						nQueenBoard bt = new nQueenBoard(nQueens);
						dfsAlgs.resetNumNodes();	//Resets the expanded node count

						startTime = System.nanoTime();
						dfsAlgs.btDFS(bt,0);
						endTime = System.nanoTime();

						break;
					case 3:

						nQueenBoardFC fc = new nQueenBoardFC(nQueens);
						dfsAlgs.resetNumNodes();	//Resets the expanded node count

						startTime = System.nanoTime();
						dfsAlgs.fcDFS(fc,0);
						endTime = System.nanoTime();

						break;
					case 4:
						//runLSRR();
						break;
					default:
						break;
					}

					//Calculate and print elapsed time
					duration = (endTime - startTime);

					System.out.print("ALG " + algChoice + ", ");
					System.out.print("QUEENS " + nQueens + ", ");
					System.out.println("TRIAL " + trial);
					
					System.out.println("Nodes expanded: " + dfsAlgs.getNumNodes());
					System.out.println("Time Elapsed: \t" + duration/1000000000.0 + " seconds\n\n\n\n");

				}
			}
		}
	}
}