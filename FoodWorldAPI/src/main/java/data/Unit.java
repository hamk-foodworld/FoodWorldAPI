package data;

public class Unit {
	
	private int iID;
	private String sName;
	private Unit unit;
	
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
	
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return "Unit [iID=" + iID + ", sName=" + sName + ", unit=" + unit + "]";
	}
	
	
	
}
