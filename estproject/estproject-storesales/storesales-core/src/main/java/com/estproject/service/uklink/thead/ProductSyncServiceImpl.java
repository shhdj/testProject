package com.estproject.service.uklink.thead;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.etong.app.abstacts.AbstractService;
import com.etong.commons.command.Result;
import com.etong.commons.command.support.ResultSupport;
import com.etong.framework.util.CollectionUtils;
import com.etong.framework.util.DispatchUtils;
import com.etong.framework.util.ObjectUtils;
import com.etong.framework.util.thread.ThreadUtil;
import com.etong.framework.util.thread.iface.IRun;
import com.etong.product.common.annotation.Sync;
import com.etong.product.common.constant.ProdeuctEnum.ChannTypeEnum;
import com.etong.product.common.service.ProductSyncService;
import com.etong.product.core.service.impl.sync.iface.ISync;
import com.etong.product.core.service.impl.sync.iface.ISyncData;

/****
 * 商品同步impl
 * @author  YZH
 * @version 1.0
 * @date 2016年4月15日
 */
@Service("productSyncService")
public class ProductSyncServiceImpl extends AbstractService implements ProductSyncService {

	@Override
	public Result syncPutawayStatus(final String[] goodIds) {
		Result _result = new ResultSupport();
		this.execute(new ISyncData() {
			@Override
			public void syncData(Entry<ChannTypeEnum, ISync> entry) {
				entry.getValue().syncPutawayStatus(goodIds);
			}
		});
		return _result;
	}

	@Override
	public Result syncDeleteStatus(final String[] goodIds) {
		Result _result = new ResultSupport();
		this.execute(new ISyncData() {
			@Override
			public void syncData(Entry<ChannTypeEnum, ISync> entry) {
				entry.getValue().syncDeleteStatus(goodIds);
			}
		});
		return _result;
	}

	@Override
	public Result syncInfo(final String goodId) {
		Result _result = new ResultSupport();
		this.execute(new ISyncData() {
			@Override
			public void syncData(Entry<ChannTypeEnum, ISync> entry) {
				entry.getValue().syncInfo(goodId);
			}
		});
		return _result;
	}
	
	
	private void execute(final ISyncData iSyncData){
		try {
			ThreadUtil.execute(new IRun() {
				@Override
				public void execute() {
					
				   try {
						Thread.sleep(15000);
						Map<ChannTypeEnum, ISync> _syncs = DispatchUtils.getImpls(Sync.class);
						if (!CollectionUtils.isEmpty(_syncs)) {
							for (final Entry<ChannTypeEnum, ISync> _sync : _syncs.entrySet()) {
								if (ObjectUtils.isEmpty(_sync)) {
									continue;
								}
								
								try {
									ThreadUtil.execute(new IRun() {
										@Override
										public void execute() {
											iSyncData.syncData(_sync);
										}
									});
								} catch (Exception e) {
									logger.error(e.getMessage());
								}
								
	
							}
						}
					} catch (Exception e) {
						logger.error(e.getMessage());
					}
                  
                  
				}
			});
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	

}
