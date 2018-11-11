package Hamiltonian;

public class Main {
	
	static int W[][]= {{0,0,0,0,0,0},{0,0,1,1,0,1},{0,1,0,1,1,1},{0,1,1,0,1,0},{0,0,1,1,0,1},{0,1,1,0,1,0}};
	static int n=5,vindex[]=new int [n];

	public static void main(String[] args) {
		vindex[0]=1;
		backtracking(0);
	}
	
	public static void backtracking(int i) {
		int j;
		if(promising(i)==1) {
			if(i==n-1) {
				for(int k=0;k<n;k++) {
					System.out.print(vindex[k]+" ");
				}
				System.out.println();
			}else {
				for(j=2;j<=n;j++) {
					vindex[i+1]=j;
					backtracking(i+1);
				}
			}
		}
	}
	public static int promising(int i) {
		int j,choose;
		if(i==n-1&& W[vindex[n-1]][vindex[0]]==0) 
			choose=0;
		else if(i>0&&W[vindex[i-1]][vindex[i]]==0)
			choose=0;
		else {
			choose=1;
			j=1;
			while(j<i&&choose==1) {
				if(vindex[i]==vindex[j])
					choose=0;
				j++;
			}
		}
		return choose;
	}

}
