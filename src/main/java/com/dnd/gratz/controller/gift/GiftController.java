package com.dnd.gratz.controller.gift;

import com.dnd.gratz.controller.BaseController;
import com.dnd.gratz.db.entity.common.Code;
import com.dnd.gratz.db.entity.common.Gift;
import com.dnd.gratz.service.code.CodeService;
import com.dnd.gratz.service.gift.GiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GiftController extends BaseController {

    @Autowired
    CodeService codeService;

    @Autowired
    GiftService giftService;

    /**
     * 선물 목록 코드 리스트
     */
    @GetMapping("/gifts")
    public ResponseEntity<List<Code>> getGiftCode(){
        List<Code> codeList = codeService.getCodeList("B");
        return new ResponseEntity<>(codeList, HttpStatus.OK);
    }

    /**
     * 선물 카테고리 별 리스트
     */
    @GetMapping("/gifts/{code}")
    public ResponseEntity<List<Gift>> getDetailGiftCode(@PathVariable("code") String code){
        List<Gift> giftList = giftService.getGiftEachTheme(code);
        return new ResponseEntity<>(giftList, HttpStatus.OK);
    }
}
