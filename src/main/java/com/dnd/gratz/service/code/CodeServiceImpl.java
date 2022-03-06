package com.dnd.gratz.service.code;

import com.dnd.gratz.db.entity.common.Code;
import com.dnd.gratz.repository.code.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    @Autowired
    CodeRepository codeRepository;

    @Override
    public List<Code> getCodeList(String commonCode) {
        return codeRepository.findByCommonCode(commonCode).get();
    }
}
