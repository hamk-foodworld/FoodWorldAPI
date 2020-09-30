package data;

public class Ingredient {

	private int iID;
	private String sName;
	private int iAmount;
	private String sUnit;
	
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
			
	public String getsUnit() {
		return sUnit;
	}
	public void setsUnit(String sUnit) {
		this.sUnit = sUnit;
	}
	
	@Override
	public String toString() {
		return "Ingredient [iID=" + iID + ", sName=" + sName + ", iAmount=" + iAmount + ", sUnit=" + sUnit + "]";
	}

}
