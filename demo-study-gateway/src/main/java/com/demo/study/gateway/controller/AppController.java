package com.demo.study.gateway.controller;

import com.demo.study.common.data.Result;
import com.demo.study.gateway.service.AppService;
import com.demo.study.gateway.vo.VOAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 账户controller
 * @author: Aaron Ma
 **/

@RestController
@RequestMapping("api/app")
public class AppController {

    @Autowired
    AppService appService;

    @GetMapping("/login")
    @ResponseBody
    public Result<VOAccount> login(VOAccount vo) {
        return this.appService.login(vo);
    }

    @PostMapping("/register")
    @ResponseBody
    public Result<VOAccount> register(@RequestBody @Validated VOAccount vo) {
        return this.appService.register(vo);
    }

}
