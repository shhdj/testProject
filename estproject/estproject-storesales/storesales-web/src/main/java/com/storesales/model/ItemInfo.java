package com.storesales.model;

import java.io.Serializable;


import java.util.Date;

import com.storesales.tools.ZhConvertSpell;

public class ItemInfo implements Serializable {

	
	private String item_no;
	
	private String barcode;
	
	private Double sale_price;
//	
//	
//	
	private String item_subno;
//	
	private String item_name;
//
	private String item_subname;
//	
	private String unit_no="个";
	
	private String item_size;//
	
	private String product_area;//
	
	private String item_other1;//
	
	private String item_other2;//
	
	private String item_other3;//
	
	
	private String item_clsno="01";
	
	private String item_brand="00";
	
	private String item_brandname="00";
	

	
	private Double price=0.0000d;
	
	private Double base_price=0.0000d;
	
	private String combine_sta="0";
	
	private String display_flag="2";

	
	private String sup_no="0";
	
	private String have_stock="1";
	
	private String allow_discount="1";
	
	private String change_price="1";
	
	private String item_flag="0";
	
	private Double integral_rate=-1.0000d;
	
	private String data_lock="0";
	
	private Double vip_price=0.0000d;
	
	private String counter_code="0";
	
	private Date update_time=new Date();
	
	private Double item_num1=0.0000d;
	
	private Double item_num2=0.0000d;
	
	private Double item_num3=0.0000d;
	
	private Double max_change=16d;
	
	private Double max_pos=2d;
	
	private Double base_price2=0.0000d;
	
	private Double base_price3=0.0000d;
	
	private Double base_price4=0.0000d;
	
	private Double base_price5=0.0000d;
	
	private Double vip_price2=0.0000d;
	
	private Double vip_price3=0.0000d;
	private Double valid_day=0.0000d;
	
	private String abc="A";
	private String sn_flag="0";
	
	private String sale_no="A";
	
	private Double ly_kl=0.0000d;
	
	private String cost_type="A";
	
	

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
		if(item_name!=null&&!"".equals(item_name)){
			this.item_subname=ZhConvertSpell.converterToFirstSpell(item_name);
		}
	}
	

	public String getItem_no() {
		return item_no;
	}

	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Double getSale_price() {
		return sale_price;
	}

	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}

	public String getItem_subno() {
		return item_subno;
	}

	public void setItem_subno(String item_subno) {
		this.item_subno = item_subno;
	}

	public String getUnit_no() {
		return unit_no;
	}

	public void setUnit_no(String unit_no) {
		this.unit_no = unit_no;
	}

	public String getItem_size() {
		return item_size;
	}

	public void setItem_size(String item_size) {
		this.item_size = item_size;
	}

	public String getProduct_area() {
		return product_area;
	}

	public void setProduct_area(String product_area) {
		this.product_area = product_area;
	}

	public String getItem_other1() {
		return item_other1;
	}

	public void setItem_other1(String item_other1) {
		this.item_other1 = item_other1;
	}

	public String getItem_other2() {
		return item_other2;
	}

	public void setItem_other2(String item_other2) {
		this.item_other2 = item_other2;
	}

	public String getItem_other3() {
		return item_other3;
	}

	public void setItem_other3(String item_other3) {
		this.item_other3 = item_other3;
	}

	public String getItem_subname() {
		return item_subname;
	}

	public void setItem_subname(String item_subname) {
		this.item_subname = item_subname;
	}

	public String getItem_clsno() {
		return item_clsno;
	}

	public void setItem_clsno(String item_clsno) {
		this.item_clsno = item_clsno;
	}

	public String getItem_brand() {
		return item_brand;
	}

	public void setItem_brand(String item_brand) {
		this.item_brand = item_brand;
	}

	public String getItem_brandname() {
		return item_brandname;
	}

	public void setItem_brandname(String item_brandname) {
		this.item_brandname = item_brandname;
	}

	


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getBase_price() {
		return base_price;
	}

	public void setBase_price(Double base_price) {
		this.base_price = base_price;
	}


	public String getCombine_sta() {
		return combine_sta;
	}

	public void setCombine_sta(String combine_sta) {
		this.combine_sta = combine_sta;
	}

	public String getDisplay_flag() {
		return display_flag;
	}

	public void setDisplay_flag(String display_flag) {
		this.display_flag = display_flag;
	}

	public String getSup_no() {
		return sup_no;
	}

	public void setSup_no(String sup_no) {
		this.sup_no = sup_no;
	}

	public String getHave_stock() {
		return have_stock;
	}

	public void setHave_stock(String have_stock) {
		this.have_stock = have_stock;
	}

	public String getAllow_discount() {
		return allow_discount;
	}

	public void setAllow_discount(String allow_discount) {
		this.allow_discount = allow_discount;
	}

	public String getChange_price() {
		return change_price;
	}

	public void setChange_price(String change_price) {
		this.change_price = change_price;
	}

	public String getItem_flag() {
		return item_flag;
	}

	public void setItem_flag(String item_flag) {
		this.item_flag = item_flag;
	}

	public Double getIntegral_rate() {
		return integral_rate;
	}

	public void setIntegral_rate(Double integral_rate) {
		this.integral_rate = integral_rate;
	}

	public String getData_lock() {
		return data_lock;
	}

	public void setData_lock(String data_lock) {
		this.data_lock = data_lock;
	}

	public Double getVip_price() {
		return vip_price;
	}

	public void setVip_price(Double vip_price) {
		this.vip_price = vip_price;
	}

	public String getCounter_code() {
		return counter_code;
	}

	public void setCounter_code(String counter_code) {
		this.counter_code = counter_code;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Double getItem_num1() {
		return item_num1;
	}

	public void setItem_num1(Double item_num1) {
		this.item_num1 = item_num1;
	}

	public Double getItem_num2() {
		return item_num2;
	}

	public void setItem_num2(Double item_num2) {
		this.item_num2 = item_num2;
	}

	public Double getItem_num3() {
		return item_num3;
	}

	public void setItem_num3(Double item_num3) {
		this.item_num3 = item_num3;
	}

	public Double getMax_change() {
		return max_change;
	}

	public void setMax_change(Double max_change) {
		this.max_change = max_change;
	}

	public Double getMax_pos() {
		return max_pos;
	}

	public void setMax_pos(Double max_pos) {
		this.max_pos = max_pos;
	}


	public Double getBase_price2() {
		return base_price2;
	}

	public void setBase_price2(Double base_price2) {
		this.base_price2 = base_price2;
	}

	public Double getBase_price3() {
		return base_price3;
	}

	public void setBase_price3(Double base_price3) {
		this.base_price3 = base_price3;
	}

	public Double getBase_price4() {
		return base_price4;
	}

	public void setBase_price4(Double base_price4) {
		this.base_price4 = base_price4;
	}

	public Double getBase_price5() {
		return base_price5;
	}

	public void setBase_price5(Double base_price5) {
		this.base_price5 = base_price5;
	}

	public Double getVip_price2() {
		return vip_price2;
	}

	public void setVip_price2(Double vip_price2) {
		this.vip_price2 = vip_price2;
	}

	public Double getVip_price3() {
		return vip_price3;
	}

	public void setVip_price3(Double vip_price3) {
		this.vip_price3 = vip_price3;
	}

	public Double getValid_day() {
		return valid_day;
	}

	public void setValid_day(Double valid_day) {
		this.valid_day = valid_day;
	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}

	public String getSn_flag() {
		return sn_flag;
	}

	public void setSn_flag(String sn_flag) {
		this.sn_flag = sn_flag;
	}

	public String getSale_no() {
		return sale_no;
	}

	public void setSale_no(String sale_no) {
		this.sale_no = sale_no;
	}

	public Double getLy_kl() {
		return ly_kl;
	}

	public void setLy_kl(Double ly_kl) {
		this.ly_kl = ly_kl;
	}

	public String getCost_type() {
		return cost_type;
	}

	public void setCost_type(String cost_type) {
		this.cost_type = cost_type;
	}

	
}
