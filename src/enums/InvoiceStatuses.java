package enums;

public enum InvoiceStatuses {
	UNCLAIMED("請求未作成"),
	BILLED("請求済み"),
	WAITING_FOR_PAYMENT("入金待ち"),
	PAYMENT_CONFIRMED("入金確認済み");
	
	private String name;

	private InvoiceStatuses(String name){
		this.name = name;
	}
	
	public String getValue(){
		return this.name;
	}
}
