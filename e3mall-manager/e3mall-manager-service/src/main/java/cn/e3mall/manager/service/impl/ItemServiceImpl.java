package cn.e3mall.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.manager.service.ItemService;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.utils.PageBeanResult;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public TbItem getItemById(Long id) {
		// TODO Auto-generated method stub
		return tbItemMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public PageBeanResult pageList(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		
		List<TbItem> list = tbItemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		
		PageBeanResult pageBeanResult = new PageBeanResult();
		pageBeanResult.setTotal(pageInfo.getTotal());
		pageBeanResult.setRows(list);
		
		return pageBeanResult;
	}

}
