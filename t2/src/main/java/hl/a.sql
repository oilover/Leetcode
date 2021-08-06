create table log (
    uid string,
    url string,
    ts timestamp ,
)
select url, from (
     select url,
            rank() over (partition by url order by nv desc) rnk from
    (select url, count distinct (uid) uv from
        (select url, uid, count(*) u_cnt from log group by url, uid)
    group by url) join (
        select url, row_number() over (partition by url order by u_cnt desc) rnk
        from (select url, uid, count(*) u_cnt from log group by url, uid) where rnk=1
    )
        )
 ) where rnk<=3;

select url, uid,count(*) u_cnt from log group by url, uid