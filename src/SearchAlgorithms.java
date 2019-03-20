
/**
 * 
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class SearchAlgorithms {
	public static int numDFS = 0;
	public static int numOptimizedDFS = 0;
	
	/**
	 * 
	 * @param board
	 * @param depth
	 * @return
	 */
	public static boolean DFS(nQueenBoard board, int depth) {
		
		numDFS++;
		
		if(board.getCollisions() == 0) {
			System.out.println("Solution found using DFS: ");
			
			for(int i = 0; i < board.getSize(); i++) {
				System.out.print(board.getQueenAt(i) + " ");
			}
			
			System.out.println();
			
			return true;
		}
		
		if (depth == board.getSize()) {
			return false;
		}
		else {
			for (int i = 0; i < board.getSize(); i++) {
				board.editBoard(depth, i);
				
				if (DFS(board, depth+1)) {
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
	public static boolean optimizedDFS(nQueenBoard board, int depth) {
		
		/*this if statement is the optimization
		* basically, if there is a collision in the part of the board we are no longer changing (row < depth)
		* then we return
		* because no changes to subsequent rows could fix the collision of these rows
		*/
		if (board.hasCollisionsUpToDepth(depth)) {
			return false;
		}
		
		numOptimizedDFS++;
		
		if(board.getCollisions() == 0) {
			System.out.println("Optimized DFS found solution");
			for(int i = 0; i < board.getSize(); i++) {
				System.out.print(board.getQueenAt(i) + " ");
			}
			System.out.println();
			return true;
		}

		
		if (depth == board.getSize()) {
			return false;
		}
		else {
			for (int i = 0; i < board.getSize(); i++) {
				board.editBoard(depth, i);
				
				if (optimizedDFS(board, depth+1)) {
					return true;
				}
			}
			
			return false;
		}
	}

}
