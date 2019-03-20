import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("How many queens do you want?");
		int nQueens = s.nextInt();
		s.close();
		nQueenBoard n = new nQueenBoard(nQueens);
		DFS(n,0);
	}
	public static boolean DFS(nQueenBoard n, int depth) {
		if(n.getCollisions() == 0) {
			System.out.println("found solution");
			for(int i = 0; i < n.getN(); i++) {
				System.out.print(n.getQueenAt(i) + " ");
			}
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
}