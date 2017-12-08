package com.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;
@Repository("itemsMapperCustom")
public interface ItemsMapperCustom {
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}
