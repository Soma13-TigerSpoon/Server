package com.clovi.api.controller.shopItem;

import com.clovi.api.response.BaseResponse;
import com.clovi.api.response.MessageCode;
import com.clovi.api.response.ProcessStatus;
import com.clovi.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @GetMapping("/api/v1/shops")
    public ResponseEntity getShopsV1(){
        return ResponseEntity.ok(new BaseResponse(shopService.getShops(), HttpStatus.OK.value(), ProcessStatus.SUCCESS, MessageCode.SUCCESS_GET));
    }

}