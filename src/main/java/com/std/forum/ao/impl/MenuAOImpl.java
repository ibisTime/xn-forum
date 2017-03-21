package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IMenuAO;
import com.std.forum.bo.IMenuBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Menu;
import com.std.forum.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class MenuAOImpl implements IMenuAO {

	@Autowired
	private IMenuBO menuBO;

	@Override
	public String addMenu(Menu data) {
		return menuBO.saveMenu(data);
	}

	@Override
	public int editMenu(Menu data) {
		if (!menuBO.isMenuExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return menuBO.refreshMenu(data);
	}

	@Override
	public int dropMenu(String code) {
		if (!menuBO.isMenuExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return menuBO.removeMenu(code);
	}

	@Override
	public Paginable<Menu> queryMenuPage(int start, int limit,
			Menu condition) {
		return menuBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Menu> queryMenuList(Menu condition) {
		return menuBO.queryMenuList(condition);
	}

	@Override
	public Menu getMenu(String code) {
		return menuBO.getMenu(code);
	}
}