
/**
 * Contains the DFS algorithms (brute force, w/ backtracking, w/ forward checking)
 * for solving the n-queens problem.
 * 
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class DFSAlgorithms {
	private int numNodes = 0;
	
	//-----------------------------
	//TODO: Move numNodes into method parameter, and print along with solutions
	
	/**
	 * Getter for member variable numNodes
	 * 
	 * @return the number of expanded nodes
	 */
	public int getNumNodes(){
		return numNodes;
	}

	/**
	 * Recursive method for plain DFS, with no thinking. 
	 * Branches on every node, only checking if the board 
	 * is valid at the max depth.
	 * 
	 * @param 	board	the initial board to search for a solution
	 * @param 	depth   the current depth of the board being searched
	 * @return	true,	if a solution has been found
	 */
	public boolean DFS(nQueenBoard board, int depth) {

		//Increment number of nodes expanded
		numNodes++;

		//Check if the board is a solution
		//If so, print the solution.
		if(board.getCollisions() == 0) {
			System.out.println("\nSolution found using DFS: ");
			System.out.println(board.toString());
			return true;
		}

		//If board is not a solution, but at the bottom of the
		//tree, it is not a solution.
		if (depth == board.getSize()) {
			return false;
		}
		else {
			//Loop through all positions of a queen at a given depth
			for (int i = 0; i < board.getSize(); i++) {
				//Create a new board modified at one position
				nQueenBoard b = new nQueenBoard(board, depth, i);
				
				//Expand the node with a recursive call
				if (DFS(b, depth+1)) {
					return true;
				}
			}

			return false;
		}
	}


	/**
	 * Recursive method for DFS with backtracking. 
	 * Before expanding a node, this implementation
	 * checks if there are already existing conflicts.
	 * That is, it prunes the domain of the queen being placed
	 * based on previously placed queens.
	 * 
	 * @param 	board	the initial board to search for a solution
	 * @param 	depth   the current depth of the board being searched
	 * @return	true,	if a solution has been found
	 */
	public boolean btDFS(nQueenBoard board, int depth) {

		//Increment number of nodes expanded
		numNodes++;

		//Check if the board is a solution
		//If so, print the solution.
		if(board.getCollisions() == 0) {
			System.out.println("Backtracking DFS found solution.");
			System.out.println(board.toString());
			return true;
		}

		//If board is not a solution, but at the bottom of the
		//tree, it is not a solution.
		if (depth == board.getSize()) {
			return false;
		}
		else {
			//Loop through all positions of a queen at a given depth
			for (int i = 0; i < board.getSize(); i++) {
				//Create a new board modified at one position
				nQueenBoard b = new nQueenBoard(board, depth, i);

				//This outer-if is the backtracking
				//Only expand the node if the choice currently satisfies constraints
				if (!b.hasCollisionsUpToDepth(depth + 1)) {
					//Expand the node with a recursive call
					if (btDFS(b, depth+1)) {
						return true;
					}
				}
			}

			return false;
		}
	}


	/**
	 * Recursive method for DFS with forward checking. 
	 * This implementation tracks the domain values of 
	 * each row in the board, pruning the domains of queens
	 * at greater depths, based on the queen just placed.
	 * If a domain of a queen's row becomes empty, that board's
	 * node is not expanded.
	 * 
	 * @param 	board	the initial board to search for a solution
	 * @param 	depth   the current depth of the board being searched
	 * @return	true,	if a solution has been found
	 */
	public boolean fcDFS(nQueenBoard board, int depth) {

		numNodes++;
		
		//Check if any rows are all false
		//		return false;
		
		//Check if depth == size of board
		//		print board;
		//		print stats;
		//		return true;
		
		//for(col in available in current depth)
		//		if col == true
		//			//Copy availPositions 2D array
					//Reduce constraints in array
					//if(FC())
						//Return true
		//Done
					
		
		
		
		

		if(board.getCollisions() == 0) {
			System.out.println("Backtracking DFS found solution");
			System.out.println(board.toString());

			System.out.println();
			return true;
		}


		if (depth == board.getSize()) {
			return false;
		}
		else {
			for (int i = 0; i < board.getSize(); i++) {
				nQueenBoard b = new nQueenBoard(board, depth, i);

				if (!b.hasCollisionsUpToDepth(depth + 1)) {
					if (btDFS(b, depth+1)) {
						return true;
					}
				}
			}

			return false;
		}
	}

}
