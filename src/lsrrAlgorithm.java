
/**
 *	Contains the Local Search with Random Research algorithm
 * for solving the n-queens problem.
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class lsrrAlgorithm {
    private int numRestarts = 0;
    private int minCollisions = 0;
    private boolean betterBoardExists = true;
    private nQueenBoard betterBoard = null;
    private nQueenBoard board;

    /** constructor: takes board
     *
     * @param startBoard
     */
    public void LSRR(nQueenBoard startBoard) {
        this.board = startBoard;
        this.betterBoard = startBoard;
        minCollisions = board.getCollisions();
        this.search();
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
            System.out.println("\nLocal Search with Random Restart found a solution:");
            System.out.println(this.board.toString());
            return true;
        }
        // otherwise rand restart because we're in a local min/max
        else {
            numRestarts++;
            this.board = new nQueenBoard(board.getSize(),true);
            this.search();
        }
        
        //Will never reach this return statement.
        //You could check numRestarts to return 
        //false if it has restarted too many times.
        return false;
    }

    // generate all neighbors and find minimum collisions board
    public boolean betterNeighbor() {

        boolean foundBetter = false;
        int currMC = minCollisions;
        int tempMC = 0;
        
        for (int q = 0; q < board.getSize(); q++) {

            for (int p = 0; p < board.getSize(); p++) {

                nQueenBoard temp = new nQueenBoard(this.board);
                temp.placeQueen(q, p);
                tempMC = temp.getCollisions(); 
                
                if(tempMC < currMC) {
                    betterBoard = temp;
                    currMC = tempMC;
                }
            }
        }
        
        if(currMC < minCollisions) {
            foundBetter = true;
            minCollisions = currMC;
        }
        
        return foundBetter;
    }

}