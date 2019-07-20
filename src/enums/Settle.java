package enums;

public enum Settle {
	SETTLE("確定"),
	UNSETTLED("未確定");
	
	private String name;

	private Settle(String name){
		this.name = name;
	}
	
	public String getValue(){
		return this.name;
	}
}
