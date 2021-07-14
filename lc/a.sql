selct province,city from
(select province,city, score, row_number() over (partition by province order by score desc) rnk from table1)
    where rnk<=2

select c1,c2,concat_ws(',', collect_list(c3)) from table2 group by c1,c2