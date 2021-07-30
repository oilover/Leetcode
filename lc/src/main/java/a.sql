select a.month,a.driverid, sum(max(min(b.max_amount, a.amount)-b.min_amount, 0)*b.rate)
from driver_income a left join tax_rate b
    on a.month=b.month
group by a.month,a.driverid