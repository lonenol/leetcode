## 题目:
https://leetcode-cn.com/problems/rank-scores/

## 思路

## 答案

```sql
select s1.Score, 
(select count(distinct s2.score) from scores s2 where s2.score >= s1.score)  Rank
from scores s1 order by s1.Score desc
```