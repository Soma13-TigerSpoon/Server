package com.clovi.domain.item;

import com.clovi.domain.Base.BaseEntity;
import com.clovi.domain.Base.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemSize extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Size size;
  @ManyToOne(fetch = FetchType.LAZY)
  private ItemInfo itemInfo;

  public ItemSize(Size size, ItemInfo itemInfo, Long memberId) {
    this.size = size;
    this.itemInfo = itemInfo;
    this.createBy = memberId;
    this.lastModifiedBy = memberId;
  }


  public String getSizeName(){
    return size.getName();
  }
}
