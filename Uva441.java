package UVA;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static public ArrayList<Integer> list;
	static public int[] solution, used;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while (true) {
			String arr[] = scn.nextLine().split(" ");
			if (arr[0].equals("0"))
				break;
			list = new ArrayList<Integer>();
			for (int i = 1; i < arr.length; i++)
				list.add(Integer.parseInt(arr[i]));
			solution = new int[6];
			used = new int[list.size()];
			backtracking(0, 0);
			System.out.println();
		}

	}

	public static void backtracking(int n, int pos) {
		if (n == 6) {
			for (int i = 0; i < 6; i++) {
				if (i != 0)
					System.out.print(" ");
				System.out.print(solution[i]);
			}
			System.out.println();
			return;
		}
		for (int i = pos; i < list.size(); i++) {
			if (used[i] == 0) {
				used[i] = 1;
				solution[n] = list.get(i);
				backtracking(n + 1, i + 1);
				used[i] = 0;
			}
		}
	}

}
