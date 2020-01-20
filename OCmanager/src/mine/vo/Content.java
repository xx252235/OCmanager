package mine.vo;

import java.util.Date;


public class Content {
	//正好是数据库里面创建的8个对象，并在这里设置他们的get和set方法，等待着被封装
	private String id;
	private String contract_id;
	private String contract_con;
	private String style;
	private String unit;
	private String price;
	private String inputdate;
	private String updatedate;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the contract_id
	 */
	public String getContract_id() {
		return contract_id;
	}
	/**
	 * @param contract_id the contract_id to set
	 */
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}
	/**
	 * @return the contract_con
	 */
	public String getContract_con() {
		return contract_con;
	}
	/**
	 * @param contract_con the contract_con to set
	 */
	public void setContract_con(String contract_con) {
		this.contract_con = contract_con;
	}
	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}
	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the inputdate
	 */
	public String getInputdate() {
		return inputdate;
	}
	/**
	 * @param inputdate the inputdate to set
	 */
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	/**
	 * @return the updatedate
	 */
	public String getUpdatedate() {
		return updatedate;
	}
	/**
	 * @param updatedate the updatedate to set
	 */
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Content [id=" + id + ", contract_id=" + contract_id
				+ ", contract_con=" + contract_con + ", style=" + style
				+ ", unit=" + unit + ", price=" + price + ", inputdate="
				+ inputdate + ", updatedate=" + updatedate + "]";
	}

	

}









