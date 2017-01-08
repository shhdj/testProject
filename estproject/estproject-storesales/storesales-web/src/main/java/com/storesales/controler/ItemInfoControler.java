package com.storesales.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.storesales.model.ItemInfo;
import com.storesales.model.SaleFlow;
import com.storesales.query.model.EditItemInfoParam;
import com.storesales.query.model.SaleDataQuery;
import com.storesales.service.IItemInfoService;
import com.storesales.tools.ResponseUtil;

@Controller
public class ItemInfoControler {

	@Autowired
	IItemInfoService itemInfoService;
	
	@RequestMapping("/editItemInfo")
	public void editItemInfo(HttpServletRequest request,HttpServletResponse response){
		String requestBody = request.getParameter("json");
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		EditItemInfoParam editItemInfoParam = gson.fromJson(requestBody, EditItemInfoParam.class);
		itemInfoService.update(editItemInfoParam);
	}
	
	@RequestMapping("/publishItem")
	public void publishItem(HttpServletRequest request,HttpServletResponse response){
		String requestBody = request.getParameter("json");
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		EditItemInfoParam editItemInfoParam = gson.fromJson(requestBody, EditItemInfoParam.class);
		ItemInfo ii = new ItemInfo();
		ii.setItem_name(editItemInfoParam.getItem_name());
		ii.setBarcode(editItemInfoParam.getBarcode());
		ii.setSale_price(editItemInfoParam.getSale_price());
		itemInfoService.insert(ii);
	}
	
	@RequestMapping("/synchronizeSaleData")
	public void synchronizeSaleData(HttpServletRequest request,HttpServletResponse response,
			@RequestBody String requestBody){
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		SaleDataQuery saleDataQuery = gson.fromJson(requestBody, SaleDataQuery.class);
		List<SaleFlow> list = itemInfoService.querySaleData(saleDataQuery);
		String json = gson.toJson(list);
		ResponseUtil.write(response, json);
	}
	
	
}
