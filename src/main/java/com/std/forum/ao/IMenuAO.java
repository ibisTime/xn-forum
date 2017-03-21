package com.std.forum.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Menu;

@Component
public interface IMenuAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addMenu(Menu data);

    public int dropMenu(String code);

    public int editMenu(Menu data);

    public Paginable<Menu> queryMenuPage(int start, int limit, Menu condition);

    public List<Menu> queryMenuList(Menu condition);

    public Menu getMenu(String code);

}
