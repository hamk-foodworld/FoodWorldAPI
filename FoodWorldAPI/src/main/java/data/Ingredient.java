package data;

public class Ingredient {

	private int iID;
	private String sName;
	private int iAmount;
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
	
	@Override
	public String toString() {
		return "Ingredient [iID=" + iID + ", sName=" + sName + ", iAmount=" + iAmount + "]";
	}
	
	
	
}
