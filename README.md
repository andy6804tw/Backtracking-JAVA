# Backtracking-JAVA

- [UVA 441](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=382)

漢米爾頓迴路(Hamiltonian circuit)，是一條由某個起始節點出發，經過每個節點恰好一次，且最後會回到起始節點的路徑(path)。

## 介紹
Backtracking是一種窮舉搜尋的演算法，目標是找尋所有可能的答案，可分為兩個概念，分別是enumerate(枚舉)與pruning(剪枝)
(1)enumerate(枚舉):每一步列出所有可能的下一步一一測試
(2)pruning(剪枝):遇到不符合條件的下一步便省略，不再繼續枚舉

## 何時使用
1.需要搜尋所有可能答案的時候
2.需要暴力破解的時候

## 如何使用
1.列舉所有可能下一步的答案
2.設立答案的停損點
3.如果需要的話，把關注的解儲存下來
4.遇到不可能的條件不再繼續搜尋或過濾不可能的條件


ref: http://wiki.csie.ncku.edu.tw/acm/course/Backtracking
