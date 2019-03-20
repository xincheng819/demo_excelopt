package com.nhnchina.demoexcelopt.Service.impl;

import com.alibaba.fastjson.JSON;
import com.nhnchina.demoexcelopt.model.DeptIncomeModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeptIncomeService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private final Log log = LogFactory.getLog(DeptIncomeService.class);


    public Object selectDeptIncomeList(String key){

//        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
//        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
//        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

        // 具体使用
       // redisTemplate.opsForList().leftPush("JobList:GW00010",Long.parseLong("20140107"), Long.parseLong("20140107"));
        return redisTemplate.opsForValue().get(key);

    }
}
