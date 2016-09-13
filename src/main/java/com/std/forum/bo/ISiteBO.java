/**
 * @Title ISiteBO.java 
 * @Package com.std.forum.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:21:32 
 * @version V1.0   
 */
package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Site;

/** 
 * 站点
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:21:32 
 * @history:
 */
public interface ISiteBO extends IPaginableBO<Site> {

    public void isExistSite(String name);

    public String saveSite(Site data);

    public int refreshSite(Site data);

    public Site getSite(String code);

    public List<Site> querySiteList(Site condition);
}
