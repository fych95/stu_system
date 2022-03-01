package com.cy.store.service.impl;

import com.cy.store.Mapper.goodsMapper;
import com.cy.store.entity.goods;
import com.cy.store.service.IGoodsService;
import com.cy.store.service.ex.ShowAllException;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IGoodsServiceImpl implements IGoodsService {
    @Autowired
    private goodsMapper gdmapper;
    @Override
    public List<goods> selectGoodsPage() {
        List<goods> resultlist = new ArrayList<>();
        resultlist = gdmapper.selectGoodsPage();
        if (resultlist == null){
            throw new ShowAllException("商品查询出现异常");
        }
        System.out.println(resultlist);
        return resultlist;
    }
}
