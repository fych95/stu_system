package com.cy.store.Mapper;

import com.cy.store.entity.goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface goodsMapper {
 List<goods> selectGoodsPage();
}
