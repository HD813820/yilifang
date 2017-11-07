package cn.e3mall.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.manager.service.ItemCatService;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.utils.EasyNoteTreeUtils;

public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Override
	public List<EasyNoteTreeUtils> getItemCatTree(Long parentId) {
		// TODO Auto-generated method stub
		TbItemCatExample example = new  TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<EasyNoteTreeUtils> list = new ArrayList<EasyNoteTreeUtils>();
		
		List<TbItemCat> tbItemCatList = tbItemCatMapper.selectByExample(example);
		for (TbItemCat tbItemCat : tbItemCatList) {
			EasyNoteTreeUtils easyNoteTreeUtils = new EasyNoteTreeUtils();
			
			easyNoteTreeUtils.setId(tbItemCat.getId());
			easyNoteTreeUtils.setText(tbItemCat.getName());
			easyNoteTreeUtils.setState(tbItemCat.getIsParent()?"closed":"open");
			
			list.add(easyNoteTreeUtils);
		}
		
		return list;
	}

}
