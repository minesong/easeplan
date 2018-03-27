package com.ease.controller;

import com.ease.model.Content;
import com.ease.service.ContentService;
import com.ease.service.PurItemService;
import com.ease.utils.UploadUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {
    private Logger log = Logger.getLogger(ContentController.class);
    @Resource
    private ContentService contentService;
    @Resource
    private PurItemService purItemService;

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
    private String contentAndDetailEditSubmit(HttpServletRequest request, Content content, Model model, @RequestParam MultipartFile[] myfiles) {
        log.info("编辑商品详情");
        //暂存。此时的content 是 cotentdetail
        Long detailId = content.getId();
        if (StringUtils.isEmpty(content.getImageURL())) {
            String realPath = UploadUtils.upload(myfiles, request);
            content.setImageURL(realPath);
        }
        Boolean flag = contentService.updateContentAndDetailById(content);
        if (flag) {
            //此时的content.getId 已经不是detailId 而是简略版的contentId。所以。要暂存detailId
            model.addAttribute("contendId", detailId);
            return "editSubmit";
        }
        return "edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String addContentAndDetail(HttpServletRequest request, Content content, Model model, @RequestParam MultipartFile[] myfiles) {
        log.info("新增商品详情");
        if (StringUtils.isEmpty(content.getImageURL())) {
            String realPath = UploadUtils.upload(myfiles, request);
            content.setImageURL(realPath);
        }
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
        BigDecimal buyPrice = purItemService.getBuyPriceByDetailId(contentId);
        model.addAttribute("contentDetail", contentDetail);
        model.addAttribute("buyPrice", buyPrice);

        return "show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    //@ResponseBodya 很关键 ，不然ajax 请求报错。post或者get方法不匹配
    public String deleteItem(Long id, Model model) {
        log.info("删除商品详情");
        Integer res = contentService.deleteItem(id);
        //需要更新商品的IsSale状态
        return res == null ? "0" : res.toString();
    }
}

