package com.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;
import com.ssm.service.ItemsService;

@Controller
public class ItemsController {
	@Resource(name="itemsService")
	private ItemsService itemsService;
	
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception{
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	
	@RequestMapping("/editItems")
	public ModelAndView editItems(HttpServletRequest request)throws Exception {
		
//		获取请求提交的id值
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		//调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		//将商品信息放到model
		modelAndView.addObject("itemsCustom", itemsCustom);
		
		//商品修改页面
		modelAndView.setViewName("items/editItems");
		
		return modelAndView;
	}
	
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Integer id,
			ItemsCustom itemsCustom,MultipartFile items_pic)
			throws Exception {
		
//		文件上传处理
		String OriginalFilename = items_pic.getOriginalFilename();
		
		System.out.println(OriginalFilename);
		if(items_pic != null && OriginalFilename != null && OriginalFilename.length()>0 ){
			
			String pic_path = "E:/img_up/";
			
			String newFileName = UUID.randomUUID().toString()+OriginalFilename;
			
			File newFile = new File(pic_path+newFileName);
			
			items_pic.transferTo(newFile);
			
			itemsCustom.setPic(newFileName);
			
		}
		
		//调用service更新商品信息，页面需要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);
		
		//重定向到商品查询列表
//		return "redirect:queryItems.action";
		//页面转发
		//return "forward:queryItems.action";
		return "forward:queryItems.action";
	}
	
	@RequestMapping("deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		itemsService.deleteItems(items_id);
		return "forward:queryItems.action";
	}
	
	
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(ItemsQueryVo itemsQueryVo) throws Exception{
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList_edit", itemsList);
		modelAndView.setViewName("items/editItemsQuery");
		return modelAndView;
	}
	
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
		List<ItemsCustom> itemsList = itemsQueryVo.getItemsList();
		for (ItemsCustom itemsCustom : itemsList) {
			System.out.println(itemsCustom);
		}
		itemsService.updateItems2(itemsQueryVo);
		return "forward:editItemsQuery.action";
	}
	
	
}
