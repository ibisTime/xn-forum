package com.std.forum;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.std.forum.common.PropertiesUtil;

public class ConfigServlet extends HttpServlet {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -7810670972793349913L;

    @Override
    public void init() throws ServletException {
        super.init();
        PropertiesUtil.init("/config.properties");
    }

}
