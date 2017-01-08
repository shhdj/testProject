package com.storesales.query.model;

import java.io.Serializable;

import com.storesales.tools.ZhConvertSpell;

public class EditItemInfoParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1716671716472958524L;

	private String barcode;
	
	private Double price;
	
	private String item_name;

	private String item_subname;
	
	private Double sale_price;
	
	

	public Double getSale_price() {
		return sale_price;
	}

	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
		if(item_name!=null&&!"".equals(item_name)){
			this.item_subname=ZhConvertSpell.converterToFirstSpell(item_name);
		}
	}

	public String getItem_subname() {
		return item_subname;
	}

	public void setItem_subname(String item_subname) {
		this.item_subname = item_subname;
	}



	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
