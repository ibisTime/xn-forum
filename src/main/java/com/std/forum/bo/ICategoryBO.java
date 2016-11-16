package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Category;

public interface ICategoryBO extends IPaginableBO<Category> {

    public boolean isCategoryExist(String code);

    public String saveCategory(Category data);

    public int removeCategory(String code);

    public int refreshCategory(Category data);

    public List<Category> queryCategoryList(Category condition);

    public Category getCategory(String code);
}
