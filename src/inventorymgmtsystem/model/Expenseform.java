package inventorymgmtsystem.model;

public class Expenseform {

	private String date;
	private String dealer;
	//private String salary;
	private String quantity;
	private String unit;
	private String productcode;
	private String lot;
	private String description;
	private String unitprice;
	private String totalprice;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDealer() {
		return dealer;
	}
	public void setDealer(String dealer) {
		this.dealer = dealer;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "Expenseform [date=" + date + ", dealer=" + dealer + ", quantity=" + quantity + ", unit=" + unit
				+ ", productcode=" + productcode + ", lot=" + lot + ", description=" + description + ", unitprice="
				+ unitprice + ", totalprice=" + totalprice + "]";
	}
	
	
	
	
	
}
