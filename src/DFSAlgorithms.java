
/**
 * Contains the DFS algorithms (brute force, w/ backtracking, w/ forward checking)
 * for solving the n-queens problem.
 * 
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class DFSAlgorithms {
	private int numNodes = 0;

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

		//Only check if the board is a solution when all queens have been placed
		if (depth == board.getSize()) {
			//If there are no collisions, we've found a solution
			if(board.getCollisions() == 0) {
				System.out.println("DFS found a solution:");
				System.out.println(board.toString());
				return true;
			}
			else {
				return false;
			}
		}

		//Loop through all positions of a queen at a given depth
		for (int c = 0; c < board.getSize(); c++) {
			//Create a new board and modify it at one position
			nQueenBoard b = new nQueenBoard(board);
			b.placeQueen(depth, c);

			//Expand the node with a recursive call
			if (DFS(b, depth+1)) {
				return true;
			}
		}

		return false;
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

		//Only check if the board is a solution when all queens have been placed
		if (depth == board.getSize()) {
			//If there are no collisions, we've found a solution
			if(board.getCollisions() == 0) {
				System.out.println("Backtracking DFS found a solution:");
				System.out.println(board.toString());
				return true;
			}
			else {
				return false;
			}
		}
		
		//Loop through all positions of a queen at a given depth
		for (int c = 0; c < board.getSize(); c++) {
			//Create a new board and modify it at one position
			nQueenBoard b = new nQueenBoard(board);
			b.placeQueen(depth, c);

			//This outer-if is the backtracking
			//Only expand the node if the choice currently satisfies constraints
			if (!b.hasCollisionsUpToDepth(depth)) {
				//Expand the node with a recursive call
				if (btDFS(b, depth+1)) {
					return true;
				}
			}
		}

		return false;
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
	public boolean fcDFS(nQueenBoardFC board, int depth) {

		numNodes++;

		//If the board had no empty domains (and so was expanded)
		//and is at it's max depth, then it must be a solution
		if(depth == board.getSize()) {
			System.out.println("Forward Checking DFS found a solution:");
			System.out.println(board.toString());
			return true;
		}

		//Loop through all positions of a queen at a given depth
		for(int c = 0; c < board.getSize(); c++) {
			//Check if position is in the domain
			if(board.isPosValid(depth,c)) {
				
				//Copy the current board and reduce its domain
				nQueenBoardFC b = new nQueenBoardFC(board);
				b.reduceDomain(depth, c);

				//Only expand the node if the board does not have any empty domains
				if(!b.hasEmptyDomain(depth)) {
					if(fcDFS(b, depth+1)){
						return true;
					}
				}
			}
		}

		return false;
	}

}
