package inventorymgmtsystem.model;

public class Incomemenuform {

	private String date;
	private String unit;
	private String qty;
	private String prodcode;
	private String descriptions;
	private String issuedto;
	private String lot;
	private Long unitprice;
	
	
	public String getIssuedto() {
		return issuedto;
	}
	public void setIssuedto(String issuedto) {
		this.issuedto = issuedto;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getProdcode() {
		return prodcode;
	}
	public void setProdcode(String prodcode) {
		this.prodcode = prodcode;
	}
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public Long getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Long unitprice) {
		this.unitprice = unitprice;
	}
	@Override
	public String toString() {
		return "Incomemenuform [date=" + date + ", unit=" + unit + ", qty=" + qty + ", prodcode=" + prodcode
				+ ", descriptions=" + descriptions + ", issuedto=" + issuedto + ", lot=" + lot + ", unitprice="
				+ unitprice + "]";
	}
	
	
	
}
