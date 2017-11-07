package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.manager.service.ItemService;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.utils.PageBeanResult;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/findItem/{itemId}")
	@ResponseBody
	public TbItem findItem(@PathVariable Long itemId) {
		TbItem item = itemService.getItemById(itemId);
		return item;
	}

	@RequestMapping("/list")
	@ResponseBody
	public PageBeanResult itemList(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "20") Integer rows) {
		
		PageBeanResult pageList = itemService.pageList(page, rows);
		return pageList;
	}
}
