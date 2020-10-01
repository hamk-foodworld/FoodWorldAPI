package data;

public class Unit {
	
	private int iID;
	private String sName;
	
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
	
	
	@Override
	public String toString() {
		return "Unit [iID=" + iID + ", sName=" + sName + "]";
	}
	
	
	
}
