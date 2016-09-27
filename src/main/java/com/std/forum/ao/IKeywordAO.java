package com.std.forum.ao;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Keyword;

public interface IKeywordAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addKeyword(String word);

    public int dropKeyword(String code);

    public int editKeyword(String code, String word);

    public Paginable<Keyword> queryKeywordPage(int start, int limit,
            Keyword condition);

    public Keyword getKeyword(String code);

}
