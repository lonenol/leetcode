## 题目
https://leetcode-cn.com/problems/combine-two-tables/

## 思路
 
 sql..明显是个左连接..

## 答案

```sql
select p.FirstName,p.LastName, a.city,a.state from person p
left join address a on p.PersonId = a.PersonId
```