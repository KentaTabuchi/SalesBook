select *,customers.name as customers_name,
genres.name as genres_name,
staff_director_name (select statuses.name as staff_director_name from sales left outer join statuses on sales.staff_director_id = statuses.id),
staff_sale_name (select statuses.name as staff_sale_name from sales left outer join statuses on sales.staff_sale_id = statuses.id),
staff_design_name (select statuses.name as staff_design_name from sales left outer join statuses on sales.staff_design_id = statuses.id),
staff_coding_name (select statuses.name as staff_coding_name from sales left outer join statuses on sales.staff_coding_id = statuses.id),
staff_system_name (select statuses.name as staff_system_name from sales left outer join on statuses sales.staff_system_id = statuses.id)
from sales
left outer join customers on sales.customer_id = customers.id 
left outer join genres on sales.genres_id = genres.id
