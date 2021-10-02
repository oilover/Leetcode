select user_id
from (select user_id, count(distinct friend_user_id) f_num from friend group by user_id)
order by f_num limit 1,1;

select friend_user_id
from friend a
where user_id = uid1
  and friend_user_id in
      (select friend_user_id from friend where user_id = uid2)