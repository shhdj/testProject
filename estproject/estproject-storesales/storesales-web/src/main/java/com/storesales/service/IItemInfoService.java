package com.storesales.service;

import java.util.List;


import com.storesales.query.model.ItemInfoQuery;
import com.storesales.query.model.SaleDataQuery;
import com.storesales.model.ItemInfo;
import com.storesales.model.SaleFlow;
import com.storesales.query.model.EditItemInfoParam;


public interface IItemInfoService {

	public List<ItemInfoQuery> getList();
	public List<SaleFlow> querySaleData(SaleDataQuery sale) ;
	
	public boolean update(EditItemInfoParam info);
	
	public boolean insert(ItemInfo info);
}
