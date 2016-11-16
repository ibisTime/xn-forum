package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Category;

/**
 * @author: xieyj 
 * @since: 2016年11月16日 下午4:37:11 
 * @history:
 */
public interface ICategoryAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCategory(Category data);

    public void dropCategory(String code);

    public void editCategory(Category data);

    public Paginable<Category> queryCategoryPage(int start, int limit,
            Category condition);

    public List<Category> queryCategoryList(Category condition);

    public Category getCategory(String code);

}
