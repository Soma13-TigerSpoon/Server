package Soma.CLOVI.dto.use;

import Soma.CLOVI.domain.ShopItem;
import Soma.CLOVI.domain.TimeFrame;
import Soma.CLOVI.domain.item.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TimeShopItemResponseDto {
    private TimeResponseDto times;
    private ModelResponseDto model;
    private List<ItemResponseDto> items = new ArrayList<>();

    public TimeShopItemResponseDto(TimeFrame timeFrame){
        this.times = new TimeResponseDto(timeFrame);
        for(Item item : timeFrame.getItemList()){
            items.add(new ItemResponseDto(item));
        }
        this.model = new ModelResponseDto(timeFrame.getModel());
    }
}