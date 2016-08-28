package com.std.forum.api.impl;

import com.std.forum.api.AProcessor;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;

public class XNOther extends AProcessor {

    @Override
    public Object doBusiness() throws BizException {
        throw new BizException("702xxx", "无效API功能号");
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        throw new ParaException("702xxx", "无效API功能号");

    }

}
