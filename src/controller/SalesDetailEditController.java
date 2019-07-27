package controller;

public class SalesDetailEditController extends SalesDetailCRUDController {
	@Override
	public void setSales_id(){
		
		sales_id = SalesTableUController.sales.idProperty().getValue();
	}
}
