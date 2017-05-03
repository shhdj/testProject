package com.estproject.service.goods.thead;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;


/****
 * 商品同步impl
 * @author  YZH
 * @version 1.0
 * @date 2016年4月15日
 */
@Service("productSyncService")
public class ProductSyncServiceImpl{
//		extends AbstractService implements ProductSyncService {
//
//	@Override
//	public Result syncPutawayStatus(final String[] goodIds) {
//		Result _result = new ResultSupport();
//		this.execute(new ISyncData() {
//			@Override
//			public void syncData(Entry<ChannTypeEnum, ISync> entry) {
//				entry.getValue().syncPutawayStatus(goodIds);
//			}
//		});
//		return _result;
//	}
//
//	@Override
//	public Result syncDeleteStatus(final String[] goodIds) {
//		Result _result = new ResultSupport();
//		this.execute(new ISyncData() {
//			@Override
//			public void syncData(Entry<ChannTypeEnum, ISync> entry) {
//				entry.getValue().syncDeleteStatus(goodIds);
//			}
//		});
//		return _result;
//	}
//
//	@Override
//	public Result syncInfo(final String goodId) {
//		Result _result = new ResultSupport();
//		this.execute(new ISyncData() {
//			@Override
//			public void syncData(Entry<ChannTypeEnum, ISync> entry) {
//				entry.getValue().syncInfo(goodId);
//			}
//		});
//		return _result;
//	}
//
//
//	private void execute(final ISyncData iSyncData){
//		try {
//			ThreadUtil.execute(new IRun() {
//				@Override
//				public void execute() {
//
//				   try {
//						Thread.sleep(15000);
//						Map<ChannTypeEnum, ISync> _syncs = DispatchUtils.getImpls(Sync.class);
//						if (!CollectionUtils.isEmpty(_syncs)) {
//							for (final Entry<ChannTypeEnum, ISync> _sync : _syncs.entrySet()) {
//								if (ObjectUtils.isEmpty(_sync)) {
//									continue;
//								}
//
//								try {
//									ThreadUtil.execute(new IRun() {
//										@Override
//										public void execute() {
//											iSyncData.syncData(_sync);
//										}
//									});
//								} catch (Exception e) {
//									logger.error(e.getMessage());
//								}
//
//
//							}
//						}
//					} catch (Exception e) {
//						logger.error(e.getMessage());
//					}
//
//
//				}
//			});
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
//	}
	
	

}
