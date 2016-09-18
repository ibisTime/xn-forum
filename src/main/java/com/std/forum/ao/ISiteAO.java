/**
 * @Title ISiteAO.java 
 * @Package com.std.forum.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:59:47 
 * @version V1.0   
 */
package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Site;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:59:47 
 * @history:
 */
public interface ISiteAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public String addSite(Site data);

    public int editSite(Site data);

    public Paginable<Site> querySitePage(int start, int limit, Site condition);

    public List<Site> querySiteList(Site condition);

    // 设置默认站点
    public int editSiteDef(String code);

    // 禁用站点
    public int editSitePri(String code);

    // 经纬度查询站点
    public Site getSiteByJW(Site condition);

    public Site getSite(String code);

}
