package com.storesales.model;

import java.util.Date;

public class SaleFlow {

	private String barcode;
	
	private String item_name;
	
	private Integer flow_id;
	
	private String flow_no;
	
	private String branch_no;
	
	private String item_no;
	
	private Double source_price;
	
	private Double sale_price;
	
	private Double sale_qnty;
	
	private Double sale_money;
	
	private String sell_way;
	
	private String oper_id;
	
	private String sale_man;
	
//	private String counter_no;
	
	private Date  oper_date;
	
	private Double sale_notax;

	
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(Integer flow_id) {
		this.flow_id = flow_id;
	}

	public String getFlow_no() {
		return flow_no;
	}

	public void setFlow_no(String flow_no) {
		this.flow_no = flow_no;
	}

	public String getBranch_no() {
		return branch_no;
	}

	public void setBranch_no(String branch_no) {
		this.branch_no = branch_no;
	}

	public String getItem_no() {
		return item_no;
	}

	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}

	public Double getSource_price() {
		return source_price;
	}

	public void setSource_price(Double source_price) {
		this.source_price = source_price;
	}

	public Double getSale_price() {
		return sale_price;
	}

	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}

	public Double getSale_qnty() {
		return sale_qnty;
	}

	public void setSale_qnty(Double sale_qnty) {
		this.sale_qnty = sale_qnty;
	}

	public Double getSale_money() {
		return sale_money;
	}

	public void setSale_money(Double sale_money) {
		this.sale_money = sale_money;
	}

	public String getSell_way() {
		return sell_way;
	}

	public void setSell_way(String sell_way) {
		this.sell_way = sell_way;
	}

	public String getOper_id() {
		return oper_id;
	}

	public void setOper_id(String oper_id) {
		this.oper_id = oper_id;
	}

	public String getSale_man() {
		return sale_man;
	}

	public void setSale_man(String sale_man) {
		this.sale_man = sale_man;
	}

	public Date getOper_date() {
		return oper_date;
	}

	public void setOper_date(Date oper_date) {
		this.oper_date = oper_date;
	}

	public Double getSale_notax() {
		return sale_notax;
	}

	public void setSale_notax(Double sale_notax) {
		this.sale_notax = sale_notax;
	}
	
	
}
