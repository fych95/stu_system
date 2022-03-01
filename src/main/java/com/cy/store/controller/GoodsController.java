package com.cy.store.controller;

import com.cy.store.entity.goods;
import com.cy.store.service.IGoodsService;
import com.cy.store.service.ex.ShowAllException;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private IGoodsService iGoodsService;
    @RequestMapping("showgoodspage")
    public JsonResult<goods> showGoods(){
        JsonResult<List<goods>> Jsonresult = new JsonResult<>();
        List<goods> result = new ArrayList<>();
        result = iGoodsService.selectGoodsPage();

        try {
            Jsonresult.setState(200);
            Jsonresult.setMessage("success");
            Jsonresult.setData(result);
        } catch (ShowAllException e) {
            Jsonresult.setState(404);
            Jsonresult.setMessage("show goods failed");
        }


        return
    }

}
