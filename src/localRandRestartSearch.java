
/**
 *
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class localRandRestartSearch {
    private int numRestarts = 0;
    private int numNodes = 0;
    private int minCollisions = 0;
    private nQueenBoard betterBoard = null;
    private boolean betterBoardExists = true;
    private nQueenBoard board;

    /** constructor: takes board
     *
     * @param board
     */
    public localRandRestartSearch(nQueenBoard startBoard) {
        this.board = startBoard;
        this.search();
    }

    /**
     * Getter for member variable numNodes
     *
     * @return the number of expanded nodes
     */
    public int getNumNodes(){
        return numNodes;
    }

    /**
     * @return found solution
     */
    public boolean search() {

        minCollisions = board.getCollisions();

        // while there are still better options keep optimizing
        while (betterBoardExists) {
            betterBoardExists = betterNeighbor();
            this.board = betterBoard;
        }
        // there are no better options for the board
        // if there are no collisions then the solution has been found
        if (board.getCollisions() == 0) {
            System.out.println("\nlocal search with random restart found a solution: ");
            this.board.toString();
            return true;
        }
        // otherwise rand restart because we're in a local min/max
        else {
            numRestarts++;
            numNodes++;
            this.board = new nQueenBoard(board.getSize());
        }

    }

    // generate all neighbors and find minimum collisions board
    public boolean betterNeighbor() {

        boolean foundBetter = false;

        for (int q = 0; q < board.getSize(); q++) {

            for (int p = 0; p < board.getSize(); p++) {
                numNodes++;

                nQueenBoard temp = new nQueenBoard(this.board);
                temp.placeQueen(q, p);
                // if this has fewer collisions than the
                if(temp.getCollisions() < minCollisions) {

                    betterBoard = temp;
                    minCollisions = temp.getCollisions();
                    foundBetter = true;
                }
            }
        }
        return foundBetter;
    }

}