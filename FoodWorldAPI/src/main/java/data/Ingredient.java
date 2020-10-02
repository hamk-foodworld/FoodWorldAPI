package data;

public class Ingredient {

	private int iID;
	private String sName;
	private int iAmount;
	private int iUnit;
	private String sUnit;
	private String sAcronym;
	
	
	public int getiID() {
		return iID;
	}
	public void setiID(int iID) {
		this.iID = iID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getiAmount() {
		return iAmount;
	}
	public void setiAmount(int iAmount) {
		this.iAmount = iAmount;
	}
			
	public int getiUnit() {
		return iUnit;
	}
	public void setiUnit(int iUnit) {
		this.iUnit = iUnit;
	}
	
	public String getsUnit() {
		return sUnit;
	}
	public void setsUnit(String sUnit) {
		this.sUnit = sUnit;
	}
	
	
	
	
	public String getsAcronym() {
		return sAcronym;
	}
	public void setsAcronym(String sAcronym) {
		this.sAcronym = sAcronym;
	}
	@Override
	public String toString() {
		return "Ingredient [iID=" + iID + ", sName=" + sName + ", iAmount=" + iAmount + ", iUnit=" + iUnit + ", sUnit =" + sUnit + ",sAcronym=" + sAcronym+"]";
	}

}
