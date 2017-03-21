package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.IBannerDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Banner;

@Repository("bannerDAOImpl")
public class BannerDAOImpl extends AMybatisTemplate implements IBannerDAO {

    @Override
    public int insert(Banner data) {
        return super.insert(NAMESPACE.concat("insert_banner"), data);
    }

    @Override
    public int delete(Banner data) {
        return super.delete(NAMESPACE.concat("delete_banner"), data);
    }

    @Override
    public Banner select(Banner condition) {
        return super.select(NAMESPACE.concat("select_banner"), condition,
            Banner.class);
    }

    @Override
    public Long selectTotalCount(Banner condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_banner_count"),
            condition);
    }

    @Override
    public List<Banner> selectList(Banner condition) {
        return super.selectList(NAMESPACE.concat("select_banner"), condition,
            Banner.class);
    }

    @Override
    public List<Banner> selectList(Banner condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_banner"), start,
            count, condition, Banner.class);
    }

    @Override
    public int updateByGlobal(Banner data) {
        return super.update(NAMESPACE.concat("update_banner_byglobal"), data);
    }

    @Override
    public int updateByLocal(Banner data) {
        return super.update(NAMESPACE.concat("update_banner_bylocal"), data);
    }

}
