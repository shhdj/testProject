package com.storesales.service.implement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.storesales.dao.implement.ItemInfoDao;
import com.storesales.model.ItemInfo;
import com.storesales.model.Sale;
import com.storesales.model.SaleFlow;
import com.storesales.query.model.ItemInfoQuery;
import com.storesales.query.model.EditItemInfoParam;
import com.storesales.query.model.SaleDataQuery;
import com.storesales.service.IItemInfoService;
import com.storesales.tools.ConvertSqlTool;

@Service
public class ItemInfoServiceImpl implements IItemInfoService{

	@Resource(name="itemInfoDao")
	ItemInfoDao itemInfoDao;
	
	@Override
	public List<ItemInfoQuery> getList() {
		String sql="select b.item_no,b.item_subno,b.item_name from bi_t_item_info b";
		return itemInfoDao.queryList(sql, ItemInfoQuery.class);
	}
	
	@Override
	public List<SaleFlow> querySaleData(SaleDataQuery saledata) {
		Object[] arg = new Object[]{saledata.getStart_date(),saledata.getEnd_date()};
		String sql="select b.barcode,b.item_name,p.* from bi_t_item_info b,pos_t_saleflow p where b.item_no=p.item_no ";
		sql+=" and p.oper_date > ? and p.oper_date < ? ";
		return itemInfoDao.queryList(sql, arg,SaleFlow.class);
	}
	
	public boolean insert(ItemInfo info){
		String barsql = "select barcode from bi_t_item_info where barcode='"+info.getBarcode()+"'";
		List<String> barlist = this.itemInfoDao.queryList(barsql, String.class);
		if(barlist.size()>0){
			return false;
		}
		Long mill= System.currentTimeMillis();
		String millstring = mill.toString();
		int len = millstring.length();
		if(len>13){
			millstring= millstring.substring(len-13, len);
		}
		info.setItem_no(millstring);
		info.setItem_subno(millstring.substring(len-6, len));
		StringBuilder sql = new StringBuilder("insert into bi_t_item_info(");
		sql.append(ConvertSqlTool.getFieldsString(ItemInfo.class));
		sql.append(") values ( ");
		sql.append(ConvertSqlTool.getFieldsAlias(ItemInfo.class));
		sql.append(")");
		Map param = null;
		try {
			param = ConvertSqlTool.getFileValue(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.itemInfoDao.insert(sql.toString(), param);  
		return true;
	}
	
	public boolean update(EditItemInfoParam info){
		if(StringUtils.isBlank(info.getBarcode())){
			return false;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("update bi_t_item_info set " );
		Map<Integer, Object> param = new HashMap<Integer,Object>();
		int count = 1;
		if(StringUtils.isNotBlank(info.getItem_name())){
			sb.append(" item_name = ? ");
			param.put(count++, info.getItem_name());
		}
		if(StringUtils.isNotBlank(info.getItem_subname())){
			if(count>1)
				sb.append(",");
			sb.append(" item_subname = ? ");
			param.put(count++, info.getItem_subname());
		}
		if(info.getSale_price()!=null){
			if(count>1)
				sb.append(",");
			sb.append(" sale_price = ? ");
			param.put(count++, info.getSale_price());
		}
		if(info.getPrice()!=null){
			if(count>1)
				sb.append(",");
			sb.append(" price = ? ");
			param.put(count++, info.getPrice());
		}
		sb.append(" where barcode = ?");
		param.put(count, info.getBarcode());
		itemInfoDao.update(sb.toString(), param);
		return true;
	}

	
}
