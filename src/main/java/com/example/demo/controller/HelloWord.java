package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.impl.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Stream;

@RestController
@Slf4j
public class HelloWord {

    @Autowired
    AccountService accountService;

    @GetMapping("/account/get")
    public String helloWord(@RequestParam String username,Integer ps,Integer pn){
        if("all".equals(username)){
            Integer pageSize=ps==null?1:ps;
            Integer pageNum=pn==null?Integer.MAX_VALUE:pn;

            List<Account> allObject = accountService.getAllObject(pageSize, pageNum);
            Stream<String> tmp = allObject.stream().map(Account::getPassword);
            return tmp.reduce((a, b)->a+","+b).orElse("No Such Account");
        }
        return accountService.getObjectByUsername(username).orElse(new Account()).getPassword() ;
    }
}
