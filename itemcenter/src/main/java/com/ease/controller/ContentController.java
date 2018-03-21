package com.ease.controller;

import com.ease.model.Content;
import com.ease.model.User;
import com.ease.service.ContentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {
    private Logger log = Logger.getLogger(ContentController.class);
    @Resource
    private ContentService contentService;

    @RequestMapping(value = "/showContent")
    private String getAllContent(HttpServletRequest request, Model model) {
        log.info("查询所有商品");
        List<Content> contentList = contentService.getAllContent();
        model.addAttribute("contentList", contentList);
        return "index";
    }
    @RequestMapping(value = "/isSale")
    private String getContentIsSale(HttpServletRequest request, Model model) {
        log.info("查询在售商品");
        List<Content> contentList = contentService.getContentIsSale();
        model.addAttribute("contentList", contentList);
        return "index";
    }
}
