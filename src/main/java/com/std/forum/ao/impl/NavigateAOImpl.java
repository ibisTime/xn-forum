package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.INavigateAO;
import com.std.forum.bo.INavigateBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Navigate;

/** 
 * @author: zuixian 
 * @since: 2016年9月14日 上午11:24:38 
 * @history:
 */
@Service
public class NavigateAOImpl implements INavigateAO {

    @Autowired
    private INavigateBO navigateBO;

    @Override
    public String addNavigate(Navigate data) {
        navigateBO.isExistNavigate(null, data.getTitle());
        return navigateBO.saveNavigate(data);
    }

    @Override
    public int editNavigate(Navigate data) {
        navigateBO.isExistNavigate(data.getCode(), data.getTitle());
        return navigateBO.refreshNavigate(data);
    }

    @Override
    public int removeNavigate(String code) {
        return navigateBO.deleteNavigate(code);
    }

    @Override
    public Paginable<Navigate> queryNavigatePage(int start, int limit,
            Navigate condition) {
        return navigateBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Navigate> queryNavigateList(Navigate condition) {
        return navigateBO.queryNavigateList(condition);
    }

    @Override
    public Navigate getNavigate(String code) {
        return navigateBO.getNavigate(code);
    }

}
