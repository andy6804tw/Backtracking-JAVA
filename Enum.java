package backtracking;

public class Main {
	
	static int num[]= {0,1,2,3,4};
	static int solution[]=new int [3],used[]=new int[num.length];

	public static void main(String[] args) {
		backtracking(0,0);
	}
	
	public static void backtracking(int n,int pos) {
		System.out.println("--------------");
		for(int j=0;j<3;j++)
			System.out.print(solution[j]+" ");
		System.out.println();
		System.out.println("--------------");
		if(n==3) {
//			for(int i=0;i<3;i++)
//				System.out.print(solution[i]+" ");
//		System.out.println();
		return ;
		}
		for(int i=pos;i<num.length;i++) {
			if (used[i]==0){
	            used[i] = 1;
	            solution[n] = num[i];
	            backtracking(n+1,i+1);
	            used[i] = 0;
	        }
		}
		for(int j=n;j<3;j++)
			solution[j]=0;
	}

}
