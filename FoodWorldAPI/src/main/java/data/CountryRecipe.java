package data;

public class CountryRecipe {
	private int iCountryID;
	private int iRecipeID;
	private int iNumber;
	
	public int getiCountryID() {
		return iCountryID;
	}
	public void setiCountryID(int iCountryID) {
		this.iCountryID = iCountryID;
	}
	public int getiRecipeID() {
		return iRecipeID;
	}
	public void setiRecipeID(int iRecipeID) {
		this.iRecipeID = iRecipeID;
	}		
	
	public int getiNumber() {
		return iNumber;
	}
	public void setiNumber(int iNumber) {
		this.iNumber = iNumber;
	}
	@Override
	public String toString() {
		return "CountryRecipe [iCountryID=" + iCountryID + ", iRecipeID=" + iRecipeID + ", iNumber="+ iNumber+"]";
	}
	
	
}
