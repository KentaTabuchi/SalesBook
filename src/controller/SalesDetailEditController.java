package controller;

public class SalesDetailEditController extends SalesDetailCRUDController {
	@Override
	public void setSales_id(){
		
		sales_id = SalesTableUController.sales.idProperty().getValue();
	}
	
	@Override
	protected void setVendor(){
		vendor_id = SalesTableUController.vendor_id;
		vendor_name = SalesTableUController.vendor_name;
	}
	
	@Override
	protected void setTotal_pay(){
		SalesTableUController.total_expense.textProperty().bind(total_pay);
	}
}
