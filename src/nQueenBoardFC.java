
/**
 * This is the class for managing a board for the n-queens problem.
 * It is used for our DFS algorithm with Forward Tracking. It requires
 * a different representation than the other algorithms.
 * 
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class nQueenBoardFC {
	private int size;  					// keeps track of the size of the board/number of queens
	private boolean[][] availPos;   	// Tracks the valid positions in the domain for forward checking

	/** Constructor which initializes the domain of an
	 *  nQueens board by initializing every position to be valid.
	 * 
	 * @param numQueens the dimension of the board
	 */
	public nQueenBoardFC(int numQueens) {
		this.size = numQueens;
		this.availPos = new boolean[size][size];

		//Initialize all positions as valid
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				availPos[i][j] = true;
			}
		}
	}

	/** 
	 * Copy constructor
	 * 
	 * @param oldBoard	the board to be copied
	 */
	public nQueenBoardFC(nQueenBoardFC oldBoard) {
		this.size = oldBoard.size;
		this.availPos = new boolean[size][size];

		//Copy the old array into the new array
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				availPos[i][j] = oldBoard.availPos[i][j];
			}
		}
	}
	
	/**
	 * Reduces the domain of the new board given a placement of a queen.
	 * 
	 * @param row		the row of the queen that will be placed
	 * @param col		the column location of the queen
	 */
	public void reduceDomain(int row, int col) {
		int i;
		int j;
		//Modify the domain of the new array

		//Falsify the entire row
		for(j = 0; j < size; j++) {
			availPos[row][j] = false;
		}

		//Falsify the column in rows below the placement
		for(i = row+1; i < size; i++) {
			availPos[i][col] = false;
		}

		//Falsify the downwards diagonals
		int rCol = col + 1;
		int lCol = col - 1;
		for(i = row+1; i < size; i++) {
			if(rCol < size) {
				availPos[i][rCol] = false;
				rCol++;
			}
			if(lCol >= 0) {
				availPos[i][lCol] = false;
				lCol--;
			}
		}

		//Mark the placement of the queen
		availPos[row][col] = true;
	}

	/**
	 * Checks if there is at least one row with no valid positions
	 * for a queen. That is, at least one row has an empty domain.
	 * 
	 * @param	depth	the current depth that you need to check from (earlier rows won't have empty domains)
	 * @return 	true, if there is at least one row with no valid positions
	 * 			false, otherwise
	 */
	public boolean hasEmptyDomain(int depth) {
		boolean hasValidCol = false;

		for(int i = depth; i < size; i++) {			
			for(int j = 0; j < size; j++) {
				if(availPos[i][j]) {
					hasValidCol = true;
					break;
				};
			}

			//Return false if the checked row had no valid values in its domain
			if(!hasValidCol) {
				return true;
			}
			
			//Reset flag
			hasValidCol = false;
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
			for(int j = 0; j < size; j++) {
				if(availPos[i][j]) {
					sb.append("(" + i + ", " + j + ")");
					break;
				}
			}

			if(i != size-1) {
				sb.append(", ");
			}
		}
		sb.append("\n");


		//Print the board graphically, Q for queen, X for empty
		for(int i = 0; i < size; i++) {
			sb.append("\n");

			for(int j = 0; j < size; j++) {
				if(availPos[i][j]) {
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
	
	/**
	 * Checks if the given indices are within the domain of constraints
	 * 
	 * @param r		the row position
	 * @param c		the col position
	 * @return		a boolean of the position's validity
	 */
    public boolean isPosValid(int r, int c) {
    	return availPos[r][c];
    }
}