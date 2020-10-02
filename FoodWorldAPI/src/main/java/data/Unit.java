package data;

public class Unit {
	
	private int iID;
	private String sName;
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
	
	public String getsAcronym() {
		return sAcronym;
	}
	public void setsAcronym(String sAcronym) {
		this.sAcronym = sAcronym;
	}
	
	
	@Override
	public String toString() {
		return "Unit [iID=" + iID + ", sName=" + sName + ", sAcronym=" + sAcronym + "]";
	}	
}
