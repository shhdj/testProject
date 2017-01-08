package com.storesales.query.model;

import java.io.Serializable;

import com.storesales.tools.ZhConvertSpell;

public class ItemInfoQuery implements Serializable {

private String item_no;
	
	private String item_subno;
	
	private String item_name;

	private String item_subname;
	
	private Integer sale_price;
	
	
	
	
	public Integer getSale_price() {
		return sale_price;
	}

	public void setSale_price(Integer sale_price) {
		this.sale_price = sale_price;
	}

	public String getItem_subname() {
		return item_subname;
	}

	public void setItem_subname(String item_subname) {
		this.item_subname = item_subname;
	}

	public String getItem_no() {
		return item_no;
	}

	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}


	public String getItem_subno() {
		return item_subno;
	}

	public void setItem_subno(String item_subno) {
		this.item_subno = item_subno;
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

	
}
