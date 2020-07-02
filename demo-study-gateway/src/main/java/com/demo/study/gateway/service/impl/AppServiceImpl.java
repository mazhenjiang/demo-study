package com.demo.study.gateway.service.impl;

import cn.hutool.Hutool;
import cn.hutool.extra.mail.MailUtil;
import com.demo.study.common.data.Result;
import com.demo.study.common.exceptions.BusinessRuntimeException;
import com.demo.study.common.exceptions.GlobalRuntimeException;
import com.demo.study.gateway.service.AppService;
import com.demo.study.gateway.service.BaseService;
import com.demo.study.gateway.vo.VOAccount;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description:
 * @author: Aaron Ma
 **/

@Service
public class AppServiceImpl extends BaseService implements AppService {
    public final static Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);
    @Override
    public Result<VOAccount> login(VOAccount vo) {

        logger.info("接收的VO对象是：{}",vo);
        //参数 string
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");

        //格式化生成message , 占位符 {}
        logger.info("1 + {} + 3 = {}" ,2,"6");

        //输出异常信息
        logger.info("异常信息：",new Exception("hhhhhhhhhhhhhhh"));

        if (StringUtils.isEmpty(vo.getAccountName())) {
            throw new BusinessRuntimeException("账户名不能为空！");
        }
        if (StringUtils.isEmpty(vo.getAccountPwd())) {
            throw new BusinessRuntimeException("密码不能为空！");
        }
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
