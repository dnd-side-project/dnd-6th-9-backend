package com.dnd.gratz.repository.code;

import com.dnd.gratz.db.entity.common.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CodeRepository extends JpaRepository<Code, String> {
    Optional<List<Code>> findByCommonCode(String commonCode);
}
