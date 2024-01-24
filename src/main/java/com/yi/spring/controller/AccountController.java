package com.yi.spring.controller;

import com.yi.spring.service.AccountService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Setter
@Controller
@RequestMapping("/account/*")
public class AccountController {

    @Autowired
    private AccountService accountService;
//    @Autowired
//    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "/account/index";
    }

    @GetMapping("/balance")
    @Transactional
    @ResponseBody
    public String sendMoney(Model model) throws Exception{

            accountService.sendMoney();

//        model.addAttribute("aaa",1000);

        return "/account/list";
    }


}