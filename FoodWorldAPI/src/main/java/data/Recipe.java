package data;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Recipe {

	private int iRecipeID;
	private String sName;
	private int iCookingTime;
	private String sDescription;
	private int iAmountPeople;
	private int iRating;
	private String sPreparation;
	private byte byVegan;
	private byte byVegetarian;
	private byte byGluten;
	private byte byLactose;
	private Date dtEntrydate;
	private String sEntrydate;
	private String sPic;
	private byte[] byPicBlob;
	
	private int iCountryID;
	
	private List<Ingredient> ingredients;
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public int getiRecipeID() {
		return iRecipeID;
	}
	public void setiRecipeID(int iRecipeID) {
		this.iRecipeID = iRecipeID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getiCookingTime() {
		return iCookingTime;
	}
	public void setiCookingTime(int iCookingTime) {
		this.iCookingTime = iCookingTime;
	}
	
	public String getsDescription() {
		return sDescription;
	}
	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}
	public int getiAmountPeople() {
		return iAmountPeople;
	}
	public void setiAmountPeople(int iAmountPeople) {
		this.iAmountPeople = iAmountPeople;
	}
	public int getiRating() {
		return iRating;
	}
	public void setiRating(int iRating) {
		this.iRating = iRating;
	}
	public String getsPreparation() {
		return sPreparation;
	}
	public void setsPreparation(String sPreparation) {
		this.sPreparation = sPreparation;
	}
	public byte getByVegan() {
		return byVegan;
	}
	public void setByVegan(byte byVegan) {
		this.byVegan = byVegan;
	}
	public byte getByVegetarian() {
		return byVegetarian;
	}
	public void setByVegetarian(byte byVegetarian) {
		this.byVegetarian = byVegetarian;
	}
	public byte getByGluten() {
		return byGluten;
	}
	public void setByGluten(byte byGluten) {
		this.byGluten = byGluten;
	}
	public byte getByLactose() {
		return byLactose;
	}
	public void setByLactose(byte byLactose) {
		this.byLactose = byLactose;
	}
	public Date getDtEntrydate() {
		return dtEntrydate;
	}
	public void setDtEntrydate(Date dtEntrydate) {
		this.dtEntrydate = dtEntrydate;
	}
	public String getsPic() {
		return sPic;
	}
	public void setsPic(String sPic) {
		this.sPic = sPic;
	}
	public byte[] getByPicBlob() {
		return byPicBlob;
	}
	public void setByPicBlob(byte[] byPicBlob) {
		this.byPicBlob = byPicBlob;
	}	
	
	public String getsEntrydate() {
		return sEntrydate;
	}
	public void setsEntrydate(String sEntrydate) {
		this.sEntrydate = sEntrydate;
	}
	
	public int getiCountryID() {
		return iCountryID;
	}
	public void setiCountryID(int iCountryID) {
		this.iCountryID = iCountryID;
	}
	
	@Override
	public String toString() {
		return "Recipe [iRecipeID=" + iRecipeID + ", sName=" + sName + ", iCookingTime=" + iCookingTime
				+ ", sDescription=" + sDescription + ", iAmountPeople=" + iAmountPeople + ", iRating=" + iRating
				+ ", sPreparation=" + sPreparation + ", byVegan=" + byVegan + ", byVegetarian=" + byVegetarian
				+ ", byGluten=" + byGluten + ", byLactose=" + byLactose + ", dtEntrydate=" + dtEntrydate
				+ ", sEntrydate=" + sEntrydate + ", sPic=" + sPic + ", byPicBlob=" + Arrays.toString(byPicBlob)
				+ ", iCountryID=" + iCountryID + ", ingredients=" + ingredients + "]";
	}
	
}
