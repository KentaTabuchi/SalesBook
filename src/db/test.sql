select
  sum(total_sale),
  strftime('%Y-%m',income_date) as month
from sales
group by month
having = '2019-07'
;
