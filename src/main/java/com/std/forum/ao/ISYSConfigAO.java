package com.std.forum.ao;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.SYSConfig;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午4:02:23 
 * @history:
 */
public interface ISYSConfigAO {

    String DEFAULT_ORDER_COLUMN = "id";

    public Long addSYSConfig(SYSConfig data);

    public int editSYSConfig(SYSConfig data);

    public Paginable<SYSConfig> querySYSConfigPage(int start, int limit,
            SYSConfig condition);

    public SYSConfig getSYSConfig(Long id);

    public SYSConfig getConfigValue(String ckey);
}
