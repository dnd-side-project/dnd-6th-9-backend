package com.dnd.gratz.service.code;

import com.dnd.gratz.db.entity.common.Code;

import java.util.List;

public interface CodeService {
    List<Code> getCodeList(String commonCode);
}
