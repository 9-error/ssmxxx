package com.zz.admin.controller;

import com.zz.admin.bean.Stu;
import com.zz.admin.bean.User;
import com.zz.admin.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class indexController {


    @Autowired
    StuService stuService;

    @ResponseBody
    @GetMapping("/acct")
    public Stu getById(@RequestParam("id") Long id){

        return stuService.getStuById(id);
    }



    /*
    * 登陆页
    * */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(!(StringUtils.isEmpty(user.getUserName())) && !(StringUtils.isEmpty(user.getPassword()))){
            //保存登录成功用户
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;重定向防止post表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){

        log.info("当前方法是:{}","mainPage");
        //使用过滤器机制

//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null){
//            return "main";
//        }else {
//            model.addAttribute("msg","重新登陆");
//            return "login";
//
//        }
        return "main";

    }
}
