package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Menu;

public interface IMenuBO extends IPaginableBO<Menu> {

    public boolean isMenuExist(String code);

    public String saveMenu(String name, String pic, String orderNo,
            String belong, String companyCode, String remark);

    public int removeMenu(String code);

    public int refreshMenuByGlobal(String code, String name, String pic,
            String orderNo, String belong, String remark);

    public int refreshMenuByLocal(String code, String name, String pic,
            String orderNo, String remark);

    public List<Menu> queryMenuList(Menu condition);

    public List<Menu> queryMenuList(String companyCode);

    public List<Menu> queryBelongMenuList(String belong);

    public Menu getMenu(String code);

}
