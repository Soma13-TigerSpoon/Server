package Soma.CLOVI.dto.response;

import Soma.CLOVI.domain.ManyToMany.ShopItem;
import Soma.CLOVI.domain.item.Item;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ItemResponseDto {

  List<ShopItemResponseDto> shops = new ArrayList<>();
  List<ItemResponseDto> childItems = new ArrayList<>();

  private Long id;
  private String name;
  private int type;
  private String itemImgUrl;
  private String color;
  private String size;

  private String brand;
  private CategoryResponseDto category;

  public ItemResponseDto(Item item) {
    this.id = item.getId();
    this.name = item.getName();
    this.type = item.getCategory().getOrder();
    this.color = item.getColor();
    this.size = item.getSize();
    this.brand = item.getBrand();
    this.itemImgUrl = item.getImgUrl();
    this.category = new CategoryResponseDto(item.getCategory());
    for (ShopItem shopItem : item.getShopItems()) { // Select ShopItem
      this.shops.add(new ShopItemResponseDto(shopItem));
    }
    for (Item cur : item.getChildItems()){
      this.childItems.add(new ItemResponseDto(cur));
    }

  }

}
