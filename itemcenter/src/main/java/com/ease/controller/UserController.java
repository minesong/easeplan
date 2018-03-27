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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public String showUser(HttpServletRequest request, Model model) {
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "showUser";
    }

    @RequestMapping(value = "/loginskip", method = RequestMethod.GET)
    public String userLoginSkip() {
        log.info("用户登录跳转");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(String userName, String password, HttpSession httpSession) {
        log.info("用户登录");
        //reyub
        if (userName.equals("buyer") && password.equals("37254660e226ea65ce6f1efd54233424")) {
            httpSession.setAttribute("loginName", userName);
            return "success";
        }
        //relles
        if (userName.equals("seller") && password.equals("981c57a5cfb0f868e064904b8745766f")) {
            httpSession.setAttribute("loginName", userName);
            return "success";
        }
        return "error";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String userLogout(HttpSession httpSession) {
        log.info("用户退出");
        httpSession.removeAttribute("loginName");
        httpSession.invalidate();
        return "success";
    }
}

