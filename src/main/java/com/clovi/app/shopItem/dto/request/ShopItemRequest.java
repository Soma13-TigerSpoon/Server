package com.clovi.app.shopItem.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ShopItemRequest {
  private Long itemId;

  private String hostname;
  private String shopItemUrl;

  @NotBlank(message = "상품값은 필수 항목입니다!")
  @Schema(description = "가격", example = "36000")
  private Long price;

  public ShopItemRequest(String shopUrl, Long price) {
    this.shopItemUrl = shopUrl;
    this.price = price;
  }
  // 빈 생성자 없으면 error 발생
  public ShopItemRequest() {
  }
}