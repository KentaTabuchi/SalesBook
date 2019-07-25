select
  sales.id,
  director.name as staff_director_name,
  sale.name as staff_sale_name
from
  sales

  left join
  statuses as director
  on
  sales.staff_director_id = director.id

  left join
  statuses as sale
  on
  sales.staff_sale_id = sale.id
  left join
  statuses as design
  on
  sales.staff_design_id = design.id
  left join
  statuses as coding
  on
  sales.staff_coding_id = coding.id
  left join
  statuses as system
  sales.staff_system_id = system.id
;
