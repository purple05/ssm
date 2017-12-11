package com.ssm.mapper;

import com.ssm.po.Items;
import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsDeleteVo;

public interface ItemsMapper {

	Items selectByPrimaryKey(Integer id) throws Exception;

	void updateByPrimaryKeyWithBLOBs(ItemsCustom itemsCustom) throws Exception;
	
	public void deleteItems(ItemsDeleteVo itemsDeleteVo) throws Exception;
}
