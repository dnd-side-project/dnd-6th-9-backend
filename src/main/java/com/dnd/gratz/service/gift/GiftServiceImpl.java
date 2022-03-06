package com.dnd.gratz.service.gift;

import com.dnd.gratz.db.entity.common.Gift;
import com.dnd.gratz.repository.gift.GiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService{
    @Autowired
    GiftRepository giftRepository;

    @Override
    public List<Gift> getGiftEachTheme(String code) {
        return giftRepository.findByCode(code).get();
    }
}
