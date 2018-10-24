
emp
empno   ename   sal deptno
1       user1   100 1
2       user2   200 2
3       user3   300 1
4       user4   400 2
5       user5   500 1

dept
deptno  dname
1   dept1
2   dept2


1)  问题：请查询人员编号、人员姓名和所属部门名称。
select e.empno, e.ename, d.dname from emp e, dept d where e.deptno=d.deptno 

2)  问题：请查询各部门中高于部门平均工资的人员及该部门平均工资。
   select empno, ename, e.deptno, d2.asal from emp e, (select deptno, avg(sal) asal  from emp e2 group by deptno ) d2
   where e.deptno = d2.deptno and e.sal > d2.asal
