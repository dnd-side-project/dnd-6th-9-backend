package com.dnd.gratz.repository.gift;

import com.dnd.gratz.db.entity.common.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GiftRepository extends JpaRepository<Gift, String> {
    Optional<List<Gift>> findByCode(String code);
}
