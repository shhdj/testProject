package com.estproject.service.goods.thead;

/**
 * 商品数据同步
 * @author  YZH
 * @version 1.0
 * @date 2016年4月15日
 */
public interface ISync {
   /***
    * 同步上下架状态
    * @param goodIds
    * @return
    */
   Result syncPutawayStatus(final String[] goodIds);
   /***
    * 同步删除状态
    * @param goodIds
    * @return
    */
   Result syncDeleteStatus(final String[] goodIds);
   
   /***
    * 同步商品信息
    * @param goodId
    * @return
    */
   Result  syncInfo(final String goodId);
}
