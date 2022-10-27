package Soma.CLOVI.api.controller;

import Soma.CLOVI.api.response.BaseResponse;
import Soma.CLOVI.api.response.MessageCode;
import Soma.CLOVI.api.response.ProcessStatus;
import Soma.CLOVI.dto.response.VideoItemResponseDto;
import Soma.CLOVI.service.VideoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class VideoItemController {
    private final VideoItemService videoItemService;

    @GetMapping("/videoItems/{item_id}")
    public ResponseEntity getVideoItems(@Validated @PathVariable(name = "item_id") Long itemId) {
        List<VideoItemResponseDto> result = videoItemService.getVideosByItemId(itemId);

        return ResponseEntity.ok(
                new BaseResponse(result, HttpStatus.OK.value(), ProcessStatus.SUCCESS, MessageCode.SUCCESS_GET)
        );
    }
}
