
/**
 *	Contains the Local Search with Random Research algorithm
 * for solving the n-queens problem.
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class lsrrAlgorithm {
    private int numRestarts = 0; //number of random restarts
    private int minCollisions = 0; //the fewest collisions on the best board so far
    private boolean betterBoardExists = true;
    private nQueenBoard betterBoard = null;
    private nQueenBoard board;

    /** constructor: takes number of queens
     *
     * @param number of queens
     */
    public void LSRR(int nQueens) {
        boolean foundSolution = false;
        
        // while a solution hasn't been found generate a random board of size
        // nQueens and then proceeds to locally search.
        while(!foundSolution) {
            this.board = new nQueenBoard(nQueens, true);
            this.betterBoard = this.board;
            minCollisions = board.getCollisions();
        	foundSolution = search();
            // if the search doesn't return a solution,
        	// you'll loop and restart randomly
            numRestarts++;
        }
        
        System.out.println("\nLocal Search with Random Restart found a solution:");
        System.out.println(this.board.toString());
    }

    /**
     * Getter for member variable numNodes
     *
     * @return the number of expanded nodes
     */
    public int getNumRestarts(){
        return numRestarts;
    }
	
	/**
	 * Resets restart count to 0
	 */
	public void resetNumRestarts() {
		numRestarts = 0;
	}

    /**
     * @return found solution
     */
    public boolean search() {

        // while there are still better options keep optimizing
        do {
            betterBoardExists = betterNeighbor();
            this.board = betterBoard;
        } while(betterBoardExists);
        
        // there are no better options for the board
        // if there are no collisions then the solution has been found
        if (minCollisions == 0) {
            return true;
        }
        // otherwise rand restart because we're in a local min/max
        return false;
        
    }

    // generate all neighbors and find minimum collisions board
    public boolean betterNeighbor() {
    	
        boolean foundBetter = false;
        int currMC = minCollisions;
        int tempMC = 0;
        
        // loop through all queens
        for (int q = 0; q < board.getSize(); q++) {
        	// loop through all rows
            for (int p = 0; p < board.getSize(); p++) {
            	// create a temporary neighbor board that is 
            	// identical to the original except for the
            	// qth qeen which will be moved to position p
                nQueenBoard temp = new nQueenBoard(this.board);
                temp.placeQueen(q, p);
                tempMC = temp.getCollisions(); 
                
                // if the temp boards collisions is less than the current collision counts
                if(tempMC < currMC) {
                	// this is the best neighbor board so far so we save it
                    betterBoard = temp;
                    currMC = tempMC;
                }
            }
        }
        
        // the best neighbor has fewer collisions than the original
        // this is better than the original
        if(currMC < minCollisions) {
            foundBetter = true;
            minCollisions = currMC;
        }
        
        return foundBetter;
    }

}