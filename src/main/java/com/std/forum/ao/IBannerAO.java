package com.std.forum.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Banner;

@Component
public interface IBannerAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void editBannerGlobal(String code, String name, String url,
            String pic, String location, String orderNo, String belong,
            String remark);

    public void editBannerLocal(String code, String name, String url,
            String pic, String location, String orderNo, String belong,
            String companyCode, String remark);

    public Paginable<Banner> queryBannerPage(int start, int limit,
            Banner condition);

    public List<Banner> queryBannerList(Banner condition);

    public Banner getBanner(String code);

}
