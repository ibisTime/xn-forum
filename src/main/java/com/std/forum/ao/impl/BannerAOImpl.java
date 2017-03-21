package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IBannerAO;
import com.std.forum.bo.IBannerBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Banner;
import com.std.forum.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class BannerAOImpl implements IBannerAO {

	@Autowired
	private IBannerBO bannerBO;

	@Override
	public String addBanner(Banner data) {
		return bannerBO.saveBanner(data);
	}

	@Override
	public int editBanner(Banner data) {
		if (!bannerBO.isBannerExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return bannerBO.refreshBanner(data);
	}

	@Override
	public int dropBanner(String code) {
		if (!bannerBO.isBannerExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return bannerBO.removeBanner(code);
	}

	@Override
	public Paginable<Banner> queryBannerPage(int start, int limit,
			Banner condition) {
		return bannerBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Banner> queryBannerList(Banner condition) {
		return bannerBO.queryBannerList(condition);
	}

	@Override
	public Banner getBanner(String code) {
		return bannerBO.getBanner(code);
	}
}