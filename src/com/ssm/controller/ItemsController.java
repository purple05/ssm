package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.po.ItemsCustom;
import com.ssm.service.ItemsService;

@Controller
public class ItemsController {
	@Resource(name="itemsService")
	private ItemsService itemsService;
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception{
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
}
