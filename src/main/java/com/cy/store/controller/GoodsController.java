package com.cy.store.controller;

import com.cy.store.entity.goods;
import com.cy.store.service.IGoodsService;
import com.cy.store.service.ex.ShowAllException;
import com.cy.store.util.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private IGoodsService iGoodsService;
    @RequestMapping("git")
    public JsonResult<PageInfo<goods>> showGoods(@RequestParam(defaultValue = "1") Integer pageNum){
        JsonResult<PageInfo<goods>> Jsonresult = new JsonResult<>();
        List<goods> result = new ArrayList<>();
        PageHelper.startPage(pageNum,5);
        result = iGoodsService.selectGoodsPage();
        PageInfo<goods> pageresult = new PageInfo<>(result);

        try {
            Jsonresult.setState(200);
            Jsonresult.setMessage("success");
            Jsonresult.setData(pageresult);
        } catch (ShowAllException e) {
            Jsonresult.setState(404);
            Jsonresult.setMessage("show goods failed");
        }


        return Jsonresult;
    }

}
