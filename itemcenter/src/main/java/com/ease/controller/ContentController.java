package com.ease.controller;

import com.ease.model.Content;
import com.ease.service.ContentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {
    private Logger log = Logger.getLogger(ContentController.class);
    @Resource
    private ContentService contentService;

    @RequestMapping(value = "/showContent", method = RequestMethod.GET)
    private String getAllContent(HttpServletRequest request, Model model) {
        log.info("查询所有商品");
        List<Content> contentList = contentService.getAllContent();
        model.addAttribute("contentList", contentList);
        return "index";
    }

    @RequestMapping(value = "/isSale", method = RequestMethod.GET)
    private String getContentIsSale(HttpServletRequest request, Model model) {
        log.info("查询在售商品");
        List<Content> contentList = contentService.getContentIsSale();
        model.addAttribute("contentList", contentList);
        return "index";
    }

    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    private String contentAndDetailEditSubmit(Content content, Model model) {
        log.info("编辑商品详情");
        Boolean flag = contentService.updateContentAndDetailById(content);
        if (flag) {
            model.addAttribute("contendId", content.getId());
            return "editSubmit";
        }
        return "edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String addContentAndDetail(Content content, Model model) {
        log.info("新增商品详情");
        Long detailId = contentService.addContentAndDetail(content);
        model.addAttribute("contentId", detailId);
        return "publicSubmit";
    }

    @RequestMapping(value = "/editSkip", method = RequestMethod.GET)
    private String getContentDetailByIdToEdit(Long contentId, Model model) {
        log.info("查询商品编辑详情");
        Content contentDetail = contentService.getContentDetailById(contentId);
        model.addAttribute("contentDetail", contentDetail);
        return "edit";
    }

    @RequestMapping(value = "/publicSkip", method = RequestMethod.GET)
    private String toPublicEditSkip(Long contentId, Model model) {
        log.info("跳转到新增详情详情");
        return "public";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    private String getContentDetailById(Long contentId, Model model) {
        log.info("查询商品详情");
        Content contentDetail = contentService.getContentDetailById(contentId);
        model.addAttribute("contentDetail", contentDetail);
        return "show";
    }
}
