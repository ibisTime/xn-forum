package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IMenuAO;
import com.std.forum.bo.IMenuBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Menu;
import com.std.forum.dto.req.XN610080Req;
import com.std.forum.dto.req.XN610081Req;
import com.std.forum.enums.EBelong;
import com.std.forum.exception.BizException;

@Service
public class MenuAOImpl implements IMenuAO {

    @Autowired
    private IMenuBO menuBO;

    @Override
    public String addMenu(Menu data) {
        return menuBO.saveMenu(data.getName(), data.getPic(),
            data.getOrderNo(), data.getBelong(), data.getCompanyCode(),
            data.getRemark());
    }

    @Override
    public void editMenu(XN610080Req req) {
        if (!EBelong.getBelongMap().containsKey(req.getBelong())) {
            throw new BizException("xn0000", "属于不允许自定义");
        }
        Menu menu = menuBO.getMenu(req.getCode());
        if (EBelong.GLOBAL.getCode().equals(menu.getBelong())
                || EBelong.LOCAL.getCode().equals(menu.getBelong())) {
            menuBO.refreshMenu(req.getCode(), req.getName(), req.getPic(),
                req.getOrderNo(), req.getBelong(), req.getRemark());
        } else {
            throw new BizException("xn0000", "地方性菜单，不可修改");
        }
    }

    @Override
    public void editMenu(XN610081Req req) {
        Menu menu = menuBO.getMenu(req.getCode());
        if (EBelong.LOCAL.getCode().equals(menu.getBelong())) {
            menuBO.saveMenu(req.getName(), req.getPic(), req.getOrderNo(),
                req.getCode(), req.getCompanyCode(), req.getRemark());
        } else if (EBelong.GLOBAL.getCode().equals(menu.getBelong())) {
            throw new BizException("xn0000", "总部菜单，地方不可修改");
        } else {//
            menuBO.refreshMenu(req.getCode(), req.getName(), req.getPic(),
                req.getOrderNo(), req.getBelong(), req.getCompanyCode(),
                req.getRemark());
        }
    }

    @Override
    public int dropMenu(String code) {
        if (!menuBO.isMenuExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return menuBO.removeMenu(code);
    }

    @Override
    public Paginable<Menu> queryMenuPage(int start, int limit, Menu condition) {
        return menuBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Menu> queryMenuList(Menu condition) {
        return menuBO.queryMenuList(condition);
    }

    @Override
    public List<Menu> queryMenuList(String companyCode) {
        List<Menu> menulist = menuBO.queryMenuList(EBelong.GLOBAL.getCode());
        List<Menu> menuList = menuBO.queryMenuList(companyCode);
        for (Menu menu : menulist) {
            for (Menu data : menuList) {
                if (menu.getOrderNo().equals(data.getOrderNo())) {
                    menu.setMenu(data);
                    break;
                }
            }
        }
        return menuList;
    }

    @Override
    public Menu getMenu(String code) {
        return menuBO.getMenu(code);
    }

}
