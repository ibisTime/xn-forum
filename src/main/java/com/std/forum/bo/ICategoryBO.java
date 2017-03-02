package com.std.forum.bo;

import java.util.List;
import java.util.Map;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Category;

/**
 * @author: xieyj 
 * @since: 2016年11月17日 上午8:32:09 
 * @history:
 */
public interface ICategoryBO extends IPaginableBO<Category> {

    public boolean isCategoryExist(String code);

    public String saveCategory(Category data);

    public Map<String, String> saveDefaultCategory(List<Category> list,
            String companyCode);

    public int removeCategory(String code);

    public int refreshCategory(Category data);

    public List<Category> queryCategoryList(Category condition);

    public List<Category> queryCategoryList();

    public Category getCategory(String code);
}
