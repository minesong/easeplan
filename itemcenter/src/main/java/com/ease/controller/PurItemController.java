package com.ease.controller;

import com.ease.model.PurItem;
import com.ease.service.PurItemService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
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
    public String showUser(HttpServletRequest request, Model model) {
        log.info("查询所有已经购买商品信息");
        List<PurItem> purItemList = purItemService.getAllPurItems();
        BigDecimal total = new BigDecimal("0");
        if (purItemList != null) {
            for (PurItem purItem : purItemList) {
                total.add(purItem.getPrice());
            }
        }
        model.addAttribute("purItemList", purItemList);
        model.addAttribute("total", total);
        return "account";
    }
}
