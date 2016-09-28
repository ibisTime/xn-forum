package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Navigate;

/** 
 * 导航BO
 * @author: zuixian 
 * @since: 2016年9月14日 上午10:54:31 
 * @history:
 */
public interface INavigateBO extends IPaginableBO<Navigate> {

    public void isExistNavigate(String code, String title, String siteCode);

    public String saveNavigate(Navigate data);

    public int refreshNavigate(Navigate data);

    public int deleteNavigate(String code);

    public List<Navigate> queryNavigateList(Navigate condition);

    public Navigate getNavigate(String code);
}
