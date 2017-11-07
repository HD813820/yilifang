package cn.e3mall.manager.service;

import java.util.List;

import cn.e3mall.utils.EasyNoteTreeUtils;

public interface ItemCatService {
	public abstract List<EasyNoteTreeUtils> getItemCatTree(Long parentId);
}
