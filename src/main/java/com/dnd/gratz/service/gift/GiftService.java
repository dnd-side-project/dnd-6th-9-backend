package com.dnd.gratz.service.gift;

import com.dnd.gratz.db.entity.common.Gift;

import java.util.List;

public interface GiftService {
    List<Gift> getGiftEachTheme(String code);
}
