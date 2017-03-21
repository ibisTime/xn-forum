package com.std.forum.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Banner;

@Component
public interface IBannerAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBanner(Banner data);

    public int dropBanner(String code);

    public int editBanner(Banner data);

    public Paginable<Banner> queryBannerPage(int start, int limit,
            Banner condition);

    public List<Banner> queryBannerList(Banner condition);

    public Banner getBanner(String code);

}
