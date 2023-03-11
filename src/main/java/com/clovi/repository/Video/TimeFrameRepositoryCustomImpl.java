package com.clovi.repository.Video;

import com.clovi.domain.TimeFrame;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.clovi.domain.ManyToMany.QTimeShopItem.timeShopItem;
import static com.clovi.domain.QTimeFrame.timeFrame;
import static com.clovi.domain.item.QItem.item;
import static com.clovi.domain.item.QItemInfo.itemInfo;
import static com.clovi.domain.youtube.QVideo.video;

@Repository
@RequiredArgsConstructor
public class TimeFrameRepositoryCustomImpl implements TimeFrameRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    @Override
    public List<TimeFrame> getTimeFramesByVideoIdAndItemInfoId(Long videoId, Long itemInfoId) {
        List<TimeFrame> queryResults = queryFactory
                .selectFrom(timeFrame)
                .innerJoin(timeFrame.video,video)
                .innerJoin(timeFrame.items,timeShopItem)
                .innerJoin(timeShopItem.item,item)
                .innerJoin(item.itemInfo,itemInfo)
                .where(
                        videoIdEq(videoId),
                        itemInfoIdEq(itemInfoId),
                        NotDeleted()
                ).fetch().stream().collect(Collectors.toList());

        return queryResults;
    }
    private BooleanExpression videoIdEq(Long videoId){
        if(videoId == null) return null;
        return video.id.eq(videoId);
    }
    private BooleanExpression itemInfoIdEq(Long itemInfoId){
        if(itemInfoId == null) return null;
        return itemInfo.id.eq(itemInfoId);
    }
    private BooleanExpression NotDeleted(){
        return timeFrame.deleted.isFalse();
    }
}
