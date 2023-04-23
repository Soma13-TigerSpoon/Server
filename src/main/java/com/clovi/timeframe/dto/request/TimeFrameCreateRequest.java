package com.clovi.timeframe.dto.request;

import com.clovi.utils.TimeFormatUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Schema(name = "시간 생성 요청")
@NoArgsConstructor
public class TimeFrameCreateRequest {
    @NotBlank
    @Schema(description = "시간 형식 -> 1:02:23 or 2:24 or 04:25 or 35...", example = "01:00")
    @Pattern(regexp = "(2[0-3]|[01]\\d:)?([0-5]?\\d:)?([0-5]?\\d)+")
    private String time;

    public TimeFrameCreateRequest(String time) {
        this.time = time;
    }

    public Long getTime() {
        return TimeFormatUtils.StringTimeToLong(this.time);
    }
}

