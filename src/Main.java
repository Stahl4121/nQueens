import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("How many queens do you want?");
		int nQueens = s.nextInt();
		s.close();
		nQueenBoard n = new nQueenBoard(nQueens);
	}
}