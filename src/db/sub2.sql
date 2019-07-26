select
*,
(select statuses.name from sales left outer join statuses on sales.staff_system_id = statuses.id)as staff_system_name,
(select statuses.name  from sales left outer join statuses on sales.staff_design_id = statuses.id)as staff_design_name 
from sales
;
