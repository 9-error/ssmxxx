package com.zz.admin.controller;


import com.zz.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //遍历表格内容
        List<User> users = Arrays.asList(new User("zhangsan","123456"),
                new User("lisi","456"),
                new User("wangwu","56sd"),
                new User("ddd","1dddd6"));

        model.addAttribute("users",users);

        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){

        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }



}
