## 题目:
https://leetcode-cn.com/problems/second-highest-salary/

## 思路
竟然是个 sql...注意1. 去重  2. 只有一个的时候返回 null

## 答案

```sql
SELECT  (select distinct Salary as SecondHighestSalary from Employee  order by salary desc limit 1,1) SecondHighestSalary
```