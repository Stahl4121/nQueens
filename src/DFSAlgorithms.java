
/**
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
	 * 
	 * @param board
	 * @param depth
	 * @return
	 */
	public boolean DFS(nQueenBoard board, int depth) {
		numNodes++;

		if(board.getCollisions() == 0) {
			System.out.println("\nSolution found using DFS: ");
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
				if (DFS(b, depth+1)) {
					return true;
				}
			}

			return false;
		}
	}

	/**
	 * 
	 * @param board
	 * @param depth
	 * @return
	 */
	public boolean btDFS(nQueenBoard board, int depth) {

		numNodes++;

		if(board.getCollisions() == 0) {
			System.out.println("Backtracking DFS found solution.");
			System.out.println(board.toString());
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

	/**
	 * 
	 * @param board
	 * @param depth
	 * @return
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
