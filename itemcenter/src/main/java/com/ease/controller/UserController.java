package com.ease.controller;

import com.ease.model.User;
import com.ease.service.UserService;
import com.ease.utils.ContentResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping(value = "/showUser",method = RequestMethod.GET)
    public String showUser(HttpServletRequest request, Model model) {
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "showUser";
    }

    @RequestMapping(value = "/loginskip",method = RequestMethod.GET)
    public String userLoginSkip() {
        log.info("用户登录跳转");
        return "login";
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String userLogin(String userName, String password, HttpSession httpSession) {
        log.info("用户登录");
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            return "login";
        }
        if (userName.equals("buyer") && password.equals("reyub")) {
            httpSession.setAttribute("loginName", userName);
            return "index";
        }
        if (userName.equals("seller") && password.equals("relles")) {
            httpSession.setAttribute("loginName", userName);
            return "";
        }
        return "login";
    }
}

