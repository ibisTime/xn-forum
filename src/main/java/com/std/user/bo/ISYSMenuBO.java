package com.std.user.bo;

import java.util.List;

import com.std.user.bo.base.IPaginableBO;
import com.std.user.domain.SYSMenu;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月16日 下午7:48:35 
 * @history:
 */
public interface ISYSMenuBO extends IPaginableBO<SYSMenu> {
    public boolean isSYSMenuExist(String code);

    public int saveSYSMenu(SYSMenu data);

    public int removeSYSMenu(String code);

    public int refreshSYSMenu(SYSMenu data);

    public SYSMenu getSYSMenu(String code);

    public List<SYSMenu> querySYSMenuList(SYSMenu data);
}
