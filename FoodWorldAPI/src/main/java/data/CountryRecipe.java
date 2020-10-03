package data;

public class CountryRecipe {
	private int iCountryID;
	private int iRecipeID;
	private int iAnzahl;
	
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
	
	public int getiAnzahl() {
		return iAnzahl;
	}
	public void setiAnzahl(int iAnzahl) {
		this.iAnzahl = iAnzahl;
	}
	@Override
	public String toString() {
		return "CountryRecipe [iCountryID=" + iCountryID + ", iRecipeID=" + iRecipeID + ", iAnzahl="+ iAnzahl+"]";
	}
	
	
}
