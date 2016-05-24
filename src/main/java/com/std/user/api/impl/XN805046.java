package com.std.user.api.impl;

import com.std.user.ao.IUserAO;
import com.std.user.api.AProcessor;
import com.std.user.common.IdCardChecker;
import com.std.user.common.JsonUtil;
import com.std.user.core.StringValidater;
import com.std.user.dto.req.XN805046Req;
import com.std.user.dto.res.XN805046Res;
import com.std.user.enums.EIDKind;
import com.std.user.exception.BizException;
import com.std.user.exception.ParaException;
import com.std.user.spring.SpringContextHolder;

/**
 * 实名认证+设置交易密码
 * @author: myb858 
 * @since: 2016年1月28日 下午3:33:40 
 * @history:
 */
public class XN805046 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN805046Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userAO.doIdentifySetTradePwd(req.getUserId(), req.getIdKind(),
            req.getIdNo(), req.getRealName(), req.getTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha());
        return new XN805046Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805046Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getIdKind(),
            req.getIdNo(), req.getRealName(), req.getTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha());
        if (!EIDKind.IDCard.getCode().equalsIgnoreCase(req.getIdKind())) {
            throw new BizException("xn702000", "证件类型暂只支持身份证");
        }
        // 验证身份证号是否正确
        IdCardChecker idCardChecker = new IdCardChecker(req.getIdNo());
        if (!idCardChecker.validate()) {
            throw new BizException("xn702000", "身份证号格式不正确");
        }

    }

}
