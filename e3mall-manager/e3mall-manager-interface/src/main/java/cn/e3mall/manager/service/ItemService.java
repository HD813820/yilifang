package cn.e3mall.manager.service;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.utils.PageBeanResult;

public interface ItemService {
	public abstract TbItem getItemById(Long id);
	public abstract PageBeanResult pageList(Integer page,Integer rows);
}
