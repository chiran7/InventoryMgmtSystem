package inventorymgmtsystem.model;

public class Mainform {
	
private int id;
private String date;
private String qty;
private String unit;
private String productcode;
private String lot;
private String description;
private String issuedto;
private String unitprice;
private String totalprice;
public int getId() {
	return id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public void setId(int id) {
	this.id = id;
}
public String getQty() {
	return qty;
}
public void setQty(String qty) {
	this.qty = qty;
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
public String getIssuedto() {
	return issuedto;
}
public void setIssuedto(String issuedto) {
	this.issuedto = issuedto;
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
	return "Mainform [id=" + id + ", date=" + date + ", qty=" + qty + ", unit=" + unit + ", productcode=" + productcode
			+ ", lot=" + lot + ", description=" + description + ", issuedto=" + issuedto + ", unitprice=" + unitprice
			+ ", totalprice=" + totalprice + "]";
}


	
	
}
