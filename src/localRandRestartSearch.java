
/**
 *
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class localRandRestartSearch {
    public static int numRestarts = 0;
    public static double totalTime = 0.0;
    public static int minCollisions = 0;
    public static int betterBoard = new nQueenBoard;
    public static int betterLocation = -1;

    private nQueenBoard board;   		

    /** constructor: takes board
     *
     * @param board
     */
    public nQueenBoard(nQueenBoard startBoard) {
        this.board = startBoard;
    }

    /**
     * @return found solution
     */
    public static boolean localRandRestartSearch() {

        minCollisions = board.getCollsions();

        // while there are still better options keep optimizing
        while (better) {

        }
        // there are no better options for the board
        // if there are no collisions then the solution has been found
        if (board.getCollisions() == 0) {
            System.out.println("\nSolution found using local search with random restart: ");
            for (int i = 0; i < board.getSize(); i++) {
                System.out.print(board.getQueenAt(i) + " ");
            }
            System.out.println();
            return true;
        }
        // otherwise rand restart because we're in a local min/max
        else {
            numRestarts++;
        }


    }

    // generate all neighbors and find minimum collisions board
    public static boolean betterNeighbor(nQueenBoard board) {

        for (int q = 0; q < board.size; q++) {

            for (int p = 0; p < board.size; p++) {

                nQueenBoard temp = new nQueenBoard(board, q, p);
                // if this has fewer collisions than the
                if(temp.getCollisions() < minCollisions) {

                }
            }
        }
    }

}