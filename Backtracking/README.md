https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=382

回溯法是一種用來找尋問題所有解(或部份解答)；當問題的解答是由一系列的選擇所組成時，運用遞迴遞增地建立所有可能的組合方案，並於建立過程中去除不可能的組合，最終得到所要的答案。
回溯法屬於暴力法(Brute-force)的一種，若將問題的所有可能解答，表示成一個稱為狀態空間樹(State Space Tree)的樹狀結構，其解法就類似 "深度優先搜尋法"(DFS)。

這題是利用回朔言算法來枚舉，排列出所有的可能組合，題目要求輸入一串數列，第一個數字(k)代表接下來後面會有幾個數字，最後就會從S1~Sk中取六個出來的所有組合。

在解這提前可以思考如何利用回朔法來將1 2 3 4 5這五個數字取三個出來的組合，答案如下，總共十個:
注意 1 2 3 和 1 3 2 是一樣的所以每個答案是要從小到大排列，請參考Main.java

```
1 2 3 
1 2 4 
1 2 5 
1 3 4 
1 3 5 
1 4 5 
2 3 4 
2 3 5 
2 4 5 
3 4 5 
```

```java
public class Main {
	static int arr[]= {1,2,3,4,5}; // S集合
	static int ans[]=new int[3]; // 從集合中取三個的組合
	public static void main(String[] args) {
		backtracking(0,0);
	}
	public static void backtracking(int n,int pos) {
		if(n==3) { // 若dimension維度是第三層代表找完答案依序印出並結束遞迴
			for(int i=0;i<3;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=pos;i<5;i++) {// 每次遞迴從pos開始這樣就不會遇到重複值
				ans[n]=arr[i];
				backtracking(n+1,i+1);
		}
	}
/*  五個數字取三個並由小到大排列
    作者：1010
    時間：西元 2018 年 11 月 */
}
```

若沒有大小順序限制則要建立一個check[]陣列來檢查目前此數是否在答案中且不重複(程式碼請參考Main2.java)

```java
public class Main {
	static int arr[]= {1,2,3,4,5}; // S集合
	static int ans[]=new int[3]; // 從集合中取三個的組合
	static int check[]=new int[5]; // 檢查該數是否在ans[]集合中
	public static void main(String[] args) {
		backtracking(0);
	}
	public static void backtracking(int n) {
		if(n==3) { // 若dimension維度是第三層代表找完答案依序印出並結束遞迴
			for(int i=0;i<3;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<5;i++) {
			if(check[i]==0) {// 判斷該數是否已經出現在ans[]中
				check[i]=1; 
				ans[n]=arr[i];
				backtracking(n+1);
				check[i]=0;
			}
		}
	}
/*  五個數字取三個所有組合(無大小順序限制)
    作者：1010
    時間：西元 2018 年 11 月 */
}
```

題目要求由小至大所以我們拿第一個程式下去修改實做(參考Q441:Lotto.java)

```java
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
    static public ArrayList < Integer > list;
    static public int[] solution;
 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int count = 0;
		while (true) {
			String arr[] = scn.nextLine().split(" ");
			if (arr[0].equals("0"))
				break;
			if (count != 0)
				System.out.println();
			list = new ArrayList<Integer>();
			for (int i = 1; i < arr.length; i++)
				list.add(Integer.parseInt(arr[i]));
			solution = new int[6];
			used = new int[list.size()];
			backtracking(0, 0);
			count++;
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
                solution[n] = list.get(i);
                backtracking(n + 1, i + 1);
        }
    }
    /*題目：UVA Q441:Lotto
    作者：1010
    時間：西元 2018 年 11 月 */
}
```


利用BFS
```java
public class Main {
	
	static int num[]= {1,2,3,4};
	static int solution[]=new int [4],used[]=new int[num.length];

	public static void main(String[] args) {
		backtracking(0);
	}
	
	public static void backtracking(int n) {
		
		if(n==4) {
			for(int i=0;i<4;i++) {
				System.out.print(solution[i]+" ");
			}
			System.out.println();
		}else {
			for(int i=n;i<4;i++) {
				if(used[i]==0) {
					solution[n]=num[i];
					used[i]=1;
				}
				backtracking(n+1);
				used[n]=0;
			}
			
		}
	}
}
```
