package data;

import java.util.Arrays;

public class Country {
	private int iCountryID;
	private String sName;
	private String sFlag;
	private byte[] byFlagBlob;
	public int getiCountryID() {
		return iCountryID;
	}
	public void setiCountryID(int iCountryID) {
		this.iCountryID = iCountryID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsFlag() {
		return sFlag;
	}
	public void setsFlag(String sFlag) {
		this.sFlag = sFlag;
	}
	public byte[] getByFlagBlob() {
		return byFlagBlob;
	}
	public void setByFlagBlob(byte[] byFlagBlob) {
		this.byFlagBlob = byFlagBlob;
	}
	
	@Override
	public String toString() {
		return "Country [iCountryID=" + iCountryID + ", sName=" + sName + ", sFlag=" + sFlag + ", byFlagBlob="
				+ Arrays.toString(byFlagBlob) + "]";
	}
	
	
		
	
}
