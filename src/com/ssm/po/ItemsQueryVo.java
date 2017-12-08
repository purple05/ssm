package com.ssm.po;

public class ItemsQueryVo {
	// 商品信息
	private Items items;
	// 为了系统 可扩展性，对原始生成的po进行扩展
	private ItemsCustom itemsCustom;
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	
	public ItemsQueryVo() {
		// TODO Auto-generated constructor stub
	}
	public ItemsQueryVo(Items items, ItemsCustom itemsCustom) {
		super();
		this.items = items;
		this.itemsCustom = itemsCustom;
	}
	@Override
	public String toString() {
		return "ItemsQueryVo [items=" + items + ", itemsCustom=" + itemsCustom + "]";
	}
	
}
