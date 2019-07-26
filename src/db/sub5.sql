select
  *,
  sales.id,
  customers.name as customers_name,
  genres.name as genres_name,
  director.name as staff_director_name,
  sale.name as staff_sale_name,
  design.name as staff_desing_name,
  coding.name as staff_coding_name,
  system.name as staff_system_name
from
  sales
  left outer join
  statuses as director
  on
  sales.staff_director_id = director.id
  left outer join
  statuses as sale
  on
  sales.staff_sale_id = sale.id
  left outer join
  statuses as design
  on
  sales.staff_design_id = design.id
  left outer join
  statuses as coding
  on
  sales.staff_coding_id = coding.id
  left outer join
  statuses as system
  on
  sales.staff_system_id = system.id
  left outer join
  customers
  on
  sales.customer_id = customers.id
  left outer join
  genres
  on
  sales.genres_id = genres.id
;
