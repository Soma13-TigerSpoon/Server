package com.clovi.item.item.dto.response;

import com.clovi.item.shopItem.ShopItem;
import com.clovi.item.item.Item;
import com.clovi.item.shopItem.dto.response.ShopItemResponseDto;
import lombok.Getter;

@Getter
public class ItemShopItemResponseDto {
  private ItemResponseDto item;
  private ShopItemResponseDto shopLink;

  public ItemShopItemResponseDto(ShopItem shopItem, Item item) {
    this.item = new ItemResponseDto(item);
    this.shopLink = (shopItem == null) ? null : new ShopItemResponseDto(shopItem);
  }
}
