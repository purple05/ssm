package com.ssm.po;

import java.util.List;

public class ItemsDeleteVo {
	
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	public ItemsDeleteVo() {
		// TODO Auto-generated constructor stub
	}

	public ItemsDeleteVo(List<Integer> ids) {
		super();
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "ItemsDeleteVo [ids=" + ids + "]";
	}
	
	
	
	
	
}
