package com.demo.study.gateway.service;

import com.demo.study.common.data.Result;
import com.demo.study.gateway.vo.VOAccount;

public interface AppService {

    Result<VOAccount> login(VOAccount vo);

    Result<VOAccount> register(VOAccount vo);
}
