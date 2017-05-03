package com.estproject.service.uklink.thead;

import java.util.Map.Entry;

/***
 * 数据库同步执行方法
 * @author  YZH
 * @version 1.0
 * @date 2016年4月15日
 */
public interface ISyncData {
  void syncData(Entry<ChannTypeEnum, ISync> entry);
}
