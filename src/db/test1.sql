select *,customers.name 
from sales_detail
  left outer join
  customers
  on
  sales_detail.vendor_id = customers.id
  where
  sales_detail.sales_id = 10
