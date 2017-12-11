package com.ssm.service;

import java.util.List;

import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;

public interface ItemsService {
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
	public void deleteItems(Integer[] items_id) throws Exception;
	
}
