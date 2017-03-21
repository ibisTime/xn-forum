package com.std.forum.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Menu;
import com.std.forum.dto.req.XN610080Req;
import com.std.forum.dto.req.XN610081Req;

@Component
public interface IMenuAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 总部修改菜单
     * @param req
     * @return 
     * @create: 2017年3月21日 下午1:54:40 asus
     * @history:
     */
    public void editMenuByGlobal(XN610080Req req);

    /**
     * 地方修改菜单
     * @param req
     * @return 
     * @create: 2017年3月21日 下午1:55:01 asus
     * @history:
     */
    public void editMenuByLocal(XN610081Req req);

    public Paginable<Menu> queryMenuPage(int start, int limit, Menu condition);

    public List<Menu> queryMenuList(String companyCode);

    public Menu getMenu(String code);

}
