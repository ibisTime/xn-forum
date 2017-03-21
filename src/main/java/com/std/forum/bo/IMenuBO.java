package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Menu;



//CHECK ��鲢��ע�� 
public interface IMenuBO extends IPaginableBO<Menu> {


	public boolean isMenuExist(String code);


	public String saveMenu(Menu data);


	public int removeMenu(String code);


	public int refreshMenu(Menu data);


	public List<Menu> queryMenuList(Menu condition);


	public Menu getMenu(String code);


}