package com.std.forum.bo;

import com.std.forum.enums.ERuleKind;
import com.std.forum.enums.ERuleType;

public interface IRuleBO {
    public Long getAmountByRule(ERuleKind kind, ERuleType type, String level);
}
