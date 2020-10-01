package data;

public class FavRecipe {
	private int iRecipeID;

	public int getiRecipeID() {
		return iRecipeID;
	}

	public void setiRecipeID(int iRecipeID) {
		this.iRecipeID = iRecipeID;
	}

	@Override
	public String toString() {
		return "FavRecipe [iRecipeID=" + iRecipeID + "]";
	}
	
	
}
