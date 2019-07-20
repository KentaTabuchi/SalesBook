package enums;

public enum Settle {
	settle("確定"),
	unsettled("未確定");
	
	private String name;

	private Settle(String name){
		this.name = name;
	}
	
	public String getValue(){
		return this.name;
	}
}
