public class Main {
	
	static int num[]= {2,4,5};
	static int solution[]=new int [3],used[]=new int[num.length];

	public static void main(String[] args) {
		backtracking(0);
	}
	
	public static void backtracking(int n) {
		if(n==3) {
			for(int i=0;i<3;i++) {
				if(solution[i]==1) {
					System.out.print(num[i]+" ");
				}
			}
			System.out.println();
			return;
		}
			solution[n]=1;
			backtracking(n+1);
			solution[n]=0;
			backtracking(n+1);
	}

}
