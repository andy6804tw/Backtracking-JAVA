package Backtracking;

public class Main {
	
	static int W[][]= {{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,1,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,1,0,0,0,0},{0,0,1,0,1,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,1,0,0,0},{0,1,0,0,0,0,1,0,0,0,1,0,0},
			{0,0,0,0,0,1,0,1,0,0,0,1,0},{0,0,1,0,0,0,1,0,1,0,0,0,0},{0,0,1,1,0,0,0,1,0,1,0,0,0},{0,0,0,0,1,0,0,0,1,0,0,0,1},{0,0,0,0,0,1,0,0,0,0,0,1,0},{0,0,0,0,0,0,1,0,0,0,1,0,1},{0,0,0,0,0,0,0,0,0,1,0,1,0}};
	static int n=12,vindex[]=new int [n];
	static int count=0;

	public static void main(String[] args) {
		vindex[0]=1;
		backtracking(0);
		if(count==0) {
			System.out.println("此圖形非 Hamiltonian circuit");
		}
	}
	
	public static void backtracking(int i) {
		int j;
		if(promising(i)==1) { // 若promising代表有路走
			if(i==n-1) { // 判斷是否繞回起點了，若有則印出答案
				for(int k=0;k<n;k++) {
					System.out.print(vindex[k]+" ");
				}
				System.out.println();
				count++;
			}else { // 尋找所有路線
				for(j=2;j<=n;j++) {
					vindex[i+1]=j;
					backtracking(i+1);
				}
			}
		}
	}
	public static int promising(int i) {
		int j,choose;
		if(i==n-1&& W[vindex[n-1]][vindex[0]]==0) // 起始點點是否與第(n−1)點相鄰
			choose=0;
		else if(i>0&&W[vindex[i-1]][vindex[i]]==0) // 第(n−1)個點是否與最後一點相鄰
			choose=0;
		else {
			choose=1;
			j=1;
			while(j<i&&choose==1) { // 檢查陣列vindex中該點是否已經被走過
				if(vindex[i]==vindex[j])
					choose=0;
				j++;
			}
		}
		return choose;
	}

}
