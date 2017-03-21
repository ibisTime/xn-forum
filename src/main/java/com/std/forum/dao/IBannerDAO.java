package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Banner;

//dao层 
public interface IBannerDAO extends IBaseDAO<Banner> {
    String NAMESPACE = IBannerDAO.class.getName().concat(".");

    public int updateByGlobal(Banner data);

    public int updateByLocal(Banner data);
}
