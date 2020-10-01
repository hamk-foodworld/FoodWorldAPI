package data;

public class CountryRecipe {
	private int iCountryID;
	private int iRecipeID;
	
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
	
	@Override
	public String toString() {
		return "CountryRecipe [iCountryID=" + iCountryID + ", iRecipeID=" + iRecipeID + "]";
	}
	
	
}
