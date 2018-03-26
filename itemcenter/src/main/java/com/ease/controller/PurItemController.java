package com.ease.controller;

import com.ease.dao.ContentDao;
import com.ease.model.PurItem;
import com.ease.service.PurItemService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Resource
    private ContentDao contentDao;

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
    @ResponseBody
    //@ResponseBodya 很关键 ，不然ajax 请求报错。post或者get方法不匹配
    public String addPurItem(Long id, Model model) {
        log.info("新增购买详情");
        Long purItemId = purItemService.addPurItem(id);
        //需要更新商品的IsSale状态
        return purItemId == null ? "0" : purItemId.toString();
    }
}
