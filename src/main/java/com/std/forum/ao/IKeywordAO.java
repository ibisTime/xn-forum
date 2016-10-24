package com.std.forum.ao;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Keyword;

public interface IKeywordAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addKeyword(Keyword data);

    public void dropKeyword(String code);

    public void editKeyword(Keyword data);

    public Paginable<Keyword> queryKeywordPage(int start, int limit,
            Keyword condition);

    public Keyword getKeyword(String code);

}
