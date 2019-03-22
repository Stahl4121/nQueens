
/**
 * This is the class for managing a board for the n-queens problem.
 * It is used for our DFS algorithm, DFS with Backtracking algorithm, and Local Search with Random Restart.
 * 
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class nQueenBoard {
    private int size;  					// keeps track of the size of the board/number of queens
    private int[] queens;   			// the ith queen is at location [i][queens[i]] on the board
    private int nCollisions;   			// this tracks the total number of collisions

    /** Constructor
     * 
     * @param numQueens the dimension of the board
     */
    public nQueenBoard(int numQueens) {
        this.size = numQueens;
        this.queens = new int[size];
    }
    
    /** Copy constructor
     * 
     * @param oldBoard	the board to be copied
     */
    public nQueenBoard(nQueenBoard oldBoard) {
        this.size = oldBoard.size;
        this.queens = new int[size];
        this.nCollisions = oldBoard.getCollisions();

        //Copy locations of queens over
        for(int i = 0; i < size; i++) {
        	this.queens[i] = oldBoard.queens[i];
        }
    }
    
    /**
     * Modifies one location in the new board. 
     * Used for backtracking DFS and DFS.
     * @param row		the row of the queen that will be moved
     * @param col		the new column location to move the queen
     */
    public void placeQueen(int row, int col) {
    	//Move the queen
    	queens[row] = col;
    }
    
    /**
     * Checks if the locations of two queens indicates a collision.
     * 
     * @param q1 the first queen
     * @param q2 the second queen
     * @return	true if the two queens can attack each other
     */
    public boolean isCollision(int q1, int q2) {
        int colDist = Math.abs(queens[q1] - queens[q2]);  // col distance between the two queens
        int rowDist = Math.abs(q1 - q2);  				  // row distance between the two queens
        
        // If in same column or diagonal there is a collision
        if(colDist == 0 || colDist == rowDist) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *  Calculates and returns the number of queen collisions on the board
     *  
     * @return number of collisions
     */
    public int getCollisions() {
        nCollisions = 0;
        
        for(int q1 = 0; q1 < size; q1++) {
            for(int q2 = q1 + 1; q2 < size; q2++) {
                if(isCollision(q1, q2)) {
                    nCollisions++;
                }
            }
        }
        
        return nCollisions;
    }
    
    /**
     * this method returns true if there are collisions up to depth d
     * allows partial checking of the board for backtracking constraint satisfiability
     * 
     * @param d 	the max depth to check the board
     * @return 		boolean of if there is at least one collision
     */
    public boolean hasCollisionsUpToDepth(int d) {
        for(int q1 = 0; q1 <= d; q1++) {
            for(int q2 = q1 + 1; q2 <= d; q2++) {
                if(isCollision(q1, q2)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Creates a string with the coordinates of the queens on the board 
     * and the board itself, represented with Q for queen, X for empty.
     * 
     * @return string of the queen's coords and the board
     */
    public String toString() {
    	StringBuilder sb = new StringBuilder();

		sb.append("-------------------------------------------------\n");
		
		sb.append("COORDS: ");
		
    	//Print the ordered pair coordinates of the solution
		for(int i = 0; i < size; i++) {
			sb.append("(" + i + ", " + queens[i] + ")");
			
			if(i != size-1) {
				sb.append(", ");
			}
		}
		sb.append("\n");

		
		//Print the board graphically, Q for queen, X for empty
		for(int i = 0; i < size; i++) {
			sb.append("\n");
			
			for(int j = 0; j < size; j++) {
				if(queens[i] == j) {
					sb.append("Q ");
				}
				else {
					sb.append("X ");
				}
			}
		}
		
		sb.append("\n\n-------------------------------------------------");
		
		return sb.toString();
    }
    
    /**
     * Getter for private member variable size
     * 
     * @return size, the board dimension
     */
    public int getSize() {
    	return size;
    }
}