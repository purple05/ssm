package com.ssm.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.mapper.ItemsMapper;
import com.ssm.mapper.ItemsMapperCustom;
import com.ssm.po.Items;
import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsDeleteVo;
import com.ssm.po.ItemsQueryVo;
import com.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	@Resource(name = "itemsMapperCustom")
	private ItemsMapperCustom itemsMapperCustom;

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		// 中间对商品信息进行业务处理
		// ....
		// 返回ItemsCustom
		ItemsCustom itemsCustom = new ItemsCustom();
		// 将items的属性值拷贝到itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);

		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		// 添加业务校验，通常在service接口对关键参数进行校验
		// 校验 id是否为空，如果为空抛出异常

		// 更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
		// updateByPrimaryKeyWithBLOBs要求必须转入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);

	}

	@Override
	public void deleteItems(Integer[] items_id) throws Exception {
		if(items_id.length == 0){
			return;
		}
		
		List<Integer> list = Arrays.asList(items_id);
		ItemsDeleteVo itemsDeleteVo = new ItemsDeleteVo();
		itemsDeleteVo.setIds(list);
		for (Integer integer : itemsDeleteVo.getIds()) {
			System.out.println(integer);
		}
		itemsMapper.deleteItems(itemsDeleteVo);
		
	}

}
