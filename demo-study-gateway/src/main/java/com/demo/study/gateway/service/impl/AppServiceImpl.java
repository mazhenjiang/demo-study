package com.demo.study.gateway.service.impl;

import cn.hutool.Hutool;
import cn.hutool.extra.mail.MailUtil;
import com.demo.study.common.data.Result;
import com.demo.study.gateway.service.AppService;
import com.demo.study.gateway.service.BaseService;
import com.demo.study.gateway.vo.VOAccount;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Aaron Ma
 **/
@Service
public class AppServiceImpl extends BaseService implements AppService {
    @Override
    public Result<VOAccount> login(VOAccount vo) {

        System.out.println(vo.getAccountName());
        System.out.println(vo.getAccountPwd());
        return null;
    }

    @Override
    public Result<VOAccount> register(VOAccount vo) {
        System.out.println(vo.getAccountName());
        System.out.println(vo.getAccountPwd());
        System.out.println(vo.getTel());


        return null;
    }

}
