

public class nQueenBoard {
    private int n;  // keeps track of the size of the board/number of queens
    private int[] queens;   // the ith queen is at location [i][queens[i]] on the board
    private boolean[] collisions;  // this tracks if the ith queen is in a collision
    private int nCollisions;    // this track total number of collisions

    // constructor: takes boardsize/numQueens
    public nQueenBoard(int numQueens) {
        this.n = numQueens;
        this.queens = new int[numQueens];
        this.collisions = new boolean[numQueens];
        this.nCollisions = 0;

        // need to initialize queens

        /////////////////////////////
        ///////////////////////////////
        /////////////////////////////

        // then run getCollisions
        getCollisions();
    }

    public boolean isCollision(int i, int j) {
        int iQ = queens[i]; // y index for the ith Queen
        int jQ = queens[j]; // y index for the jth Queen
        int qDist = Math.abs(iQ - jQ);  // y distance between the two queens
        // if they are on the same row or diagonal there is a collision
        if(qDist == 0 || qDist == Math.abs(j - i)) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getCollisions() {
        this.nCollisions = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isCollision(i, j)) {
                    collisions[i] = true;
                    nCollisions++;
                    break;  // as soon as you find a collision for a queen move to the next queen
                }
            }
        }
        return nCollisions;
    }
}