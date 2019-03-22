
/**
 *
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class localRandRestartSearch {
    private static int numRestarts = 0;
    private static int numNodes = 0;
    private static int minCollisions = 0;
    private static nQueenBoard betterBoard = null;
    private static boolean betterBoardExists = true;
    private static nQueenBoard board;

    /** constructor: takes board
     *
     * @param board
     */
    public localRandRestartSearch(nQueenBoard startBoard) {
        this.board = startBoard;
        search();
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
    public static boolean search() {

        minCollisions = board.getCollisions();

        // while there are still better options keep optimizing
        while (betterBoardExists) {
            betterBoardExists = betterNeighbor();
            board = betterBoard;
        }
        // there are no better options for the board
        // if there are no collisions then the solution has been found
        if (board.getCollisions() == 0) {
            System.out.println("\nlocal search with random restart found a solution: ");
            board.toString();
            return true;
        }
        // otherwise rand restart because we're in a local min/max
        else {
            numRestarts++;
            numNodes++;
            int s = board.getSize();
            board = new nQueenBoard(s);
            search();
        }


    }

    // generate all neighbors and find minimum collisions board
    public static boolean betterNeighbor() {

        boolean foundBetter = false;

        for (int q = 0; q < board.getSize(); q++) {

            for (int p = 0; p < board.getSize(); p++) {
                numNodes++;

                nQueenBoard temp = new nQueenBoard(board, q, p);
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