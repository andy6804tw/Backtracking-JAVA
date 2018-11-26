public class Main {
	
	static int num[]= {2,4,5};
	static int solution[]=new int [3],used[]=new int[num.length];

	public static void main(String[] args) {
		backtracking(0,0,6);
	}
	
	public static void backtracking(int n,int weight,int total) {
		if(n==2) {
			for(int i=0;i<3;i++) {
				if(solution[i]==1) {
					System.out.print(num[i]+" ");
				}
			}
			System.out.println();
		}
		if(promising(n,weight,total)) {
			solution[n]=1;
			backtracking(n+1,weight+num[n],total-num[n]);
			solution[n]=0;
			backtracking(n+1,weight,total-num[n]);
		}
	}
	public static boolean promising(int i,int weight,int total) {
		return (weight+total>=6)&&(weight+num[i]<=6);
	}

}
