## 题目:
https://leetcode-cn.com/problems/department-top-three-salaries/
## 思路

## 答案

```sql

select d.name as 'Department', e1.Name as 'Employee' , e1.Salary 
from Employee e1 join  Department d on e1.DepartmentId = d.id
where (select count(distinct salary) from Employee e2 where e2.salary > e1.salary and e2.DepartmentId = e1.DepartmentId) < 3
order by d.id,  e1.Salary desc

```