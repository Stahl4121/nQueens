import java.util.Scanner;
public class Main {
	static int numDFS = 0;
	static int numOptimizedDFS = 0;
	public static void main(String[] args) {
		//Get number of queens
		Scanner s = new Scanner(System.in);
		System.out.println("How many queens do you want?");
		int nQueens = s.nextInt();
		s.close();
		
		//Run DFS
		nQueenBoard n = new nQueenBoard(nQueens);
		long startTime = System.nanoTime();
		DFS(n,0);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("DFS time: " + duration/1000000000.0 );
		System.out.println("Number of times DFS was called " + numDFS+ "\n");
		
		//Run Optimized DFS
		nQueenBoard n1 = new nQueenBoard(nQueens);
		startTime = System.nanoTime();
		optimizedDFS(n1,0);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Optimized DFS time: " + duration/1000000000.0);
		System.out.println("Number of times Optimized DFS was called " + numOptimizedDFS + "\n");
	}
	public static boolean DFS(nQueenBoard n, int depth) {
		numDFS++;
		if(n.getCollisions() == 0) {
			System.out.println("\nDFS found solution");
			for(int i = 0; i < n.getN(); i++) {
				System.out.print(n.getQueenAt(i) + " ");
			}
			System.out.println();
			return true;
		}
		if (depth == n.getN()) {
			return false;
		}
		else {
			for (int i = 0; i < n.getN(); i++) {
				n.editBoard(depth, i);
				if (DFS(n, depth+1)) {
					return true;
				}
			}
			return false;
		}
	}
	public static boolean optimizedDFS(nQueenBoard n, int depth) {
		//this if statement is the optimization
		//basically, if there is a collision in the part of the board we are no longer changing (row < depth)
		//then we return
		//because no changes to subsequent rows could fix the collision of these rows
		if (n.collisionsAtDepth(depth) != 0) {
			return false;
		}
		numOptimizedDFS++;
		if(n.getCollisions() == 0) {
			System.out.println("Optimized DFS found solution");
			for(int i = 0; i < n.getN(); i++) {
				System.out.print(n.getQueenAt(i) + " ");
			}
			System.out.println();
			return true;
		}
		if (depth == n.getN()) {
			return false;
		}
		else {
			for (int i = 0; i < n.getN(); i++) {
				n.editBoard(depth, i);
				if (optimizedDFS(n, depth+1)) {
					return true;
				}
			}
			return false;
		}
	}
}