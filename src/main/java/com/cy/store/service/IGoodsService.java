package com.cy.store.service;

import com.cy.store.entity.goods;

import java.util.List;

public interface IGoodsService {
    List<goods> selectGoodsPage();
}
