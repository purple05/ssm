package com.ssm.mapper;

import com.ssm.po.Items;
import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsDeleteVo;
import com.ssm.po.ItemsQueryVo;

public interface ItemsMapper {

	Items selectByPrimaryKey(Integer id) throws Exception;

	void updateByPrimaryKeyWithBLOBs(ItemsCustom itemsCustom) throws Exception;
	
	public void deleteItems(ItemsDeleteVo itemsDeleteVo) throws Exception;
	
	public void updateItems2(ItemsQueryVo itemsQueryVo) throws Exception;
}
