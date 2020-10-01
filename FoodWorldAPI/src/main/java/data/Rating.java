package data;

public class Rating {
	private int iRecipeID;
	private boolean bState;
	
	public int getiRecipeID() {
		return iRecipeID;
	}
	public void setiRecipeID(int iRecipeID) {
		this.iRecipeID = iRecipeID;
	}
	public boolean isbState() {
		return bState;
	}
	public void setbState(boolean bState) {
		this.bState = bState;
	}
	
	@Override
	public String toString() {
		return "Rating [iRecipeID=" + iRecipeID + ", bState=" + bState + "]";
	}
}
