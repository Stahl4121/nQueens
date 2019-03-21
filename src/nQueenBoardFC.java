
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
    
    /** Copy constructor which reduces the domain
     *  of the new board given a placement of a queen.
     * 
     * @param oldBoard	the board to be copied
     * @param row		the row of the queen that will be placed
     * @param column	the column location of the queen
     */
    public nQueenBoardFC(nQueenBoardFC oldBoard, int row, int column) {
        this.size = oldBoard.size;
        this.availPos = new boolean[size][size];

        //Copy the old array into the new array
        for(int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++) {
        		availPos[i][j] = oldBoard.availPos[i][j];
        	}
        }
        
        //Modify the domain of the new array
        
 
    }
    
    /**
     * Checks if there is at least one row with no valid positions
     * for a queen. That is, at least one row has an empty domain.
     * 
     * @return 	true, if there is at least one row with no valid positions
     * 			false, otherwise
     */
    public boolean hasEmptyDomain() {
    	boolean hasValidCol = false;
    	
        for(int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++) {
        		if(availPos[i][j]) {
        			hasValidCol = true;
        			break;
        		};
        	}
        	
        	if(!hasValidCol) {
        		return false;
        	}
        }
        
        return true;
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
}