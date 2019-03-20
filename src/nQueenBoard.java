
/**
 * 
 * @authors Sarah Calvis, Logan Stahl, Miriam Tan
 *
 */
public class nQueenBoard {
    private int size;  				// keeps track of the size of the board/number of queens
    private int[] queens;   		// the ith queen is at location [i][queens[i]] on the board
    private int nCollisions;   		// this track total number of collisions

    /** constructor: takes boardsize/numQueens
     * 
     * @param numQueens
     */
    public nQueenBoard(int numQueens) {
        this.size = numQueens;
        this.queens = new int[numQueens];

        // need to initialize queens
        for(int i = 0; i < size; i++) {
        	queens[i] = i;
        }
        
        checkCollisions();
    }
    
    /** constructor: takes boardsize/numQueens
     * 
     * @param numQueens
     */
    public nQueenBoard(nQueenBoard oldBoard, int row, int column) {
        this.size = oldBoard.size;
        this.queens = new int[size];

        // need to initialize queens
        for(int i = 0; i < size; i++) {
        	this.queens[i] = oldBoard.queens[i];
        }
        
    	queens[row] = column;
        
        checkCollisions();
    }
    
    /**
     * 
     * @param q1
     * @param q2
     * @return
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
     * 
     * @return
     */
    public void checkCollisions() {
        nCollisions = 0;
        
        for(int q1 = 0; q1 < size; q1++) {
            for(int q2 = q1 + 1; q2 < size; q2++) {
                if(isCollision(q1, q2)) {
                    nCollisions++;
                }
            }
        }
    }
    
    /**
     * 
     * @return member variable nCollisions
     */
    public int getCollisions() {
    	return nCollisions;
    }
    
    /**
     * this method only gets collisions up to depth d
     * 
     * @param d
     * @return
     */
    public boolean hasCollisionsUpToDepth(int d) {
        for(int i = 0; i < d; i++) {
            for(int j = i + 1; j < d; j++) {
                if(isCollision(i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * 
     * @return size o board
     */
    public int getSize() {
    	return size;
    }
    
    /**
     * 
     * @param i
     * @return
     */
    public int getQueenAt(int i) {
    	return queens[i];
    }
}