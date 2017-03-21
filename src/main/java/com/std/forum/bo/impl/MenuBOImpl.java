package com.std.forum.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IMenuBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IMenuDAO;
import com.std.forum.domain.Menu;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

@Component
public class MenuBOImpl extends PaginableBOImpl<Menu> implements IMenuBO {

    @Autowired
    private IMenuDAO menuDAO;

    @Override
    public boolean isMenuExist(String code) {
        Menu condition = new Menu();
        condition.setCode(code);
        if (menuDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveMenu(String name, String pic, String orderNo,
            String belong, String companyCode, String remark) {
        Menu data = new Menu();
        String code = OrderNoGenerater.generateME(EPrefixCode.MENU.getCode());
        data.setCode(code);
        data.setName(name);
        data.setPic(pic);
        data.setOrderNo(orderNo);
        data.setBelong(belong);
        data.setCompanyCode(companyCode);
        data.setRemark(remark);
        menuDAO.insert(data);
        return code;
    }

    @Override
    public int removeMenu(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Menu data = new Menu();
            data.setCode(code);
            count = menuDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshMenu(String code, String name, String pic,
            String orderNo, String belong, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Menu data = new Menu();
            data.setCode(code);
            data.setName(name);
            data.setPic(pic);
            data.setOrderNo(orderNo);
            data.setBelong(belong);
            data.setRemark(remark);
            count = menuDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Menu> queryMenuList(Menu condition) {
        return menuDAO.selectList(condition);
    }

    @Override
    public List<Menu> queryMenuList(String companyCode) {
        Menu condition = new Menu();
        condition.setCompanyCode(companyCode);
        return menuDAO.selectList(condition);
    }

    @Override
    public List<Menu> queryBelongMenuList(String belong) {
        Menu condition = new Menu();
        condition.setBelong(belong);
        return menuDAO.selectList(condition);
    }

    @Override
    public Menu getMenu(String code) {
        Menu data = null;
        if (StringUtils.isNotBlank(code)) {
            Menu condition = new Menu();
            condition.setCode(code);
            data = menuDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "菜单编号不存在");
            }
        }
        return data;
    }

}
