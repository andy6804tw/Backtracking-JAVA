# Subsets
## 枚舉子串列 DFS
例如 {1,2,8} 所有的子集就是 0 、 1 、 2 、 8 、 1 2 、 1 8 、 2 8 、 1 2 8 

```java
public class Main {
	
	static int num[]= {1,2,8};
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
```

## 枚舉子串列並限定重量
2、4、5 組合最大重量為6
```java
public class Main {
	
	static int num[]= {2,4,5};
	static int solution[]=new int [3],used[]=new int[num.length];

	public static void main(String[] args) {
		backtracking(0,0,6); //6為重量限制
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
```
