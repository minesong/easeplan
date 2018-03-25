package com.ease.controller;

import com.ease.model.PurItem;
import com.ease.service.PurItemService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/purchased")
public class PurItemController {
    private Logger log = Logger.getLogger(PurItemController.class);
    @Resource
    private PurItemService purItemService;

    @RequestMapping(value = "/showPurItem", method = RequestMethod.GET)
    public String showPurItem(HttpServletRequest request, Model model) {
        log.info("查询所有已经购买商品信息");
        List<PurItem> purItemList = purItemService.getAllPurItems();
        BigDecimal total = new BigDecimal("0");
        if (purItemList != null) {
            for (PurItem purItem : purItemList) {
                total = total.add(purItem.getPrice());
            }
        }
        total = total.setScale(2, BigDecimal.ROUND_HALF_UP);
        model.addAttribute("purItemList", purItemList);
        model.addAttribute("total", total);
        return "account";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private void addPurItem(PurItem purItem, Model model) {
        log.info("新增购买详情");
        Long detailId = purItemService.addPurItem(purItem);
    }
}
