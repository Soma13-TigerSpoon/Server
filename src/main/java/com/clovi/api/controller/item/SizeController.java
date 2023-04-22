package com.clovi.api.controller.item;

import com.clovi.api.response.BaseResponse;
import com.clovi.api.response.MessageCode;
import com.clovi.api.response.ProcessStatus;
import com.clovi.domain.user.Member;
import com.clovi.dto.requests.item.ItemColorCreateRequest;
import com.clovi.dto.requests.item.ItemSizeCreateRequest;
import com.clovi.dto.response.ColorAndImgResponseDto;
import com.clovi.dto.response.IdResponseDto;
import com.clovi.service.item.ColorService;
import com.clovi.service.item.SizeService;
import com.clovi.support.auth.AuthMember;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "[Size] 아이템 사이즈 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SizeController {
    private final SizeService sizeService;
    //저장
    @PostMapping("/info/items/{item_info_id}/size")
    @Operation(summary = "save itemColor", description = "save color of item", responses = {
            @ApiResponse(responseCode = "201", description = "Success create", content = @Content(schema = @Schema(implementation = IdResponseDto.class)))
    })
    public ResponseEntity createItemSize(@Validated @RequestBody ItemSizeCreateRequest itemSizeCreateRequest, @AuthMember Member member, @PathVariable(name = "item_info_id") Long itemInfoId){
        IdResponseDto savedId = new IdResponseDto(sizeService.create(itemSizeCreateRequest,member,itemInfoId));
        return ResponseEntity.created(
                URI.create("/api/v1/info/items" + savedId.getSavedId() + "/colors")).body(new BaseResponse(savedId, HttpStatus.CREATED.value(), ProcessStatus.SUCCESS,
                MessageCode.SUCCESS_CREATE));
    }
    @GetMapping("/info/items/{item_info_id}/size")
    @Operation(summary = "find colors by itemInfo", description = "Find information all colors of item by itemInfoID", responses = {
            @ApiResponse(responseCode = "200", description = "Success Find colors of items ", content = @Content(schema = @Schema(implementation = ColorAndImgResponseDto.class)))
    })
    public ResponseEntity getAllSizeByItemInfo(@Validated @PathVariable(name = "item_info_id") Long itemInfoId) {
        List<String> response = sizeService.findAllColors(itemInfoId);
        return ResponseEntity.ok(
                new BaseResponse(response, HttpStatus.OK.value(), ProcessStatus.SUCCESS, MessageCode.SUCCESS_GET_LIST)
        );
    }
}
